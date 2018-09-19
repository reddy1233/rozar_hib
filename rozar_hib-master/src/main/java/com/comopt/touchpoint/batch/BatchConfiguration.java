package com.comopt.touchpoint.batch;


import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.comopt.touchpoint.AppConstant;
import com.comopt.touchpoint.entities.TransAudit;


@Configuration
@EnableBatchProcessing
@EnableJms
@EnableScheduling
public class BatchConfiguration extends DefaultBatchConfigurer{
	
	/*private final String QUERY ="select * from ccm_trans_audit ta,
	 *  ccm_trans_dtls_audit tda,
	 *   ccm_trans_dtls_strg_pfm_status_audit tdsps, 
	 *   ccm_trans_comm_chnl_status_audit tccsa, " + 
			"ccm_trans_dtls_comm_chnl_status_audit tdcsa where " + 
			" ta.trans_id = tda.trans_id  " + 
			"and tda.trns_dtls_seq_id  = tdsps.trns_dtls_seq_id   " + 
			"and ta.trans_id =tccsa.trans_id   " + 
			"and tda.trns_dtls_seq_id =tdcsa.trns_dtls_seq_id   " + 
			"and tdsps.strg_pfm_status= 'Accepted' " + 
			"and tdcsa.comm_chnl_status_cd ='0'  ";*/

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    private JobCompletionNotificationListener listener;
    
    @Autowired
    private DataSource dataSource; 
    
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    
    
    @Override
    public void setDataSource(DataSource dataSource) {
    	//donot write spring batch metadata to database
        // override to do not set datasource even if a datasource exist.
        // initialize will use a Map based JobRepository (instead of database)
    }
   
   /* @Bean(destroyMethod = "")
    public JdbcCursorItemReader<TouchPointActor> reader(){
    	
    	System.out.println("dataSource>>>>>>"+dataSource);
    	
     JdbcCursorItemReader<TouchPointActor> reader = new JdbcCursorItemReader<TouchPointActor>();
     reader.setDataSource(dataSource);
     reader.setSql(QUERY);
     reader.setVerifyCursorPosition(false);
     reader.setRowMapper(new TouchPointActorRowMapper());
     
     return reader;
    }*/
    
    String jpqlQuery = "select ta from TransAudit ta"
    		+ " join fetch ta.transDtlsAudits tda "
    		+ " join fetch ta.transCommChnlStatusAudits tccsa "
    		+ " join fetch tda.transDtlsCommChnlStatusAudits tdccsa "
    		+ " join fetch tda.transDtlsStrgPfmStatusAudits tdspsa"
    		+ " join fetch ta.sourceSytemCd sscd "
    		+ " where tdspsa.strgPfmStatus= 'Accepted' " 
			+ " and tdccsa.commChnlStatusCd ='0'  ";


    @Bean(destroyMethod = "")
    public ItemReader<TransAudit> reader() throws Exception {
        
    		JpaPagingItemReader<TransAudit> reader = new JpaPagingItemReader<TransAudit>();
    		reader.setQueryString(jpqlQuery);
    		reader.setEntityManagerFactory(entityManagerFactory);
    		reader.setPageSize(3);
    		reader.afterPropertiesSet();
    		reader.setSaveState(true);

    		return reader;
    }

    
    /*public class TouchPointActorRowMapper implements RowMapper<TouchPointActor>{

     @Override
     public TouchPointActor mapRow(ResultSet rs, int rowNum) throws SQLException {
    	 
    	
    	 TouchPointActor tpa = new TouchPointActor();
    	 tpa.setAppId(rs.getString("file_nm"));
    	 tpa.setTransId(rs.getString("trans_id"));
      
      return tpa;
     }
     
    }*/
 
    @Bean
    public TPAItemProcessor processor() {
        return new TPAItemProcessor();
    }
    
    @Bean(destroyMethod="")
    public Step step1() throws Exception {
    	  return stepBuilderFactory.get("chunkStep")
    		        .<TransAudit, TransAudit>chunk(10)
    		        .reader(reader())
    		        .processor(processor())
    		        .writer(writer())
    		        .build();
    }
    
    @Bean
    public Job testJob() throws Exception {
     return jobBuilderFactory.get("testJob")
       .incrementer(new RunIdIncrementer())
       .listener(listener)
       .flow(step1())
       .end()
       .build();
    }

   

    @Bean
    public CustomItemWriter writer() {
    	System.out.println("writer.....");
     return new CustomItemWriter();
    }
   

 /** Job launcher and scheduler integration code..**/
    
    @Autowired
    private SimpleJobLauncher jobLauncher;
    
    @Bean
    public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository(jobRepository);
        return launcher;
    }
    
    
   //@Scheduled(cron = "*/30 * * * * *")
    //@Scheduled(fixedRate = 60000)
   // @Scheduled(cron = "${scheduling.job.cron}")
    //@Scheduled(cron = "0 0 8 1/1 * ?") 
  	public void perform() throws Exception {

    	
  		System.out.println("Job Started at :" + new Date());
  		
  		AppConstant.isReadComplete = false;

  		JobParameters param = new JobParametersBuilder().addString("TPA batch JobID", String.valueOf(System.currentTimeMillis()))
  				.toJobParameters();

  	
  		
  		try {
  			JobExecution execution = jobLauncher.run(testJob(), param);
  			System.out.println("Job finished with status :" + execution.getStatus());
  	    	}catch(Exception e) {
  	    		
  	    		//System.out.println(e);
  	    	}

  		
  	}
}
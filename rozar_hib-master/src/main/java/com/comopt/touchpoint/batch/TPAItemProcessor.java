package com.comopt.touchpoint.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.comopt.touchpoint.entities.TransAudit;

public class TPAItemProcessor implements ItemProcessor<TransAudit,TransAudit> {

    private static final Logger log = LoggerFactory.getLogger(TPAItemProcessor.class);

    @Override
    public TransAudit process(final TransAudit tpa) throws Exception {
       // final String firstName = person.getFirstName().toUpperCase();
       // final String lastName = person.getLastName().toUpperCase();

       // final Person transformedPerson = new Person(firstName, lastName);
    	
    	//TouchPointActor tpa = new TouchPointActor();

        //log.info("Converting (" + tpa + ") into (" + tpa + ")");
        
        
        return tpa;
    }

}

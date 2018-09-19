package com.comopt.touchpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.comopt.touchpoint.entities.TransDtlsAudit;


@Service
public class TouchPointActorServiceImpl implements  TouchPointActorService {
	
	/*@Autowired
	TouchPointRepository touchPointRepository;

	@Override
	public void updateProcessedTouchPoint(List<TransDtlsAudit> transDtlsAuditUpdateList) {
		
		for(TransDtlsAudit entity: transDtlsAuditUpdateList) {
			System.out.println("Updating entity....TransDtlsAudit");
			touchPointRepository.updateStatus(entity.getTransDtlsSeqId(), "CREATED");
			System.out.println("After Updating entity....TransDtlsAudit");
		
		}
		
	}*/
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	String UPDATE_QUERY = "UPDATE ccm_trans_dtls_audit tda SET tda.tp_status = ? WHERE tda.trns_dtls_seq_id = ?";
	
	@Override
	public void updateProcessedTouchPoint(List<TransDtlsAudit> transDtlsAuditUpdateList) {
		
		for(TransDtlsAudit entity: transDtlsAuditUpdateList) {
			
			jdbcTemplate.update(UPDATE_QUERY, "CREATED", entity.getTransDtlsSeqId());
		
		}
		
	}

}

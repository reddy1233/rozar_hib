package com.comopt.touchpoint.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comopt.touchpoint.entities.TransDtlsAudit;

@Service
public class TouchPointActorServiceImpl implements  TouchPointActorService {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void updateProcessedTouchPoint(List<TransDtlsAudit> transDtlsAuditUpdateList) {
		
		for(TransDtlsAudit entity: transDtlsAuditUpdateList) {
			
			entity.setTpStatus("Created");
			entityManager.merge(entity);
		}
		
	}

}

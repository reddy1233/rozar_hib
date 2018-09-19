package com.comopt.touchpoint.service;

import java.util.List;

import com.comopt.touchpoint.entities.TransDtlsAudit;

public interface TouchPointActorService {
	
	
	void updateProcessedTouchPoint(List<TransDtlsAudit> transDtlsAuditUpdateList);

	
}

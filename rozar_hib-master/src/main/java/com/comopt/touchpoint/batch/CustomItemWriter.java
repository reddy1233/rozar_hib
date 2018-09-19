package com.comopt.touchpoint.batch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.comopt.touchpoint.AppConstant;
import com.comopt.touchpoint.entities.TransAudit;
import com.comopt.touchpoint.entities.TransDtlsAudit;
import com.comopt.touchpoint.entities.TransDtlsStrgPfmStatusAudit;
import com.comopt.touchpoint.model.Initiator;
import com.comopt.touchpoint.model.TouchPointActor;
import com.comopt.touchpoint.model.Touchpoint;
import com.comopt.touchpoint.service.TouchPointActorService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomItemWriter implements ItemWriter<TransAudit> {

	private static final Logger log = LoggerFactory.getLogger(CustomItemWriter.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	private List<TransDtlsAudit> transDtlsAuditUpdateList;
	
	@Autowired
	private TouchPointActorService touchPointActorService;

	@Override
	public void write(List<? extends TransAudit> data) throws Exception {
		//System.out.println("jdbcTemplate::" + jdbcTemplate);
		transDtlsAuditUpdateList = new ArrayList<>();
		List<TouchPointActor> touchPointActors = constructTocuhPointObject(data,transDtlsAuditUpdateList);
		
		System.out.println("transDtlsAuditUpdateList size:::"+transDtlsAuditUpdateList.size());

		System.out.println("touchPointActor::" + touchPointActors);

		AppConstant.isReadComplete = true;
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(touchPointActors);
			System.out.println("json:::" + json);
			// jmsTemplate.convertAndSend("DEV.QUEUE.1", data);
			System.out.println("Touch Point JSON Strings send to queue " + data);
			
			//After writing to queue update the records...
			touchPointActorService.updateProcessedTouchPoint(transDtlsAuditUpdateList);
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	List<TouchPointActor> constructTocuhPointObject(List<? extends TransAudit> data, List<TransDtlsAudit> transDtlsAuditUpdateList2) {
		System.out.println("data:::" + data.size());
		List<TouchPointActor> touchPointActorList = new ArrayList<>();
		TouchPointActor tpa = null;
		if (data != null) {
			for (TransAudit transAudit : data) {

				tpa = new TouchPointActor();
				tpa.setAppId("ccm");
				tpa.setEtlBusinessRecordId(transAudit.getCommPfmJobId());
				tpa.setSourceCd("sourceCd");
				tpa.setTenantId(0L);
				// tpa.setTransId(transId);

				tpa.setTouchpoint(getTouchPoints(transAudit.getTransDtlsAudits(), tpa));
				touchPointActorList.add(tpa);
				
				//add to update the db records
				transDtlsAuditUpdateList2.addAll(transAudit.getTransDtlsAudits());
			}

		}

		return touchPointActorList;

	}

	private List<Touchpoint> getTouchPoints(Set<TransDtlsAudit> transDtlsAudits, TouchPointActor tpa) {
		List<Touchpoint> touchPointList = new ArrayList<>();
		Touchpoint touchPoint = null;
		if (transDtlsAudits != null) {

			Iterator<TransDtlsAudit> it = transDtlsAudits.iterator();
			while (it.hasNext()) {

				TransDtlsAudit transDtlsAudit = it.next();
				tpa.setTransId(transDtlsAudit.getCommPfmTrnsId());

				touchPoint = new Touchpoint();

				Initiator aboutWhom = new Initiator();

				// transDtlsAudit.get

				aboutWhom.setCategory(transDtlsAudit.getDocType());
				String docType = transDtlsAudit.getDocType();
				if (docType != null && !docType.equalsIgnoreCase("")) {

					if (docType.equalsIgnoreCase("grp")) {
						aboutWhom.setId(transDtlsAudit.getGrpId());

					}
					if (docType.equalsIgnoreCase("mbr")) {
						aboutWhom.setId(transDtlsAudit.getMbrId());
					}
					aboutWhom.setConstinuencyCd("enrl");
				}

				touchPoint.setAboutWhom(aboutWhom);

				touchPointList.add(touchPoint);

				Set<TransDtlsStrgPfmStatusAudit> transDtlsStrgPfmStatusAudit = transDtlsAudit
						.getTransDtlsStrgPfmStatusAudits();

			}

			// set logic of initiator
			// touchpoint.setAboutWhom(aboutWhom);

		}

		return touchPointList;

	}

}

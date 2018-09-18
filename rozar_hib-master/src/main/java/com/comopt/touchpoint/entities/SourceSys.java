package com.comopt.touchpoint.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//create table source_sys ( source_system_cd VARCHAR(100), source_cd VARCHAR(20),
//source_cd_de VARCHAR(20), audit_load_id varchar(100),
//audit_load_tm varchar(100) ) ;

@Entity
@Table(name="source_sys")
public class SourceSys implements Serializable {

	private static final long serialVersionUID = -2636822488929723246L;
	
	@Id
	@Column(name="source_system_cd")
	private String sourceSystemCd;
	
	@Column(name="source_cd")
	private String sourceCd;
	
	@Column(name="source_cd_de")
	private String sourceCdDe;
	
	
	@Column(name = "audit_load_id")
	private String auditLoadId;

	@Column(name = "audit_load_tm")
	private String auditLoadTm;
	
	@OneToOne(optional=false, mappedBy="sourceSytemCd")
    public TransAudit transAudit;
	
	

	public TransAudit getTransAudit() {
		return transAudit;
	}

	public void setTransAudit(TransAudit transAudit) {
		this.transAudit = transAudit;
	}

	public String getSourceSystemCd() {
		return sourceSystemCd;
	}

	public void setSourceSystemCd(String sourceSystemCd) {
		this.sourceSystemCd = sourceSystemCd;
	}

	public String getSourceCd() {
		return sourceCd;
	}

	public void setSourceCd(String sourceCd) {
		this.sourceCd = sourceCd;
	}

	public String getSourceCdDe() {
		return sourceCdDe;
	}

	public void setSourceCdDe(String sourceCdDe) {
		this.sourceCdDe = sourceCdDe;
	}

	public String getAuditLoadId() {
		return auditLoadId;
	}

	public void setAuditLoadId(String auditLoadId) {
		this.auditLoadId = auditLoadId;
	}

	public String getAuditLoadTm() {
		return auditLoadTm;
	}

	public void setAuditLoadTm(String auditLoadTm) {
		this.auditLoadTm = auditLoadTm;
	}
	
	
	

}

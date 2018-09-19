package com.comopt.touchpoint.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//create table source_sys ( source_system_cd INT(11), source_cd VARCHAR(20),
//source_cd_de VARCHAR(20), audit_load_id varchar(100),
//audit_load_tm varchar(100) ) ;

@Entity
@Table(name = "source_sys")
public class SourceSys implements Serializable {

	private static final long serialVersionUID = -2636822488929723246L;

	@Id
	@Column(name = "source_system_cd")
	private Long sourceSystemCd;

	@Column(name = "source_cd")
	private String sourceCd;

	@Column(name = "source_cd_de")
	private String sourceCdDe;

	@Column(name = "audit_load_id")
	private String auditLoadId;

	@Column(name = "audit_load_tm")
	private String auditLoadTm;

	@OneToMany(mappedBy = "sourceSytemCd")
	public Set<TransAudit> transAudits;

	public Set<TransAudit> getTransAudits() {
		return transAudits;
	}

	public void setTransAudits(Set<TransAudit> transAudits) {
		this.transAudits = transAudits;
	}

	public Long getSourceSystemCd() {
		return sourceSystemCd;
	}

	public void setSourceSystemCd(Long sourceSystemCd) {
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

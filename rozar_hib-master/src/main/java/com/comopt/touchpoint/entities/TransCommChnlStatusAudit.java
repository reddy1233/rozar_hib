package com.comopt.touchpoint.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ccm_trans_comm_chnl_status_audit")
public class TransCommChnlStatusAudit implements Serializable {

	private static final long serialVersionUID = 6552792385796418045L;

	@Id
	@Column(name = "trns_comm_chnl_seq_id")
	private Long trnsCommChnlSeqId;

	@Column(name = "comm_chnl_name")
	private String commChnlName;

	@Column(name = "comm_chnl_name_type")
	private String commChnlNameType;

	@Column(name = "comm_chnl_status")
	private String commChnlStatus;

	@Column(name = "comm_chnl_status_cd")
	private String commChnlStatusCd;

	@Column(name = "comm_chnl_status_de")
	private String commChnlStatusDe;

	@Column(name = "audit_load_id")
	private String auditLoadId;

	@Column(name = "audit_load_tm")
	private String auditLoadTm;

	@ManyToOne
	@JoinColumn(name = "trans_id", nullable = false)
	private TransAudit transAudit;

	public Long getTrnsCommChnlSeqId() {
		return trnsCommChnlSeqId;
	}

	public void setTrnsCommChnlSeqId(Long trnsCommChnlSeqId) {
		this.trnsCommChnlSeqId = trnsCommChnlSeqId;
	}

	public String getCommChnlName() {
		return commChnlName;
	}

	public void setCommChnlName(String commChnlName) {
		this.commChnlName = commChnlName;
	}

	public String getCommChnlNameType() {
		return commChnlNameType;
	}

	public void setCommChnlNameType(String commChnlNameType) {
		this.commChnlNameType = commChnlNameType;
	}

	public String getCommChnlStatus() {
		return commChnlStatus;
	}

	public void setCommChnlStatus(String commChnlStatus) {
		this.commChnlStatus = commChnlStatus;
	}

	public String getCommChnlStatusCd() {
		return commChnlStatusCd;
	}

	public void setCommChnlStatusCd(String commChnlStatusCd) {
		this.commChnlStatusCd = commChnlStatusCd;
	}

	public String getCommChnlStatusDe() {
		return commChnlStatusDe;
	}

	public void setCommChnlStatusDe(String commChnlStatusDe) {
		this.commChnlStatusDe = commChnlStatusDe;
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

	public TransAudit getTransAudit() {
		return transAudit;
	}

	public void setTransAudit(TransAudit transAudit) {
		this.transAudit = transAudit;
	}
	
	

}

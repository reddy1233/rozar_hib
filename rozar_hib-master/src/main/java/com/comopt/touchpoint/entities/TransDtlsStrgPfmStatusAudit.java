package com.comopt.touchpoint.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ccm_trans_dtls_strg_pfm_status_audit")
public class TransDtlsStrgPfmStatusAudit implements Serializable {

	private static final long serialVersionUID = -8412420464194796409L;

	@Id
	@Column(name = "trns_dtls_strg_pfm_seq_id")
	private Long trbsDtlsStrgPfmSeqId;

	@Column(name = "strg_pfm_id")
	private String strgPfmId;

	@Column(name = "strg_pfm_status")
	private String strgPfmStatus;

	@Column(name = "strg_pfm_status_cd")
	private String strgPfmStatusCd;

	@Column(name = "strg_pfm_status_de")
	private String strgPfmStatusDe;

	@Column(name = "audit_load_id")
	private String auditLoadId;

	@Column(name = "audit_load_tm")
	private String auditLoadTm;

	@ManyToOne
	@JoinColumn(name = "trns_dtls_seq_id", nullable = false)
	private TransDtlsAudit transDtlsAudit;

	public Long getTrbsDtlsStrgPfmSeqId() {
		return trbsDtlsStrgPfmSeqId;
	}

	public void setTrbsDtlsStrgPfmSeqId(Long trbsDtlsStrgPfmSeqId) {
		this.trbsDtlsStrgPfmSeqId = trbsDtlsStrgPfmSeqId;
	}

	public String getStrgPfmId() {
		return strgPfmId;
	}

	public void setStrgPfmId(String strgPfmId) {
		this.strgPfmId = strgPfmId;
	}

	public String getStrgPfmStatus() {
		return strgPfmStatus;
	}

	public void setStrgPfmStatus(String strgPfmStatus) {
		this.strgPfmStatus = strgPfmStatus;
	}

	public String getStrgPfmStatusCd() {
		return strgPfmStatusCd;
	}

	public void setStrgPfmStatusCd(String strgPfmStatusCd) {
		this.strgPfmStatusCd = strgPfmStatusCd;
	}

	public String getStrgPfmStatusDe() {
		return strgPfmStatusDe;
	}

	public void setStrgPfmStatusDe(String strgPfmStatusDe) {
		this.strgPfmStatusDe = strgPfmStatusDe;
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

	public TransDtlsAudit getTransDtlsAudit() {
		return transDtlsAudit;
	}

	public void setTransDtlsAudit(TransDtlsAudit transDtlsAudit) {
		this.transDtlsAudit = transDtlsAudit;
	}


	
	
}

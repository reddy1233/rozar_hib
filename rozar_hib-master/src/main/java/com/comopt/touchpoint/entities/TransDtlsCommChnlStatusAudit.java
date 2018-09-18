package com.comopt.touchpoint.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ccm_trans_dtls_comm_chnl_status_audit")
public class TransDtlsCommChnlStatusAudit implements Serializable {

	private static final long serialVersionUID = 9004184975382873499L;

	@Id
	@Column(name = "trns_dtls_comm_chnl_seq_id")
	private Long trnsDtlsCommChnlSeqId;

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
	@JoinColumn(name = "trns_dtls_seq_id", nullable = false)
	private TransDtlsAudit transDtlsAudit;

	public Long getTrnsDtlsCommChnlSeqId() {
		return trnsDtlsCommChnlSeqId;
	}

	public void setTrnsDtlsCommChnlSeqId(Long trnsDtlsCommChnlSeqId) {
		this.trnsDtlsCommChnlSeqId = trnsDtlsCommChnlSeqId;
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

	public TransDtlsAudit getTransDtlsAudit() {
		return transDtlsAudit;
	}

	public void setTransDtlsAudit(TransDtlsAudit transDtlsAudit) {
		this.transDtlsAudit = transDtlsAudit;
	}

	
	
	

}

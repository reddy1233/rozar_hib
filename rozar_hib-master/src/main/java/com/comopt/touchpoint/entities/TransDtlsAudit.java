package com.comopt.touchpoint.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ccm_trans_dtls_audit")
public class TransDtlsAudit implements Serializable {

	private static final long serialVersionUID = 2699754268565902634L;

	@Id
	@Column(name = "trns_dtls_seq_id")
	private Long transDtlsSeqId;

	@Column(name = "source_sytem_trans_id")
	private String sourceSytemTransId;

	@Column(name = "comm_pfm_trns_id")
	private String commPfmTrnsId;

	@Column(name = "comm_pfm_status")
	private String commPfmStatus;

	@Column(name = "comm_pfm_status_cd")
	private String commPfmStatusCd;

	@Column(name = "comm_pfm_status_de")
	private String commPfmStatusDe;

	@Column(name = "audit_load_id")
	private String auditLoadId;

	@Column(name = "audit_load_tm")
	private String auditLoadTm;
	
	@Column(name= "mbr_id")
	private String mbrId;
	
	@Column(name= "grp_id")
	private String grpId;
	
	@Column(name="doc_type")
	private String docType;
	
	@Column(name="tp_status")
	private String tpStatus;
	
	@Column(name="del_chnl")
	private String delChnl;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "transDtlsAudit")
	private Set<TransDtlsCommChnlStatusAudit> transDtlsCommChnlStatusAudits;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "transDtlsAudit")
	private Set<TransDtlsStrgPfmStatusAudit> transDtlsStrgPfmStatusAudits;

	@ManyToOne
	@JoinColumn(name = "trans_id", nullable = false)
	private TransAudit transAudit;

	public Long getTransDtlsSeqId() {
		return transDtlsSeqId;
	}

	public void setTransDtlsSeqId(Long transDtlsSeqId) {
		this.transDtlsSeqId = transDtlsSeqId;
	}

	public String getSourceSytemTransId() {
		return sourceSytemTransId;
	}

	public void setSourceSytemTransId(String sourceSytemTransId) {
		this.sourceSytemTransId = sourceSytemTransId;
	}

	public String getCommPfmTrnsId() {
		return commPfmTrnsId;
	}

	public void setCommPfmTrnsId(String commPfmTrnsId) {
		this.commPfmTrnsId = commPfmTrnsId;
	}

	public String getCommPfmStatus() {
		return commPfmStatus;
	}

	public void setCommPfmStatus(String commPfmStatus) {
		this.commPfmStatus = commPfmStatus;
	}

	public String getCommPfmStatusCd() {
		return commPfmStatusCd;
	}

	public void setCommPfmStatusCd(String commPfmStatusCd) {
		this.commPfmStatusCd = commPfmStatusCd;
	}

	public String getCommPfmStatusDe() {
		return commPfmStatusDe;
	}

	public void setCommPfmStatusDe(String commPfmStatusDe) {
		this.commPfmStatusDe = commPfmStatusDe;
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

	public String getMbrId() {
		return mbrId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	public String getGrpId() {
		return grpId;
	}

	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getTpStatus() {
		return tpStatus;
	}

	public void setTpStatus(String tpStatus) {
		this.tpStatus = tpStatus;
	}

	public String getDelChnl() {
		return delChnl;
	}

	public void setDelChnl(String delChnl) {
		this.delChnl = delChnl;
	}

	public Set<TransDtlsCommChnlStatusAudit> getTransDtlsCommChnlStatusAudits() {
		return transDtlsCommChnlStatusAudits;
	}

	public void setTransDtlsCommChnlStatusAudits(Set<TransDtlsCommChnlStatusAudit> transDtlsCommChnlStatusAudits) {
		this.transDtlsCommChnlStatusAudits = transDtlsCommChnlStatusAudits;
	}

	public Set<TransDtlsStrgPfmStatusAudit> getTransDtlsStrgPfmStatusAudits() {
		return transDtlsStrgPfmStatusAudits;
	}

	public void setTransDtlsStrgPfmStatusAudits(Set<TransDtlsStrgPfmStatusAudit> transDtlsStrgPfmStatusAudits) {
		this.transDtlsStrgPfmStatusAudits = transDtlsStrgPfmStatusAudits;
	}

	
}

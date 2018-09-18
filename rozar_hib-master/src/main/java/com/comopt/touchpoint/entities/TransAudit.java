package com.comopt.touchpoint.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ccm_trans_audit")
public class TransAudit implements Serializable{

	
	private static final long serialVersionUID = 3726256088716562525L;

	@Id
	@Column(name = "trans_id")
	private Long transId;

	@Column(name = "file_nm")
	private String fileNm;

	//@Column(name = "source_sytem_cd")
	//@OneToOne @MapsId
	@OneToOne(optional=false)
    @JoinColumn(
     name="source_system_cd", unique=true, nullable=false, updatable=false)
	private SourceSys sourceSytemCd;

	@Column(name = "trans_type")
	private String transType;

	@Column(name = "comm_pfm_job_id")
	private String commPfmJobId;

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
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="transAudit")
	private Set<TransDtlsAudit> transDtlsAudits;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="transAudit")
	private Set<TransCommChnlStatusAudit> transCommChnlStatusAudits;
	

	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public String getFileNm() {
		return fileNm;
	}

	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}

	

	public SourceSys getSourceSytemCd() {
		return sourceSytemCd;
	}

	public void setSourceSytemCd(SourceSys sourceSytemCd) {
		this.sourceSytemCd = sourceSytemCd;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getCommPfmJobId() {
		return commPfmJobId;
	}

	public void setCommPfmJobId(String commPfmJobId) {
		this.commPfmJobId = commPfmJobId;
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

	public Set<TransDtlsAudit> getTransDtlsAudits() {
		return transDtlsAudits;
	}

	public void setTransDtlsAudits(Set<TransDtlsAudit> transDtlsAudits) {
		this.transDtlsAudits = transDtlsAudits;
	}

	public Set<TransCommChnlStatusAudit> getTransCommChnlStatusAudits() {
		return transCommChnlStatusAudits;
	}

	public void setTransCommChnlStatusAudits(Set<TransCommChnlStatusAudit> transCommChnlStatusAudits) {
		this.transCommChnlStatusAudits = transCommChnlStatusAudits;
	}

	@Override
	public String toString() {
		return "TransAudit [transId=" + transId + ", fileNm=" + fileNm + ", sourceSytemCd=" + sourceSytemCd
				+ ", transType=" + transType + ", commPfmJobId=" + commPfmJobId + ", commPfmStatus=" + commPfmStatus
				+ ", commPfmStatusCd=" + commPfmStatusCd + ", commPfmStatusDe=" + commPfmStatusDe + ", auditLoadId="
				+ auditLoadId + ", auditLoadTm=" + auditLoadTm + ", transDtlsAudits=" + transDtlsAudits
				+ ", transCommChnlStatusAudits=" + transCommChnlStatusAudits + "]";
	}
	
	
	

}

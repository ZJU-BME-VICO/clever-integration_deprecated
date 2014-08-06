package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;


public class ExamReport extends Entity {
	
	private String examId;
	private Integer reportNo;
	private Integer storageMode;
	private String reportUrl;
	private String examDesc;
	private String examView;
	private String examDiag;
	private String examMemo;
	private LocalDateTime reportDate;
	private String reporterId;
	private String reporterName;
	private String verifierId;
	private String verifierName;
	private String dataType;
	private String firstMediaName;
	private String firstPath;
	private String secondMediaName;
	private String secondPath;
	private Integer isAbnormal;
	private Integer _hibernarmId;
	private String _uid_value;
	
	public ExamReport() {
		super();
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public Integer getReportNo() {
		return reportNo;
	}

	public void setReportNo(Integer reportNo) {
		this.reportNo = reportNo;
	}

	public Integer getStorageMode() {
		return storageMode;
	}

	public void setStorageMode(Integer storageMode) {
		this.storageMode = storageMode;
	}

	public String getReportUrl() {
		return reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}

	public String getExamDesc() {
		return examDesc;
	}

	public void setExamDesc(String examDesc) {
		this.examDesc = examDesc;
	}

	public String getExamView() {
		return examView;
	}

	public void setExamView(String examView) {
		this.examView = examView;
	}

	public String getExamDiag() {
		return examDiag;
	}

	public void setExamDiag(String examDiag) {
		this.examDiag = examDiag;
	}

	public String getExamMemo() {
		return examMemo;
	}

	public void setExamMemo(String examMemo) {
		this.examMemo = examMemo;
	}

	public LocalDateTime getReportDate() {
		return reportDate;
	}

	public void setReportDate(LocalDateTime reportDate) {
		this.reportDate = reportDate;
	}

	public String getReporterId() {
		return reporterId;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public String getVerifierId() {
		return verifierId;
	}

	public void setVerifierId(String verifierId) {
		this.verifierId = verifierId;
	}

	public String getVerifierName() {
		return verifierName;
	}

	public void setVerifierName(String verifierName) {
		this.verifierName = verifierName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getFirstMediaName() {
		return firstMediaName;
	}

	public void setFirstMediaName(String firstMediaName) {
		this.firstMediaName = firstMediaName;
	}

	public String getFirstPath() {
		return firstPath;
	}

	public void setFirstPath(String firstPath) {
		this.firstPath = firstPath;
	}

	public String getSecondMediaName() {
		return secondMediaName;
	}

	public void setSecondMediaName(String secondMediaName) {
		this.secondMediaName = secondMediaName;
	}

	public String getSecondPath() {
		return secondPath;
	}

	public void setSecondPath(String secondPath) {
		this.secondPath = secondPath;
	}

	public Integer getIsAbnormal() {
		return isAbnormal;
	}

	public void setIsAbnormal(Integer isAbnormal) {
		this.isAbnormal = isAbnormal;
	}

	public Integer get_hibernarmId() {
		return _hibernarmId;
	}

	public void set_hibernarmId(Integer _hibernarmId) {
		this._hibernarmId = _hibernarmId;
	}

	public String get_uid_value() {
		return _uid_value;
	}

	public void set_uid_value(String _uid_value) {
		this._uid_value = _uid_value;
	}
	
}

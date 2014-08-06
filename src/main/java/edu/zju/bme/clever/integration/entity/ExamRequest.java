package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;

public class ExamRequest extends Entity {
	
	private String examReqId;
	private String patientId;
	private String visitId;
	private Integer orderId;
	private String priority;
	private LocalDateTime reqDateTime;
	private String reqDeptName;
	private String reqDeptId;
	private String reqDoctorName;
	private String reqDoctorId;
	private String purpose;
	private String syndrom;
	private String signs;
	private String relevantLabTest;
	private String relevantDiag;
	private String diagnosis;
	private String memo;
	private String transportationMode;
	private Integer examRequestStatus;
	private Integer _hibernarmId;
	private String _uid_value;
	
	public ExamRequest() {
		super();
	}

	public String getExamReqId() {
		return examReqId;
	}

	public void setExamReqId(String examReqId) {
		this.examReqId = examReqId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public LocalDateTime getReqDateTime() {
		return reqDateTime;
	}

	public void setReqDateTime(LocalDateTime reqDateTime) {
		this.reqDateTime = reqDateTime;
	}

	public String getReqDeptName() {
		return reqDeptName;
	}

	public void setReqDeptName(String reqDeptName) {
		this.reqDeptName = reqDeptName;
	}

	public String getReqDeptId() {
		return reqDeptId;
	}

	public void setReqDeptId(String reqDeptId) {
		this.reqDeptId = reqDeptId;
	}

	public String getReqDoctorName() {
		return reqDoctorName;
	}

	public void setReqDoctorName(String reqDoctorName) {
		this.reqDoctorName = reqDoctorName;
	}

	public String getReqDoctorId() {
		return reqDoctorId;
	}

	public void setReqDoctorId(String reqDoctorId) {
		this.reqDoctorId = reqDoctorId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getSyndrom() {
		return syndrom;
	}

	public void setSyndrom(String syndrom) {
		this.syndrom = syndrom;
	}

	public String getSigns() {
		return signs;
	}

	public void setSigns(String signs) {
		this.signs = signs;
	}

	public String getRelevantLabTest() {
		return relevantLabTest;
	}

	public void setRelevantLabTest(String relevantLabTest) {
		this.relevantLabTest = relevantLabTest;
	}

	public String getRelevantDiag() {
		return relevantDiag;
	}

	public void setRelevantDiag(String relevantDiag) {
		this.relevantDiag = relevantDiag;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getTransportationMode() {
		return transportationMode;
	}

	public void setTransportationMode(String transportationMode) {
		this.transportationMode = transportationMode;
	}

	public Integer getExamRequestStatus() {
		return examRequestStatus;
	}

	public void setExamRequestStatus(Integer examRequestStatus) {
		this.examRequestStatus = examRequestStatus;
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

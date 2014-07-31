package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;

public class LabTestRequest extends Entity {
	
	private String testReqId;
	private String patientId;
	private String visitId;
	private String orderId;
	private LocalDateTime reqDateTime;
	private String reqDeptName;
	private String reqDeptId;
	private String reqDoctorName;
	private String reqDoctorId;
	private String labTestSubjectCode;
	private String labTestSubjectName;
	private String testCause;
	private String relevantClinicDiag;
	private String sampleClassCode;
	private String sampleClassName;
	private String testTubeCode;
	private String testTubeName;
	private String labTestTypeCode;
	private String labTestTypeName;
	private String executeDeptCode;
	private String executeDeptName;
	private String notesForSpcm;
	private String priorityIdicator;
	private Integer labTestStatus;
	private Integer _hibernarmId;
	private String _uid_value;
	private Integer idPatient;
	private Integer idVisit;
	private Integer idOrder;
	
	public LabTestRequest() {
		super();
	}

	public String getTestReqId() {
		return testReqId;
	}

	public void setTestReqId(String testReqId) {
		this.testReqId = testReqId;
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public String getLabTestSubjectCode() {
		return labTestSubjectCode;
	}

	public void setLabTestSubjectCode(String labTestSubjectCode) {
		this.labTestSubjectCode = labTestSubjectCode;
	}

	public String getLabTestSubjectName() {
		return labTestSubjectName;
	}

	public void setLabTestSubjectName(String labTestSubjectName) {
		this.labTestSubjectName = labTestSubjectName;
	}

	public String getTestCause() {
		return testCause;
	}

	public void setTestCause(String testCause) {
		this.testCause = testCause;
	}

	public String getRelevantClinicDiag() {
		return relevantClinicDiag;
	}

	public void setRelevantClinicDiag(String relevantClinicDiag) {
		this.relevantClinicDiag = relevantClinicDiag;
	}

	public String getSampleClassCode() {
		return sampleClassCode;
	}

	public void setSampleClassCode(String sampleClassCode) {
		this.sampleClassCode = sampleClassCode;
	}

	public String getSampleClassName() {
		return sampleClassName;
	}

	public void setSampleClassName(String sampleClassName) {
		this.sampleClassName = sampleClassName;
	}

	public String getTestTubeCode() {
		return testTubeCode;
	}

	public void setTestTubeCode(String testTubeCode) {
		this.testTubeCode = testTubeCode;
	}

	public String getTestTubeName() {
		return testTubeName;
	}

	public void setTestTubeName(String testTubeName) {
		this.testTubeName = testTubeName;
	}

	public String getLabTestTypeCode() {
		return labTestTypeCode;
	}

	public void setLabTestTypeCode(String labTestTypeCode) {
		this.labTestTypeCode = labTestTypeCode;
	}

	public String getLabTestTypeName() {
		return labTestTypeName;
	}

	public void setLabTestTypeName(String labTestTypeName) {
		this.labTestTypeName = labTestTypeName;
	}

	public String getExecuteDeptCode() {
		return executeDeptCode;
	}

	public void setExecuteDeptCode(String executeDeptCode) {
		this.executeDeptCode = executeDeptCode;
	}

	public String getExecuteDeptName() {
		return executeDeptName;
	}

	public void setExecuteDeptName(String executeDeptName) {
		this.executeDeptName = executeDeptName;
	}

	public String getNotesForSpcm() {
		return notesForSpcm;
	}

	public void setNotesForSpcm(String notesForSpcm) {
		this.notesForSpcm = notesForSpcm;
	}

	public String getPriorityIdicator() {
		return priorityIdicator;
	}

	public void setPriorityIdicator(String priorityIdicator) {
		this.priorityIdicator = priorityIdicator;
	}

	public Integer getLabTestStatus() {
		return labTestStatus;
	}

	public void setLabTestStatus(Integer labTestStatus) {
		this.labTestStatus = labTestStatus;
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

	public Integer getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public Integer getIdVisit() {
		return idVisit;
	}

	public void setIdVisit(Integer idVisit) {
		this.idVisit = idVisit;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}
	
}

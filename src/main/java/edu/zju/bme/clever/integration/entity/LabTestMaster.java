package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;

public class LabTestMaster extends Entity {

	private Integer serialNo;
	private String testId;
	private String patientId;
	private String visitId;
	private String testReqId;
	private String hisTestId;
	private Integer orderId;
	private String testNo;
	private String labTestSubjectCode;
	private String labTestSubjectName;
	private String sampleClassCode;
	private String sampleClassName;
	private String testTubeCode;
	private String testTubeName;
	private String labTestTypeCode;
	private String labTestTypeName;
	private String executeDeptCode;
	private String executeDeptName;
	private Integer testStatus;
	private LocalDateTime testTime;
	private Integer isRead;
	private Integer isNormal;
	private Integer _hibernarmId;
	private String _uid_value;
	
	public LabTestMaster() {
		super();
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
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

	public String getTestReqId() {
		return testReqId;
	}

	public void setTestReqId(String testReqId) {
		this.testReqId = testReqId;
	}

	public String getHisTestId() {
		return hisTestId;
	}

	public void setHisTestId(String hisTestId) {
		this.hisTestId = hisTestId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getTestNo() {
		return testNo;
	}

	public void setTestNo(String testNo) {
		this.testNo = testNo;
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

	public Integer getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(Integer testStatus) {
		this.testStatus = testStatus;
	}

	public LocalDateTime getTestTime() {
		return testTime;
	}

	public void setTestTime(LocalDateTime testTime) {
		this.testTime = testTime;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public Integer getIsNormal() {
		return isNormal;
	}

	public void setIsNormal(Integer isNormal) {
		this.isNormal = isNormal;
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

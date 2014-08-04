package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;

public class ExamMaster extends Entity {
	
	private String examId;
	private String patientId;
	private String visitId;
	private String examReqId;
	private String hisExamId;
	private String examDeptName;
	private String examDeptCode;
	private LocalDateTime scheduledDateTime;
	private LocalDateTime examTime;
	private Integer examStatus;
	private Integer isRead;
	private Integer isNormal;
	private Integer serialNo;
	private Integer _hibernarmId;
	private String _uid_value;
	private Integer idPatient;
	private Integer idVisit;
	private Integer idExamRequest;
	
	public ExamMaster() {
		super();
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
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

	public String getExamReqId() {
		return examReqId;
	}

	public void setExamReqId(String examReqId) {
		this.examReqId = examReqId;
	}

	public String getHisExamId() {
		return hisExamId;
	}

	public void setHisExamId(String hisExamId) {
		this.hisExamId = hisExamId;
	}

	public String getExamDeptName() {
		return examDeptName;
	}

	public void setExamDeptName(String examDeptName) {
		this.examDeptName = examDeptName;
	}

	public String getExamDeptCode() {
		return examDeptCode;
	}

	public void setExamDeptCode(String examDeptCode) {
		this.examDeptCode = examDeptCode;
	}

	public LocalDateTime getScheduledDateTime() {
		return scheduledDateTime;
	}

	public void setScheduledDateTime(LocalDateTime scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}

	public LocalDateTime getExamTime() {
		return examTime;
	}

	public void setExamTime(LocalDateTime examTime) {
		this.examTime = examTime;
	}

	public Integer getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(Integer examStatus) {
		this.examStatus = examStatus;
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

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
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

	public Integer getIdExamRequest() {
		return idExamRequest;
	}

	public void setIdExamRequest(Integer idExamRequest) {
		this.idExamRequest = idExamRequest;
	}
	
}

package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;


public class ExamAction extends Entity {
	
	private Integer serialNo;
	private String examReqId;
	private String examId;
	private String actorId;
	private LocalDateTime actionDateTime;
	private String actionTypeId;
	private String actionMemo;
	private String actorName;
	private Integer _hibernarmId;
	private String _uid_value;
	private Integer idExamRequest;
	private Integer idExamMaster;
	
	public ExamAction() {
		super();
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getExamReqId() {
		return examReqId;
	}

	public void setExamReqId(String examReqId) {
		this.examReqId = examReqId;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getActorId() {
		return actorId;
	}

	public void setActorId(String actorId) {
		this.actorId = actorId;
	}

	public LocalDateTime getActionDateTime() {
		return actionDateTime;
	}

	public void setActionDateTime(LocalDateTime actionDateTime) {
		this.actionDateTime = actionDateTime;
	}

	public String getActionTypeId() {
		return actionTypeId;
	}

	public void setActionTypeId(String actionTypeId) {
		this.actionTypeId = actionTypeId;
	}

	public String getActionMemo() {
		return actionMemo;
	}

	public void setActionMemo(String actionMemo) {
		this.actionMemo = actionMemo;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
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

	public Integer getIdExamRequest() {
		return idExamRequest;
	}

	public void setIdExamRequest(Integer idExamRequest) {
		this.idExamRequest = idExamRequest;
	}

	public Integer getIdExamMaster() {
		return idExamMaster;
	}

	public void setIdExamMaster(Integer idExamMaster) {
		this.idExamMaster = idExamMaster;
	}
	
}

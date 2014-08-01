package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;

public class LabTestAction extends Entity {

	private String testReqId;
	private String testId;
	private String actorId;
	private LocalDateTime actionDateTime;
	private String actionTypeId;
	private String actionMemo;
	private String actorName;
	private Integer serialNo;
	private Integer _hibernarmId;
	private String _uid_value;
	private Integer idLabTestRequest;
	
	public LabTestAction() {
		super();
	}

	public String getTestReqId() {
		return testReqId;
	}

	public void setTestReqId(String testReqId) {
		this.testReqId = testReqId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
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

	public Integer getIdLabTestRequest() {
		return idLabTestRequest;
	}

	public void setIdLabTestRequest(Integer idLabTestRequest) {
		this.idLabTestRequest = idLabTestRequest;
	}
	
}

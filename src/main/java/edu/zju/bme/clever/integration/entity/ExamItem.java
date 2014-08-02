package edu.zju.bme.clever.integration.entity;


public class ExamItem extends Entity {
	
	private Integer serialNo;
	private String examReqId;
	private String examId;
	private Integer examItemNo;
	private String examClass;
	private String examSubClass;
	private String examItemName;
	private String examItemCode;
	private Integer _hibernarmId;
	private String _uid_value;
	private Integer idExamRequest;
	private Integer idExamMaster;
	
	public ExamItem() {
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

	public Integer getExamItemNo() {
		return examItemNo;
	}

	public void setExamItemNo(Integer examItemNo) {
		this.examItemNo = examItemNo;
	}

	public String getExamClass() {
		return examClass;
	}

	public void setExamClass(String examClass) {
		this.examClass = examClass;
	}

	public String getExamSubClass() {
		return examSubClass;
	}

	public void setExamSubClass(String examSubClass) {
		this.examSubClass = examSubClass;
	}

	public String getExamItemName() {
		return examItemName;
	}

	public void setExamItemName(String examItemName) {
		this.examItemName = examItemName;
	}

	public String getExamItemCode() {
		return examItemCode;
	}

	public void setExamItemCode(String examItemCode) {
		this.examItemCode = examItemCode;
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

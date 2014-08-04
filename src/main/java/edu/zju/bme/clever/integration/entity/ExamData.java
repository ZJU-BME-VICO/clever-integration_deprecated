package edu.zju.bme.clever.integration.entity;


public class ExamData extends Entity {
	
	private String examId;
	private Integer dataNo;
	private String dataType;
	private String seriesNo;
	private String imageNo;
	private Integer imageFlag;
	private String firstMediaName;
	private String firstPath;
	private String secondMediaName;
	private String secondPath;
	private Integer _hibernarmId;
	private String _uid_value;
	private Integer idExamMaster;
	
	public ExamData() {
		super();
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public Integer getDataNo() {
		return dataNo;
	}

	public void setDataNo(Integer dataNo) {
		this.dataNo = dataNo;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getSeriesNo() {
		return seriesNo;
	}

	public void setSeriesNo(String seriesNo) {
		this.seriesNo = seriesNo;
	}

	public String getImageNo() {
		return imageNo;
	}

	public void setImageNo(String imageNo) {
		this.imageNo = imageNo;
	}

	public Integer getImageFlag() {
		return imageFlag;
	}

	public void setImageFlag(Integer imageFlag) {
		this.imageFlag = imageFlag;
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

	public Integer getIdExamMaster() {
		return idExamMaster;
	}

	public void setIdExamMaster(Integer idExamMaster) {
		this.idExamMaster = idExamMaster;
	}
	
}

package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;

public class Allergy extends Entity {
	
	private Integer allergyId;
	private String patientId;
	private String visitId;
	private Integer orderId;
	private Integer infoSourceType;
	private Integer allergyClassCode;
	private String allergySource;
	private String memo;
	private String editor;
	private LocalDateTime editDateTime;
	private Integer allergySubClassCode;
	private String drugTradeName;
	private String drugRatifyCode;
	private String drugManufacturer;
	private String productionBatchNo;
	private Integer _hibernarmId;
	private String _uid_value;
	private Integer idPatient;
	private Integer idVisit;
	private Integer idOrder;
	
	public Allergy() {
		super();
	}

	public Integer getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(Integer allergyId) {
		this.allergyId = allergyId;
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

	public Integer getInfoSourceType() {
		return infoSourceType;
	}

	public void setInfoSourceType(Integer infoSourceType) {
		this.infoSourceType = infoSourceType;
	}

	public Integer getAllergyClassCode() {
		return allergyClassCode;
	}

	public void setAllergyClassCode(Integer allergyClassCode) {
		this.allergyClassCode = allergyClassCode;
	}

	public String getAllergySource() {
		return allergySource;
	}

	public void setAllergySource(String allergySource) {
		this.allergySource = allergySource;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public LocalDateTime getEditDateTime() {
		return editDateTime;
	}

	public void setEditDateTime(LocalDateTime editDateTime) {
		this.editDateTime = editDateTime;
	}

	public Integer getAllergySubClassCode() {
		return allergySubClassCode;
	}

	public void setAllergySubClassCode(Integer allergySubClassCode) {
		this.allergySubClassCode = allergySubClassCode;
	}

	public String getDrugTradeName() {
		return drugTradeName;
	}

	public void setDrugTradeName(String drugTradeName) {
		this.drugTradeName = drugTradeName;
	}

	public String getDrugRatifyCode() {
		return drugRatifyCode;
	}

	public void setDrugRatifyCode(String drugRatifyCode) {
		this.drugRatifyCode = drugRatifyCode;
	}

	public String getDrugManufacturer() {
		return drugManufacturer;
	}

	public void setDrugManufacturer(String drugManufacturer) {
		this.drugManufacturer = drugManufacturer;
	}

	public String getProductionBatchNo() {
		return productionBatchNo;
	}

	public void setProductionBatchNo(String productionBatchNo) {
		this.productionBatchNo = productionBatchNo;
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

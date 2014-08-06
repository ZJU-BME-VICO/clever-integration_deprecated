package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;

public class LabTestData extends Entity {

	private String patientId;
	private String visitId;
	private String testId;
	private String testItemNo;
	private String testItemName;
	private String testItemCode;
	private String result;
	private String units;
	private String abnormalIndicator;
	private String normalReferenceValues;
	private String instrumentId;
	private LocalDateTime resultDateTime;
	private Integer testDataId;
	private Integer _hibernarmId;
	private String _uid_value;
	
	public LabTestData() {
		super();
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

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestItemNo() {
		return testItemNo;
	}

	public void setTestItemNo(String testItemNo) {
		this.testItemNo = testItemNo;
	}

	public String getTestItemName() {
		return testItemName;
	}

	public void setTestItemName(String testItemName) {
		this.testItemName = testItemName;
	}

	public String getTestItemCode() {
		return testItemCode;
	}

	public void setTestItemCode(String testItemCode) {
		this.testItemCode = testItemCode;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getAbnormalIndicator() {
		return abnormalIndicator;
	}

	public void setAbnormalIndicator(String abnormalIndicator) {
		this.abnormalIndicator = abnormalIndicator;
	}

	public String getNormalReferenceValues() {
		return normalReferenceValues;
	}

	public void setNormalReferenceValues(String normalReferenceValues) {
		this.normalReferenceValues = normalReferenceValues;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public LocalDateTime getResultDateTime() {
		return resultDateTime;
	}

	public void setResultDateTime(LocalDateTime resultDateTime) {
		this.resultDateTime = resultDateTime;
	}

	public Integer getTestDataId() {
		return testDataId;
	}

	public void setTestDataId(Integer testDataId) {
		this.testDataId = testDataId;
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

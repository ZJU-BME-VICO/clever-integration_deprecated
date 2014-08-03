package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;

public class Diagnosis extends Entity {
	
	private Integer diagnosisId;
	private String patientId;
	private String visitId;
	private Integer diagnosisClassId;
	private Integer diagnosisNo;
	private String diagnosisItemCode;
	private String diagnosisItemName;
	private String admissionIllness;
	private Integer treatDays;
	private String treatResult;
	private Integer operTreatIndicator;
	private String doctor;
	private LocalDateTime diagnosisDateTime;
	private Integer _hibernarmId;
	private String _uid_value;
	private Integer idPatient;
	private Integer idVisit;
	
	public Diagnosis() {
		super();
	}

	public Integer getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(Integer diagnosisId) {
		this.diagnosisId = diagnosisId;
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

	public Integer getDiagnosisClassId() {
		return diagnosisClassId;
	}

	public void setDiagnosisClassId(Integer diagnosisClassId) {
		this.diagnosisClassId = diagnosisClassId;
	}

	public Integer getDiagnosisNo() {
		return diagnosisNo;
	}

	public void setDiagnosisNo(Integer diagnosisNo) {
		this.diagnosisNo = diagnosisNo;
	}

	public String getDiagnosisItemCode() {
		return diagnosisItemCode;
	}

	public void setDiagnosisItemCode(String diagnosisItemCode) {
		this.diagnosisItemCode = diagnosisItemCode;
	}

	public String getDiagnosisItemName() {
		return diagnosisItemName;
	}

	public void setDiagnosisItemName(String diagnosisItemName) {
		this.diagnosisItemName = diagnosisItemName;
	}

	public String getAdmissionIllness() {
		return admissionIllness;
	}

	public void setAdmissionIllness(String admissionIllness) {
		this.admissionIllness = admissionIllness;
	}

	public Integer getTreatDays() {
		return treatDays;
	}

	public void setTreatDays(Integer treatDays) {
		this.treatDays = treatDays;
	}

	public String getTreatResult() {
		return treatResult;
	}

	public void setTreatResult(String treatResult) {
		this.treatResult = treatResult;
	}

	public Integer getOperTreatIndicator() {
		return operTreatIndicator;
	}

	public void setOperTreatIndicator(Integer operTreatIndicator) {
		this.operTreatIndicator = operTreatIndicator;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public LocalDateTime getDiagnosisDateTime() {
		return diagnosisDateTime;
	}

	public void setDiagnosisDateTime(LocalDateTime diagnosisDateTime) {
		this.diagnosisDateTime = diagnosisDateTime;
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
	
}

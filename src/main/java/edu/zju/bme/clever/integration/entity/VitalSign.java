package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;

public class VitalSign extends Entity {
	
	private Integer recordId;
	private String patientId;
	private String visitId;
	private LocalDateTime timePoint;
	private String vitalSignsItem;
	private String vitalSignsValues;
	private String units;
	private String recorder;
	private LocalDateTime recordingDateTime;
	private Integer flag;
	private Integer _hibernarmId;
	private String _uid_value;
	private Integer idPatient;
	private Integer idVisit;
	
	public VitalSign() {
		super();
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
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

	public LocalDateTime getTimePoint() {
		return timePoint;
	}

	public void setTimePoint(LocalDateTime timePoint) {
		this.timePoint = timePoint;
	}

	public String getVitalSignsItem() {
		return vitalSignsItem;
	}

	public void setVitalSignsItem(String vitalSignsItem) {
		this.vitalSignsItem = vitalSignsItem;
	}

	public String getVitalSignsValues() {
		return vitalSignsValues;
	}

	public void setVitalSignsValues(String vitalSignsValues) {
		this.vitalSignsValues = vitalSignsValues;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public LocalDateTime getRecordingDateTime() {
		return recordingDateTime;
	}

	public void setRecordingDateTime(LocalDateTime recordingDateTime) {
		this.recordingDateTime = recordingDateTime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
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

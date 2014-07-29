package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;

public class Order extends Entity {

	private Integer orderId;
	private String patientId;
	private String visitId;
	private Integer orderNo;
	private Integer orderSubNo;
	private Integer emergencyAttr;
	private Integer motherBabyAttr;
	private Integer ownDrugAttr;
	private Integer skinTestAttr;
	private Integer reservedOrderAttr;
	private Integer afterwardOrderAttr;
	private Integer repeatIndicator;
	private String orderClass;
	private String orderText;
	private String orderCode;
	private Double dosage;
	private String dosageUnits;
	private String administrationCode;
	private String administration;
	private LocalDateTime startDateTime;
	private LocalDateTime stopDateTimePlan;
	private LocalDateTime stopDateTime;
	private Integer duration;
	private String durationUnits;
	private String freqCode;
	private String frequency;
	private Integer freqCounter;
	private Integer freqInterval;
	private String freqIntervalUnit;
	private String memo;
	private String orderingDeptName;
	private String orderingDeptCode;
	private String startDoctorName;
	private String startDoctorCode;
	private String stopDoctorName;
	private String stopDoctorCode;
	private String performWardName;
	private String performWardCode;
	private String startNurseName;
	private String startNurseCode;
	private String stopNurseName;
	private String stopNurseCode;
	private LocalDateTime startOrderEnterDateTime;
	private LocalDateTime stopOrderEnterDateTime;
	private Integer orderStatus;
	private String orderStatusMemo;
	private String cdsSemantics;
	private Integer orderPrintAttr;
	private LocalDateTime lastPerformDateTime;
	private LocalDateTime lastActingDateTime;
	private LocalDateTime checkDateTime;
	private Integer _hibernarmId;
	private String _uid_value;
	private Integer idPatient;
	private Integer idVisit;
	
	public Order() {
		super();
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderSubNo() {
		return orderSubNo;
	}

	public void setOrderSubNo(Integer orderSubNo) {
		this.orderSubNo = orderSubNo;
	}

	public Integer getEmergencyAttr() {
		return emergencyAttr;
	}

	public void setEmergencyAttr(Integer emergencyAttr) {
		this.emergencyAttr = emergencyAttr;
	}

	public Integer getMotherBabyAttr() {
		return motherBabyAttr;
	}

	public void setMotherBabyAttr(Integer motherBabyAttr) {
		this.motherBabyAttr = motherBabyAttr;
	}

	public Integer getOwnDrugAttr() {
		return ownDrugAttr;
	}

	public void setOwnDrugAttr(Integer ownDrugAttr) {
		this.ownDrugAttr = ownDrugAttr;
	}

	public Integer getSkinTestAttr() {
		return skinTestAttr;
	}

	public void setSkinTestAttr(Integer skinTestAttr) {
		this.skinTestAttr = skinTestAttr;
	}

	public Integer getReservedOrderAttr() {
		return reservedOrderAttr;
	}

	public void setReservedOrderAttr(Integer reservedOrderAttr) {
		this.reservedOrderAttr = reservedOrderAttr;
	}

	public Integer getAfterwardOrderAttr() {
		return afterwardOrderAttr;
	}

	public void setAfterwardOrderAttr(Integer afterwardOrderAttr) {
		this.afterwardOrderAttr = afterwardOrderAttr;
	}

	public Integer getRepeatIndicator() {
		return repeatIndicator;
	}

	public void setRepeatIndicator(Integer repeatIndicator) {
		this.repeatIndicator = repeatIndicator;
	}

	public String getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(String orderClass) {
		this.orderClass = orderClass;
	}

	public String getOrderText() {
		return orderText;
	}

	public void setOrderText(String orderText) {
		this.orderText = orderText;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Double getDosage() {
		return dosage;
	}

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

	public String getDosageUnits() {
		return dosageUnits;
	}

	public void setDosageUnits(String dosageUnits) {
		this.dosageUnits = dosageUnits;
	}

	public String getAdministrationCode() {
		return administrationCode;
	}

	public void setAdministrationCode(String administrationCode) {
		this.administrationCode = administrationCode;
	}

	public String getAdministration() {
		return administration;
	}

	public void setAdministration(String administration) {
		this.administration = administration;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getStopDateTimePlan() {
		return stopDateTimePlan;
	}

	public void setStopDateTimePlan(LocalDateTime stopDateTimePlan) {
		this.stopDateTimePlan = stopDateTimePlan;
	}

	public LocalDateTime getStopDateTime() {
		return stopDateTime;
	}

	public void setStopDateTime(LocalDateTime stopDateTime) {
		this.stopDateTime = stopDateTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDurationUnits() {
		return durationUnits;
	}

	public void setDurationUnits(String durationUnits) {
		this.durationUnits = durationUnits;
	}

	public String getFreqCode() {
		return freqCode;
	}

	public void setFreqCode(String freqCode) {
		this.freqCode = freqCode;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Integer getFreqCounter() {
		return freqCounter;
	}

	public void setFreqCounter(Integer freqCounter) {
		this.freqCounter = freqCounter;
	}

	public Integer getFreqInterval() {
		return freqInterval;
	}

	public void setFreqInterval(Integer freqInterval) {
		this.freqInterval = freqInterval;
	}

	public String getFreqIntervalUnit() {
		return freqIntervalUnit;
	}

	public void setFreqIntervalUnit(String freqIntervalUnit) {
		this.freqIntervalUnit = freqIntervalUnit;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOrderingDeptName() {
		return orderingDeptName;
	}

	public void setOrderingDeptName(String orderingDeptName) {
		this.orderingDeptName = orderingDeptName;
	}

	public String getOrderingDeptCode() {
		return orderingDeptCode;
	}

	public void setOrderingDeptCode(String orderingDeptCode) {
		this.orderingDeptCode = orderingDeptCode;
	}

	public String getStartDoctorName() {
		return startDoctorName;
	}

	public void setStartDoctorName(String startDoctorName) {
		this.startDoctorName = startDoctorName;
	}

	public String getStartDoctorCode() {
		return startDoctorCode;
	}

	public void setStartDoctorCode(String startDoctorCode) {
		this.startDoctorCode = startDoctorCode;
	}

	public String getStopDoctorName() {
		return stopDoctorName;
	}

	public void setStopDoctorName(String stopDoctorName) {
		this.stopDoctorName = stopDoctorName;
	}

	public String getStopDoctorCode() {
		return stopDoctorCode;
	}

	public void setStopDoctorCode(String stopDoctorCode) {
		this.stopDoctorCode = stopDoctorCode;
	}

	public String getPerformWardName() {
		return performWardName;
	}

	public void setPerformWardName(String performWardName) {
		this.performWardName = performWardName;
	}

	public String getPerformWardCode() {
		return performWardCode;
	}

	public void setPerformWardCode(String performWardCode) {
		this.performWardCode = performWardCode;
	}

	public String getStartNurseName() {
		return startNurseName;
	}

	public void setStartNurseName(String startNurseName) {
		this.startNurseName = startNurseName;
	}

	public String getStartNurseCode() {
		return startNurseCode;
	}

	public void setStartNurseCode(String startNurseCode) {
		this.startNurseCode = startNurseCode;
	}

	public String getStopNurseName() {
		return stopNurseName;
	}

	public void setStopNurseName(String stopNurseName) {
		this.stopNurseName = stopNurseName;
	}

	public String getStopNurseCode() {
		return stopNurseCode;
	}

	public void setStopNurseCode(String stopNurseCode) {
		this.stopNurseCode = stopNurseCode;
	}

	public LocalDateTime getStartOrderEnterDateTime() {
		return startOrderEnterDateTime;
	}

	public void setStartOrderEnterDateTime(LocalDateTime startOrderEnterDateTime) {
		this.startOrderEnterDateTime = startOrderEnterDateTime;
	}

	public LocalDateTime getStopOrderEnterDateTime() {
		return stopOrderEnterDateTime;
	}

	public void setStopOrderEnterDateTime(LocalDateTime stopOrderEnterDateTime) {
		this.stopOrderEnterDateTime = stopOrderEnterDateTime;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusMemo() {
		return orderStatusMemo;
	}

	public void setOrderStatusMemo(String orderStatusMemo) {
		this.orderStatusMemo = orderStatusMemo;
	}

	public String getCdsSemantics() {
		return cdsSemantics;
	}

	public void setCdsSemantics(String cdsSemantics) {
		this.cdsSemantics = cdsSemantics;
	}

	public Integer getOrderPrintAttr() {
		return orderPrintAttr;
	}

	public void setOrderPrintAttr(Integer orderPrintAttr) {
		this.orderPrintAttr = orderPrintAttr;
	}

	public LocalDateTime getLastPerformDateTime() {
		return lastPerformDateTime;
	}

	public void setLastPerformDateTime(LocalDateTime lastPerformDateTime) {
		this.lastPerformDateTime = lastPerformDateTime;
	}

	public LocalDateTime getLastActingDateTime() {
		return lastActingDateTime;
	}

	public void setLastActingDateTime(LocalDateTime lastActingDateTime) {
		this.lastActingDateTime = lastActingDateTime;
	}

	public LocalDateTime getCheckDateTime() {
		return checkDateTime;
	}

	public void setCheckDateTime(LocalDateTime checkDateTime) {
		this.checkDateTime = checkDateTime;
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

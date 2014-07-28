package edu.zju.bme.clever.integration.entity;

import java.time.LocalDateTime;

public class Visit extends Entity {

	private Integer serialNo;
	private Integer mpimlSerialNo;
	private String visitType;
	private String visitId;
	private String hisVisitId;
	private String hisVisitSubId;
	private String departmentCode;
	private String departmentName;
	private String wardCode;
	private String wardName;
	private LocalDateTime visitTime;
	private Integer status;
	private Integer _hibernarmId;
	private String _uid_value;
	private Integer idPatient;
	
	public Visit() {
		super();
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getMpimlSerialNo() {
		return mpimlSerialNo;
	}

	public void setMpimlSerialNo(Integer mpimlSerialNo) {
		this.mpimlSerialNo = mpimlSerialNo;
	}

	public String getVisitType() {
		return visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getHisVisitId() {
		return hisVisitId;
	}

	public void setHisVisitId(String hisVisitId) {
		this.hisVisitId = hisVisitId;
	}

	public String getHisVisitSubId() {
		return hisVisitSubId;
	}

	public void setHisVisitSubId(String hisVisitSubId) {
		this.hisVisitSubId = hisVisitSubId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getWardCode() {
		return wardCode;
	}

	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public LocalDateTime getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(LocalDateTime visitTime) {
		this.visitTime = visitTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
	
}

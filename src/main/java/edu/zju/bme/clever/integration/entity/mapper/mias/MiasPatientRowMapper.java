package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasPatientRowMapper implements RowMapper<Patient> {

	public enum MASTER_PATIENT_INDEX {
		SERIAL_NO, 
		PATIENT_ID, 
		NAME, 
		NAME_PHONETIC, 
		GENDER, 
		DATE_OF_BIRTH,
		BIRTH_PLACE,
		NATIONALITY,
		ETHNIC_GROUP,
		MARITAL_STATUS,
		CAREER,
		DEGREE,
		BLOOD_TYPE_ABO,
		BLOOD_TYPE_RH,
		IDENTITY_CARD_NO,
		HOUSEHOLD_NO,
		PASSPORT_NO,
		MILITARY_ID,
		HEALTH_INSURANCE_ID,
		HEALTH_CARD_NO,
		EMAIL,
		MAILING_ADDRESS,
		ZIP_CODE,
		PHONE_NO_MOBILE,
		PHONE_NO_HOME,
		PHONE_NO_BUSINESS,
		DEATH_INDICATOR,
		DEATH_TIME,
		CREATED_DATE,
		CREATED_BY,
		LAST_MODIFY_DATE,
		LAST_MODIFIED_BY,
		VOIDED_INDICATOR,
		VOIDED_DATE,
		VOIDED_BY,
		REF_PATIENT_ID,
		INPATIENTNO,
		OUTPATIENTNO,
		EMERGENCYNO,
		PATIENT_HEALTHCARE_TYPE_CODE,
		PATIENT_HEALTHCARE_TYPE_NAME,
		PATIENT_HEALTHCARE_PROPERTY_CODE,
		PATIENT_HEALTHCARE_PROPERTY_NAME,
	}

	@Override
	public Patient mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Patient p = new Patient();
		p.setSerialNo(RowMapperUtil.getInteger(rs, MiasPatientRowMapper.MASTER_PATIENT_INDEX.SERIAL_NO.toString()));
		p.setPatientId(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.PATIENT_ID.toString()));
		p.setName(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.NAME.toString()));
		p.setNamePhonetic(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.NAME_PHONETIC.toString()));
		p.setGender(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.GENDER.toString()));
		p.setDateOfBirth(RowMapperUtil.getDateTime(
				rs.getTimestamp(MiasPatientRowMapper.MASTER_PATIENT_INDEX.DATE_OF_BIRTH.toString())));
		p.setBirthPlace(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.BIRTH_PLACE.toString()));
		p.setNationality(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.NATIONALITY.toString()));
		p.setEthnicGroup(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.ETHNIC_GROUP.toString()));
		p.setMaritalStatus(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.MARITAL_STATUS.toString()));
		p.setCareer(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.CAREER.toString()));
		p.setDegree(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.DEGREE.toString()));
		p.setBloodTypeAbo(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.BLOOD_TYPE_ABO.toString()));
		p.setBloodTypeRh(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.BLOOD_TYPE_RH.toString()));
		p.setIdentityCardNo(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.IDENTITY_CARD_NO.toString()));
		p.setHouseholdNo(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.HOUSEHOLD_NO.toString()));
		p.setPassportId(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.PASSPORT_NO.toString()));
		p.setMilitaryId(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.MILITARY_ID.toString()));
		p.setHealthInsuranceId(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.HEALTH_INSURANCE_ID.toString()));
		p.setHealthCardNo(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.HEALTH_CARD_NO.toString()));
		p.setEmail(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.EMAIL.toString()));
		p.setMailingAddress(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.MAILING_ADDRESS.toString()));
		p.setZipCode(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.ZIP_CODE.toString()));
		p.setPhoneNoMobile(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.PHONE_NO_MOBILE.toString()));
		p.setPhoneNoHome(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.PHONE_NO_HOME.toString()));
		p.setPhoneNoBusiness(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.PHONE_NO_BUSINESS.toString()));
		p.setDeathIndicator(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.DEATH_INDICATOR.toString()));
		p.setDeathTime(RowMapperUtil.getDateTime(
				rs.getTimestamp(MiasPatientRowMapper.MASTER_PATIENT_INDEX.DEATH_TIME.toString())));
		p.setCreatedDate(RowMapperUtil.getDateTime(
				rs.getTimestamp(MiasPatientRowMapper.MASTER_PATIENT_INDEX.CREATED_DATE.toString())));
		p.setCreatedBy(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.CREATED_BY.toString()));
		p.setLastModifyDate(RowMapperUtil.getDateTime(
				rs.getTimestamp(MiasPatientRowMapper.MASTER_PATIENT_INDEX.LAST_MODIFY_DATE.toString())));
		p.setLastModifiedBy(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.LAST_MODIFIED_BY.toString()));
		p.setVoidedIndicator(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.VOIDED_INDICATOR.toString()));
		p.setVoidedDate(RowMapperUtil.getDateTime(
				rs.getTimestamp(MiasPatientRowMapper.MASTER_PATIENT_INDEX.VOIDED_DATE.toString())));
		p.setVoidedBy(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.VOIDED_BY.toString()));
		p.setRefPatientId(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.REF_PATIENT_ID.toString()));
		p.setInpatientNo(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.INPATIENTNO.toString()));
		p.setOutpatientNo(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.OUTPATIENTNO.toString()));
		p.setEmergencyNo(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.EMERGENCYNO.toString()));
		p.setPatientHealthcareTypeCode(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.PATIENT_HEALTHCARE_TYPE_CODE.toString()));
		p.setPatientHealthcareTypeName(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.PATIENT_HEALTHCARE_TYPE_NAME.toString()));
		p.setPatientHealthcarePropertyCode(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.PATIENT_HEALTHCARE_PROPERTY_CODE.toString()));
		p.setPatientHealthcarePropertyName(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX.PATIENT_HEALTHCARE_PROPERTY_NAME.toString()));
		return p;
	}

}

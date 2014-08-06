package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasPatientRowMapper implements RowMapper<Patient> {

	public enum MASTER_PATIENT_INDEX_MODIFYED_LOG {
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
		PATIENT_HEALTHCARE_TYPE_CODE,
		PATIENT_HEALTHCARE_TYPE_NAME,
		PATIENT_HEALTHCARE_PROPERTY_CODE,
		PATIENT_HEALTHCARE_PROPERTY_NAME,
	    MPI_SERIAL_NO,
	    EDIT_TIME,
	}

	@Override
	public Patient mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Patient p = new Patient();
		p.setSerialNo(RowMapperUtil.getInteger(rs, MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.SERIAL_NO.toString()));
		p.setPatientId(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.PATIENT_ID.toString()));
		p.setName(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.NAME.toString()));
		p.setNamePhonetic(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.NAME_PHONETIC.toString()));
		p.setGender(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.GENDER.toString()));
		p.setDateOfBirth(RowMapperUtil.getDateTime(
				rs.getTimestamp(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.DATE_OF_BIRTH.toString())));
		p.setBirthPlace(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.BIRTH_PLACE.toString()));
		p.setNationality(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.NATIONALITY.toString()));
		p.setEthnicGroup(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.ETHNIC_GROUP.toString()));
		p.setMaritalStatus(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.MARITAL_STATUS.toString()));
		p.setCareer(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.CAREER.toString()));
		p.setDegree(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.DEGREE.toString()));
		p.setBloodTypeAbo(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.BLOOD_TYPE_ABO.toString()));
		p.setBloodTypeRh(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.BLOOD_TYPE_RH.toString()));
		p.setIdentityCardNo(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.IDENTITY_CARD_NO.toString()));
		p.setHouseholdNo(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.HOUSEHOLD_NO.toString()));
		p.setPassportId(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.PASSPORT_NO.toString()));
		p.setMilitaryId(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.MILITARY_ID.toString()));
		p.setHealthInsuranceId(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.HEALTH_INSURANCE_ID.toString()));
		p.setHealthCardNo(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.HEALTH_CARD_NO.toString()));
		p.setEmail(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.EMAIL.toString()));
		p.setMailingAddress(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.MAILING_ADDRESS.toString()));
		p.setZipCode(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.ZIP_CODE.toString()));
		p.setPhoneNoMobile(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.PHONE_NO_MOBILE.toString()));
		p.setPhoneNoHome(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.PHONE_NO_HOME.toString()));
		p.setPhoneNoBusiness(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.PHONE_NO_BUSINESS.toString()));
		p.setDeathIndicator(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.DEATH_INDICATOR.toString()));
		p.setDeathTime(RowMapperUtil.getDateTime(
				rs.getTimestamp(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.DEATH_TIME.toString())));
		p.setCreatedDate(RowMapperUtil.getDateTime(
				rs.getTimestamp(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.CREATED_DATE.toString())));
		p.setCreatedBy(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.CREATED_BY.toString()));
		p.setPatientHealthcareTypeCode(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.PATIENT_HEALTHCARE_TYPE_CODE.toString()));
		p.setPatientHealthcareTypeName(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.PATIENT_HEALTHCARE_TYPE_NAME.toString()));
		p.setPatientHealthcarePropertyCode(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.PATIENT_HEALTHCARE_PROPERTY_CODE.toString()));
		p.setPatientHealthcarePropertyName(rs.getString(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.PATIENT_HEALTHCARE_PROPERTY_NAME.toString()));
		p.setMpiSerialNo(RowMapperUtil.getInteger(rs, MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.MPI_SERIAL_NO.toString()));
		p.setEditTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasPatientRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.EDIT_TIME.toString())));
		return p;
	}

}

package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrPatientRowMapper implements RowMapper<Patient> {

	public enum openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log {
		_hibernarmId, 
		patient_id, 
		name, 
		name_phonetic, 
		gender, 
		date_of_birth,
		birth_place,
		nationality,
		ethnic_group,
		marital_status,
		career,
		degree,
		blood_type_abo,
		blood_type_rh,
		identity_card_no,
		household_no,
		passport_no,
		military_id,
		health_insurance_id,
		health_card_no,
		email,
		mailing_address,
		zip_code,
		phone_no_mobile,
		phone_no_home,
		phone_no_business,
		death_indicator,
		death_time,
		created_date,
		created_by,
		patient_healthcare_type_code,
		patient_healthcare_type_name,
		patient_healthcare_property_code,
		patient_healthcare_property_name,
	    mpi_serial_no,
	    edit_time,
		serial_no,
		_uid_value,
	}

	@Override
	public Patient mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Patient p = new Patient();
		p.setSerialNo(RowMapperUtil.getInteger(rs, CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.serial_no.toString()));
		p.setPatientId(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.patient_id.toString()));
		p.setName(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.name.toString()));
		p.setNamePhonetic(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.name_phonetic.toString()));
		p.setGender(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.gender.toString()));
		p.setDateOfBirth(RowMapperUtil.getDateTime(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.date_of_birth.toString())));
		p.setBirthPlace(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.birth_place.toString()));
		p.setNationality(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.nationality.toString()));
		p.setEthnicGroup(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.ethnic_group.toString()));
		p.setMaritalStatus(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.marital_status.toString()));
		p.setCareer(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.career.toString()));
		p.setDegree(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.degree.toString()));
		p.setBloodTypeAbo(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.blood_type_abo.toString()));
		p.setBloodTypeRh(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.blood_type_rh.toString()));
		p.setIdentityCardNo(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.identity_card_no.toString()));
		p.setHouseholdNo(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.household_no.toString()));
		p.setPassportId(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.passport_no.toString()));
		p.setMilitaryId(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.military_id.toString()));
		p.setHealthInsuranceId(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.health_insurance_id.toString()));
		p.setHealthCardNo(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.health_card_no.toString()));
		p.setEmail(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.email.toString()));
		p.setMailingAddress(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.mailing_address.toString()));
		p.setZipCode(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.zip_code.toString()));
		p.setPhoneNoMobile(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.phone_no_mobile.toString()));
		p.setPhoneNoHome(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.phone_no_home.toString()));
		p.setPhoneNoBusiness(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.phone_no_business.toString()));
		p.setDeathIndicator(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.death_indicator.toString()));
		p.setDeathTime(RowMapperUtil.getDateTime(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.death_time.toString())));
		p.setCreatedDate(RowMapperUtil.getDateTime(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.created_date.toString())));
		p.setCreatedBy(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.created_by.toString()));
		p.setPatientHealthcareTypeCode(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.patient_healthcare_type_code.toString()));
		p.setPatientHealthcareTypeName(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.patient_healthcare_type_name.toString()));
		p.setPatientHealthcarePropertyCode(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.patient_healthcare_property_code.toString()));
		p.setPatientHealthcarePropertyName(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.patient_healthcare_property_name.toString()));
		p.setMpiSerialNo(RowMapperUtil.getInteger(rs, CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.mpi_serial_no.toString()));
		p.setEditTime(RowMapperUtil.getDateTime(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log.edit_time.toString())));
		p.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log._hibernarmId.toString()));
		p.set_uid_value(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_master_patient_index_modifyed_log._uid_value.toString()));
		return p;
	}

}

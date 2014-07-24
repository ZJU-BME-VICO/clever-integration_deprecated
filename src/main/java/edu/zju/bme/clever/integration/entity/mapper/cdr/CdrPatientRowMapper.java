package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrPatientRowMapper implements RowMapper<Patient> {

	public enum openEHR_DEMOGRAPHIC_PERSON_patient {
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
		last_modify_date,
		last_modified_by,
		voided_indicator,
		voided_date,
		voided_by,
		ref_patient_id,
		inpatientno,
		outpatientno,
		emergencyno,
		patient_healthcare_type_code,
		patient_healthcare_type_name,
		patient_healthcare_property_code,
		patient_healthcare_property_name,
		serial_no,
		_uid_value,
	}

	@Override
	public Patient mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Patient p = new Patient();
		p.setSerialNo(rs.getInt(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.serial_no.toString()));
		p.setPatientId(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.patient_id.toString()));
		p.setName(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.name.toString()));
		p.setNamePhonetic(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.name_phonetic.toString()));
		p.setGender(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.gender.toString()));
		p.setDateOfBirth(RowMapperUtil.getDateTime(
				rs.getTimestamp(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.date_of_birth.toString())));
		p.setBirthPlace(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.birth_place.toString()));
		p.setNationality(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.nationality.toString()));
		p.setEthnicGroup(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.ethnic_group.toString()));
		p.setMaritalStatus(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.marital_status.toString()));
		p.setCareer(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.career.toString()));
		p.setDegree(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.degree.toString()));
		p.setBloodTypeAbo(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.blood_type_abo.toString()));
		p.setBloodTypeRh(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.blood_type_rh.toString()));
		p.setIdentityCardNo(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.identity_card_no.toString()));
		p.setHouseholdNo(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.household_no.toString()));
		p.setPassportId(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.passport_no.toString()));
		p.setMilitaryId(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.military_id.toString()));
		p.setHealthInsuranceId(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.health_insurance_id.toString()));
		p.setHealthCardNo(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.health_card_no.toString()));
		p.setEmail(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.email.toString()));
		p.setMailingAddress(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.mailing_address.toString()));
		p.setZipCode(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.zip_code.toString()));
		p.setPhoneNoMobile(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.phone_no_mobile.toString()));
		p.setPhoneNoHome(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.phone_no_home.toString()));
		p.setPhoneNoBusiness(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.phone_no_business.toString()));
		p.setDeathIndicator(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.death_indicator.toString()));
		p.setDeathTime(RowMapperUtil.getDateTime(
				rs.getTimestamp(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.death_time.toString())));
		p.setCreatedDate(RowMapperUtil.getDateTime(
				rs.getTimestamp(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.created_date.toString())));
		p.setCreatedBy(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.created_by.toString()));
		p.setLastModifyDate(RowMapperUtil.getDateTime(
				rs.getTimestamp(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.last_modify_date.toString())));
		p.setLastModifiedBy(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.last_modified_by.toString()));
		p.setVoidedIndicator(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.voided_indicator.toString()));
		p.setVoidedDate(RowMapperUtil.getDateTime(
				rs.getTimestamp(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.voided_date.toString())));
		p.setVoidedBy(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.voided_by.toString()));
		p.setRefPatientId(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.ref_patient_id.toString()));
		p.setInpatientNo(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.inpatientno.toString()));
		p.setOutpatientNo(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.outpatientno.toString()));
		p.setEmergencyNo(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.emergencyno.toString()));
		p.setPatientHealthcareTypeCode(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.patient_healthcare_type_code.toString()));
		p.setPatientHealthcareTypeName(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.patient_healthcare_type_name.toString()));
		p.setPatientHealthcarePropertyCode(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.patient_healthcare_property_code.toString()));
		p.setPatientHealthcarePropertyName(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient.patient_healthcare_property_name.toString()));
		p.set_hibernarmId(rs.getInt(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient._hibernarmId.toString()));
		p.set_uid_value(rs.getString(CdrPatientRowMapper.openEHR_DEMOGRAPHIC_PERSON_patient._uid_value.toString()));
		return p;
	}

}

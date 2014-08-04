package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Diagnosis;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrDiagnosisRowMapper implements RowMapper<Diagnosis> {

	public enum openEHR_EHR_EVALUATION_diagnosis {
		_hibernarmId,
		diagnosis_id,
		patient_id,
		visit_id,
		diagnosis_class_id,
		diagnosis_no,
		diagnosis_item_code,
		diagnosis_item_name,
		admission_illness,
		treat_days,
		treat_result,
		oper_treat_indicator,
		doctor,
		diagnosis_date_time,
		_uid_value,
		idPatient,
		idVisit,
	}

	@Override
	public Diagnosis mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Diagnosis d = new Diagnosis();
		d.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis._hibernarmId.toString()));
		d.setDiagnosisId(RowMapperUtil.getInteger(rs, CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_id.toString()));
		d.setPatientId(rs.getString(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.patient_id.toString()));
		d.setVisitId(rs.getString(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.visit_id.toString()));
		d.setDiagnosisClassId(RowMapperUtil.getInteger(rs, CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_class_id.toString()));
		d.setDiagnosisNo(RowMapperUtil.getInteger(rs, CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_no.toString()));
		d.setDiagnosisItemCode(rs.getString(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_item_code.toString()));
		d.setDiagnosisItemName(rs.getString(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_item_name.toString()));
		d.setAdmissionIllness(rs.getString(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.admission_illness.toString()));
		d.setTreatDays(RowMapperUtil.getInteger(rs, CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.treat_days.toString()));
		d.setTreatResult(rs.getString(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.treat_result.toString()));
		d.setOperTreatIndicator(RowMapperUtil.getInteger(rs, CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.oper_treat_indicator.toString()));
		d.setDoctor(rs.getString(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.doctor.toString()));
		d.setDiagnosisDateTime(RowMapperUtil.getDateTime(rs.getString(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_date_time.toString())));
		d.set_uid_value(rs.getString(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis._uid_value.toString()));
		d.setIdPatient(RowMapperUtil.getInteger(rs, CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.idPatient.toString()));
		d.setIdVisit(RowMapperUtil.getInteger(rs, CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.idVisit.toString()));
		return d;
	}

}

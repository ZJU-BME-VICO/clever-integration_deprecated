package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Diagnosis;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasDiagnosisRowMapper implements RowMapper<Diagnosis> {

	public enum DIAGNOSIS {
		DIAGNOSIS_ID,
		PATIENT_ID,
		VISIT_ID,
		DIAGNOSIS_CLASS_ID,
		DIAGNOSIS_NO,
		DIAGNOSIS_ITEM_CODE,
		DIAGNOSIS_ITEM_NAME,
		ADMISSION_ILLNESS,
		TREAT_DAYS,
		TREAT_RESULT,
		OPER_TREAT_INDICATOR,
		DOCTOR,
		DIAGNOSIS_DATE_TIME,
	}

	@Override
	public Diagnosis mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Diagnosis d = new Diagnosis();
		d.setDiagnosisId(RowMapperUtil.getInteger(rs, MiasDiagnosisRowMapper.DIAGNOSIS.DIAGNOSIS_ID.toString()));
		d.setPatientId(rs.getString(MiasDiagnosisRowMapper.DIAGNOSIS.PATIENT_ID.toString()));
		d.setVisitId(rs.getString(MiasDiagnosisRowMapper.DIAGNOSIS.VISIT_ID.toString()));
		d.setDiagnosisClassId(RowMapperUtil.getInteger(rs, MiasDiagnosisRowMapper.DIAGNOSIS.DIAGNOSIS_CLASS_ID.toString()));
		d.setDiagnosisNo(RowMapperUtil.getInteger(rs, MiasDiagnosisRowMapper.DIAGNOSIS.DIAGNOSIS_NO.toString()));
		d.setDiagnosisItemCode(rs.getString(MiasDiagnosisRowMapper.DIAGNOSIS.DIAGNOSIS_ITEM_CODE.toString()));
		d.setDiagnosisItemName(rs.getString(MiasDiagnosisRowMapper.DIAGNOSIS.DIAGNOSIS_ITEM_NAME.toString()));
		d.setAdmissionIllness(rs.getString(MiasDiagnosisRowMapper.DIAGNOSIS.ADMISSION_ILLNESS.toString()));
		d.setTreatDays(RowMapperUtil.getInteger(rs, MiasDiagnosisRowMapper.DIAGNOSIS.TREAT_DAYS.toString()));
		d.setTreatResult(rs.getString(MiasDiagnosisRowMapper.DIAGNOSIS.TREAT_RESULT.toString()));
		d.setOperTreatIndicator(RowMapperUtil.getInteger(rs, MiasDiagnosisRowMapper.DIAGNOSIS.OPER_TREAT_INDICATOR.toString()));
		d.setDoctor(rs.getString(MiasDiagnosisRowMapper.DIAGNOSIS.DOCTOR.toString()));
		d.setDiagnosisDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasDiagnosisRowMapper.DIAGNOSIS.DIAGNOSIS_DATE_TIME.toString())));
		return d;
	}

}

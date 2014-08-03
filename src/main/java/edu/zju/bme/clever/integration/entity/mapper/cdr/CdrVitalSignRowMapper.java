package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.VitalSign;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrVitalSignRowMapper implements RowMapper<VitalSign> {

	public enum openEHR_EHR_OBSERVATION_vital_signs_record {
		_hibernarmId,
		record_id,
		patient_id,
		visit_id,
		time_point,
		vital_signs_item,
		vital_signs_values,
		units,
		recorder,
		recording_date_time,
		flag,
		_uid_value,
		idPatient,
		idVisit,
	}

	@Override
	public VitalSign mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		VitalSign v = new VitalSign();
		v.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record._hibernarmId.toString()));
		v.setRecordId(RowMapperUtil.getInteger(rs, CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.record_id.toString()));
		v.setPatientId(rs.getString(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.patient_id.toString()));
		v.setVisitId(rs.getString(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.visit_id.toString()));
		v.setTimePoint(RowMapperUtil.getDateTime(rs.getTimestamp(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.time_point.toString())));
		v.setVitalSignsItem(rs.getString(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.vital_signs_item.toString()));
		v.setVitalSignsValues(rs.getString(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.vital_signs_values.toString()));
		v.setUnits(rs.getString(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.units.toString()));
		v.setRecorder(rs.getString(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.recorder.toString()));
		v.setRecordingDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.recording_date_time.toString())));
		v.setFlag(RowMapperUtil.getInteger(rs, CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.flag.toString()));
		v.set_uid_value(rs.getString(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record._uid_value.toString()));
		v.setIdPatient(RowMapperUtil.getInteger(rs, CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.idPatient.toString()));
		v.setIdVisit(RowMapperUtil.getInteger(rs, CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.idVisit.toString()));
		return v;
	}

}

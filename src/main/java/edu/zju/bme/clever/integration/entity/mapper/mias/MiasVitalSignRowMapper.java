package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.VitalSign;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasVitalSignRowMapper implements RowMapper<VitalSign> {

	public enum VITAL_SIGNS_RECORD {
		RECORD_ID,
		PATIENT_ID,
		VISIT_ID,
		TIME_POINT,
		VITAL_SIGNS_ITEM,
		VITAL_SIGNS_VALUES,
		UNITS,
		RECORDER,
		RECORDING_DATE_TIME,
		FLAG,
	}

	@Override
	public VitalSign mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		VitalSign v = new VitalSign();
		v.setRecordId(RowMapperUtil.getInteger(rs, MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.RECORD_ID.toString()));
		v.setPatientId(rs.getString(MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.PATIENT_ID.toString()));
		v.setVisitId(rs.getString(MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.VISIT_ID.toString()));
		v.setTimePoint(RowMapperUtil.getDateTime(rs.getTimestamp(MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.TIME_POINT.toString())));
		v.setVitalSignsItem(rs.getString(MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.VITAL_SIGNS_ITEM.toString()));
		v.setVitalSignsValues(rs.getString(MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.VITAL_SIGNS_VALUES.toString()));
		v.setUnits(rs.getString(MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.UNITS.toString()));
		v.setRecorder(rs.getString(MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.RECORDER.toString()));
		v.setRecordingDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.RECORDING_DATE_TIME.toString())));
		v.setFlag(RowMapperUtil.getInteger(rs, MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.FLAG.toString()));
		return v;
	}

}

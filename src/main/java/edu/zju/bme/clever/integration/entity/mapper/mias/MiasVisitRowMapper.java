package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Visit;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasVisitRowMapper implements RowMapper<Visit> {

	public enum PATIENT_VISIT {
		SERIAL_NO, 
		MPIML_SERIAL_NO, 
		VISIT_TYPE, 
		VISIT_ID, 
		HIS_VISIT_ID, 
		HIS_VISIT_SUB_ID,
		DEPARTMENT_CODE,
		DEPARTMENT_NAME,
		WARD_CODE,
		WARD_NAME,
		VISIT_TIME,
		STATUS,
	}

	@Override
	public Visit mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Visit v = new Visit();
		v.setSerialNo(RowMapperUtil.getInteger(rs, MiasVisitRowMapper.PATIENT_VISIT.SERIAL_NO.toString()));
		v.setMpimlSerialNo(RowMapperUtil.getInteger(rs, MiasVisitRowMapper.PATIENT_VISIT.MPIML_SERIAL_NO.toString()));
		v.setVisitType(rs.getString(MiasVisitRowMapper.PATIENT_VISIT.VISIT_TYPE.toString()));
		v.setVisitId(rs.getString(MiasVisitRowMapper.PATIENT_VISIT.VISIT_ID.toString()));
		v.setHisVisitId(rs.getString(MiasVisitRowMapper.PATIENT_VISIT.HIS_VISIT_ID.toString()));
		v.setHisVisitSubId(rs.getString(MiasVisitRowMapper.PATIENT_VISIT.HIS_VISIT_SUB_ID.toString()));
		v.setDepartmentCode(rs.getString(MiasVisitRowMapper.PATIENT_VISIT.DEPARTMENT_CODE.toString()));
		v.setDepartmentName(rs.getString(MiasVisitRowMapper.PATIENT_VISIT.DEPARTMENT_NAME.toString()));
		v.setWardCode(rs.getString(MiasVisitRowMapper.PATIENT_VISIT.WARD_CODE.toString()));
		v.setWardName(rs.getString(MiasVisitRowMapper.PATIENT_VISIT.WARD_NAME.toString()));
		v.setVisitTime(RowMapperUtil.getDateTime(
				rs.getTimestamp(MiasVisitRowMapper.PATIENT_VISIT.VISIT_TIME.toString())));
		v.setStatus(RowMapperUtil.getInteger(rs, MiasVisitRowMapper.PATIENT_VISIT.STATUS.toString()));
		return v;
	}

}

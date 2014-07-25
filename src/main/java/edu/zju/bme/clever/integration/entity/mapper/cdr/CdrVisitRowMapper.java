package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Visit;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrVisitRowMapper implements RowMapper<Visit> {

	public enum openEHR_EHR_ADMIN_ENTRY_visit {
		_hibernarmId, 
		mpiml_serial_no, 
		visit_type, 
		visit_id, 
		his_visit_id, 
		his_visit_sub_id,
		department_code,
		department_name,
		ward_code,
		ward_name,
		visit_time,
		status,
		serial_no,
		_uid_value,
		idPatient,
	}

	@Override
	public Visit mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Visit v = new Visit();
		v.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit._hibernarmId.toString()));
		v.setMpimlSerialNo(RowMapperUtil.getInteger(rs, CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.mpiml_serial_no.toString()));
		v.setVisitType(rs.getString(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.visit_type.toString()));
		v.setVisitId(rs.getString(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.visit_id.toString()));
		v.setHisVisitId(rs.getString(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.his_visit_id.toString()));
		v.setHisVisitSubId(rs.getString(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.his_visit_sub_id.toString()));
		v.setDepartmentCode(rs.getString(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.department_code.toString()));
		v.setDepartmentName(rs.getString(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.department_name.toString()));
		v.setWardCode(rs.getString(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.ward_code.toString()));
		v.setWardName(rs.getString(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.ward_name.toString()));
		v.setVisitTime(RowMapperUtil.getDateTime(
				rs.getTimestamp(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.visit_time.toString())));
		v.setStatus(RowMapperUtil.getInteger(rs, CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.status.toString()));
		v.setSerialNo(RowMapperUtil.getInteger(rs, CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.serial_no.toString()));
		v.set_uid_value(rs.getString(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit._uid_value.toString()));
		v.setIdPatient(RowMapperUtil.getInteger(rs, CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.idPatient.toString()));
		return v;
	}

}

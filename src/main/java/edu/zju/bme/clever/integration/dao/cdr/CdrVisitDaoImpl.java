package edu.zju.bme.clever.integration.dao.cdr;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.entity.Visit;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrVisitRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrVisitDao")
@Transactional
public class CdrVisitDaoImpl implements CdrVisitDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<Visit> get(String visitId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :visitId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.class.getSimpleName()),
				CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.visit_id);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("visitId", visitId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<Visit> visits = jt.query(sql, source, new CdrVisitRowMapper());
		visits.forEach(v -> {
			Visit k = new Visit();
			k.setVisitId(visitId);
			CdrCache.INSTANCE.put(Visit.class, k.hashCode(), v);
		});
		return visits;
	}

	@Override
	public int getCount(String visitId) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :visitId";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.class.getSimpleName()),
				CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.visit_id);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("visitId", visitId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(Visit v) {
		String sql = "";
		SqlParameterSource source = new MapSqlParameterSource(this.putParameters(v));
		if (this.getCount(v.getVisitId()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":mpiml_serial_no, "
					+ ":visit_type, "
					+ ":visit_id, "
					+ ":his_visit_id, "
					+ ":his_visit_sub_id, "
					+ ":department_code, "
					+ ":department_name, "
					+ ":ward_code, "
					+ ":ward_name, "
					+ ":visit_time, "
					+ ":status, "
					+ ":serial_no, "
					+ ":_uid_value, "
					+ ":idPatient)";		
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.class.getSimpleName()));	
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :mpiml_serial_no, "
					+ "{2} = :visit_type, "
					+ "{3} = :his_visit_id, "
					+ "{4} = :his_visit_sub_id, "
					+ "{5} = :department_code, "
					+ "{6} = :department_name, "
					+ "{7} = :ward_code, "
					+ "{8} = :ward_name, "
					+ "{9} = :visit_time, "
					+ "{10} = :status, "
					+ "{11} = :serial_no, "
					+ "{12} = :_uid_value, "
					+ "{13} = :idPatient WHERE {14} = :visit_id";		
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.class.getSimpleName()),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.mpiml_serial_no.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.visit_type.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.his_visit_id.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.his_visit_sub_id.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.department_code.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.department_name.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.ward_code.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.ward_name.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.visit_time.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.status.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.serial_no.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit._uid_value.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.idPatient.toString(),
					CdrVisitRowMapper.openEHR_EHR_ADMIN_ENTRY_visit.visit_id.toString());
		}
		return jt.update(sql, source);		
	}
	
	private Map<String, Object> putParameters(Visit v) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("mpiml_serial_no", v.getMpimlSerialNo());
		parameters.put("visit_type", v.getVisitType());
		parameters.put("visit_id", v.getVisitId());
		parameters.put("his_visit_id", v.getHisVisitId());
		parameters.put("his_visit_sub_id", v.getHisVisitSubId());
		parameters.put("department_code", v.getDepartmentCode());
		parameters.put("department_name", v.getDepartmentName());
		parameters.put("ward_code", v.getWardCode());
		parameters.put("ward_name", v.getWardName());
		parameters.put("visit_time", RowMapperUtil.getDateTimeString(v.getVisitTime()));
		parameters.put("status", v.getStatus());
		parameters.put("serial_no", v.getSerialNo());
		parameters.put("_uid_value", v.get_uid_value());
		parameters.put("idPatient", v.getIdPatient());
		return parameters;
	}
	
}

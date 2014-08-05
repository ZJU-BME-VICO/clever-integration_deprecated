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

import edu.zju.bme.clever.integration.entity.VitalSign;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrVitalSignRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrVitalSignDao")
@Transactional
public class CdrVitalSignDaoImpl implements CdrVitalSignDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<VitalSign> get(int recordId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :recordId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.class.getSimpleName()),
				CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.record_id);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("recordId", recordId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<VitalSign> visits = jt.query(sql, source, new CdrVitalSignRowMapper());
		visits.forEach(v -> {
			VitalSign k = new VitalSign();
			k.setRecordId(recordId);
			CdrCache.INSTANCE.put(VitalSign.class, k.hashCode(), v);
		});
		return visits;
	}

	@Override
	public int getCount(int recordId) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :recordId";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.class.getSimpleName()),
				CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.record_id);
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("recordId", recordId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(VitalSign v) {
		String sql = "";
		SqlParameterSource source = new MapSqlParameterSource(this.putParameters(v));
		if (this.getCount(v.getRecordId()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":record_id, "
					+ ":patient_id, "
					+ ":visit_id, "
					+ ":time_point, "
					+ ":vital_signs_item, "
					+ ":vital_signs_values, "
					+ ":units, "
					+ ":recorder, "
					+ ":recording_date_time, "
					+ ":flag, "
					+ ":_uid_value, "
					+ ":idPatient, "
					+ ":idVisit)";		
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.class.getSimpleName()));	
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :patient_id, "
					+ "{2} = :visit_id, "
					+ "{3} = :time_point, "
					+ "{4} = :vital_signs_item, "
					+ "{5} = :vital_signs_values, "
					+ "{6} = :units, "
					+ "{7} = :recorder, "
					+ "{8} = :recording_date_time, "
					+ "{9} = :flag, "
					+ "{10} = :_uid_value, "
					+ "{11} = :idPatient, "
					+ "{12} = :idVisit WHERE {13} = :record_id";		
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.class.getSimpleName()),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.patient_id.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.visit_id.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.time_point.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.vital_signs_item.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.vital_signs_values.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.units.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.recorder.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.recording_date_time.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.flag.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record._uid_value.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.idPatient.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.idVisit.toString(),
					CdrVitalSignRowMapper.openEHR_EHR_OBSERVATION_vital_signs_record.record_id.toString());
		}
		return jt.update(sql, source);	
	}
	
	private Map<String, Object> putParameters(VitalSign v) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("record_id", v.getRecordId());
		parameters.put("patient_id", v.getPatientId());
		parameters.put("visit_id", v.getVisitId());
		parameters.put("time_point", RowMapperUtil.getDateTimeString(v.getTimePoint()));
		parameters.put("vital_signs_item", v.getVitalSignsItem());
		parameters.put("vital_signs_values", v.getVitalSignsValues());
		parameters.put("units", v.getUnits());
		parameters.put("recorder", v.getRecorder());
		parameters.put("recording_date_time", RowMapperUtil.getDateTimeString(v.getRecordingDateTime()));
		parameters.put("flag", v.getFlag());
		parameters.put("_uid_value", v.get_uid_value());
		parameters.put("idPatient", v.getIdPatient());
		parameters.put("idVisit", v.getIdVisit());
		return parameters;
	}
	
}

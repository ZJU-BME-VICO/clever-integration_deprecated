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

import edu.zju.bme.clever.integration.entity.ExamMaster;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrExamMasterRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrExamMasterDao")
@Transactional
public class CdrExamMasterDaoImpl implements CdrExamMasterDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

//	@Override
//	public List<ExamMaster> get(int serialNo) {
//		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :serialNo";
//		String sql = MessageFormat.format(sqlFormat, 
//				DatabaseUtil.getCdrDatabaseTableName(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.class.getSimpleName()),
//				CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.serial_no);		
//		Map<String, Object> paramters = new HashMap<String, Object>();
//		paramters.put("serialNo", serialNo);
//		SqlParameterSource source = new MapSqlParameterSource(paramters);
//		List<ExamMaster> examRequests = jt.query(sql, source, new CdrExamMasterRowMapper());
//		examRequests.forEach(l -> {
//			ExamMaster k = new ExamMaster();
//			k.setSerialNo(serialNo);
//			CdrCache.INSTANCE.put(ExamMaster.class, k.hashCode(), l);
//		});
//		return examRequests;
//	}

	@Override
	public List<ExamMaster> get(String examId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :examId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.class.getSimpleName()),
				CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.exam_id);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("examId", examId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<ExamMaster> examRequests = jt.query(sql, source, new CdrExamMasterRowMapper());
		examRequests.forEach(l -> {
			ExamMaster k = new ExamMaster();
			k.setExamId(examId);
			CdrCache.INSTANCE.put(ExamMaster.class, k.hashCode(), l);
		});
		return examRequests;
	}

//	@Override
//	public int getCount(int serialNo) {
//		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :serialNo";
//		String sql = MessageFormat.format(sqlFormat, 				
//				DatabaseUtil.getCdrDatabaseTableName(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.class.getSimpleName()),
//				CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.serial_no);
//		Map<String, Object> paramters = new HashMap<String, Object>();
//		paramters.put("serialNo", serialNo);
//		SqlParameterSource source = new MapSqlParameterSource(paramters);
//		return jt.queryForObject(sql, source, Integer.class);
//	}

	@Override
	public int getCount(String examId) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :examId";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.class.getSimpleName()),
				CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.exam_id);
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("examId", examId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(ExamMaster e) {
		String sql = "";
		SqlParameterSource source = new MapSqlParameterSource(this.putParameters(e));
		if (this.getCount(e.getExamId()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":exam_id, "
					+ ":patient_id, "
					+ ":visit_id, "
					+ ":exam_req_id, "
					+ ":his_exam_id, "
					+ ":exam_dept_name, "
					+ ":exam_dept_code, "
					+ ":scheduled_date_time, "
					+ ":exam_time, "
					+ ":exam_status, "
					+ ":is_read, "
					+ ":is_normal, "
					+ ":serial_no, "
					+ ":_uid_value)";		
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.class.getSimpleName()));
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :exam_id, "
					+ "{2} = :patient_id, "
					+ "{3} = :visit_id, "
					+ "{4} = :exam_req_id, "
					+ "{5} = :his_exam_id, "
					+ "{6} = :exam_dept_name, "
					+ "{7} = :exam_dept_code, "
					+ "{8} = :scheduled_date_time, "
					+ "{9} = :exam_time, "
					+ "{10} = :exam_status, "
					+ "{11} = :is_read, "
					+ "{12} = :is_normal, "
					+ "{13} = :_uid_value WHERE {14} = :serial_no";	
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.class.getSimpleName()),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.exam_id.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.patient_id.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.visit_id.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.exam_req_id.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.his_exam_id.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.exam_dept_name.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.exam_dept_code.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.scheduled_date_time.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.exam_time.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.exam_status.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.is_read.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.is_normal.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master._uid_value.toString(),
					CdrExamMasterRowMapper.openEHR_EHR_OBSERVATION_exam_master.serial_no.toString());	
		}
		return jt.update(sql, source);	
	}
	
	private Map<String, Object> putParameters(ExamMaster e) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("exam_id", e.getExamId());
		parameters.put("patient_id", e.getPatientId());
		parameters.put("visit_id", e.getVisitId());
		parameters.put("exam_req_id", e.getExamReqId());
		parameters.put("his_exam_id", e.getHisExamId());
		parameters.put("exam_dept_name", e.getExamDeptName());
		parameters.put("exam_dept_code", e.getExamDeptCode());
		parameters.put("scheduled_date_time", RowMapperUtil.getDateTimeString(e.getScheduledDateTime()));
		parameters.put("exam_time", RowMapperUtil.getDateTimeString(e.getExamTime()));
		parameters.put("exam_status", e.getExamStatus());
		parameters.put("is_read", e.getIsRead());
		parameters.put("is_normal", e.getIsNormal());
		parameters.put("serial_no", e.getSerialNo());
		parameters.put("_uid_value", e.get_uid_value());
		return parameters;
	}
	
}

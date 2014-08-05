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

import edu.zju.bme.clever.integration.entity.ExamAction;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrExamActionRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrExamActionDao")
@Transactional
public class CdrExamActionDaoImpl implements CdrExamActionDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<ExamAction> get(int serialNo) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :serialNo";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.class.getSimpleName()),
				CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.serial_no);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("serialNo", serialNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<ExamAction> examDatas = jt.query(sql, source, new CdrExamActionRowMapper());
		examDatas.forEach(l -> {
			ExamAction k = new ExamAction();
			k.setSerialNo(serialNo);
			CdrCache.INSTANCE.put(ExamAction.class, k.hashCode(), l);
		});
		return examDatas;
	}

	@Override
	public int getCount(int serialNo) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :serialNo";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.class.getSimpleName()),
				CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.serial_no);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("serialNo", serialNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(ExamAction e) {
		String sql = "";
		SqlParameterSource source = new MapSqlParameterSource(this.putParameters(e));
		if (this.getCount(e.getSerialNo()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":exam_req_id, "
					+ ":exam_id, "
					+ ":actor_id, "
					+ ":action_date_time, "
					+ ":action_type_id, "
					+ ":action_memo, "
					+ ":actor_name, "
					+ ":serial_no, "
					+ ":_uid_value, "
					+ ":idExamRequest, "
					+ ":idExamMaster)";		
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.class.getSimpleName()));
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :exam_req_id, "
					+ "{2} = :exam_id, "
					+ "{3} = :actor_id, "
					+ "{4} = :action_date_time, "
					+ "{5} = :action_type_id, "
					+ "{6} = :action_memo, "
					+ "{7} = :actor_name, "
					+ "{8} = :_uid_value, "
					+ "{9} = :idExamRequest, "
					+ "{10} = :idExamMaster WHERE {11} = :serial_no";	
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.class.getSimpleName()),
					CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.exam_req_id.toString(),
					CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.exam_id.toString(),
					CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.actor_id.toString(),
					CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.action_date_time.toString(),
					CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.action_type_id.toString(),
					CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.action_memo.toString(),
					CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.actor_name.toString(),
					CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action._uid_value.toString(),
					CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.idExamRequest.toString(),
					CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.idExamMaster.toString(),
					CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.serial_no.toString());
		}
		return jt.update(sql, source);	
	}
	
	private Map<String, Object> putParameters(ExamAction e) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("exam_req_id", e.getExamReqId());
		parameters.put("exam_id", e.getExamId());
		parameters.put("actor_id", e.getActorId());
		parameters.put("action_date_time", RowMapperUtil.getDateTimeString(e.getActionDateTime()));
		parameters.put("action_type_id", e.getActionTypeId());
		parameters.put("action_memo", e.getActionMemo());
		parameters.put("actor_name", e.getActorName());
		parameters.put("serial_no", e.getSerialNo());
		parameters.put("_uid_value", e.get_uid_value());
		parameters.put("idExamRequest", e.getIdExamRequest());
		parameters.put("idExamMaster", e.getIdExamMaster());
		return parameters;
	}
	
}

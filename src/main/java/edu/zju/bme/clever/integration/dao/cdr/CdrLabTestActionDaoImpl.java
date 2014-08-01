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

import edu.zju.bme.clever.integration.entity.LabTestAction;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrLabTestActionRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrLabTestActionDao")
@Transactional
public class CdrLabTestActionDaoImpl implements CdrLabTestActionDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<LabTestAction> get(int serialNo) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :serialNo";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.class.getSimpleName()),
				CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.serial_no);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("serialNo", serialNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<LabTestAction> labTestActions = jt.query(sql, source, new CdrLabTestActionRowMapper());
		labTestActions.forEach(l -> {
			LabTestAction k = new LabTestAction();
			k.setSerialNo(serialNo);
			CdrCache.INSTANCE.put(LabTestAction.class, k.hashCode(), l);
		});
		return labTestActions;
	}

	@Override
	public int getCount(int serialNo) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :serialNo";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.class.getSimpleName()),
				CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.serial_no);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("serialNo", serialNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(LabTestAction l) {
		if (this.getCount(l.getSerialNo()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":test_req_id, "
					+ ":test_id, "
					+ ":actor_id, "
					+ ":action_date_time, "
					+ ":action_type_id, "
					+ ":action_memo, "
					+ ":actor_name, "
					+ ":serial_no, "
					+ ":_uid_value, "
					+ ":idLabTestRequest)";		
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.class.getSimpleName()));
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(l));
			return jt.update(sql, source);
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :test_req_id, "
					+ "{2} = :test_id, "
					+ "{3} = :actor_id, "
					+ "{4} = :action_date_time, "
					+ "{5} = :action_type_id, "
					+ "{6} = :action_memo, "
					+ "{7} = :actor_name, "
					+ "{8} = :_uid_value, "
					+ "{9} = :idLabTestRequest WHERE {10} = :serial_no";	
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.class.getSimpleName()),
					CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.test_req_id.toString(),
					CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.test_id.toString(),
					CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.actor_id.toString(),
					CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.action_date_time.toString(),
					CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.action_type_id.toString(),
					CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.action_memo.toString(),
					CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.actor_name.toString(),
					CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action._uid_value.toString(),
					CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.idLabTestRequest.toString(),
					CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.serial_no.toString());
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(l));
			return jt.update(sql, source);			
		}
	}
	
	private Map<String, Object> putParameters(LabTestAction l) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("test_req_id", l.getTestReqId());
		parameters.put("test_id", l.getTestId());
		parameters.put("actor_id", l.getActorId());
		parameters.put("action_date_time", RowMapperUtil.getDateTimeString(l.getActionDateTime()));
		parameters.put("action_type_id", l.getActionTypeId());
		parameters.put("action_memo", l.getActionMemo());
		parameters.put("actor_name", l.getActorName());
		parameters.put("serial_no", l.getSerialNo());
		parameters.put("_uid_value", l.get_uid_value());
		parameters.put("idLabTestRequest", l.getIdLabTestRequest());
		return parameters;
	}
	
}

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

import edu.zju.bme.clever.integration.entity.ExamItem;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrExamItemRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("cdrExamItemDao")
@Transactional
public class CdrExamItemDaoImpl implements CdrExamItemDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<ExamItem> get(int serialNo) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :serialNo";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.class.getSimpleName()),
				CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.serial_no);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("serialNo", serialNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<ExamItem> examRequests = jt.query(sql, source, new CdrExamItemRowMapper());
		examRequests.forEach(l -> {
			ExamItem k = new ExamItem();
			k.setSerialNo(serialNo);
			CdrCache.INSTANCE.put(ExamItem.class, k.hashCode(), l);
		});
		return examRequests;
	}

	@Override
	public int getCount(int serialNo) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :serialNo";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.class.getSimpleName()),
				CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.serial_no);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("serialNo", serialNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(ExamItem e) {
		if (this.getCount(e.getSerialNo()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":exam_req_id, "
					+ ":exam_id, "
					+ ":exam_item_no, "
					+ ":exam_class, "
					+ ":exam_sub_class, "
					+ ":exam_item_name, "
					+ ":exam_item_code, "
					+ ":serial_no, "
					+ ":_uid_value, "
					+ ":idExamRequest, "
					+ ":idExamMaster)";		
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.class.getSimpleName()));
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(e));
			return jt.update(sql, source);
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :exam_req_id, "
					+ "{2} = :exam_id, "
					+ "{3} = :exam_item_no, "
					+ "{4} = :exam_class, "
					+ "{5} = :exam_sub_class, "
					+ "{6} = :exam_item_name, "
					+ "{7} = :exam_item_code, "
					+ "{8} = :_uid_value, "
					+ "{9} = :idExamRequest, "
					+ "{10} = :idExamMaster WHERE {11} = :serial_no";	
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.class.getSimpleName()),
					CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_req_id.toString(),
					CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_id.toString(),
					CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_item_no.toString(),
					CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_class.toString(),
					CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_sub_class.toString(),
					CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_item_name.toString(),
					CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_item_code.toString(),
					CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item._uid_value.toString(),
					CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.idExamRequest.toString(),
					CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.idExamMaster.toString(),
					CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.serial_no.toString());
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(e));
			return jt.update(sql, source);			
		}
	}
	
	private Map<String, Object> putParameters(ExamItem e) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("exam_req_id", e.getExamReqId());
		parameters.put("exam_id", e.getExamId());
		parameters.put("exam_item_no", e.getExamItemNo());
		parameters.put("exam_class", e.getExamClass());
		parameters.put("exam_sub_class", e.getExamSubClass());
		parameters.put("exam_item_name", e.getExamItemName());
		parameters.put("exam_item_code", e.getExamItemCode());
		parameters.put("serial_no", e.getSerialNo());
		parameters.put("_uid_value", e.get_uid_value());
		parameters.put("idExamRequest", e.getIdExamRequest());
		parameters.put("idExamMaster", e.getIdExamMaster());
		return parameters;
	}
	
}

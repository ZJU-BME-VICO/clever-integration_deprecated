package edu.zju.bme.clever.integration.dao;

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

import edu.zju.bme.clever.integration.entity.IntegrationQueue;
import edu.zju.bme.clever.integration.entity.mapper.IntegrationQueueLogRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.IntegrationQueueRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("integrationQueueDao")
@Transactional
public class IntegrationQueueDaoImpl implements IntegrationQueueDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<IntegrationQueue> getTop(int n) {
		String sqlFormat = "SELECT TOP {0} * FROM {1}";
		String sql = MessageFormat.format(sqlFormat,
				n,
				DatabaseUtil.getInegrationDatabaseTableName(IntegrationQueueRowMapper.Queue.class.getSimpleName()));
		return jt.query(sql, new IntegrationQueueRowMapper());
	}

	@Override
	public void save(IntegrationQueue iq) {
		String sqlInsertFormat = "INSERT INTO {0} VALUES("
				+ ":tableName, "
				+ ":logicalKeyName, "
				+ ":logicalKeyValue, "
				+ ":status)";
		String sqlInsert = MessageFormat.format(sqlInsertFormat,
				DatabaseUtil.getInegrationDatabaseTableName(IntegrationQueueLogRowMapper.QueueLog.class.getSimpleName()));
		Map<String, Object> insertParamters = new HashMap<String, Object>();
		insertParamters.put("tableName", iq.getTableName());
		insertParamters.put("logicalKeyName", iq.getLogicalKeyName());
		insertParamters.put("logicalKeyValue", iq.getLogicalKeyValue());
		insertParamters.put("status", iq.getStatus());
		SqlParameterSource insertSource = new MapSqlParameterSource(insertParamters);
		jt.update(sqlInsert, insertSource);

		String sqlDeleteFormat = "DELETE FROM {0} WHERE {1} = :id";
		String sqlDelete = MessageFormat.format(sqlDeleteFormat,
				DatabaseUtil.getInegrationDatabaseTableName(IntegrationQueueRowMapper.Queue.class.getSimpleName()),
				IntegrationQueueRowMapper.Queue.id.toString());
		Map<String, Object> deleteParamters = new HashMap<String, Object>();
		deleteParamters.put("id", iq.getId());
		SqlParameterSource deleteSource = new MapSqlParameterSource(deleteParamters);
		jt.update(sqlDelete, deleteSource);
	}

}

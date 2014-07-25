package edu.zju.bme.clever.integration.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.IntegrationQueue;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class IntegrationQueueLogRowMapper implements RowMapper<IntegrationQueue> {
	
	public enum QueueLog {
		id,
		tableName,
		logicalKeyName,
		logicalKeyValue,
		status,
	}

	@Override
	public IntegrationQueue mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		IntegrationQueue iq = new IntegrationQueue();
		iq.setId(RowMapperUtil.getInteger(rs, IntegrationQueueLogRowMapper.QueueLog.id.toString()));
		iq.setTableName(rs.getString(IntegrationQueueLogRowMapper.QueueLog.tableName.toString()));
		iq.setLogicalKeyName(rs.getString(IntegrationQueueLogRowMapper.QueueLog.logicalKeyName.toString()));
		iq.setLogicalKeyValue(rs.getString(IntegrationQueueLogRowMapper.QueueLog.logicalKeyValue.toString()));
		iq.setStatus(RowMapperUtil.getBoolean(rs, IntegrationQueueLogRowMapper.QueueLog.status.toString()));
		return iq;
	}

}

package edu.zju.bme.clever.integration.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.IntegrationQueue;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class IntegrationQueueRowMapper implements RowMapper<IntegrationQueue> {
	
	public enum Queue {
		id,
		tableName,
		logicalKeyName,
		logicalKeyValue,
	}

	@Override
	public IntegrationQueue mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		IntegrationQueue iq = new IntegrationQueue();
		iq.setId(RowMapperUtil.getInteger(rs, IntegrationQueueRowMapper.Queue.id.toString()));
		iq.setTableName(rs.getString(IntegrationQueueRowMapper.Queue.tableName.toString()));
		iq.setLogicalKeyName(rs.getString(IntegrationQueueRowMapper.Queue.logicalKeyName.toString()));
		iq.setLogicalKeyValue(rs.getString(IntegrationQueueRowMapper.Queue.logicalKeyValue.toString()));
		return iq;
	}

}

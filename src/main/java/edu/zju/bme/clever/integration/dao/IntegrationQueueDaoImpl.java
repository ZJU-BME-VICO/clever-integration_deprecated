package edu.zju.bme.clever.integration.dao;

import java.text.MessageFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.entity.IntegrationQueue;
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
	public void save() {
		// TODO Auto-generated method stub
		
	}

}

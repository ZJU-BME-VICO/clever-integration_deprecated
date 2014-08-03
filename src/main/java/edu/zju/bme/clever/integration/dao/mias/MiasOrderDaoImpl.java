package edu.zju.bme.clever.integration.dao.mias;

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

import edu.zju.bme.clever.integration.entity.Order;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasOrderRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("miasOrderDao")
@Transactional
public class MiasOrderDaoImpl implements MiasOrderDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<Order> get(int orderId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :orderId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getMiasDatabaseTableName(MiasOrderRowMapper.ORDERS.class.getSimpleName()),
				MiasOrderRowMapper.ORDERS.ORDER_ID);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("orderId", orderId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.query(sql, source, new MiasOrderRowMapper());
	}
	
}

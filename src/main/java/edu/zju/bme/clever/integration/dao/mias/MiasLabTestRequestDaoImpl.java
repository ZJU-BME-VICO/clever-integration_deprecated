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

import edu.zju.bme.clever.integration.entity.LabTestRequest;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasLabTestRequestRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("miasLabTestRequestDao")
@Transactional
public class MiasLabTestRequestDaoImpl implements MiasLabTestRequestDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<LabTestRequest> get(String testReqId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :testReqId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getMiasDatabaseTableName(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.class.getSimpleName()),
				MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.TEST_REQ_ID);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("testReqId", testReqId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.query(sql, source, new MiasLabTestRequestRowMapper());
	}
	
}

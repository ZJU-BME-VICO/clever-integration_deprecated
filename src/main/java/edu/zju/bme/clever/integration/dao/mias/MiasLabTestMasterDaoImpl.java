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

import edu.zju.bme.clever.integration.entity.LabTestMaster;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasLabTestMasterRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("miasLabTestMasterDao")
@Transactional
public class MiasLabTestMasterDaoImpl implements MiasLabTestMasterDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<LabTestMaster> get(String testId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :testId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getMiasDatabaseTableName(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.class.getSimpleName()),
				MiasLabTestMasterRowMapper.LAB_TEST_MASTER.TEST_ID);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("testId", testId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.query(sql, source, new MiasLabTestMasterRowMapper());
	}
	
}

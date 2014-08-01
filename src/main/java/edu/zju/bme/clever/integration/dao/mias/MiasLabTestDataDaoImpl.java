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

import edu.zju.bme.clever.integration.entity.LabTestData;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasLabTestDataRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("miasLabTestDataDao")
@Transactional
public class MiasLabTestDataDaoImpl implements MiasLabTestDataDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<LabTestData> get(int testDataId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :testDataId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getMiasDatabaseTableName(MiasLabTestDataRowMapper.LAB_TEST_DATA.class.getSimpleName()),
				MiasLabTestDataRowMapper.LAB_TEST_DATA.TEST_DATA_ID);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("testDataId", testDataId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.query(sql, source, new MiasLabTestDataRowMapper());
	}
	
}

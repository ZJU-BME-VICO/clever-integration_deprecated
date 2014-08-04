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

import edu.zju.bme.clever.integration.entity.Diagnosis;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasDiagnosisRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("miasDiagnosisDao")
@Transactional
public class MiasDiagnosisDaoImpl implements MiasDiagnosisDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<Diagnosis> get(int diagnosisId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :diagnosisId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getMiasDatabaseTableName(MiasDiagnosisRowMapper.DIAGNOSIS.class.getSimpleName()),
				MiasDiagnosisRowMapper.DIAGNOSIS.DIAGNOSIS_ID);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("diagnosisId", diagnosisId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.query(sql, source, new MiasDiagnosisRowMapper());
	}
	
}

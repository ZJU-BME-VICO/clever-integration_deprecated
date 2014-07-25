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

import edu.zju.bme.clever.integration.entity.Visit;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasVisitRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("miasVisitDao")
@Transactional
public class MiasVisitDaoImpl implements MiasVisitDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<Visit> get(String visitId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :visitId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getMiasDatabaseTableName(MiasVisitRowMapper.PATIENT_VISIT.class.getSimpleName()),
				MiasVisitRowMapper.PATIENT_VISIT.VISIT_ID);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("visitId", visitId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.query(sql, source, new MiasVisitRowMapper());
	}
	
}

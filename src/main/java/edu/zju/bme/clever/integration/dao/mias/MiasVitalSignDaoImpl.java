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

import edu.zju.bme.clever.integration.entity.VitalSign;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasVitalSignRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("miasVitalSignDao")
@Transactional
public class MiasVitalSignDaoImpl implements MiasVitalSignDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<VitalSign> get(int recordId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :recordId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getMiasDatabaseTableName(MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.class.getSimpleName()),
				MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.RECORD_ID);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("recordId", recordId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.query(sql, source, new MiasVitalSignRowMapper());
	}
	
}

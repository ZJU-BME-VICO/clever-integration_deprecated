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

import edu.zju.bme.clever.integration.entity.Allergy;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasAllergyRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("miasAllergyDao")
@Transactional
public class MiasAllergyDaoImpl implements MiasAllergyDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<Allergy> get(int allergyId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :allergyId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getMiasDatabaseTableName(MiasAllergyRowMapper.ALLERGY_HISTORY.class.getSimpleName()),
				MiasAllergyRowMapper.ALLERGY_HISTORY.ALLERGY_ID);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("allergyId", allergyId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.query(sql, source, new MiasAllergyRowMapper());
	}
	
}

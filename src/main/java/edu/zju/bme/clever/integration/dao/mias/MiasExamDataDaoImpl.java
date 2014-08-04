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

import edu.zju.bme.clever.integration.entity.ExamData;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasExamDataRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("miasExamDataDao")
@Transactional
public class MiasExamDataDaoImpl implements MiasExamDataDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<ExamData> get(int dataNo) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :dataNo";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getMiasDatabaseTableName(MiasExamDataRowMapper.EXAM_DATA.class.getSimpleName()),
				MiasExamDataRowMapper.EXAM_DATA.DATA_NO);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("dataNo", dataNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.query(sql, source, new MiasExamDataRowMapper());
	}
	
}

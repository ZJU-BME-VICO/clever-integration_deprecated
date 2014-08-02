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

import edu.zju.bme.clever.integration.entity.ExamMaster;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasExamMasterRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("miasExamMasterDao")
@Transactional
public class MiasExamMasterDaoImpl implements MiasExamMasterDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<ExamMaster> get(int serialNo) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :serialNo";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getMiasDatabaseTableName(MiasExamMasterRowMapper.EXAM_MASTER.class.getSimpleName()),
				MiasExamMasterRowMapper.EXAM_MASTER.SERIAL_NO);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("serialNo", serialNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.query(sql, source, new MiasExamMasterRowMapper());
	}
	
}

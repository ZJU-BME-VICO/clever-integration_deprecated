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

import edu.zju.bme.clever.integration.entity.ExamReport;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasExamReportRowMapper;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("miasExamReportDao")
@Transactional
public class MiasExamReportDaoImpl implements MiasExamReportDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<ExamReport> get(int reportNo) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :reportNo";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getMiasDatabaseTableName(MiasExamReportRowMapper.EXAM_REPORT.class.getSimpleName()),
				MiasExamReportRowMapper.EXAM_REPORT.REPORT_NO);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("reportNo", reportNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.query(sql, source, new MiasExamReportRowMapper());
	}
	
}

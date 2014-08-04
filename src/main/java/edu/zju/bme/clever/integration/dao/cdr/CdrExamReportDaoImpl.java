package edu.zju.bme.clever.integration.dao.cdr;

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
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrExamReportRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("cdrExamReportDao")
@Transactional
public class CdrExamReportDaoImpl implements CdrExamReportDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<ExamReport> get(int reportNo) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :reportNo";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.class.getSimpleName()),
				CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.report_no);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("reportNo", reportNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<ExamReport> examReports = jt.query(sql, source, new CdrExamReportRowMapper());
		examReports.forEach(l -> {
			ExamReport k = new ExamReport();
			k.setReportNo(reportNo);
			CdrCache.INSTANCE.put(ExamReport.class, k.hashCode(), l);
		});
		return examReports;
	}

	@Override
	public int getCount(int reportNo) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :reportNo";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.class.getSimpleName()),
				CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.report_no);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("reportNo", reportNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(ExamReport e) {
		if (this.getCount(e.getReportNo()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":exam_id, "
					+ ":report_no, "
					+ ":storage_mode, "
					+ ":report_url, "
					+ ":exam_desc, "
					+ ":exam_view, "
					+ ":exam_diag, "
					+ ":exam_memo, "
					+ ":report_date, "
					+ ":reporter_id, "
					+ ":reporter_name, "
					+ ":verifier_id, "
					+ ":verifier_name, "
					+ ":data_type, "
					+ ":first_media_name, "
					+ ":first_path, "
					+ ":second_media_name, "
					+ ":second_path, "
					+ ":is_abnormal, "
					+ ":_uid_value, "
					+ ":idExamMaster)";		
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.class.getSimpleName()));
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(e));
			return jt.update(sql, source);
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :exam_id, "
					+ "{2} = :storage_mode, "
					+ "{3} = :report_url, "
					+ "{4} = :exam_desc, "
					+ "{5} = :exam_view, "
					+ "{6} = :exam_diag, "
					+ "{7} = :exam_memo, "
					+ "{8} = :report_date, "
					+ "{9} = :reporter_id, "
					+ "{10} = :reporter_name, "
					+ "{11} = :verifier_id, "
					+ "{12} = :verifier_name, "
					+ "{13} = :data_type, "
					+ "{14} = :first_media_name, "
					+ "{15} = :first_path, "
					+ "{16} = :second_media_name, "
					+ "{17} = :second_path, "
					+ "{18} = :is_abnormal, "
					+ "{19} = :_uid_value, "
					+ "{20} = :idExamMaster WHERE {21} = :report_no";	
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.class.getSimpleName()),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.exam_id.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.report_no.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.storage_mode.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.report_url.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.exam_desc.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.exam_view.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.exam_diag.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.exam_memo.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.report_date.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.reporter_id.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.reporter_name.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.verifier_id.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.verifier_name.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.data_type.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.first_media_name.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.first_path.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.second_media_name.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.second_path.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.is_abnormal.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report._uid_value.toString(),
					CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.idExamMaster.toString());
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(e));
			return jt.update(sql, source);			
		}
	}
	
	private Map<String, Object> putParameters(ExamReport e) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("exam_id", e.getExamId());
		parameters.put("report_no", e.getReportNo());
		parameters.put("storage_mode", e.getStorageMode());
		parameters.put("report_url", e.getReportUrl());
		parameters.put("exam_desc", e.getExamDesc());
		parameters.put("exam_view", e.getExamView());
		parameters.put("exam_diag", e.getExamDiag());
		parameters.put("exam_memo", e.getExamMemo());
		parameters.put("report_date", e.getReportDate());
		parameters.put("reporter_id", e.getReporterId());
		parameters.put("reporter_name", e.getReporterName());
		parameters.put("verifier_id", e.getVerifierId());
		parameters.put("verifier_name", e.getVerifierName());
		parameters.put("data_type", e.getDataType());
		parameters.put("first_media_name", e.getFirstMediaName());
		parameters.put("first_path", e.getFirstPath());
		parameters.put("second_media_name", e.getSecondMediaName());
		parameters.put("second_path", e.getSecondPath());
		parameters.put("is_abnormal", e.getIsAbnormal());
		parameters.put("_uid_value", e.get_uid_value());
		parameters.put("idExamMaster", e.getIdExamMaster());
		return parameters;
	}
	
}

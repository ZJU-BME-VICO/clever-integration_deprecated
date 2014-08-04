package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamReport;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasExamReportRowMapper implements RowMapper<ExamReport> {

	public enum EXAM_REPORT {
		EXAM_ID,
		REPORT_NO,
		STORAGE_MODE,
		REPORT_URL,
		EXAM_DESC,
		EXAM_VIEW,
		EXAM_DIAG,
		EXAM_MEMO,
		REPORT_DATE,
		REPORTER_ID,
		REPORTER_NAME,
		VERIFIER_ID,
		VERIFIER_NAME,
		DATA_TYPE,
		FIRST_MEDIA_NAME,
		FIRST_PATH,
		SECOND_MEDIA_NAME,
		SECOND_PATH,
		IS_ABNORMAL,
	}

	@Override
	public ExamReport mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamReport e = new ExamReport();
		e.setExamId(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.EXAM_ID.toString()));
		e.setReportNo(RowMapperUtil.getInteger(rs, MiasExamReportRowMapper.EXAM_REPORT.REPORT_NO.toString()));
		e.setStorageMode(RowMapperUtil.getInteger(rs, MiasExamReportRowMapper.EXAM_REPORT.STORAGE_MODE.toString()));
		e.setReportUrl(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.REPORT_URL.toString()));
		e.setExamDesc(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.EXAM_DESC.toString()));
		e.setExamView(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.EXAM_VIEW.toString()));
		e.setExamDiag(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.EXAM_DIAG.toString()));
		e.setExamMemo(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.EXAM_MEMO.toString()));
		e.setReportDate(RowMapperUtil.getDateTime(rs.getTimestamp(MiasExamReportRowMapper.EXAM_REPORT.REPORT_DATE.toString())));
		e.setReporterId(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.REPORTER_ID.toString()));
		e.setReporterName(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.REPORTER_NAME.toString()));
		e.setVerifierId(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.VERIFIER_ID.toString()));
		e.setVerifierName(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.VERIFIER_NAME.toString()));
		e.setDataType(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.DATA_TYPE.toString()));
		e.setFirstMediaName(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.FIRST_MEDIA_NAME.toString()));
		e.setFirstPath(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.FIRST_PATH.toString()));
		e.setSecondMediaName(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.SECOND_MEDIA_NAME.toString()));
		e.setSecondPath(rs.getString(MiasExamReportRowMapper.EXAM_REPORT.SECOND_PATH.toString()));
		e.setIsAbnormal(RowMapperUtil.getInteger(rs, MiasExamReportRowMapper.EXAM_REPORT.IS_ABNORMAL.toString()));
		return e;
	}

}

package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamReport;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrExamReportRowMapper implements RowMapper<ExamReport> {

	public enum openEHR_EHR_OBSERVATION_exam_report {
		_hibernarmId,
		exam_id,
		report_no,
		storage_mode,
		report_url,
		exam_desc,
		exam_view,
		exam_diag,
		exam_memo,
		report_date,
		reporter_id,
		reporter_name,
		verifier_id,
		verifier_name,
		data_type,
		first_media_name,
		first_path,
		second_media_name,
		second_path,
		is_abnormal,
		_uid_value,
		idExamMaster,
	}

	@Override
	public ExamReport mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamReport e = new ExamReport();
		
		
		e.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report._hibernarmId.toString()));
		e.setExamId(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.exam_id.toString()));
		e.setReportNo(RowMapperUtil.getInteger(rs, CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.report_no.toString()));
		e.setStorageMode(RowMapperUtil.getInteger(rs, CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.storage_mode.toString()));
		e.setReportUrl(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.report_url.toString()));
		e.setExamDesc(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.exam_desc.toString()));
		e.setExamView(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.exam_view.toString()));
		e.setExamDiag(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.exam_diag.toString()));
		e.setExamMemo(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.exam_memo.toString()));
		e.setReportDate(RowMapperUtil.getDateTime(rs.getTimestamp(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.report_date.toString())));
		e.setReporterId(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.reporter_id.toString()));
		e.setReporterName(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.reporter_name.toString()));
		e.setVerifierId(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.verifier_id.toString()));
		e.setVerifierName(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.verifier_name.toString()));
		e.setDataType(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.data_type.toString()));
		e.setFirstMediaName(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.first_media_name.toString()));
		e.setFirstPath(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.first_path.toString()));
		e.setSecondMediaName(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.second_media_name.toString()));
		e.setSecondPath(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.second_path.toString()));
		e.setIsAbnormal(RowMapperUtil.getInteger(rs, CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.is_abnormal.toString()));
		e.set_uid_value(rs.getString(CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report._uid_value.toString()));
		e.setIdExamMaster(RowMapperUtil.getInteger(rs, CdrExamReportRowMapper.openEHR_EHR_OBSERVATION_exam_report.idExamMaster.toString()));
		return e;
	}

}

package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamData;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrExamDataRowMapper implements RowMapper<ExamData> {

	public enum openEHR_EHR_OBSERVATION_exam_data {
		_hibernarmId,
		exam_id,
		data_no,
		data_type,
		series_no,
		image_no,
		image_flag,
		first_media_name,
		first_path,
		second_media_name,
		second_path,
		_uid_value,
		idExamMaster,
	}

	@Override
	public ExamData mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamData e = new ExamData();
		e.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data._hibernarmId.toString()));
		e.setExamId(rs.getString(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.exam_id.toString()));
		e.setDataNo(RowMapperUtil.getInteger(rs, CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.data_no.toString()));
		e.setDataType(rs.getString(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.data_type.toString()));
		e.setSeriesNo(rs.getString(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.series_no.toString()));
		e.setImageNo(rs.getString(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.image_no.toString()));
		e.setImageFlag(RowMapperUtil.getInteger(rs, CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.image_flag.toString()));
		e.setFirstMediaName(rs.getString(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.first_media_name.toString()));
		e.setFirstPath(rs.getString(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.first_path.toString()));
		e.setSecondMediaName(rs.getString(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.second_media_name.toString()));
		e.setSecondPath(rs.getString(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.second_path.toString()));
		e.set_uid_value(rs.getString(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data._uid_value.toString()));
		e.setIdExamMaster(RowMapperUtil.getInteger(rs, CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.idExamMaster.toString()));
		return e;
	}

}

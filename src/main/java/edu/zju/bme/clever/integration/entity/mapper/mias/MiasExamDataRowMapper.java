package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamData;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasExamDataRowMapper implements RowMapper<ExamData> {

	public enum EXAM_DATA {
		EXAM_ID,
		DATA_NO,
		DATA_TYPE,
		SERIES_NO,
		IMAGE_NO,
		IMAGE_FLAG,
		FIRST_MEDIA_NAME,
		FIRST_PATH,
		SECOND_MEDIA_NAME,
		SECOND_PATH,
	}

	@Override
	public ExamData mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamData e = new ExamData();
		e.setExamId(rs.getString(MiasExamDataRowMapper.EXAM_DATA.EXAM_ID.toString()));
		e.setDataNo(RowMapperUtil.getInteger(rs, MiasExamDataRowMapper.EXAM_DATA.DATA_NO.toString()));
		e.setDataType(rs.getString(MiasExamDataRowMapper.EXAM_DATA.DATA_TYPE.toString()));
		e.setSeriesNo(rs.getString(MiasExamDataRowMapper.EXAM_DATA.SERIES_NO.toString()));
		e.setImageNo(rs.getString(MiasExamDataRowMapper.EXAM_DATA.IMAGE_NO.toString()));
		e.setImageFlag(RowMapperUtil.getInteger(rs, MiasExamDataRowMapper.EXAM_DATA.IMAGE_FLAG.toString()));
		e.setFirstMediaName(rs.getString(MiasExamDataRowMapper.EXAM_DATA.FIRST_MEDIA_NAME.toString()));
		e.setFirstPath(rs.getString(MiasExamDataRowMapper.EXAM_DATA.FIRST_PATH.toString()));
		e.setSecondMediaName(rs.getString(MiasExamDataRowMapper.EXAM_DATA.SECOND_MEDIA_NAME.toString()));
		e.setSecondPath(rs.getString(MiasExamDataRowMapper.EXAM_DATA.SECOND_PATH.toString()));
		return e;
	}

}

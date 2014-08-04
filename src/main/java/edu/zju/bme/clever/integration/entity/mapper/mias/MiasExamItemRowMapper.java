package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamItem;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasExamItemRowMapper implements RowMapper<ExamItem> {

	public enum EXAM_ITEM {
		SERIAL_NO,
		EXAM_REQ_ID,
		EXAM_ID,
		EXAM_ITEM_NO,
		EXAM_CLASS,
		EXAM_SUB_CLASS,
		EXAM_ITEM_NAME,
		EXAM_ITEM_CODE,
	}

	@Override
	public ExamItem mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamItem e = new ExamItem();
		e.setSerialNo(RowMapperUtil.getInteger(rs, MiasExamItemRowMapper.EXAM_ITEM.SERIAL_NO.toString()));
		e.setExamReqId(rs.getString(MiasExamItemRowMapper.EXAM_ITEM.EXAM_REQ_ID.toString()));
		e.setExamId(rs.getString(MiasExamItemRowMapper.EXAM_ITEM.EXAM_ID.toString()));
		e.setExamItemNo(RowMapperUtil.getInteger(rs, MiasExamItemRowMapper.EXAM_ITEM.EXAM_ITEM_NO.toString()));
		e.setExamClass(rs.getString(MiasExamItemRowMapper.EXAM_ITEM.EXAM_CLASS.toString()));
		e.setExamSubClass(rs.getString(MiasExamItemRowMapper.EXAM_ITEM.EXAM_SUB_CLASS.toString()));
		e.setExamItemName(rs.getString(MiasExamItemRowMapper.EXAM_ITEM.EXAM_ITEM_NAME.toString()));
		e.setExamItemCode(rs.getString(MiasExamItemRowMapper.EXAM_ITEM.EXAM_ITEM_CODE.toString()));
		return e;
	}

}

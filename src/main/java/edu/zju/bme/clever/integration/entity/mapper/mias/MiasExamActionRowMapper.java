package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamAction;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasExamActionRowMapper implements RowMapper<ExamAction> {

	public enum EXAM_ACTION {
		SERIAL_NO,
		EXAM_REQ_ID,
		EXAM_ID,
		ACTOR_ID,
		ACTION_DATE_TIME,
		ACTION_TYPE_ID,
		ACTION_MEMO,
		ACTOR_NAME,
	}

	@Override
	public ExamAction mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamAction e = new ExamAction();
		e.setSerialNo(RowMapperUtil.getInteger(rs, MiasExamActionRowMapper.EXAM_ACTION.SERIAL_NO.toString()));
		e.setExamReqId(rs.getString(MiasExamActionRowMapper.EXAM_ACTION.EXAM_REQ_ID.toString()));
		e.setExamId(rs.getString(MiasExamActionRowMapper.EXAM_ACTION.EXAM_ID.toString()));
		e.setActorId(rs.getString(MiasExamActionRowMapper.EXAM_ACTION.ACTOR_ID.toString()));
		e.setActionDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasExamActionRowMapper.EXAM_ACTION.ACTION_DATE_TIME.toString())));
		e.setActionTypeId(rs.getString(MiasExamActionRowMapper.EXAM_ACTION.ACTION_TYPE_ID.toString()));
		e.setActionMemo(rs.getString(MiasExamActionRowMapper.EXAM_ACTION.ACTION_MEMO.toString()));
		e.setActorName(rs.getString(MiasExamActionRowMapper.EXAM_ACTION.ACTOR_NAME.toString()));
		return e;
	}

}

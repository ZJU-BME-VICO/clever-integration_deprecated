package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamAction;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrExamActionRowMapper implements RowMapper<ExamAction> {

	public enum openEHR_EHR_ACTION_exam_action {
		_hibernarmId,
		exam_req_id,
		exam_id,
		actor_id,
		action_date_time,
		action_type_id,
		action_memo,
		actor_name,
		serial_no,
		_uid_value,
		idExamRequest,
		idExamMaster,
	}

	@Override
	public ExamAction mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamAction e = new ExamAction();
		e.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action._hibernarmId.toString()));
		e.setExamReqId(rs.getString(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.exam_req_id.toString()));
		e.setExamId(rs.getString(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.exam_id.toString()));
		e.setActorId(rs.getString(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.actor_id.toString()));
		e.setActionDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.action_date_time.toString())));
		e.setActionTypeId(rs.getString(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.action_type_id.toString()));
		e.setActionMemo(rs.getString(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.action_memo.toString()));
		e.setActorName(rs.getString(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.actor_name.toString()));
		e.setSerialNo(RowMapperUtil.getInteger(rs, CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.serial_no.toString()));
		e.set_uid_value(rs.getString(CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action._uid_value.toString()));
		e.setIdExamRequest(RowMapperUtil.getInteger(rs, CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.idExamRequest.toString()));
		e.setIdExamMaster(RowMapperUtil.getInteger(rs, CdrExamActionRowMapper.openEHR_EHR_ACTION_exam_action.idExamMaster.toString()));
		return e;
	}

}

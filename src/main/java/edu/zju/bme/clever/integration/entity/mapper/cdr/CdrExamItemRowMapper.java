package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamItem;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrExamItemRowMapper implements RowMapper<ExamItem> {

	public enum openEHR_EHR_INSTRUCTION_exam_item {
		_hibernarmId,
		exam_req_id,
		exam_id,
		exam_item_no,
		exam_class,
		exam_sub_class,
		exam_item_name,
		exam_item_code,
		serial_no,
		_uid_value,
		idExamRequest,
		idExamMaster,
	}

	@Override
	public ExamItem mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamItem e = new ExamItem();
		e.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item._hibernarmId.toString()));
		e.setExamReqId(rs.getString(CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_req_id.toString()));
		e.setExamId(rs.getString(CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_id.toString()));
		e.setExamItemNo(RowMapperUtil.getInteger(rs, CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_item_no.toString()));
		e.setExamClass(rs.getString(CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_class.toString()));
		e.setExamSubClass(rs.getString(CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_sub_class.toString()));
		e.setExamItemName(rs.getString(CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_item_name.toString()));
		e.setExamItemCode(rs.getString(CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.exam_item_code.toString()));
		e.setSerialNo(RowMapperUtil.getInteger(rs, CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.serial_no.toString()));
		e.set_uid_value(rs.getString(CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item._uid_value.toString()));
		e.setIdExamRequest(RowMapperUtil.getInteger(rs, CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.idExamRequest.toString()));
		e.setIdExamMaster(RowMapperUtil.getInteger(rs, CdrExamItemRowMapper.openEHR_EHR_INSTRUCTION_exam_item.idExamMaster.toString()));
		return e;
	}

}

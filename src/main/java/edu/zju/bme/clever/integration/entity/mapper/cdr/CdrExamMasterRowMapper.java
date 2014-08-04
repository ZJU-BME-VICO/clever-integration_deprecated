package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamMaster;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrExamMasterRowMapper implements RowMapper<ExamMaster> {

	public enum openEHR_EHR_INSTRUCTION_exam_master {
		_hibernarmId,
		exam_id,
		patient_id,
		visit_id,
		exam_req_id,
		his_exam_id,
		exam_dept_name,
		exam_dept_code,
		scheduled_date_time,
		exam_time,
		exam_status,
		is_read,
		is_normal,
		serial_no,
		_uid_value,
		idPatient,
		idVisit,
		idExamRequest,
	}

	@Override
	public ExamMaster mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamMaster e = new ExamMaster();
		e.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master._hibernarmId.toString()));
		e.setExamId(rs.getString(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.exam_id.toString()));
		e.setPatientId(rs.getString(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.patient_id.toString()));
		e.setVisitId(rs.getString(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.visit_id.toString()));
		e.setExamReqId(rs.getString(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.exam_req_id.toString()));
		e.setHisExamId(rs.getString(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.his_exam_id.toString()));
		e.setExamDeptName(rs.getString(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.exam_dept_name.toString()));
		e.setExamDeptCode(rs.getString(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.exam_dept_code.toString()));
		e.setScheduledDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.scheduled_date_time.toString())));
		e.setExamTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.exam_time.toString())));
		e.setExamStatus(RowMapperUtil.getInteger(rs, CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.exam_status.toString()));
		e.setIsRead(RowMapperUtil.getInteger(rs, CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.is_read.toString()));
		e.setIsNormal(RowMapperUtil.getInteger(rs, CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.is_normal.toString()));
		e.setSerialNo(RowMapperUtil.getInteger(rs, CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.serial_no.toString()));
		e.set_uid_value(rs.getString(CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master._uid_value.toString()));
		e.setIdPatient(RowMapperUtil.getInteger(rs, CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.idPatient.toString()));
		e.setIdVisit(RowMapperUtil.getInteger(rs, CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.idVisit.toString()));
		e.setIdExamRequest(RowMapperUtil.getInteger(rs, CdrExamMasterRowMapper.openEHR_EHR_INSTRUCTION_exam_master.idExamRequest.toString()));
		return e;
	}

}

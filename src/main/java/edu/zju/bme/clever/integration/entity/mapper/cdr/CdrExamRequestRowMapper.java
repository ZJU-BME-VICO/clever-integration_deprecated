package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamRequest;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrExamRequestRowMapper implements RowMapper<ExamRequest> {

	public enum openEHR_EHR_INSTRUCTION_exam_request {
		_hibernarmId,
		exam_req_id,
		patient_id,
		visit_id,
		order_id,
		priority,
		req_date_time,
		req_dept_name,
		req_dept_id,
		req_doctor_name,
		req_doctor_id,
		purpose,
		syndrom,
		signs,
		relevant_lab_test,
		relevant_diag,
		diagnosis,
		memo,
		transportation_mode,
		exam_request_status,
		_uid_value,
		idPatient,
		idVisit,
		idOrder,
	}

	@Override
	public ExamRequest mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamRequest e = new ExamRequest();
		e.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request._hibernarmId.toString()));
		e.setExamReqId(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.exam_req_id.toString()));
		e.setPatientId(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.patient_id.toString()));
		e.setVisitId(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.visit_id.toString()));
		e.setOrderId(RowMapperUtil.getInteger(rs, CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.order_id.toString()));
		e.setPriority(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.priority.toString()));
		e.setReqDateTime(RowMapperUtil.getDateTime(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_date_time.toString())));
		e.setReqDeptName(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_dept_name.toString()));
		e.setReqDeptId(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_dept_id.toString()));
		e.setReqDoctorName(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_doctor_name.toString()));
		e.setReqDoctorId(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_doctor_id.toString()));
		e.setPurpose(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.purpose.toString()));
		e.setSyndrom(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.syndrom.toString()));
		e.setSigns(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.signs.toString()));
		e.setRelevantLabTest(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.relevant_lab_test.toString()));
		e.setRelevantDiag(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.relevant_diag.toString()));
		e.setDiagnosis(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.diagnosis.toString()));
		e.setMemo(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.memo.toString()));
		e.setTransportationMode(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.transportation_mode.toString()));
		e.setExamRequestStatus(RowMapperUtil.getInteger(rs, CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.exam_request_status.toString()));
		e.set_uid_value(rs.getString(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request._uid_value.toString()));
		e.setIdPatient(RowMapperUtil.getInteger(rs, CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.idPatient.toString()));
		e.setIdVisit(RowMapperUtil.getInteger(rs, CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.idVisit.toString()));
		e.setIdOrder(RowMapperUtil.getInteger(rs, CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.idOrder.toString()));
		return e;
	}

}

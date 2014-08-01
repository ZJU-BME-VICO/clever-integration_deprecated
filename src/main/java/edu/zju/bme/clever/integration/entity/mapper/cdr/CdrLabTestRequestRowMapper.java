package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.LabTestRequest;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrLabTestRequestRowMapper implements RowMapper<LabTestRequest> {

	public enum openEHR_EHR_INSTRUCTION_lab_test_request {
		_hibernarmId,
		test_req_id,
		patient_id,
		visit_id,
		order_id,
		req_date_time,
		req_dept_name,
		req_dept_id,
		req_doctor_name,
		req_doctor_id,
		lab_test_subject_code,
		lab_test_subject_name,
		test_cause,
		relevant_clinic_diag,
		sample_class_code,
		sample_class_name,
		test_tube_code,
		test_tube_name,
		lab_test_type_code,
		lab_test_type_name,
		execute_dept_code,
		execute_dept_name,
		notes_for_spcm,
		priority_indicator,
		lab_test_status,
		_uid_value,
		idPatient,
		idVisit,
		idOrder,
	}

	@Override
	public LabTestRequest mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		LabTestRequest l = new LabTestRequest();
		l.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request._hibernarmId.toString()));
		l.setTestReqId(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.test_req_id.toString()));
		l.setPatientId(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.patient_id.toString()));
		l.setVisitId(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.visit_id.toString()));
		l.setOrderId(RowMapperUtil.getInteger(rs, CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.order_id.toString()));
		l.setReqDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.req_date_time.toString())));
		l.setReqDeptName(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.req_dept_name.toString()));
		l.setReqDeptId(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.req_dept_id.toString()));
		l.setReqDoctorName(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.req_doctor_name.toString()));
		l.setReqDoctorId(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.req_doctor_id.toString()));
		l.setLabTestSubjectCode(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.lab_test_subject_code.toString()));
		l.setLabTestSubjectName(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.lab_test_subject_name.toString()));
		l.setTestCause(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.test_cause.toString()));
		l.setRelevantClinicDiag(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.relevant_clinic_diag.toString()));
		l.setSampleClassCode(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.sample_class_code.toString()));
		l.setSampleClassName(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.sample_class_name.toString()));
		l.setTestTubeCode(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.test_tube_code.toString()));
		l.setTestTubeName(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.test_tube_name.toString()));
		l.setLabTestTypeCode(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.lab_test_type_code.toString()));
		l.setLabTestTypeName(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.lab_test_type_name.toString()));
		l.setExecuteDeptCode(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.execute_dept_code.toString()));
		l.setExecuteDeptName(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.execute_dept_name.toString()));
		l.setNotesForSpcm(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.notes_for_spcm.toString()));
		l.setPriorityIdicator(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.priority_indicator.toString()));
		l.setLabTestStatus(RowMapperUtil.getInteger(rs, CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.lab_test_status.toString()));
		l.set_uid_value(rs.getString(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request._uid_value.toString()));
		l.setIdPatient(RowMapperUtil.getInteger(rs, CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.idPatient.toString()));
		l.setIdVisit(RowMapperUtil.getInteger(rs, CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.idVisit.toString()));
		l.setIdOrder(RowMapperUtil.getInteger(rs, CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.idOrder.toString()));
		return l;
	}

}

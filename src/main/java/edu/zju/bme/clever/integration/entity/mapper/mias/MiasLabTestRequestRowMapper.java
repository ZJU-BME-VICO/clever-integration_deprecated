package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.LabTestRequest;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasLabTestRequestRowMapper implements RowMapper<LabTestRequest> {

	public enum LAB_TEST_REQUEST {
		TEST_REQ_ID,
		PATIENT_ID,
		VISIT_ID,
		ORDER_ID,
		REQ_DATE_TIME,
		REQ_DEPT_NAME,
		REQ_DEPT_ID,
		REQ_DOCTOR_NAME,
		REQ_DOCTOR_ID,
		LAB_TEST_SUBJECT_CODE,
		LAB_TEST_SUBJECT_NAME,
		TEST_CAUSE,
		RELEVANT_CLINIC_DIAG,
		SAMPLE_CLASS_CODE,
		SAMPLE_CLASS_NAME,
		TEST_TUBE_CODE,
		TEST_TUBE_NAME,
		LAB_TEST_TYPE_CODE,
		LAB_TEST_TYPE_NAME,
		EXECUTE_DEPT_CODE,
		EXECUTE_DEPT_NAME,
		NOTES_FOR_SPCM,
		PRIORITY_INDICATOR,
		LAB_TEST_STATUS,
	}

	@Override
	public LabTestRequest mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		LabTestRequest l = new LabTestRequest();
		l.setTestReqId(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.TEST_REQ_ID.toString()));
		l.setPatientId(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.PATIENT_ID.toString()));
		l.setVisitId(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.VISIT_ID.toString()));
		l.setOrderId(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.ORDER_ID.toString()));
		l.setReqDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.REQ_DATE_TIME.toString())));
		l.setReqDeptName(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.REQ_DEPT_NAME.toString()));
		l.setReqDeptId(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.REQ_DEPT_ID.toString()));
		l.setReqDoctorName(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.REQ_DOCTOR_NAME.toString()));
		l.setReqDoctorId(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.REQ_DOCTOR_ID.toString()));
		l.setLabTestSubjectCode(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.LAB_TEST_SUBJECT_CODE.toString()));
		l.setLabTestSubjectName(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.LAB_TEST_SUBJECT_NAME.toString()));
		l.setTestCause(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.TEST_CAUSE.toString()));
		l.setRelevantClinicDiag(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.RELEVANT_CLINIC_DIAG.toString()));
		l.setSampleClassCode(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.SAMPLE_CLASS_CODE.toString()));
		l.setSampleClassName(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.SAMPLE_CLASS_NAME.toString()));
		l.setTestTubeCode(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.TEST_TUBE_CODE.toString()));
		l.setTestTubeName(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.TEST_TUBE_NAME.toString()));
		l.setLabTestTypeCode(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.LAB_TEST_TYPE_CODE.toString()));
		l.setLabTestTypeName(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.LAB_TEST_TYPE_NAME.toString()));
		l.setExecuteDeptCode(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.EXECUTE_DEPT_CODE.toString()));
		l.setExecuteDeptName(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.EXECUTE_DEPT_NAME.toString()));
		l.setNotesForSpcm(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.NOTES_FOR_SPCM.toString()));
		l.setPriorityIdicator(rs.getString(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.PRIORITY_INDICATOR.toString()));
		l.setLabTestStatus(RowMapperUtil.getInteger(rs, MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.LAB_TEST_STATUS.toString()));
		return l;
	}

}

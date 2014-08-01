package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamRequest;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasExamRequestRowMapper implements RowMapper<ExamRequest> {

	public enum EXAM_REQUEST {
		EXAM_REQ_ID,
		PATIENT_ID,
		VISIT_ID,
		ORDER_ID,
		PRIORITY,
		REQ_DATE_TIME,
		REQ_DEPT_NAME,
		REQ_DEPT_ID,
		REQ_DOCTOR_NAME,
		REQ_DOCTOR_ID,
		PURPOSE,
		SYNDROM,
		SIGNS,
		RELEVANT_LAB_TEST,
		RELEVANT_DIAG,
		DIAGNOSIS,
		MEMO,
		TRANSPORTATION_MODE,
		EXAM_REQUEST_STATUS,
	}

	@Override
	public ExamRequest mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamRequest e = new ExamRequest();
		e.setExamReqId(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.EXAM_REQ_ID.toString()));
		e.setPatientId(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.PATIENT_ID.toString()));
		e.setVisitId(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.VISIT_ID.toString()));
		e.setOrderId(RowMapperUtil.getInteger(rs, MiasExamRequestRowMapper.EXAM_REQUEST.ORDER_ID.toString()));
		e.setPriority(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.PRIORITY.toString()));
		e.setReqDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasExamRequestRowMapper.EXAM_REQUEST.REQ_DATE_TIME.toString())));
		e.setReqDeptName(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.REQ_DEPT_NAME.toString()));
		e.setReqDeptId(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.REQ_DEPT_ID.toString()));
		e.setReqDoctorName(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.REQ_DOCTOR_NAME.toString()));
		e.setReqDoctorId(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.REQ_DOCTOR_ID.toString()));
		e.setPurpose(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.PURPOSE.toString()));
		e.setSyndrom(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.SYNDROM.toString()));
		e.setSigns(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.SIGNS.toString()));
		e.setRelevantLabTest(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.RELEVANT_LAB_TEST.toString()));
		e.setRelevantDiag(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.RELEVANT_DIAG.toString()));
		e.setDiagnosis(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.DIAGNOSIS.toString()));
		e.setMemo(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.MEMO.toString()));
		e.setTransportationMode(rs.getString(MiasExamRequestRowMapper.EXAM_REQUEST.TRANSPORTATION_MODE.toString()));
		e.setExamRequestStatus(RowMapperUtil.getInteger(rs, MiasExamRequestRowMapper.EXAM_REQUEST.EXAM_REQUEST_STATUS.toString()));
		return e;
	}

}

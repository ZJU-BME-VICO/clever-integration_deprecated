package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Allergy;
import edu.zju.bme.clever.integration.entity.ExamRequest;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrAllergyRowMapper implements RowMapper<Allergy> {

	public enum openEHR_EHR_OBSERVATION_allergy {
		_hibernarmId,
		allergy_id,
		patient_id,
		visit_id,
		order_id,
		info_source_type,
		allergy_class_code,
		allergy_source,
		memo,
		editor,
		edit_date_time,
		allergy_sub_class_code,
		drug_trade_name,
		drug_rattfy_code,
		drug_manufacturer,
		production_batch_no,
		_uid_value,
		idPatient,
		idVisit,
	}

	@Override
	public Allergy mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Allergy a = new Allergy();
		a.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy._hibernarmId.toString()));
		a.setAllergyId(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.allergy_id.toString()));
		a.setPatientId(rs.getString(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.patient_id.toString()));
		a.setVisitId(rs.getString(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.visit_id.toString()));
		a.setOrderId(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.order_id.toString()));
		a.setInfoSourceType(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.info_source_type.toString()));
		a.setAllergyClassCode(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.allergy_class_code.toString()));
		a.setAllergySource(rs.getString(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.allergy_source.toString()));
		a.setMemo(rs.getString(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.memo.toString()));
		a.setEditor(rs.getString(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.editor.toString()));
		a.setEditDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.edit_date_time.toString())));
		a.setAllergySubClassCode(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.allergy_sub_class_code.toString()));
		a.setDrugTradeName(rs.getString(cdra));
		
		
		e.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request._hibernarmId.toString()));
		e.setExamReqId(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.exam_req_id.toString()));
		e.setPatientId(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.patient_id.toString()));
		e.setVisitId(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.visit_id.toString()));
		e.setOrderId(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.order_id.toString()));
		e.setPriority(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.priority.toString()));
		e.setReqDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_date_time.toString())));
		e.setReqDeptName(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_dept_name.toString()));
		e.setReqDeptId(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_dept_id.toString()));
		e.setReqDoctorName(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_doctor_name.toString()));
		e.setReqDoctorId(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_doctor_id.toString()));
		e.setPurpose(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.purpose.toString()));
		e.setSyndrom(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.syndrom.toString()));
		e.setSigns(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.signs.toString()));
		e.setRelevantLabTest(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.relevant_lab_test.toString()));
		e.setRelevantDiag(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.relevant_diag.toString()));
		e.setDiagnosis(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.diagnosis.toString()));
		e.setMemo(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.memo.toString()));
		e.setTransportationMode(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.transportation_mode.toString()));
		e.setExamRequestStatus(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.exam_request_status.toString()));
		e.set_uid_value(rs.getString(CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request._uid_value.toString()));
		e.setIdPatient(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.idPatient.toString()));
		e.setIdVisit(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.idVisit.toString()));
		e.setIdOrder(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_INSTRUCTION_exam_request.idOrder.toString()));
		return e;
	}

}

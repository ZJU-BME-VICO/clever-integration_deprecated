package edu.zju.bme.clever.integration.dao.cdr;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.entity.ExamRequest;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrExamRequestRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrExamRequestDao")
@Transactional
public class CdrExamRequestDaoImpl implements CdrExamRequestDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<ExamRequest> get(String examReqId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :examReqId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.class.getSimpleName()),
				CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.exam_req_id);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("examReqId", examReqId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<ExamRequest> examRequests = jt.query(sql, source, new CdrExamRequestRowMapper());
		examRequests.forEach(l -> {
			ExamRequest k = new ExamRequest();
			k.setExamReqId(examReqId);
			CdrCache.INSTANCE.put(ExamRequest.class, k.hashCode(), l);
		});
		return examRequests;
	}

	@Override
	public int getCount(String examReqId) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :examReqId";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.class.getSimpleName()),
				CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.exam_req_id);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("examReqId", examReqId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(ExamRequest e) {
		String sql = "";
		SqlParameterSource source = new MapSqlParameterSource(this.putParameters(e));
		if (this.getCount(e.getExamReqId()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":exam_req_id, "
					+ ":patient_id, "
					+ ":visit_id, "
					+ ":order_id, "
					+ ":priority, "
					+ ":req_date_time, "
					+ ":req_dept_name, "
					+ ":req_dept_id, "
					+ ":req_doctor_name, "
					+ ":req_doctor_id, "
					+ ":purpose, "
					+ ":syndrom, "
					+ ":signs, "
					+ ":relevant_lab_test, "
					+ ":relevant_diag, "
					+ ":diagnosis, "
					+ ":memo, "
					+ ":transportation_mode, "
					+ ":exam_request_status, "
					+ ":_uid_value, "
					+ ":idPatient, "
					+ ":idVisit, "
					+ ":idOrder)";		
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.class.getSimpleName()));
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :patient_id, "
					+ "{2} = :visit_id, "
					+ "{3} = :order_id, "
					+ "{4} = :priority, "
					+ "{5} = :req_date_time, "
					+ "{6} = :req_dept_name, "
					+ "{7} = :req_dept_id, "
					+ "{8} = :req_doctor_name, "
					+ "{9} = :req_doctor_id, "
					+ "{10} = :purpose, "
					+ "{11} = :syndrom, "
					+ "{12} = :signs, "
					+ "{13} = :relevant_lab_test, "
					+ "{14} = :relevant_diag, "
					+ "{15} = :diagnosis, "
					+ "{16} = :memo, "
					+ "{17} = :transportation_mode, "
					+ "{18} = :exam_request_status, "
					+ "{19} = :_uid_value, "
					+ "{20} = :idPatient, "
					+ "{21} = :idVisit, "
					+ "{22} = :idOrder WHERE {23} = :exam_req_id";	
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.class.getSimpleName()),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.patient_id.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.visit_id.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.order_id.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.priority.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_date_time.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_dept_name.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_dept_id.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_doctor_name.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.req_doctor_id.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.purpose.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.syndrom.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.signs.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.relevant_lab_test.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.relevant_diag.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.diagnosis.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.memo.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.transportation_mode.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.exam_request_status.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request._uid_value.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.idPatient.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.idVisit.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.idOrder.toString(),
					CdrExamRequestRowMapper.openEHR_EHR_INSTRUCTION_exam_request.exam_req_id.toString());
		}
		return jt.update(sql, source);		
	}
	
	private Map<String, Object> putParameters(ExamRequest e) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("exam_req_id", e.getExamReqId());
		parameters.put("patient_id", e.getPatientId());
		parameters.put("visit_id", e.getVisitId());
		parameters.put("order_id", e.getOrderId());
		parameters.put("priority", e.getPriority());
		parameters.put("req_date_time", RowMapperUtil.getDateTimeString(e.getReqDateTime()));
		parameters.put("req_dept_name", e.getReqDeptName());
		parameters.put("req_dept_id", e.getReqDeptId());
		parameters.put("req_doctor_name", e.getReqDoctorName());
		parameters.put("req_doctor_id", e.getReqDoctorId());
		parameters.put("purpose", e.getPurpose());
		parameters.put("syndrom", e.getSyndrom());
		parameters.put("signs", e.getSigns());
		parameters.put("relevant_lab_test", e.getRelevantLabTest());
		parameters.put("relevant_diag", e.getRelevantDiag());
		parameters.put("diagnosis", e.getDiagnosis());
		parameters.put("memo", e.getMemo());
		parameters.put("transportation_mode", e.getTransportationMode());
		parameters.put("exam_request_status", e.getExamRequestStatus());
		parameters.put("_uid_value", e.get_uid_value());
		parameters.put("idPatient", e.getIdPatient());
		parameters.put("idVisit", e.getIdVisit());
		parameters.put("idOrder", e.getIdOrder());
		return parameters;
	}
	
}

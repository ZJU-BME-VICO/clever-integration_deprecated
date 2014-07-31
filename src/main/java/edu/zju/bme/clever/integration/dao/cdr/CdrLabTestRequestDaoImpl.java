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

import edu.zju.bme.clever.integration.entity.LabTestRequest;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrLabTestRequestRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrLabTestRequestDao")
@Transactional
public class CdrLabTestRequestDaoImpl implements CdrLabTestRequestDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<LabTestRequest> get(String testReqId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :testReqId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.class.getSimpleName()),
				CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.test_req_id);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("testReqId", testReqId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<LabTestRequest> labTestRequests = jt.query(sql, source, new CdrLabTestRequestRowMapper());
		labTestRequests.forEach(l -> {
			LabTestRequest k = new LabTestRequest();
			k.setTestReqId(testReqId);
			CdrCache.INSTANCE.put(LabTestRequest.class, k.hashCode(), l);
		});
		return labTestRequests;
	}

	@Override
	public int getCount(String testReqId) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :testReqId";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.class.getSimpleName()),
				CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.test_req_id);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("testReqId", testReqId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(LabTestRequest l) {
		if (this.getCount(l.getTestReqId()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":test_req_id, "
					+ ":patient_id, "
					+ ":visit_id, "
					+ ":order_id, "
					+ ":req_date_time, "
					+ ":req_dept_name, "
					+ ":req_dept_id, "
					+ ":req_doctor_name, "
					+ ":req_doctor_id, "
					+ ":lab_test_subject_code, "
					+ ":lab_test_subject_name, "
					+ ":test_cause, "
					+ ":relevant_clinic_diag, "
					+ ":sample_class_code, "
					+ ":sample_class_name, "
					+ ":test_tube_code, "
					+ ":test_tube_name, "
					+ ":lab_test_type_code, "
					+ ":lab_test_type_name, "
					+ ":execute_dept_code, "
					+ ":execute_dept_name, "
					+ ":notes_for_spcm, "
					+ ":priority_indicator, "
					+ ":lab_test_status, "
					+ ":_uid_value, "
					+ ":idPatient, "
					+ ":idVisit, "
					+ ":idOrder)";		
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.class.getSimpleName()));
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(l));
			return jt.update(sql, source);
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :patient_id, "
					+ "{2} = :visit_id, "
					+ "{3} = :order_id, "
					+ "{4} = :req_date_time, "
					+ "{5} = :req_dept_name, "
					+ "{6} = :req_dept_id, "
					+ "{7} = :req_doctor_name, "
					+ "{8} = :req_doctor_id, "
					+ "{9} = :lab_test_subject_code, "
					+ "{10} = ::lab_test_subject_name, "
					+ "{11} = ::test_cause, "
					+ "{12} = ::relevant_clinic_diag, "
					+ "{13} = ::sample_class_code, "
					+ "{14} = ::sample_class_name, "
					+ "{15} = ::test_tube_code, "
					+ "{16} = ::test_tube_name, "
					+ "{17} = ::lab_test_type_code, "
					+ "{18} = ::lab_test_type_name, "
					+ "{19} = ::execute_dept_code, "
					+ "{20} = ::execute_dept_name, "
					+ "{21} = ::notes_for_spcm, "
					+ "{22} = ::priority_indicator, "
					+ "{23} = ::lab_test_status, "
					+ "{24} = ::_uid_value, "
					+ "{25} = ::idPatient, "
					+ "{26} = ::idVisit, "
					+ "{27} = ::idOrder WHERE {28} = :test_req_id";	
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.class.getSimpleName()),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.patient_id.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.visit_id.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.order_id.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.req_date_time.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.req_dept_name.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.req_dept_id.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.req_doctor_name.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.req_doctor_id.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.lab_test_subject_code.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.lab_test_subject_name.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.test_cause.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.relevant_clinic_diag.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.sample_class_code.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.sample_class_name.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.test_tube_code.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.test_tube_name.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.lab_test_type_code.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.lab_test_type_name.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.execute_dept_code.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.execute_dept_name.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.notes_for_spcm.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.priority_indicator.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.lab_test_status.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request._uid_value.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.idPatient.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.idVisit.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.idOrder.toString(),
					CdrLabTestRequestRowMapper.openEHR_EHR_INSTRUCTION_lab_test_request.test_req_id.toString());
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(l));
			return jt.update(sql, source);			
		}
	}
	
	private Map<String, Object> putParameters(LabTestRequest l) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("test_req_id", l.getTestReqId());
		parameters.put("patient_id", l.getPatientId());
		parameters.put("visit_id", l.getVisitId());
		parameters.put("order_id", l.getOrderId());
		parameters.put("req_date_time", RowMapperUtil.getDateTimeString(l.getReqDateTime()));
		parameters.put("req_dept_name", l.getReqDeptName());
		parameters.put("req_dept_id", l.getReqDeptId());
		parameters.put("req_doctor_name", l.getReqDoctorName());
		parameters.put("req_doctor_id", l.getReqDoctorId());
		parameters.put("lab_test_subject_code", l.getLabTestSubjectCode());
		parameters.put("lab_test_subject_name", l.getLabTestSubjectName());
		parameters.put("test_cause", l.getTestCause());
		parameters.put("relevant_clinic_diag", l.getRelevantClinicDiag());
		parameters.put("sample_class_code", l.getSampleClassCode());
		parameters.put("sample_class_name", l.getSampleClassName());
		parameters.put("test_tube_code", l.getTestTubeCode());
		parameters.put("test_tube_name", l.getTestTubeName());
		parameters.put("lab_test_type_code", l.getLabTestTypeCode());
		parameters.put("lab_test_type_name", l.getLabTestTypeName());
		parameters.put("execute_dept_code", l.getExecuteDeptCode());
		parameters.put("execute_dept_name", l.getExecuteDeptName());
		parameters.put("notes_for_spcm", l.getNotesForSpcm());
		parameters.put("priority_indicator", l.getPriorityIdicator());
		parameters.put("lab_test_status", l.getLabTestStatus());
		parameters.put("_uid_value", l.get_uid_value());
		parameters.put("idPatient", l.getIdPatient());
		parameters.put("idVisit", l.getIdVisit());
		parameters.put("idOrder", l.getIdOrder());
		return parameters;
	}
	
}

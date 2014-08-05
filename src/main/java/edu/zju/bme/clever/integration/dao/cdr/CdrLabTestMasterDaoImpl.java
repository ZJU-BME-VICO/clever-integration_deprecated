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

import edu.zju.bme.clever.integration.entity.LabTestMaster;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrLabTestMasterRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrLabTestMasterDao")
@Transactional
public class CdrLabTestMasterDaoImpl implements CdrLabTestMasterDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<LabTestMaster> get(String testId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :testId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.class.getSimpleName()),
				CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.test_id);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("testId", testId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<LabTestMaster> labTestMasters = jt.query(sql, source, new CdrLabTestMasterRowMapper());
		labTestMasters.forEach(l -> {
			LabTestMaster k = new LabTestMaster();
			k.setTestId(testId);
			CdrCache.INSTANCE.put(LabTestMaster.class, k.hashCode(), l);
		});
		return labTestMasters;
	}

	@Override
	public int getCount(String testId) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :testId";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.class.getSimpleName()),
				CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.test_id);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("testId", testId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(LabTestMaster l) {
		String sql = "";
		SqlParameterSource source = new MapSqlParameterSource(this.putParameters(l));
		if (this.getCount(l.getTestId()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":test_id, "
					+ ":patient_id, "
					+ ":visit_id, "
					+ ":test_req_id, "
					+ ":his_test_id, "
					+ ":order_id, "
					+ ":test_no, "
					+ ":lab_test_subject_code, "
					+ ":lab_test_subject_name, "
					+ ":sample_class_code, "
					+ ":sample_class_name, "
					+ ":test_tube_code, "
					+ ":test_tube_name, "
					+ ":lab_test_type_code, "
					+ ":lab_test_type_name, "
					+ ":execute_dept_code, "
					+ ":execute_dept_name, "
					+ ":test_status, "
					+ ":test_time, "
					+ ":is_read, "
					+ ":is_normal, "
					+ ":serial_no, "
					+ ":_uid_value, "
					+ ":idPatient, "
					+ ":idVisit, "
					+ ":idLabTestRequest, "
					+ ":idOrder)";		
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.class.getSimpleName()));
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :patient_id, "
					+ "{2} = :visit_id, "
					+ "{3} = :test_req_id, "
					+ "{4} = :his_test_id, "
					+ "{5} = :order_id, "
					+ "{6} = :test_no, "
					+ "{7} = :lab_test_subject_code, "
					+ "{8} = :lab_test_subject_name, "
					+ "{9} = :sample_class_code, "
					+ "{10} = :sample_class_name, "
					+ "{11} = :test_tube_code, "
					+ "{12} = :test_tube_name, "
					+ "{13} = :lab_test_type_code, "
					+ "{14} = :lab_test_type_name, "
					+ "{15} = :execute_dept_code, "
					+ "{16} = :execute_dept_name, "
					+ "{17} = :test_status, "
					+ "{18} = :test_time, "
					+ "{19} = :is_read, "
					+ "{20} = :is_normal, "
					+ "{21} = :serial_no, "
					+ "{22} = :_uid_value, "
					+ "{23} = :idPatient, "
					+ "{24} = :idVisit, "
					+ "{25} = :idLabTestRequest, "
					+ "{26} = :idOrder WHERE {27} = :test_id";	
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.class.getSimpleName()),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.patient_id.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.visit_id.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.test_req_id.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.his_test_id.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.order_id.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.test_no.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.lab_test_subject_code.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.lab_test_subject_name.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.sample_class_code.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.sample_class_name.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.test_tube_code.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.test_tube_name.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.lab_test_type_code.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.lab_test_type_name.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.execute_dept_code.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.execute_dept_name.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.test_status.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.test_time.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.is_read.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.is_normal.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.serial_no.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master._uid_value.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.idPatient.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.idVisit.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.idLabTestRequest.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.idOrder.toString(),
					CdrLabTestMasterRowMapper.openEHR_EHR_INSTRUCTION_lab_test_master.test_id.toString());
		}
		return jt.update(sql, source);	
	}
	
	private Map<String, Object> putParameters(LabTestMaster l) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("test_id", l.getTestId());
		parameters.put("patient_id", l.getPatientId());
		parameters.put("visit_id", l.getVisitId());
		parameters.put("test_req_id", l.getTestReqId());
		parameters.put("his_test_id", l.getHisTestId());
		parameters.put("order_id", l.getOrderId());
		parameters.put("test_no", l.getTestNo());
		parameters.put("lab_test_subject_code", l.getLabTestSubjectCode());
		parameters.put("lab_test_subject_name", l.getLabTestSubjectName());
		parameters.put("sample_class_code", l.getSampleClassCode());
		parameters.put("sample_class_name", l.getSampleClassName());
		parameters.put("test_tube_code", l.getTestTubeCode());
		parameters.put("test_tube_name", l.getTestTubeName());
		parameters.put("lab_test_type_code", l.getLabTestTypeCode());
		parameters.put("lab_test_type_name", l.getLabTestTypeName());
		parameters.put("execute_dept_code", l.getExecuteDeptCode());
		parameters.put("execute_dept_name", l.getExecuteDeptName());
		parameters.put("test_status", l.getTestStatus());
		parameters.put("test_time", RowMapperUtil.getDateTimeString(l.getTestTime()));
		parameters.put("is_read", l.getIsRead());
		parameters.put("is_normal", l.getIsNormal());
		parameters.put("serial_no", l.getSerialNo());
		parameters.put("_uid_value", l.get_uid_value());
		parameters.put("idPatient", l.getIdPatient());
		parameters.put("idVisit", l.getIdVisit());
		parameters.put("idLabTestRequest", l.getIdLabTestRequest());
		parameters.put("idOrder", l.getIdOrder());
		return parameters;
	}
	
}

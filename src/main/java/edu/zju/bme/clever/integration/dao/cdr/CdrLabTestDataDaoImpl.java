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

import edu.zju.bme.clever.integration.entity.LabTestData;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrLabTestDataRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrLabTestDataDao")
@Transactional
public class CdrLabTestDataDaoImpl implements CdrLabTestDataDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<LabTestData> get(int testDataId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :testDataId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.class.getSimpleName()),
				CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_data_id);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("testDataId", testDataId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<LabTestData> labTestDatas = jt.query(sql, source, new CdrLabTestDataRowMapper());
		labTestDatas.forEach(l -> {
			LabTestData k = new LabTestData();
			k.setTestDataId(testDataId);
			CdrCache.INSTANCE.put(LabTestData.class, k.hashCode(), l);
		});
		return labTestDatas;
	}

	@Override
	public int getCount(int testDataId) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :testDataId";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.class.getSimpleName()),
				CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_data_id);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("testDataId", testDataId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(LabTestData l) {
		String sql = "";
		SqlParameterSource source = new MapSqlParameterSource(this.putParameters(l));
		if (this.getCount(l.getTestDataId()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":patient_id, "
					+ ":visit_id, "
					+ ":test_id, "
					+ ":test_item_no, "
					+ ":test_item_name, "
					+ ":test_item_code, "
					+ ":result, "
					+ ":units, "
					+ ":abnormal_indicator, "
					+ ":normal_reference_values, "
					+ ":instrument_id, "
					+ ":result_date_time, "
					+ ":test_data_id, "
					+ ":_uid_value, "
					+ ":idPatient, "
					+ ":idVisit, "
					+ ":idLabTestMaster)";		
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.class.getSimpleName()));
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :patient_id, "
					+ "{2} = :visit_id, "
					+ "{3} = :test_id, "
					+ "{4} = :test_item_no, "
					+ "{5} = :test_item_name, "
					+ "{6} = :test_item_code, "
					+ "{7} = :result, "
					+ "{8} = :units, "
					+ "{9} = :abnormal_indicator, "
					+ "{10} = :normal_reference_values, "
					+ "{11} = :instrument_id, "
					+ "{12} = :result_date_time, "
					+ "{13} = :_uid_value, "
					+ "{14} = :idPatient, "
					+ "{15} = :idVisit, "
					+ "{16} = :idLabTestMaster WHERE {17} = :test_data_id";	
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.class.getSimpleName()),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.patient_id.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.visit_id.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_id.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_item_no.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_item_name.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_item_code.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.result.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.units.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.abnormal_indicator.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.normal_reference_values.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.instrument_id.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.result_date_time.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_data_id.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data._uid_value.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.idPatient.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.idVisit.toString(),
					CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.idLabTestMaster.toString());
		}
		return jt.update(sql, source);		
	}
	
	private Map<String, Object> putParameters(LabTestData l) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("patient_id", l.getPatientId());
		parameters.put("visit_id", l.getVisitId());
		parameters.put("test_id", l.getTestId());
		parameters.put("test_item_no", l.getTestItemNo());
		parameters.put("test_item_name", l.getTestItemName());
		parameters.put("test_item_code", l.getTestItemCode());
		parameters.put("result", l.getResult());
		parameters.put("units", l.getUnits());
		parameters.put("abnormal_indicator", l.getAbnormalIndicator());
		parameters.put("normal_reference_values", l.getNormalReferenceValues());
		parameters.put("instrument_id", l.getInstrumentId());
		parameters.put("result_date_time", RowMapperUtil.getDateTimeString(l.getResultDateTime()));
		parameters.put("test_data_id", l.getTestDataId());
		parameters.put("_uid_value", l.get_uid_value());
		parameters.put("idPatient", l.getIdPatient());
		parameters.put("idVisit", l.getIdVisit());
		parameters.put("idLabTestMaster", l.getIdLabTestMaster());
		return parameters;
	}
	
}

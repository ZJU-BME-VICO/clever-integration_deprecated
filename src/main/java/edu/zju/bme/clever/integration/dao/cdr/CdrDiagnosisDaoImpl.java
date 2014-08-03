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

import edu.zju.bme.clever.integration.entity.Diagnosis;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrDiagnosisRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrDiagnosisDao")
@Transactional
public class CdrDiagnosisDaoImpl implements CdrDiagnosisDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<Diagnosis> get(int diagnosisId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :diagnosisId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.class.getSimpleName()),
				CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_id);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("diagnosisId", diagnosisId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<Diagnosis> visits = jt.query(sql, source, new CdrDiagnosisRowMapper());
		visits.forEach(v -> {
			Diagnosis k = new Diagnosis();
			k.setDiagnosisId(diagnosisId);
			CdrCache.INSTANCE.put(Diagnosis.class, k.hashCode(), v);
		});
		return visits;
	}

	@Override
	public int getCount(int diagnosisId) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :diagnosisId";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.class.getSimpleName()),
				CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_id);
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("diagnosisId", diagnosisId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(Diagnosis d) {
		if (this.getCount(d.getDiagnosisId()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":diagnosis_id, "
					+ ":patient_id, "
					+ ":visit_id, "
					+ ":diagnosis_class_id, "
					+ ":diagnosis_no, "
					+ ":diagnosis_item_code, "
					+ ":diagnosis_item_name, "
					+ ":admission_illness, "
					+ ":treat_days, "
					+ ":treat_result, "
					+ ":oper_treat_indicator, "
					+ ":doctor, "
					+ ":diagnosis_date_time, "
					+ ":_uid_value, "
					+ ":idPatient, "
					+ ":idVisit)";		
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.class.getSimpleName()));	
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(d));
			return jt.update(sql, source);
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :patient_id, "
					+ "{2} = :visit_id, "
					+ "{3} = :diagnosis_class_id, "
					+ "{4} = :diagnosis_no, "
					+ "{5} = :diagnosis_item_code, "
					+ "{6} = :diagnosis_item_name, "
					+ "{7} = :admission_illness, "
					+ "{8} = :treat_days, "
					+ "{9} = :treat_result, "
					+ "{10} = :oper_treat_indicator, "
					+ "{11} = :doctor, "
					+ "{12} = :diagnosis_date_time, "
					+ "{13} = :_uid_value, "
					+ "{14} = :idPatient, "
					+ "{15} = :idVisit WHERE {16} = :diagnosis_id";		
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.class.getSimpleName()),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_id.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.patient_id.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.visit_id.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_class_id.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_no.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_item_code.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_item_name.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.admission_illness.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.treat_days.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.treat_result.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.oper_treat_indicator.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.doctor.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.diagnosis_date_time.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis._uid_value.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.idPatient.toString(),
					CdrDiagnosisRowMapper.openEHR_EHR_EVALUATION_diagnosis.idVisit.toString());
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(d));
			return jt.update(sql, source);			
		}
	}
	
	private Map<String, Object> putParameters(Diagnosis d) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("diagnosis_id", d.getDiagnosisId());
		parameters.put("patient_id", d.getPatientId());
		parameters.put("visit_id", d.getVisitId());
		parameters.put("diagnosis_class_id", d.getDiagnosisClassId());
		parameters.put("diagnosis_no", d.getDiagnosisNo());
		parameters.put("diagnosis_item_code", d.getDiagnosisItemCode());
		parameters.put("diagnosis_item_name", d.getDiagnosisItemName());
		parameters.put("admission_illness", d.getAdmissionIllness());
		parameters.put("treat_days", d.getTreatDays());
		parameters.put("treat_result", d.getTreatResult());
		parameters.put("oper_treat_indicator", d.getOperTreatIndicator());
		parameters.put("doctor", d.getDoctor());
		parameters.put("diagnosis_date_time", RowMapperUtil.getDateTimeString(d.getDiagnosisDateTime()));
		parameters.put("_uid_value", d.get_uid_value());
		parameters.put("idPatient", d.getIdPatient());
		parameters.put("idVisit", d.getIdVisit());
		return parameters;
	}
	
}

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

import edu.zju.bme.clever.integration.entity.Allergy;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrAllergyRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrAllergyDao")
@Transactional
public class CdrAllergyDaoImpl implements CdrAllergyDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<Allergy> get(int allergyId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :allergyId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.class.getSimpleName()),
				CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.allergy_id);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("allergyId", allergyId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<Allergy> visits = jt.query(sql, source, new CdrAllergyRowMapper());
		visits.forEach(a -> {
			Allergy k = new Allergy();
			k.setAllergyId(allergyId);
			CdrCache.INSTANCE.put(Allergy.class, k.hashCode(), a);
		});
		return visits;
	}

	@Override
	public int getCount(int allergyId) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :allergyId";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.class.getSimpleName()),
				CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.allergy_id);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("allergyId", allergyId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(Allergy a) {
		String sql = "";
		SqlParameterSource source = new MapSqlParameterSource(this.putParameters(a));
		if (this.getCount(a.getAllergyId()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":allergy_id, "
					+ ":patient_id, "
					+ ":visit_id, "
					+ ":order_id, "
					+ ":info_source_type, "
					+ ":allergy_class_code, "
					+ ":allergy_source, "
					+ ":memo, "
					+ ":editor, "
					+ ":edit_date_time, "
					+ ":allergy_sub_class_code, "
					+ ":drug_trade_name, "
					+ ":drug_rattfy_code, "
					+ ":drug_manufacturer, "
					+ ":production_batch_no, "
					+ ":_uid_value, "
					+ ":idPatient, "
					+ ":idVisit)";		
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.class.getSimpleName()));	
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :patient_id, "
					+ "{2} = :visit_id, "
					+ "{3} = :order_id, "
					+ "{4} = :info_source_type, "
					+ "{5} = :allergy_class_code, "
					+ "{6} = :allergy_source, "
					+ "{7} = :memo, "
					+ "{8} = :editor, "
					+ "{9} = :edit_date_time, "
					+ "{10} = :allergy_sub_class_code, "
					+ "{11} = :drug_trade_name, "
					+ "{12} = :drug_rattfy_code, "
					+ "{13} = :drug_manufacturer, "
					+ "{14} = :production_batch_no, "
					+ "{15} = :_uid_value, "
					+ "{16} = :idPatient, "
					+ "{17} = :idVisit WHERE {18} = :allergy_id";		
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.class.getSimpleName()),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.patient_id.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.visit_id.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.order_id.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.info_source_type.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.allergy_class_code.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.allergy_source.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.memo.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.editor.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.edit_date_time.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.allergy_sub_class_code.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.drug_trade_name.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.drug_rattfy_code.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.drug_manufacturer.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.production_batch_no.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy._uid_value.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.idPatient.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.idVisit.toString(),
					CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.allergy_id.toString());
		}
		return jt.update(sql, source);			
	}
	
	private Map<String, Object> putParameters(Allergy a) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("allergy_id", a.getAllergyId());
		parameters.put("patient_id", a.getPatientId());
		parameters.put("visit_id", a.getVisitId());
		parameters.put("order_id", a.getOrderId());
		parameters.put("info_source_type", a.getInfoSourceType());
		parameters.put("allergy_class_code", a.getAllergyClassCode());
		parameters.put("allergy_source", a.getAllergySource());
		parameters.put("memo", a.getMemo());
		parameters.put("editor", a.getEditor());
		parameters.put("edit_date_time", RowMapperUtil.getDateTimeString(a.getEditDateTime()));
		parameters.put("allergy_sub_class_code", a.getAllergySubClassCode());
		parameters.put("drug_trade_name", a.getDrugTradeName());
		parameters.put("drug_rattfy_code", a.getDrugRatifyCode());
		parameters.put("drug_manufacturer", a.getDrugManufacturer());
		parameters.put("production_batch_no", a.getProductionBatchNo());
		parameters.put("_uid_value", a.get_uid_value());
		parameters.put("idPatient", a.getIdPatient());
		parameters.put("idVisit", a.getIdVisit());
		return parameters;
	}
	
}

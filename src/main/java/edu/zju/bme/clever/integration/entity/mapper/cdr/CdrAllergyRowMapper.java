package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Allergy;
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
		a.setEditDateTime(RowMapperUtil.getDateTime(rs.getString(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.edit_date_time.toString())));
		a.setAllergySubClassCode(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.allergy_sub_class_code.toString()));
		a.setDrugTradeName(rs.getString(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.drug_trade_name.toString()));
		a.setDrugRatifyCode(rs.getString(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.drug_rattfy_code.toString()));
		a.setDrugManufacturer(rs.getString(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.drug_manufacturer.toString()));
		a.setProductionBatchNo(rs.getString(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.production_batch_no.toString()));
		a.set_uid_value(rs.getString(CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy._uid_value.toString()));
		a.setIdPatient(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.idPatient.toString()));
		a.setIdVisit(RowMapperUtil.getInteger(rs, CdrAllergyRowMapper.openEHR_EHR_OBSERVATION_allergy.idVisit.toString()));
		return a;
	}

}

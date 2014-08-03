package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Allergy;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasAllergyRowMapper implements RowMapper<Allergy> {

	public enum ALLERGY_HISTORY {
		ALLERGY_ID,
		PATIENT_ID,
		VISIT_ID,
		ORDER_ID,
		INFO_SOURCE_TYPE,
		ALLERGY_CLASS_CODE,
		ALLERGY_SOURCE,
		MEMO,
		EDITOR,
		EDIT_DATE_TIME,
		ALLERGY_SUB_CLASS_CODE,
		DRUG_TRADE_NAME,
		DRUG_RATIFY_CODE,
		DRUG_MANUFACTURER,
		PRODUCTION_BATCH_NO,
	}

	@Override
	public Allergy mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Allergy a = new Allergy();
		a.setAllergyId(RowMapperUtil.getInteger(rs, MiasAllergyRowMapper.ALLERGY_HISTORY.ALLERGY_ID.toString()));
		a.setPatientId(rs.getString(MiasAllergyRowMapper.ALLERGY_HISTORY.PATIENT_ID.toString()));
		a.setVisitId(rs.getString(MiasAllergyRowMapper.ALLERGY_HISTORY.VISIT_ID.toString()));
		a.setOrderId(RowMapperUtil.getInteger(rs, MiasAllergyRowMapper.ALLERGY_HISTORY.ORDER_ID.toString()));
		a.setInfoSourceType(RowMapperUtil.getInteger(rs, MiasAllergyRowMapper.ALLERGY_HISTORY.INFO_SOURCE_TYPE.toString()));
		a.setAllergyClassCode(RowMapperUtil.getInteger(rs, MiasAllergyRowMapper.ALLERGY_HISTORY.ALLERGY_CLASS_CODE.toString()));
		a.setAllergySource(rs.getString(MiasAllergyRowMapper.ALLERGY_HISTORY.ALLERGY_SOURCE.toString()));
		a.setMemo(rs.getString(MiasAllergyRowMapper.ALLERGY_HISTORY.MEMO.toString()));
		a.setEditor(rs.getString(MiasAllergyRowMapper.ALLERGY_HISTORY.EDITOR.toString()));
		a.setEditDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasAllergyRowMapper.ALLERGY_HISTORY.EDIT_DATE_TIME.toString())));
		a.setAllergySubClassCode(RowMapperUtil.getInteger(rs, MiasAllergyRowMapper.ALLERGY_HISTORY.ALLERGY_SUB_CLASS_CODE.toString()));
		a.setDrugTradeName(rs.getString(MiasAllergyRowMapper.ALLERGY_HISTORY.DRUG_TRADE_NAME.toString()));
		a.setDrugRatifyCode(rs.getString(MiasAllergyRowMapper.ALLERGY_HISTORY.DRUG_RATIFY_CODE.toString()));
		a.setDrugManufacturer(rs.getString(MiasAllergyRowMapper.ALLERGY_HISTORY.DRUG_MANUFACTURER.toString()));
		a.setProductionBatchNo(rs.getString(MiasAllergyRowMapper.ALLERGY_HISTORY.PRODUCTION_BATCH_NO.toString()));
		return a;
	}

}

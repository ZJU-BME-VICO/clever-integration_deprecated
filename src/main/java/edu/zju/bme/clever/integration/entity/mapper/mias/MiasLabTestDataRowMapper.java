package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.LabTestData;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasLabTestDataRowMapper implements RowMapper<LabTestData> {

	public enum LAB_TEST_DATA {
		TEST_DATA_ID,
		PATIENT_ID,
		VISIT_ID,
		TEST_ID,
		TEST_ITEM_NO,
		TEST_ITEM_NAME,
		TEST_ITEM_CODE,
		RESULT,
		UNITS,
		ABNORMAL_INDICATOR,
		NORMAL_REFERENCE_VALUES,
		INSTRUMENT_ID,
		RESULT_DATE_TIME,
	}

	@Override
	public LabTestData mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		LabTestData l = new LabTestData();
		l.setTestDataId(RowMapperUtil.getInteger(rs, MiasLabTestDataRowMapper.LAB_TEST_DATA.TEST_DATA_ID.toString()));
		l.setPatientId(rs.getString(MiasLabTestDataRowMapper.LAB_TEST_DATA.PATIENT_ID.toString()));
		l.setVisitId(rs.getString(MiasLabTestDataRowMapper.LAB_TEST_DATA.VISIT_ID.toString()));
		l.setTestId(rs.getString(MiasLabTestDataRowMapper.LAB_TEST_DATA.TEST_ID.toString()));
		l.setTestItemNo(rs.getString(MiasLabTestDataRowMapper.LAB_TEST_DATA.TEST_ITEM_NO.toString()));
		l.setTestItemName(rs.getString(MiasLabTestDataRowMapper.LAB_TEST_DATA.TEST_ITEM_NAME.toString()));
		l.setTestItemCode(rs.getString(MiasLabTestDataRowMapper.LAB_TEST_DATA.TEST_ITEM_CODE.toString()));
		l.setResult(rs.getString(MiasLabTestDataRowMapper.LAB_TEST_DATA.RESULT.toString()));
		l.setUnits(rs.getString(MiasLabTestDataRowMapper.LAB_TEST_DATA.UNITS.toString()));
		l.setAbnormalIndicator(rs.getString(MiasLabTestDataRowMapper.LAB_TEST_DATA.ABNORMAL_INDICATOR.toString()));
		l.setNormalReferenceValues(rs.getString(MiasLabTestDataRowMapper.LAB_TEST_DATA.NORMAL_REFERENCE_VALUES.toString()));
		l.setInstrumentId(rs.getString(MiasLabTestDataRowMapper.LAB_TEST_DATA.INSTRUMENT_ID.toString()));
		l.setResultDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasLabTestDataRowMapper.LAB_TEST_DATA.RESULT_DATE_TIME.toString())));
		return l;
	}

}

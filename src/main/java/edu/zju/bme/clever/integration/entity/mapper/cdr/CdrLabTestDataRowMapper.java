package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.LabTestData;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrLabTestDataRowMapper implements RowMapper<LabTestData> {

	public enum openEHR_EHR_OBSERVATION_lab_test_data {
		_hibernarmId,
		patient_id,
		visit_id,
		test_id,
		test_item_no,
		test_item_name,
		test_item_code,
		result,
		units,
		abnormal_indicator,
		normal_reference_values,
		instrument_id,
		result_date_time,
		test_data_id,
		_uid_value,
		idPatient,
		idVisit,
		idLabTestMaster,
	}

	@Override
	public LabTestData mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		LabTestData l = new LabTestData();
		l.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data._hibernarmId.toString()));
		l.setPatientId(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.patient_id.toString()));
		l.setVisitId(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.visit_id.toString()));
		l.setTestId(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_id.toString()));
		l.setTestItemNo(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_item_no.toString()));
		l.setTestItemName(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_item_name.toString()));
		l.setTestItemCode(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_item_code.toString()));
		l.setResult(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.result.toString()));
		l.setUnits(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.units.toString()));
		l.setAbnormalIndicator(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.abnormal_indicator.toString()));
		l.setNormalReferenceValues(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.normal_reference_values.toString()));
		l.setInstrumentId(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.instrument_id.toString()));
		l.setResultDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.result_date_time.toString())));
		l.setTestDataId(RowMapperUtil.getInteger(rs, CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.test_data_id.toString()));
		l.set_uid_value(rs.getString(rs.getString(CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data._uid_value.toString())));
		l.setIdPatient(RowMapperUtil.getInteger(rs, CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.idPatient.toString()));
		l.setIdVisit(RowMapperUtil.getInteger(rs, CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.idVisit.toString()));
		l.setIdLabTestMaster(RowMapperUtil.getInteger(rs, CdrLabTestDataRowMapper.openEHR_EHR_OBSERVATION_lab_test_data.idLabTestMaster.toString()));
		return l;
	}

}

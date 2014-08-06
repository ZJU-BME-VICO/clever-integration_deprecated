package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.LabTestMaster;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrLabTestMasterRowMapper implements RowMapper<LabTestMaster> {

	public enum openEHR_EHR_OBSERVATION_lab_test_master {
		_hibernarmId,
		test_id,
		patient_id,
		visit_id,
		test_req_id,
		his_test_id,
		order_id,
		test_no,
		lab_test_subject_code,
		lab_test_subject_name,
		sample_class_code,
		sample_class_name,
		test_tube_code,
		test_tube_name,
		lab_test_type_code,
		lab_test_type_name,
		execute_dept_code,
		execute_dept_name,
		test_status,
		test_time,
		is_read,
		is_normal,
		serial_no,
		_uid_value,
	}

	@Override
	public LabTestMaster mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		LabTestMaster l = new LabTestMaster();
		l.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master._hibernarmId.toString()));
		l.setTestId(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.test_id.toString()));
		l.setPatientId(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.patient_id.toString()));
		l.setVisitId(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.visit_id.toString()));
		l.setTestReqId(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.test_req_id.toString()));
		l.setHisTestId(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.his_test_id.toString()));
		l.setOrderId(RowMapperUtil.getInteger(rs, CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.order_id.toString()));
		l.setLabTestSubjectCode(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.lab_test_subject_code.toString()));
		l.setLabTestSubjectName(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.lab_test_subject_name.toString()));
		l.setSampleClassCode(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.sample_class_code.toString()));
		l.setSampleClassName(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.sample_class_name.toString()));
		l.setTestTubeCode(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.test_tube_code.toString()));
		l.setTestTubeName(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.test_tube_name.toString()));
		l.setLabTestTypeCode(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.lab_test_type_code.toString()));
		l.setLabTestTypeName(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.lab_test_type_name.toString()));
		l.setExecuteDeptCode(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.execute_dept_code.toString()));
		l.setExecuteDeptName(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.execute_dept_name.toString()));
		l.setTestStatus(RowMapperUtil.getInteger(rs, CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.test_status.toString()));
		l.setTestTime(RowMapperUtil.getDateTime(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.test_time.toString())));
		l.setIsRead(RowMapperUtil.getInteger(rs, CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.is_read.toString()));
		l.setIsNormal(RowMapperUtil.getInteger(rs, CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.is_normal.toString()));
		l.setSerialNo(RowMapperUtil.getInteger(rs, CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master.serial_no.toString()));
		l.set_uid_value(rs.getString(CdrLabTestMasterRowMapper.openEHR_EHR_OBSERVATION_lab_test_master._uid_value.toString()));
		return l;
	}

}

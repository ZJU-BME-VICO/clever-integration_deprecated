package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.LabTestMaster;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasLabTestMasterRowMapper implements RowMapper<LabTestMaster> {

	public enum LAB_TEST_MASTER {
		SERIAL_NO,
		TEST_ID,
		PATIENT_ID,
		VISIT_ID,
		TEST_REQ_ID,
		HIS_TEST_ID,
		ORDER_ID,
		TEST_NO,
		LAB_TEST_SUBJECT_CODE,
		LAB_TEST_SUBJECT_NAME,
		SAMPLE_CLASS_CODE,
		SAMPLE_CLASS_NAME,
		TEST_TUBE_CODE,
		TEST_TUBE_NAME,
		LAB_TEST_TYPE_CODE,
		LAB_TEST_TYPE_NAME,
		EXECUTE_DEPT_CODE,
		EXECUTE_DEPT_NAME,
		TEST_STATUS,
		TEST_TIME,
		IS_READ,
		IS_NORMAL,
	}

	@Override
	public LabTestMaster mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		LabTestMaster l = new LabTestMaster();
		l.setSerialNo(RowMapperUtil.getInteger(rs, MiasLabTestMasterRowMapper.LAB_TEST_MASTER.SERIAL_NO.toString()));
		l.setTestId(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.TEST_ID.toString()));
		l.setPatientId(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.PATIENT_ID.toString()));
		l.setVisitId(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.VISIT_ID.toString()));
		l.setTestReqId(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.TEST_REQ_ID.toString()));
		l.setHisTestId(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.HIS_TEST_ID.toString()));
		l.setOrderId(RowMapperUtil.getInteger(rs, MiasLabTestMasterRowMapper.LAB_TEST_MASTER.ORDER_ID.toString()));
		l.setTestNo(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.TEST_NO.toString()));
		l.setLabTestSubjectCode(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.LAB_TEST_SUBJECT_CODE.toString()));
		l.setLabTestSubjectName(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.LAB_TEST_SUBJECT_NAME.toString()));
		l.setSampleClassCode(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.SAMPLE_CLASS_CODE.toString()));
		l.setSampleClassName(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.SAMPLE_CLASS_NAME.toString()));
		l.setTestTubeCode(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.TEST_TUBE_CODE.toString()));
		l.setTestTubeName(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.TEST_TUBE_NAME.toString()));
		l.setLabTestTypeCode(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.LAB_TEST_TYPE_CODE.toString()));
		l.setLabTestTypeName(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.LAB_TEST_TYPE_NAME.toString()));
		l.setExecuteDeptCode(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.EXECUTE_DEPT_CODE.toString()));
		l.setExecuteDeptName(rs.getString(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.EXECUTE_DEPT_NAME.toString()));
		l.setTestStatus(RowMapperUtil.getInteger(rs, MiasLabTestMasterRowMapper.LAB_TEST_MASTER.TEST_STATUS.toString()));
		l.setTestTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.TEST_TIME.toString())));
		l.setIsRead(RowMapperUtil.getInteger(rs, MiasLabTestMasterRowMapper.LAB_TEST_MASTER.IS_READ.toString()));
		l.setIsNormal(RowMapperUtil.getInteger(rs, MiasLabTestMasterRowMapper.LAB_TEST_MASTER.IS_NORMAL.toString()));
		return l;
	}

}

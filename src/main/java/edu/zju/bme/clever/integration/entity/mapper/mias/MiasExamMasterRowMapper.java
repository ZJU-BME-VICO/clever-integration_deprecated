package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.ExamMaster;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasExamMasterRowMapper implements RowMapper<ExamMaster> {

	public enum EXAM_MASTER {
		SERIAL_NO,
		EXAM_ID,
		PATIENT_ID,
		VISIT_ID,
		EXAM_REQ_ID,
		HIS_EXAM_ID,
		EXAM_DEPT_NAME,
		EXAM_DEPT_CODE,
		SCHEDULED_DATE_TIME,
		EXAM_TIME,
		EXAM_STATUS,
		IS_READ,
		IS_NORMAL,
	}

	@Override
	public ExamMaster mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		ExamMaster e = new ExamMaster();
		e.setSerialNo(RowMapperUtil.getInteger(rs, MiasExamMasterRowMapper.EXAM_MASTER.SERIAL_NO.toString()));
		e.setExamId(rs.getString(MiasExamMasterRowMapper.EXAM_MASTER.EXAM_ID.toString()));
		e.setPatientId(rs.getString(MiasExamMasterRowMapper.EXAM_MASTER.PATIENT_ID.toString()));
		e.setVisitId(rs.getString(MiasExamMasterRowMapper.EXAM_MASTER.VISIT_ID.toString()));
		e.setExamReqId(rs.getString(MiasExamMasterRowMapper.EXAM_MASTER.EXAM_REQ_ID.toString()));
		e.setHisExamId(rs.getString(MiasExamMasterRowMapper.EXAM_MASTER.HIS_EXAM_ID.toString()));
		e.setExamDeptName(rs.getString(MiasExamMasterRowMapper.EXAM_MASTER.EXAM_DEPT_NAME.toString()));
		e.setExamDeptCode(rs.getString(MiasExamMasterRowMapper.EXAM_MASTER.EXAM_DEPT_CODE.toString()));
		e.setScheduledDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasExamMasterRowMapper.EXAM_MASTER.SCHEDULED_DATE_TIME.toString())));
		e.setExamTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasExamMasterRowMapper.EXAM_MASTER.EXAM_TIME.toString())));
		e.setExamStatus(RowMapperUtil.getInteger(rs, MiasExamMasterRowMapper.EXAM_MASTER.EXAM_STATUS.toString()));
		e.setIsRead(RowMapperUtil.getInteger(rs, MiasExamMasterRowMapper.EXAM_MASTER.IS_READ.toString()));
		e.setIsNormal(RowMapperUtil.getInteger(rs, MiasExamMasterRowMapper.EXAM_MASTER.IS_NORMAL.toString()));
		return e;
	}

}

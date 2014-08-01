package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.LabTestAction;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasLabTestActionRowMapper implements RowMapper<LabTestAction> {

	public enum LAB_TEST_ACTION {
		SERIAL_NO,
		TEST_REQ_ID,
		TEST_ID,
		ACTOR_ID,
		ACTION_DATE_TIME,
		ACTION_TYPE_ID,
		ACTION_MEMO,
		ACTOR_NAME,
	}

	@Override
	public LabTestAction mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		LabTestAction l = new LabTestAction();
		l.setSerialNo(RowMapperUtil.getInteger(rs, MiasLabTestActionRowMapper.LAB_TEST_ACTION.SERIAL_NO.toString()));
		l.setTestReqId(rs.getString(MiasLabTestActionRowMapper.LAB_TEST_ACTION.TEST_REQ_ID.toString()));
		l.setTestId(rs.getString(MiasLabTestActionRowMapper.LAB_TEST_ACTION.TEST_ID.toString()));
		l.setActorId(rs.getString(MiasLabTestActionRowMapper.LAB_TEST_ACTION.ACTOR_ID.toString()));
		l.setActionDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasLabTestActionRowMapper.LAB_TEST_ACTION.ACTION_DATE_TIME.toString())));
		l.setActionTypeId(rs.getString(MiasLabTestActionRowMapper.LAB_TEST_ACTION.ACTION_TYPE_ID.toString()));
		l.setActionMemo(rs.getString(MiasLabTestActionRowMapper.LAB_TEST_ACTION.ACTION_MEMO.toString()));
		l.setActorName(rs.getString(MiasLabTestActionRowMapper.LAB_TEST_ACTION.ACTOR_NAME.toString()));
		return l;
	}

}

package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.LabTestAction;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrLabTestActionRowMapper implements RowMapper<LabTestAction> {

	public enum openEHR_EHR_ACTION_lab_test_action {
		_hibernarmId,
		test_req_id,
		test_id,
		actor_id,
		action_date_time,
		action_type_id,
		action_memo,
		actor_name,
		serial_no,
		_uid_value,
		idLabTestRequest,
	}

	@Override
	public LabTestAction mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		LabTestAction l = new LabTestAction();
		l.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action._hibernarmId.toString()));
		l.setTestReqId(rs.getString(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.test_req_id.toString()));
		l.setTestId(rs.getString(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.test_id.toString()));
		l.setActorId(rs.getString(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.actor_id.toString()));
		l.setActionDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.action_date_time.toString())));
		l.setActionTypeId(rs.getString(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.action_type_id.toString()));
		l.setActionMemo(rs.getString(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.action_memo.toString()));
		l.setActorName(rs.getString(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.actor_name.toString()));
		l.setSerialNo(RowMapperUtil.getInteger(rs, CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.serial_no.toString()));
		l.set_uid_value(rs.getString(CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action._uid_value.toString()));
		l.setIdLabTestRequest(RowMapperUtil.getInteger(rs, CdrLabTestActionRowMapper.openEHR_EHR_ACTION_lab_test_action.idLabTestRequest.toString()));
		return l;
	}

}

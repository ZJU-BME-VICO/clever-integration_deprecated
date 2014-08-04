package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Order;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasOrderRowMapper implements RowMapper<Order> {

	public enum ORDERS {
		ORDER_ID,
		PATIENT_ID,
		VISIT_ID,
		ORDER_NO,
		ORDER_SUB_NO,
		EMERGENCY_ATTR,
		MOTHER_BABY_ATTR,
		OWN_DRUG_ATTR,
		SKIN_TEST_ATTR,
		RESERVED_ORDER_ATTR,
		AFTERWARD_ORDER_ATTR,
		REPEAT_INDICATOR,
		ORDER_CLASS,
		ORDER_TEXT,
		ORDER_CODE,
		DOSAGE,
		DOSAGE_UNITS,
		ADMINISTRATION_CODE,
		ADMINISTRATION,
		START_DATE_TIME,
		STOP_DATE_TIME_PLAN,
		STOP_DATE_TIME,
		DURATION,
		DURATION_UNITS,
		FREQ_CODE,
		FREQUENCY,
		FREQ_COUNTER,
		FREQ_INTERVAL,
		FREQ_INTERVAL_UNIT,
		MEMO,
		ORDERING_DEPT_NAME,
		ORDERING_DEPT_CODE,
		START_DOCTOR_NAME,
		START_DOCTOR_CODE,
		STOP_DOCTOR_NAME,
		STOP_DOCTOR_CODE,
		PERFORM_WARD_NAME,
		PERFORM_WARD_CODE,
		START_NURSE_NAME,
		START_NURSE_CODE,
		STOP_NURSE_NAME,
		STOP_NURSE_CODE,
		START_ORDER_ENTER_DATE_TIME,
		STOP_ORDER_ENTER_DATE_TIME,
		ORDER_STATUS,
		ORDER_STATUS_MEMO,
		CDS_SEMANTICS,
		ORDER_PRINT_ATTR,
		LAST_PERFORM_DATE_TIME,
		LAST_ACCTING_DATE_TIME,
		CHECK_DATE_TIME,
	}

	@Override
	public Order mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Order o = new Order();
		o.setOrderId(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.ORDER_ID.toString()));
		o.setPatientId(rs.getString(MiasOrderRowMapper.ORDERS.PATIENT_ID.toString()));
		o.setVisitId(rs.getString(MiasOrderRowMapper.ORDERS.VISIT_ID.toString()));
		o.setOrderNo(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.ORDER_NO.toString()));
		o.setOrderSubNo(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.ORDER_SUB_NO.toString()));
		o.setEmergencyAttr(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.EMERGENCY_ATTR.toString()));
		o.setMotherBabyAttr(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.MOTHER_BABY_ATTR.toString()));
		o.setOwnDrugAttr(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.OWN_DRUG_ATTR.toString()));
		o.setSkinTestAttr(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.SKIN_TEST_ATTR.toString()));
		o.setReservedOrderAttr(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.RESERVED_ORDER_ATTR.toString()));
		o.setAfterwardOrderAttr(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.AFTERWARD_ORDER_ATTR.toString()));
		o.setRepeatIndicator(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.REPEAT_INDICATOR.toString()));
		o.setOrderClass(rs.getString(MiasOrderRowMapper.ORDERS.ORDER_CLASS.toString()));
		o.setOrderText(rs.getString(MiasOrderRowMapper.ORDERS.ORDER_TEXT.toString()));
		o.setOrderCode(rs.getString(MiasOrderRowMapper.ORDERS.ORDER_CODE.toString()));
		o.setDosage(RowMapperUtil.getFloat(rs, MiasOrderRowMapper.ORDERS.DOSAGE.toString()));
		o.setDosageUnits(rs.getString(MiasOrderRowMapper.ORDERS.DOSAGE_UNITS.toString()));
		o.setAdministrationCode(rs.getString(MiasOrderRowMapper.ORDERS.ADMINISTRATION_CODE.toString()));
		o.setAdministration(rs.getString(MiasOrderRowMapper.ORDERS.ADMINISTRATION.toString()));
		o.setStartDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasOrderRowMapper.ORDERS.START_DATE_TIME.toString())));
		o.setStopDateTimePlan(RowMapperUtil.getDateTime(rs.getTimestamp(MiasOrderRowMapper.ORDERS.STOP_DATE_TIME_PLAN.toString())));
		o.setStopDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasOrderRowMapper.ORDERS.STOP_DATE_TIME.toString())));
		o.setDuration(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.DURATION.toString()));
		o.setDurationUnits(rs.getString(MiasOrderRowMapper.ORDERS.DURATION_UNITS.toString()));
		o.setFreqCode(rs.getString(MiasOrderRowMapper.ORDERS.FREQ_CODE.toString()));
		o.setFrequency(rs.getString(MiasOrderRowMapper.ORDERS.FREQUENCY.toString()));
		o.setFreqCounter(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.FREQ_COUNTER.toString()));
		o.setFreqInterval(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.FREQ_INTERVAL.toString()));
		o.setFreqIntervalUnit(rs.getString(MiasOrderRowMapper.ORDERS.FREQ_INTERVAL_UNIT.toString()));
		o.setMemo(rs.getString(MiasOrderRowMapper.ORDERS.MEMO.toString()));
		o.setOrderingDeptName(rs.getString(MiasOrderRowMapper.ORDERS.ORDERING_DEPT_NAME.toString()));
		o.setOrderingDeptCode(rs.getString(MiasOrderRowMapper.ORDERS.ORDERING_DEPT_CODE.toString()));
		o.setStartDoctorName(rs.getString(MiasOrderRowMapper.ORDERS.START_DOCTOR_NAME.toString()));
		o.setStartDoctorCode(rs.getString(MiasOrderRowMapper.ORDERS.START_DOCTOR_CODE.toString()));
		o.setStopDoctorName(rs.getString(MiasOrderRowMapper.ORDERS.STOP_DOCTOR_NAME.toString()));
		o.setStopDoctorCode(rs.getString(MiasOrderRowMapper.ORDERS.STOP_DOCTOR_CODE.toString()));
		o.setPerformWardName(rs.getString(MiasOrderRowMapper.ORDERS.PERFORM_WARD_NAME.toString()));
		o.setPerformWardCode(rs.getString(MiasOrderRowMapper.ORDERS.PERFORM_WARD_CODE.toString()));
		o.setStartNurseName(rs.getString(MiasOrderRowMapper.ORDERS.START_NURSE_NAME.toString()));
		o.setStartNurseCode(rs.getString(MiasOrderRowMapper.ORDERS.START_NURSE_CODE.toString()));
		o.setStopNurseName(rs.getString(MiasOrderRowMapper.ORDERS.STOP_NURSE_NAME.toString()));
		o.setStopNurseCode(rs.getString(MiasOrderRowMapper.ORDERS.STOP_NURSE_CODE.toString()));
		o.setStartOrderEnterDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasOrderRowMapper.ORDERS.START_ORDER_ENTER_DATE_TIME.toString())));
		o.setStopOrderEnterDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasOrderRowMapper.ORDERS.STOP_ORDER_ENTER_DATE_TIME.toString())));
		o.setOrderStatus(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.ORDER_STATUS.toString()));
		o.setOrderStatusMemo(rs.getString(MiasOrderRowMapper.ORDERS.ORDER_STATUS_MEMO.toString()));
		o.setCdsSemantics(rs.getString(MiasOrderRowMapper.ORDERS.CDS_SEMANTICS.toString()));
		o.setOrderPrintAttr(RowMapperUtil.getInteger(rs, MiasOrderRowMapper.ORDERS.ORDER_PRINT_ATTR.toString()));
		o.setLastPerformDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasOrderRowMapper.ORDERS.LAST_PERFORM_DATE_TIME.toString())));
		o.setLastActingDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasOrderRowMapper.ORDERS.LAST_ACCTING_DATE_TIME.toString())));
		o.setCheckDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(MiasOrderRowMapper.ORDERS.CHECK_DATE_TIME.toString())));
		return o;
	}

}

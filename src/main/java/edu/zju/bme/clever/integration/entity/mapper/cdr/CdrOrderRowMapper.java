package edu.zju.bme.clever.integration.entity.mapper.cdr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Order;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class CdrOrderRowMapper implements RowMapper<Order> {

	public enum openEHR_EHR_INSTRUCTION_order {
		_hibernarmId,
		order_id,
		patient_id,
		visit_id,
		order_no,
		order_sub_no,
		emergency_attr,
		mother_baby_attr,
		own_drug_attr,
		skin_test_attr,
		reserved_order_attr,
		afterward_order_attr,
		repeat_indicator,
		order_class,
		order_text,
		order_code,
		dosage,
		dosage_units,
		administration_code,
		administration,
		start_date_time,
		stop_date_time_plan,
		stop_date_time,
		duration,
		duration_units,
		freq_code,
		frequency,
		freq_counter,
		freq_interval,
		freq_interval_unit,
		memo,
		ordering_dept_name,
		ordering_dept_code,
		start_doctor_name,
		start_doctor_code,
		stop_doctor_name,
		stop_doctor_code,
		perform_ward_name,
		perform_ward_code,
		start_nurse_name,
		start_nurse_code,
		stop_nurse_name,
		stop_nurse_code,
		start_order_enter_date_time,
		stop_order_enter_date_time,
		order_status,
		cds_semantics,
		order_print_attr,
		last_perform_date_time,
		last_accting_date_time,
		check_date_time,
		order_status_memo,
		_uid_value,
		idPatient,
		idVisit,
	}

	@Override
	public Order mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Order o = new Order();
		o.set_hibernarmId(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order._hibernarmId.toString()));
		o.setOrderId(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_id.toString()));
		o.setPatientId(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.patient_id.toString()));
		o.setVisitId(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.visit_id.toString()));
		o.setOrderNo(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_no.toString()));
		o.setOrderSubNo(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_sub_no.toString()));
		o.setEmergencyAttr(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.emergency_attr.toString()));
		o.setMotherBabyAttr(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.mother_baby_attr.toString()));
		o.setOwnDrugAttr(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.own_drug_attr.toString()));
		o.setSkinTestAttr(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.skin_test_attr.toString()));
		o.setReservedOrderAttr(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.reserved_order_attr.toString()));
		o.setAfterwardOrderAttr(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.afterward_order_attr.toString()));
		o.setRepeatIndicator(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.repeat_indicator.toString()));
		o.setOrderClass(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_class.toString()));
		o.setOrderText(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_text.toString()));
		o.setOrderCode(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_code.toString()));
		o.setDosage(RowMapperUtil.getDouble(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.dosage.toString()));
		o.setDosageUnits(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.dosage_units.toString()));
		o.setAdministrationCode(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.administration_code.toString());
		o.setAdministration(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.administration.toString()));
		o.setStartDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_date_time.toString())));
		o.setStopDateTimePlan(RowMapperUtil.getDateTime(rs.getTimestamp(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_date_time_plan.toString())));
		o.setStopDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_date_time.toString())));
		o.setDuration(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.duration.toString()));
		o.setDurationUnits(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.duration_units.toString()));
		o.setFreqCode(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.freq_code.toString()));
		o.setFrequency(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.frequency.toString()));
		o.setFreqCounter(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.freq_counter.toString()));
		o.setFreqInterval(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.freq_interval.toString()));
		o.setFreqIntervalUnit(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.freq_interval_unit.toString()));
		o.setMemo(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.memo.toString()));
		o.setOrderingDeptName(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.ordering_dept_name.toString()));
		o.setOrderingDeptCode(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.ordering_dept_code.toString()));
		o.setStartDoctorName(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_doctor_name.toString()));
		o.setStartDoctorCode(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_doctor_code.toString()));
		o.setStopDoctorName(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_doctor_name.toString()));
		o.setStopDoctorCode(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_doctor_code.toString()));
		o.setPerformWardName(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.perform_ward_name.toString()));
		o.setPerformWardCode(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.perform_ward_code.toString()));
		o.setStartNurseName(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_nurse_name.toString()));
		o.setStartNurseCode(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_nurse_code.toString()));
		o.setStartOrderEnterDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_order_enter_date_time.toString())));
		o.setStopOrderEnterDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_order_enter_date_time.toString())));
		o.setOrderStatus(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_status.toString()));
		o.setCdsSemantics(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.cds_semantics.toString()));
		o.setOrderPrintAttr(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_print_attr.toString()));
		o.setLastPerformDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.last_perform_date_time.toString())));
		o.setLastActingDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.last_accting_date_time.toString())));
		o.setCheckDateTime(RowMapperUtil.getDateTime(rs.getTimestamp(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.check_date_time.toString())));
		o.setOrderStatusMemo(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_status_memo.toString()));
		o.set_uid_value(rs.getString(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order._uid_value.toString()));
		o.setIdPatient(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.idPatient.toString()));
		o.setIdVisit(RowMapperUtil.getInteger(rs, CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.idVisit.toString()));
		return o;
	}

}

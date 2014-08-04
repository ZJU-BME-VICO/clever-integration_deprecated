package edu.zju.bme.clever.integration.dao.cdr;

import java.sql.Types;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.AbstractSqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.entity.Order;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrOrderRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

@Service("cdrOrderDao")
@Transactional
public class CdrOrderDaoImpl implements CdrOrderDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<Order> get(int orderId) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :orderId";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.class.getSimpleName()),
				CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_id);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("orderId", orderId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<Order> orders = jt.query(sql, source, new CdrOrderRowMapper());
		orders.forEach(o -> {
			Order k = new Order();
			k.setOrderId(orderId);
			CdrCache.INSTANCE.put(Order.class, k.hashCode(), o);
		});
		return orders;
	}

	@Override
	public int getCount(int orderId) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :orderId";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.class.getSimpleName()),
				CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_id);	
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("orderId", orderId);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(Order o) {
		String sql = "";
		AbstractSqlParameterSource source = new MapSqlParameterSource(this.putParameters(o));
		source.registerSqlType("dosage", Types.FLOAT);
		if (this.getCount(o.getOrderId()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":order_id, "
					+ ":patient_id, "
					+ ":visit_id, "
					+ ":order_no, "
					+ ":order_sub_no, "
					+ ":emergency_attr, "
					+ ":mother_baby_attr, "
					+ ":own_drug_attr, "
					+ ":skin_test_attr, "
					+ ":reserved_order_attr, "
					+ ":afterward_order_attr, "
					+ ":repeat_indicator, "
					+ ":order_class, "
					+ ":order_text, "
					+ ":order_code, "
					+ ":dosage, "
					+ ":dosage_units, "
					+ ":administration_code, "
					+ ":administration, "
					+ ":start_date_time, "
					+ ":stop_date_time_plan, "
					+ ":stop_date_time, "
					+ ":duration, "
					+ ":duration_units, "
					+ ":freq_code, "
					+ ":frequency, "
					+ ":freq_counter, "
					+ ":freq_interval, "
					+ ":freq_interval_unit, "
					+ ":memo, "
					+ ":ordering_dept_name, "
					+ ":ordering_dept_code, "
					+ ":start_doctor_name, "
					+ ":start_doctor_code, "
					+ ":stop_doctor_name, "
					+ ":stop_doctor_code, "
					+ ":perform_ward_name, "
					+ ":perform_ward_code, "
					+ ":start_nurse_name, "
					+ ":start_nurse_code, "
					+ ":stop_nurse_name, "
					+ ":stop_nurse_code, "
					+ ":start_order_enter_date_time, "
					+ ":stop_order_enter_date_time, "
					+ ":order_status, "
					+ ":cds_semantics, "
					+ ":order_print_attr, "
					+ ":last_perform_date_time, "
					+ ":last_accting_date_time, "
					+ ":check_date_time, "
					+ ":order_status_memo, "
					+ ":_uid_value, "
					+ ":idPatient, "
					+ ":idVisit)";		
			sql = MessageFormat.format(sqlFormat,
					DatabaseUtil.getCdrDatabaseTableName(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.class.getSimpleName()));
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :patient_id, "
					+ "{2} = :visit_id, "
					+ "{3} = :order_no, "
					+ "{4} = :order_sub_no, "
					+ "{5} = :emergency_attr, "
					+ "{6} = :mother_baby_attr, "
					+ "{7} = :own_drug_attr, "
					+ "{8} = :skin_test_attr, "
					+ "{9} = :reserved_order_attr, "
					+ "{10} = :afterward_order_attr, "
					+ "{11} = :repeat_indicator, "
					+ "{12} = :order_class, "
					+ "{13} = :order_text, "
					+ "{14} = :order_code, "
					+ "{15} = :dosage, "
					+ "{16} = :dosage_units, "
					+ "{17} = :administration_code, "
					+ "{18} = :administration, "
					+ "{19} = :start_date_time, "
					+ "{20} = :stop_date_time_plan, "
					+ "{21} = :stop_date_time, "
					+ "{22} = :duration, "
					+ "{23} = :duration_units, "
					+ "{24} = :freq_code, "
					+ "{25} = :frequency, "
					+ "{26} = :freq_counter, "
					+ "{27} = :freq_interval, "
					+ "{28} = :freq_interval_unit, "
					+ "{29} = :memo, "
					+ "{30} = :ordering_dept_name, "
					+ "{31} = :ordering_dept_code, "
					+ "{32} = :start_doctor_name, "
					+ "{33} = :start_doctor_code, "
					+ "{34} = :stop_doctor_name, "
					+ "{35} = :stop_doctor_code, "
					+ "{36} = :perform_ward_name, "
					+ "{37} = :perform_ward_code, "
					+ "{38} = :start_nurse_name, "
					+ "{39} = :start_nurse_code, "
					+ "{40} = :stop_nurse_name, "
					+ "{41} = :stop_nurse_code, "
					+ "{42} = :start_order_enter_date_time, "
					+ "{43} = :stop_order_enter_date_time, "
					+ "{44} = :order_status, "
					+ "{45} = :cds_semantics, "
					+ "{46} = :order_print_attr, "
					+ "{47} = :last_perform_date_time, "
					+ "{48} = :last_accting_date_time, "
					+ "{49} = :check_date_time, "
					+ "{50} = :order_status_memo, "
					+ "{51} = :_uid_value, "
					+ "{52} = :idPatient, "
					+ "{53} = :idVisit WHERE {54} = :order_id";	
			sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.class.getSimpleName()),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.patient_id.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.visit_id.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_no.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_sub_no.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.emergency_attr.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.mother_baby_attr.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.own_drug_attr.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.skin_test_attr.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.reserved_order_attr.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.afterward_order_attr.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.repeat_indicator.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_class.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_text.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_code.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.dosage.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.dosage_units.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.administration_code.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.administration.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_date_time.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_date_time_plan.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_date_time.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.duration.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.duration_units.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.freq_code.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.frequency.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.freq_counter.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.freq_interval.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.freq_interval_unit.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.memo.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.ordering_dept_name.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.ordering_dept_code.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_doctor_name.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_doctor_code.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_doctor_name.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_doctor_code.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.perform_ward_name.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.perform_ward_code.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_nurse_name.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_nurse_code.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_nurse_name.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_nurse_code.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.start_order_enter_date_time.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.stop_order_enter_date_time.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_status.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.cds_semantics.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_print_attr.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.last_perform_date_time.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.last_accting_date_time.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.check_date_time.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_status_memo.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order._uid_value.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.idPatient.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.idVisit.toString(),
					CdrOrderRowMapper.openEHR_EHR_INSTRUCTION_order.order_id.toString());	
		}
		return jt.update(sql, source);	
	}
	
	private Map<String, Object> putParameters(Order o) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("order_id", o.getOrderId());
		parameters.put("patient_id", o.getPatientId());
		parameters.put("visit_id", o.getVisitId());
		parameters.put("order_no", o.getOrderNo());
		parameters.put("order_sub_no", o.getOrderSubNo());
		parameters.put("emergency_attr", o.getEmergencyAttr());
		parameters.put("mother_baby_attr", o.getMotherBabyAttr());
		parameters.put("own_drug_attr", o.getOwnDrugAttr());
		parameters.put("skin_test_attr", o.getSkinTestAttr());
		parameters.put("reserved_order_attr", o.getReservedOrderAttr());
		parameters.put("afterward_order_attr", o.getAfterwardOrderAttr());
		parameters.put("repeat_indicator", o.getRepeatIndicator());
		parameters.put("order_class", o.getOrderClass());
		parameters.put("order_text", o.getOrderText());
		parameters.put("order_code", o.getOrderCode());
		parameters.put("dosage", o.getDosage());
		parameters.put("dosage_units", o.getDosageUnits());
		parameters.put("administration_code", o.getAdministrationCode());
		parameters.put("administration", o.getAdministration());
		parameters.put("start_date_time", RowMapperUtil.getDateTimeString(o.getStartDateTime()));
		parameters.put("stop_date_time_plan", RowMapperUtil.getDateTimeString(o.getStopDateTimePlan()));
		parameters.put("stop_date_time", RowMapperUtil.getDateTimeString(o.getStopDateTime()));
		parameters.put("duration", o.getDuration());
		parameters.put("duration_units", o.getDurationUnits());
		parameters.put("freq_code", o.getFreqCode());
		parameters.put("frequency", o.getFrequency());
		parameters.put("freq_counter", o.getFreqCounter());
		parameters.put("freq_interval", o.getFreqInterval());
		parameters.put("freq_interval_unit", o.getFreqIntervalUnit());
		parameters.put("memo", o.getMemo());
		parameters.put("ordering_dept_name", o.getOrderingDeptName());
		parameters.put("ordering_dept_code", o.getOrderingDeptCode());
		parameters.put("start_doctor_name", o.getStartDoctorName());
		parameters.put("start_doctor_code", o.getStartDoctorCode());
		parameters.put("stop_doctor_name", o.getStopDoctorName());
		parameters.put("stop_doctor_code", o.getStopDoctorCode());
		parameters.put("perform_ward_name", o.getPerformWardName());
		parameters.put("perform_ward_code", o.getPerformWardCode());
		parameters.put("start_nurse_name", o.getStartNurseName());
		parameters.put("start_nurse_code", o.getStartNurseCode());
		parameters.put("stop_nurse_name", o.getStopNurseName());
		parameters.put("stop_nurse_code", o.getStopNurseCode());
		parameters.put("start_order_enter_date_time", RowMapperUtil.getDateTimeString(o.getStartOrderEnterDateTime()));
		parameters.put("stop_order_enter_date_time", RowMapperUtil.getDateTimeString(o.getStopOrderEnterDateTime()));
		parameters.put("order_status", o.getOrderStatus());
		parameters.put("cds_semantics", o.getCdsSemantics());
		parameters.put("order_print_attr", o.getOrderPrintAttr());
		parameters.put("last_perform_date_time", RowMapperUtil.getDateTimeString(o.getLastPerformDateTime()));
		parameters.put("last_accting_date_time", RowMapperUtil.getDateTimeString(o.getLastActingDateTime()));
		parameters.put("check_date_time", RowMapperUtil.getDateTimeString(o.getCheckDateTime()));
		parameters.put("order_status_memo", o.getOrderStatusMemo());
		parameters.put("_uid_value", o.get_uid_value());
		parameters.put("idPatient", o.getIdPatient());
		parameters.put("idVisit", o.getIdVisit());
		return parameters;
	}
	
}

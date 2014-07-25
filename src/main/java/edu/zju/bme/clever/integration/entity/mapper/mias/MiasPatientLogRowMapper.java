package edu.zju.bme.clever.integration.entity.mapper.mias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.util.RowMapperUtil;

public class MiasPatientLogRowMapper implements RowMapper<Patient> {

	public enum MASTER_PATIENT_INDEX_MODIFYED_LOG {
		SERIAL_NO, 
		MPI_SERIAL_NO, 
	}

	@Override
	public Patient mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Patient p = new Patient();
		p.setSerialNo(RowMapperUtil.getInteger(rs, MiasPatientLogRowMapper.MASTER_PATIENT_INDEX_MODIFYED_LOG.MPI_SERIAL_NO.toString()));
		return p;
	}

}

package edu.zju.bme.clever.integration.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RowMapperUtil {

	public static LocalDateTime getDateTime(Timestamp ts) {
		if (ts == null) {
			return null;
		} else {
			return ts.toLocalDateTime();
		}
	}

	public static LocalDateTime getDateTime(String s) {
		if (s == null) {
			return null;
		} else {
			return LocalDateTime.parse(s);
		}
	}
	
	public static String getDateTimeString(LocalDateTime dt) {
		if (dt == null) {
			return null;
		} else {
			return dt.toString();
		}
	}

	public static Integer getInteger(ResultSet rs, String columnName) throws SQLException {
		if (rs == null) {
			return null;
		} else {
			Integer i = rs.getInt(columnName);
			if (rs.wasNull()) {
				i = null;
			}
			
			return i;
		}
	}

	public static Double getDouble(ResultSet rs, String columnName) throws SQLException {
		if (rs == null) {
			return null;
		} else {
			Double d = rs.getDouble(columnName);
			if (rs.wasNull()) {
				d = null;
			}
			
			return d;
		}
	}

	public static Float getFloat(ResultSet rs, String columnName) throws SQLException {
		if (rs == null) {
			return null;
		} else {
			Float f = rs.getFloat(columnName);
			if (rs.wasNull()) {
				f = null;
			}
			
			return f;
		}
	}

	public static Boolean getBoolean(ResultSet rs, String columnName) throws SQLException {
		if (rs == null) {
			return null;
		} else {
			Boolean b = rs.getBoolean(columnName);
			if (rs.wasNull()) {
				b = null;
			}
			
			return b;
		}
	}
	
}

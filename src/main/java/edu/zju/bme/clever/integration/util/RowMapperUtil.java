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
	
}

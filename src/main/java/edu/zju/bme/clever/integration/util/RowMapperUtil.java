package edu.zju.bme.clever.integration.util;

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
	
	public static String getDateTimeString(LocalDateTime dt) {
		if (dt == null) {
			return null;
		} else {
			return dt.toString();
		}
	}
	
}

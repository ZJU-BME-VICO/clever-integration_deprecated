package edu.zju.bme.clever.integration.util;

public class DatabaseUtil {
	
	public static String getInegrationDatabaseTableName(String name) {
		return "[clever-integration-iv].[dbo]." + name;
	}
	
	public static String getCdrDatabaseTableName(String name) {
		return "[clever-iv].[dbo]." + name;
	}
	
	public static String getMiasDatabaseTableName(String name) {
		return "[MIAS_DB].[dbo]." + name;
	}
	
}

package edu.zju.bme.clever.integration.util;

public class DatabaseUtil {
	
	public static String getInegrationDatabaseTableName(String name) {
		return "[clever-integration].[dbo]." + name;
	}
	
	public static String getCdrDatabaseTableName(String name) {
		return "[clever-service-orm-dev].[dbo]." + name;
	}
	
	public static String getMiasDatabaseTableName(String name) {
		return "[MIAS_DB].[dbo]." + name;
	}
	
}

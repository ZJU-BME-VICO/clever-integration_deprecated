package edu.zju.bme.clever.integration.entity;

public class IntegrationQueueLog {
	
	private int id;
	private String tableName;
	private String logicalKeyName;
	private String logicalKeyValue;
	
	public IntegrationQueueLog(int id, String tableName, String logicalKeyName,
			String logicalKeyValue) {
		super();
		this.id = id;
		this.tableName = tableName;
		this.logicalKeyName = logicalKeyName;
		this.logicalKeyValue = logicalKeyValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getLogicalKeyName() {
		return logicalKeyName;
	}

	public void setLogicalKeyName(String logicalKeyName) {
		this.logicalKeyName = logicalKeyName;
	}

	public String getLogicalKeyValue() {
		return logicalKeyValue;
	}

	public void setLogicalKeyValue(String logicalKeyValue) {
		this.logicalKeyValue = logicalKeyValue;
	}
	
}

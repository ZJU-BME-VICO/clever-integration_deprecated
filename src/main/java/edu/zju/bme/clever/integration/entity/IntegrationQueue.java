package edu.zju.bme.clever.integration.entity;

public class IntegrationQueue {
	
	private Integer id;
	private String tableName;
	private String logicalKeyName;
	private String logicalKeyValue;
	
	public IntegrationQueue() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

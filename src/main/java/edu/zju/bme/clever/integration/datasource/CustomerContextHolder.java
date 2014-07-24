package edu.zju.bme.clever.integration.datasource;

public class CustomerContextHolder {
	
	public static final String CDR_DATA_SOURCE = "cdrDataSource";      
    public static final String MIAS_DATA_SOURCE = "miasDataSource";    
    public static final String INTEGRATION_DATA_SOURCE = "integrationDataSource";
    
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
      
    public static void setCustomerType(String customerType) {  
        contextHolder.set(customerType);  
    }  
      
    public static String getCustomerType() {  
        return contextHolder.get();  
    }  
      
    public static void clearCustomerType() {  
        contextHolder.remove();  
    }  
    
}

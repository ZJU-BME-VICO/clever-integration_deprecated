package edu.zju.bme.clever.integration.util;

import org.junit.Assert;
import org.junit.Test;

import edu.zju.bme.clever.integration.entity.Patient;

public class CdrCacheTest {
	
	@Test
	public void testGet() {

		Patient v1 = new Patient();
		v1.setName("zhangsan");
		Patient k1 = new Patient();
		k1.setPatientId("patient1");
		CdrCache.INSTANCE.put(Patient.class, k1.hashCode(), v1);
		
		Patient v3 = (Patient) CdrCache.INSTANCE.get(Patient.class, k1.hashCode());
		Assert.assertEquals(v1.getName(), v3.getName());
		Assert.assertEquals(v1, v3);

		Patient k2 = new Patient();
		k2.setPatientId("patient1");	
		
		Patient v4 = (Patient) CdrCache.INSTANCE.get(Patient.class, k2.hashCode());
		Assert.assertEquals(v1.getName(), v4.getName());
		Assert.assertEquals(v1, v4);
		
	}
	
	@Test
	public void testPut() {
		
	}
	
}

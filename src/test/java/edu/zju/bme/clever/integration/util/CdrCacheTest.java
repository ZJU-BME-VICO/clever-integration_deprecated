package edu.zju.bme.clever.integration.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.zju.bme.clever.integration.entity.Patient;

public class CdrCacheTest {
	
	@Before
	public void clear() {
		CdrCache.INSTANCE.clear();
	}
	
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
	public void testCacheSize() {

		Assert.assertEquals(1000, CdrCache.INSTANCE.getCacheSize());
		
		List<Patient> values = new ArrayList<>();
		
		for (int i = 0; i < CdrCache.INSTANCE.getCacheSize(); i++) {
			Patient v = new Patient();
			v.setName("zhangsan" + i);
			Patient k = new Patient();
			k.setPatientId("patient" + i);
			CdrCache.INSTANCE.put(Patient.class, k.hashCode(), v);		
			
			values.add(v);
		}
		
		for (int i = 0; i < CdrCache.INSTANCE.getCacheSize(); i++) {
			Patient k = new Patient();
			k.setPatientId("patient" + i);
			Patient v = (Patient) CdrCache.INSTANCE.get(Patient.class, k.hashCode());	

			Assert.assertEquals(values.get(i).getName(), v.getName());
			Assert.assertEquals(values.get(i), v);
		}

		Patient v = new Patient();
		v.setName("zhangsan" + CdrCache.INSTANCE.getCacheSize());
		Patient k = new Patient();
		k.setPatientId("patient" + CdrCache.INSTANCE.getCacheSize());
		CdrCache.INSTANCE.put(Patient.class, k.hashCode(), v);

		Patient k0 = new Patient();
		k0.setPatientId("patient0");			
		Patient v0 = (Patient) CdrCache.INSTANCE.get(Patient.class, k0.hashCode());
		Assert.assertNull(v0);
		
	}
	
	@Test
	public void testPut() {
		
	}
	
}

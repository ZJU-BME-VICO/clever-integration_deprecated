package edu.zju.bme.clever.integration.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import edu.zju.bme.clever.integration.datasource.CustomerContextHolder;

@Component
@Aspect
public class DatabaseContextAspect {

	private final Logger logger = Logger.getLogger(DatabaseContextAspect.class.getName());

	@Before(value = "execution(* edu.zju.bme.clever.integration.dao..*.*(..))")
	public void before(JoinPoint jp) {
		String packageName = jp.getTarget().getClass().getPackage().getName();
		logger.info(packageName);
		if (packageName.endsWith(".mias")) {
			CustomerContextHolder.setCustomerType(CustomerContextHolder.MIAS_DATA_SOURCE);
		} else if (packageName.endsWith(".cdr")) {
			CustomerContextHolder.setCustomerType(CustomerContextHolder.CDR_DATA_SOURCE);
		} else {
			CustomerContextHolder.setCustomerType(CustomerContextHolder.INTEGRATION_DATA_SOURCE);
		}		
	}

	@After(value = "execution(* edu.zju.bme.clever.integration.dao..*.*(..))")
	public void after(JoinPoint jp) {
	}

}

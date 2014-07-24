package edu.zju.bme.clever.integration.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private final Logger logger = Logger.getLogger(LogAspect.class.getName());

	@Before(value = "execution(* edu.zju.bme.clever.integration..*.*(..))")
	public void before(JoinPoint jp) {
		String className = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		logger.info(className + "::" + methodName);
	}

	@After(value = "execution(* edu.zju.bme.clever.integration..*.*(..))")
	public void after(JoinPoint jp) {
	}

}

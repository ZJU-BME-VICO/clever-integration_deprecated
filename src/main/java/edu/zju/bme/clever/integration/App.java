package edu.zju.bme.clever.integration;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.zju.bme.clever.integration.service.IntegrationDispatcher;

/**
 * 
 * 
 */
public class App {

	private static Logger logger = Logger.getLogger(App.class.getName());
	
	private static ClassPathXmlApplicationContext context = null;
	
	private static Boolean start = true;
	private static int poolingInterval = 1000;

	public static int getPoolingInterval() {
		return poolingInterval;
	}

	public static void setPoolingInterval(int poolingInterval) {
		App.poolingInterval = poolingInterval;
	}

	public static Boolean getStart() {
		return start;
	}

	public static void setStart(Boolean start) {
		App.start = start;
	}

	public static void main(String[] args) throws InterruptedException {

		try {
			App.start();
			while (true) {
				if (App.getStart()) {
					IntegrationDispatcher integrationDispatcher = 
							(IntegrationDispatcher) App.context.getBean("integrationDispatcher");
					integrationDispatcher.dispatch();
				}

				Thread.sleep(App.getPoolingInterval());	
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	public static ClassPathXmlApplicationContext getContextInstance() {
		if (context == null) {
			start();
		}
		if (!context.isRunning()) {
			App.context.refresh();
			context.registerShutdownHook();
		}
		return context;
	}

	private static void start() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.registerShutdownHook();
	}

}

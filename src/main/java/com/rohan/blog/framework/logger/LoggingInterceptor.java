package com.rohan.blog.framework.logger;

import org.apache.commons.logging.Log;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;



@Aspect
public class LoggingInterceptor {
	
	
	private static Log log = null;
	public LoggingInterceptor(){
	}
	
	@Before(value = "")
	public void before() throws Throwable {
		log.info("Beginning method: ");
	}
	
	@After(value = "")
	public void afterReturning() throws Throwable {		
		log.info("Ending method: ");		
	}
	
	@Around(value = "")
	public void afterThrowing() 
	{ 
		log.info("Exception in method: ");	
	}

}

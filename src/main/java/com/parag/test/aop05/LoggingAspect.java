package com.parag.test.aop05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class LoggingAspect {

 	public void loggingAdvice(JoinPoint joinPoint) {
		System.out.println("Advice run. Get method called.");
	}

	@AfterReturning(pointcut = "args(..)", returning = "retBhal")
	public void afterReturningAdvice(JoinPoint jp, String retBhal) {
		System.out.println("After Returning Advice");
		// System.out.println(name);
		// System.out.println(retVal);
	}
}

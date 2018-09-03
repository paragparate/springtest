package com.parag.test.aop03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PPAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("Suniel Shetty : ");
		Object retVal = invocation.proceed();
		System.out.println("Suniel is angry!!!");
		
		return retVal;
	}

}

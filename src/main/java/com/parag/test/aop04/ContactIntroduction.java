package com.parag.test.aop04;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ContactIntroduction extends DelegatingIntroductionInterceptor {

	private static final long serialVersionUID = 1L;
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {

		System.out.println(mi.getMethod().getName());
		if (mi.getMethod().getName().startsWith("set")) {
			System.out.println("Setter called. Instance modified.");			
		}
		
		return super.invoke(mi);
	}
	
}

package com.parag.test.aop04;

import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class TestContact {
	public static void main(String[] args) {

		IntroductionAdvisor advisor = new ContactAdvisor();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(new Contact());
		pf.setOptimize(true);
		
		Contact proxy = (Contact) pf.getProxy();
//
		proxy.setFirstName("Parag");
		proxy.setLastName("Parate");
	}
}

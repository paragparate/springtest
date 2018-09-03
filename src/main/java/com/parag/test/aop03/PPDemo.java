package com.parag.test.aop03;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PPDemo {
	public static void main(String[] args) {
		Pointcut pc = new PPPointcut();
		Advice advice = new PPAdvice();
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
		
		Actor suneil = new Actor();
		Fighter shetty = new Fighter();
		
		ProxyFactory pf = new ProxyFactory();		
		pf.addAdvisor(advisor);
		pf.setTarget(suneil);
		
		Actor actor = (Actor)pf.getProxy();
		actor.act();
		
		pf = new ProxyFactory();		
		pf.addAdvisor(advisor);
		pf.setTarget(shetty);
		
		Fighter fighter = (Fighter)pf.getProxy();	
		fighter.act();
	}
}

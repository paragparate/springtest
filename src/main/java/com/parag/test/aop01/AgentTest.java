package com.parag.test.aop01;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.parag.test.aop01"})
public class AgentTest {
	public static void main(String[] args) {
		Agent target = new Agent();
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new AgentDecorator());
		pf.setTarget(target);
		
		Agent proxy = (Agent)pf.getProxy();
		target.speak();
		System.out.println();
		proxy.speak();
		System.out.println();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AgentTest.class);
		Agent agent = ctx.getBean(Agent.class);
		
		agent.speak();
		
	}
}

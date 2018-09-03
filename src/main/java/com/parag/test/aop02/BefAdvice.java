package com.parag.test.aop02;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class BefAdvice implements MethodBeforeAdvice {

	public static void main(String[] args) {
		Actor ranbir = new Actor();
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new BefAdvice());
		pf.setTarget(ranbir);
		
		System.out.println("here");
		Actor proxy = (Actor)pf.getProxy();	
		System.out.println("here2");
		proxy.act("Jo bhi main kehna chahu");
	}
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Before "+method.getName()+" After");
		method.invoke(new Actor(), "Kun faya kun kun faya");
	}

}

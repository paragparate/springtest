package com.parag.test.aop03;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class PPPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "act".equals(method.getName());
	}

	@Override
	public ClassFilter getClassFilter() {
		// TODO Auto-generated method stub
		return new ClassFilter() {

			@Override
			public boolean matches(Class<?> clazz) {
				return (clazz == Actor.class);
			}

		};
	}

}

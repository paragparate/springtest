package com.parag.test.aop04;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class ContactAdvisor extends DefaultIntroductionAdvisor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactAdvisor() {
		super(new ContactIntroduction());
	}

}

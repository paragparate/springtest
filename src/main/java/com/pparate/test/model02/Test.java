package com.pparate.test.model02;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Configuration
@ComponentScan(basePackages = { "com.pparate.test.model02" })
public class Test {

	CreditCard card;

	public CreditCard getCard() {
		return card;
	}
	@Override
	public String toString() {
		return "Test [card=" + card + "]";
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/root-context.xml");
		ctx.refresh();

		CreditCard card = (CreditCard) ctx.getBean("myCC");
		System.out.println(card);

		ctx.close();
	}

	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// System.out.println("~~ in initBinder");
	// binder.registerCustomEditor(CreditCard.class, "cardNumber", new
	// CreditCardEditor() );
	// }

	public static class CreditCardRegistrar implements PropertyEditorRegistrar {

		@Override
		public void registerCustomEditors(PropertyEditorRegistry registry) {
			registry.registerCustomEditor(CreditCard.class, new CreditCardEditor());

		}

	}
}

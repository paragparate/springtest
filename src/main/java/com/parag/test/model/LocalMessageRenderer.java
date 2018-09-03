package com.parag.test.model;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("renderer")
public class LocalMessageRenderer implements MessageRenderer {

	MessageProvider messageProvider;
	
	@Override
	public void render() throws Exception {
		if (messageProvider != null)
			System.out.println(messageProvider.getMessage());
		else
			throw (new Exception("What the fuck man! Create a provider first."));
	}
	
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
	
	@Autowired
	public void setMessageProvider(MessageProvider msgProvider) {
		this.messageProvider = msgProvider;
	}

}

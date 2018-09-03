package com.parag.test.model;

public interface MessageRenderer {
	public void render() throws Exception;
	public void setMessageProvider(MessageProvider provider);
}

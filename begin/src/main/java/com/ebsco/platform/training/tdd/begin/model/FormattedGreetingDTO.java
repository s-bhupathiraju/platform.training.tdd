package com.ebsco.platform.training.tdd.begin.model;

public class FormattedGreetingDTO {
	private String formattedGreeting;

	public FormattedGreetingDTO() {
		super();
	}

	public FormattedGreetingDTO(String formattedGreeting) {
		super();
		this.formattedGreeting = formattedGreeting;
	}

	public String getFormattedGreeting() {
		return formattedGreeting;
	}

	public void setFormattedGreeting(String formattedGreeting) {
		this.formattedGreeting = formattedGreeting;
	}
	
}

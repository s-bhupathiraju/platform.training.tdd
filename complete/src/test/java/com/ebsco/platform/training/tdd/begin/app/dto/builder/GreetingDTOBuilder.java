package com.ebsco.platform.training.tdd.begin.app.dto.builder;

import com.ebsco.platform.training.tdd.begin.app.dto.GreetingDTO;

// Test Fixture for User
public class GreetingDTOBuilder {
	private Long userid;
	private String prefix;
	private String suffix;

	public GreetingDTOBuilder() {
		super();
	}
	
	public static GreetingDTOBuilder builder() {
		return new GreetingDTOBuilder();
	}

	public GreetingDTOBuilder(Long userid, String prefix, String suffix) {
		super();
		this.userid = userid;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public GreetingDTO build() {
		GreetingDTO greetingDTO = new GreetingDTO(userid, prefix, suffix);
		return greetingDTO;
	}

	public GreetingDTOBuilder userid(Long userid) {
		this.userid = userid;
		return this;
	}

	public GreetingDTOBuilder prefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	public GreetingDTOBuilder suffix(String suffix) {
		this.suffix = suffix;
		return this;
	}

}

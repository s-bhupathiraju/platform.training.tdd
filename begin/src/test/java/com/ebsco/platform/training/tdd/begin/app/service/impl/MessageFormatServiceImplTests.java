package com.ebsco.platform.training.tdd.begin.app.service.impl;



import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MessageFormatServiceImplTests {

	@InjectMocks
	MessageFormatServiceImpl messageFormatServiceImpl;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void shouldCheckWhetherMessageFormatServiceIsNotNull() {	
		assertNotNull("Service not null",messageFormatServiceImpl);
	}
	 
}

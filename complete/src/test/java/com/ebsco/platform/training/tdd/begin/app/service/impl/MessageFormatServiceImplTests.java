package com.ebsco.platform.training.tdd.begin.app.service.impl;

import static org.mockito.Matchers.anyLong;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.Assert;

import com.ebsco.platform.training.tdd.begin.app.dto.GreetingDTO;
import com.ebsco.platform.training.tdd.begin.app.dto.builder.GreetingDTOBuilder;
import com.ebsco.platform.training.tdd.begin.app.model.builder.UserBuilder;
import com.ebsco.platform.training.tdd.begin.app.repository.UserRepository;
import com.ebsco.platform.training.tdd.begin.app.service.components.TimeLoggingComponent;

@RunWith(MockitoJUnitRunner.class)
public class MessageFormatServiceImplTests {

	@InjectMocks
	MessageFormatServiceImpl messageFormatServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	TimeLoggingComponent timeLoggingComponent;
	
	@Before
	public void setup() {
		Mockito.reset(userRepository);
		Mockito.reset(timeLoggingComponent);
	}
	
	@Test
	public void shouldCheckWhetherMessageFormatServiceIsNotNull() {	
		Assert.notNull(messageFormatServiceImpl, "Service not null");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldReturnError_WhenUserIdIsNotInRange() {
		messageFormatServiceImpl.formatGreetingMessage(MockBuilder.buildGreetingDTOWithUserId(20000L));	
	}
	
	/*
	 * Tip: using assertions inside test methods are called direct assertions.
	 * Use indirect assertions by consolidating a list of asserts in a helper method
	 * */
	@Test
	public void shouldReturnError_WhenUserIdIsInRange() {
		// Given
		MethodStubber.simpleUserRepositoryFindOneStubber(userRepository, timeLoggingComponent);
		
		// When service is called, then ...
		Assert.notNull(messageFormatServiceImpl.formatGreetingMessage(MockBuilder.buildGreetingDTOWithUserId(1L)), "not null");	
		
		// Verify
		Mockito.verify(userRepository, Mockito.times(1)).findOne(Matchers.anyLong());
		Mockito.verify(timeLoggingComponent, Mockito.times(1)).logTime();
		Mockito.inOrder(timeLoggingComponent, userRepository);
		//can pass more than one mock in the parameters
		Mockito.verifyNoMoreInteractions(userRepository, timeLoggingComponent);
	}
	
	/*
	 * Tip: Use of Hamcrest Asserts are easily readable than JUnit Asserts.
	 * Using Hamcrest library in this unit test to make assertions
	 * */
	@Test
	public void shouldReturnConcatenatedGreet_WhenPrefixIsSent() {
		// Given
		MethodStubber.simpleUserRepositoryFindOneStubberWithFirstName(userRepository, timeLoggingComponent);
		
		// When service is called, then ...
		MatcherAssert.assertThat(messageFormatServiceImpl.formatGreetingMessage(MockBuilder.buildGreetingDTOWithIdAndPrefix(1L, "Hello")).getFormattedGreeting(), IsEqual.equalTo("Hello Chris"));
		
		// Verify
		Verfier.verifyInteractions_WhenPrefixIsSent(userRepository, timeLoggingComponent);
		
	}


	/* Verify methods in Mockito..
		// Redundant. Showing an example of another way of doing this		
		Mockito.verify(userRepository, Mockito.atLeastOnce()).findOne(anyLong());
		// All Options for Verify
		// -- times(n)
		// -- atLeastOnce(n)
		// -- atLeast(n)
		// -- atMost(n)
		// -- never() // negitivity tests can use this for some mocks
	 */
	
	public static class Verfier{
		
		public static void verifyInteractions_WhenPrefixIsSent(UserRepository userRepository, TimeLoggingComponent timeLoggingComponent) {
			Mockito.verify(userRepository, Mockito.times(1)).findOne(anyLong()); // Make sure to user Matchers for all arguments explicitly..
			Mockito.verify(timeLoggingComponent, Mockito.times(1)).logTime();
			Mockito.inOrder(timeLoggingComponent, userRepository);
			//can pass more than one mock in the parameters
			Mockito.verifyNoMoreInteractions(userRepository, timeLoggingComponent);
		}

	}
	public static class MethodStubber{
		public static void simpleUserRepositoryFindOneStubber(UserRepository userRepository, TimeLoggingComponent timeLoggingComponent) {
			/*
			 * Mockito is just a framework that uses PROXY Design pattern for mocking any calls to dependencies */

			/*
			 * A very similar approach to consolidate all stubs in an inner class would make things clean
			 * */
			Mockito.when(userRepository.findOne(1L)).thenReturn(UserBuilder.builder().id(1L).build());
			Mockito.when(timeLoggingComponent.logTime()).thenReturn(1000000L);
		}
		
		public static void simpleUserRepositoryFindOneStubberWithFirstName(UserRepository userRepository,TimeLoggingComponent timeLoggingComponent) {
			/*
			 * Mockito is just a framework that uses PROXY Design pattern for mocking any calls to dependencies */

			/*
			 * A very similar approach to consolidate all stubs in an inner class would make things clean
			 * */
			Mockito.when(userRepository.findOne(1L)).thenReturn(UserBuilder.builder().id(1L).firstName("Chris").build());
			Mockito.when(timeLoggingComponent.logTime()).thenReturn(1000000L);
		}

	}
	
	static class MockBuilder{
		static GreetingDTO buildGreetingDTOWithUserId(Long userid){
			return GreetingDTOBuilder.builder().userid(userid).build();
		}
		static GreetingDTO buildGreetingDTOWithIdAndPrefix(Long userid, String prefix){
			return GreetingDTOBuilder.builder().userid(userid)
					.prefix(prefix)
					.build();
		}
		
	}
	
}

package com.practice.dp.mailingsystem.dependencyinjection.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.practice.dp.mailingsystem.dependencyinjection.consumer.Consumer;
import com.practice.dp.mailingsystem.dependencyinjection.consumer.MyDIApplication;
import com.practice.dp.mailingsystem.dependencyinjection.injector.MessageServiceInjector;
import com.practice.dp.mailingsystem.dependencyinjection.service.MessageService;

public class MyDIApplicationJUnitTest {

	private MessageServiceInjector injector;
	@Before
	public void setUp(){
		//mock the injector with anonymous class
		injector = new MessageServiceInjector() {
			
			@Override
			public Consumer getConsumer() {
				//mock the message service
				return new MyDIApplication(new MessageService() {
					
					@Override
					public void sendMessage(String msg, String rec) {
						System.out.println("Mock Message Service implementation");
						
					}
				});
			}
		};
	}
	
	@Test
	public void test() {
		Consumer consumer = injector.getConsumer();
		consumer.processMessages("Hi Pankaj", "pankaj@abc.com");
	}
	
	@After
	public void tear(){
		injector = null;
	}

}

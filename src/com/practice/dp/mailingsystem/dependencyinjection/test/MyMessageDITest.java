package com.practice.dp.mailingsystem.dependencyinjection.test;

import com.practice.dp.mailingsystem.dependencyinjection.consumer.Consumer;
import com.practice.dp.mailingsystem.dependencyinjection.injector.EmailServiceInjector;
import com.practice.dp.mailingsystem.dependencyinjection.injector.MessageServiceInjector;
import com.practice.dp.mailingsystem.dependencyinjection.injector.SMSServiceInjector;



public class MyMessageDITest {

	public static void main(String[] args) {
		String msg = "Hi Pankaj";
		String email = "pankaj@abc.com";
		String phone = "4088888888";
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
		
		//Send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}

}

package com.practice.dp.mailingsystem.dependencyinjection.injector;

import com.practice.dp.mailingsystem.dependencyinjection.consumer.Consumer;
import com.practice.dp.mailingsystem.dependencyinjection.consumer.MyDIApplication;
import com.practice.dp.mailingsystem.dependencyinjection.service.SMSServiceImpl;


public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}

}

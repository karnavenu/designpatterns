package com.practice.dp.mailingsystem.dependencyinjection.injector;

import com.practice.dp.mailingsystem.dependencyinjection.consumer.Consumer;
import com.practice.dp.mailingsystem.dependencyinjection.consumer.MyDIApplication;
import com.practice.dp.mailingsystem.dependencyinjection.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		MyDIApplication app = new MyDIApplication();
		app.setService(new EmailServiceImpl());
		return app;
	}

}

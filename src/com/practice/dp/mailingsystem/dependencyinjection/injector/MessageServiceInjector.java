package com.practice.dp.mailingsystem.dependencyinjection.injector;

import com.practice.dp.mailingsystem.dependencyinjection.consumer.Consumer;


public interface MessageServiceInjector {

	public Consumer getConsumer();
}

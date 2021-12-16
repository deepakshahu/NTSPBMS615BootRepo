package com.nit.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Order(10)
public class ATest1Runner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ATest1Runner.run()");
		System.out.println("Non-option arg names: "+args.getNonOptionArgs());
		
		System.out.println("Option arg names and values: ");
		for(String name:args.getOptionNames()) {
			System.out.println(name+"-->"+args.getOptionValues(name));
		}
	}
}
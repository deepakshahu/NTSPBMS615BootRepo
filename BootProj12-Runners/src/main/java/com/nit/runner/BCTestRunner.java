package com.nit.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-1)
public class BCTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("BCTestRunner.run()");
		System.out.println("Runners to test..."+Arrays.toString(args));
	}
}
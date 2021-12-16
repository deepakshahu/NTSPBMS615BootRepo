package com.nit.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-30)
public class CTestRunner implements CommandLineRunner, Ordered {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CTestRunner.run()");
		System.out.println("Runners to test..."+Arrays.toString(args));
	}

	@Override
	public int getOrder() {
		return 10;
	}
}
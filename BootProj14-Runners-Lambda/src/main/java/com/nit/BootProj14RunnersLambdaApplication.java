package com.nit;

import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootProj14RunnersLambdaApplication {
	
	@Bean
	public CommandLineRunner createCLRunner() {
		
		//LAMBDA Impl for functional interface
		/*CommandLineRunner clr = (String ...args)->{
			System.out.println("From CommandLineRunner :: "+Arrays.toString(args));
		};
		return clr;*/

		//LAMBDA Impl for functional interface(improvisation)
		/*CommandLineRunner clr = (String ...args)->System.out.println("From CommandLineRunner :: "+Arrays.toString(args));
		return clr;*/

		//LAMBDA Impl for functional interface(improvisation)
		/*CommandLineRunner clr = (args)->System.out.println("From CommandLineRunner :: "+Arrays.toString(args));
		return clr;*/

		//LAMBDA Impl for functional interface(improvisation)
		/*CommandLineRunner clr = args->System.out.println("From CommandLineRunner :: "+Arrays.toString(args));
		return clr;*/

		//LAMBDA Impl for functional interface with enhanced for loop
		/*CommandLineRunner clr = args->{
			System.out.println("CommandLineRunner");
			for(String arg:args) {
				System.out.println(arg);
			}
		};
		return clr;*/

		//LAMBDA Impl for functional interface + Stream api + Static method reference
		CommandLineRunner clr = args->{
			System.out.println("CommandLineRunner");
			Stream.of(args).forEach(System.out::println);
		};
		return clr;

		//LAMBDA Impl for functional interface + Stream api + Static method reference (improvisation)
		/*CommandLineRunner clr = args->	Stream.of(args).forEach(System.out::println);
		return clr;*/

		//LAMBDA Impl for functional interface + Stream api + Static method reference (improvisation)
		//return args->Stream.of(args).forEach(System.out::println);
	}
	
	@Bean
	public ApplicationRunner createAppRunner() {
		
		return aargs->{
			System.out.println("Application Runner");
			System.out.println("Non option arg values: "+aargs.getNonOptionArgs());
			System.out.println("Option arg names and values");
			Set<String> optionArgs = aargs.getOptionNames();
			optionArgs.forEach(name->{
				System.out.println(name);
				System.out.println(aargs.getOptionValues(name));
			});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(BootProj14RunnersLambdaApplication.class, args);
	}

}

package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootBatchProj03CsvToDbBatchProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBatchProj03CsvToDbBatchProcessingApplication.class, args);
	}

}

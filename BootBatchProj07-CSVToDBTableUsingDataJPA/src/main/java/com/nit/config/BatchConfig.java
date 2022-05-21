package com.nit.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nit.listener.JobMonitoringLitener;
import com.nit.model.IExamResult;
import com.nit.model.OExamResult;
import com.nit.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jbFactory;
	@Autowired
	private StepBuilderFactory sbFactory;
	@Autowired
	private JobMonitoringLitener listener;
	@Autowired
	private EntityManagerFactory emFactory;
	@Autowired
	private ExamResultItemProcessor processor;
	
	//Reader object
	@Bean
	public FlatFileItemReader<IExamResult> createReader(){
		return new FlatFileItemReaderBuilder<IExamResult>()
				.name("csv-reader")
				.resource(new ClassPathResource("TopBrains.csv"))
				.delimited().delimiter(",")
				.names("id","dob","semester","percentage")
				.targetType(IExamResult.class)
				.build();
	}
	
	//Writer object (version 1)
	/*@Bean
	public MongoItemWriter<ExamResult> createWriter(){
		//Create MongoItemWriter object
		MongoItemWriter<ExamResult> writer = new MongoItemWriter<ExamResult>();
		//Specify the collection name
		writer.setCollection("SuperBrians");
		//Specify the template
		writer.setTemplate(template);
		//return writer object
		return writer;
	}*/
	
	//Writer object (version 1)
	/*@Bean
	public JpaItemWriter<OExamResult> createWriter(){
		//Create Object
		JpaItemWriter<OExamResult> writer = new JpaItemWriter<OExamResult>();
		//Set EntityManagerFactory
		writer.setEntityManagerFactory(emFactory);
		return writer;
	}*/
	
	//Writer object (version 2)
	@Bean
	public JpaItemWriter<OExamResult> createWriter(){
		return new JpaItemWriterBuilder<OExamResult>()
				.entityManagerFactory(emFactory)
				.build();
	}
	
	//Step preparation
	@Bean(name = "step1")
	public Step createStep1() {
		return sbFactory.get("step1")
				.<IExamResult,OExamResult>chunk(5)
				.reader(createReader())
				.writer(createWriter())
				.processor(processor)
				.build();
	}
	
	//Job preparation
	@Bean(name = "job1")
	public Job createJob1() {
		return jbFactory.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(createStep1())
				.build();
	}
	
}

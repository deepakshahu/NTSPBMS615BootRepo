package com.nit.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.nit.document.ExamResult;
import com.nit.listener.JobMonitoringLitener;
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
	private MongoTemplate template;
	@Autowired
	private ExamResultItemProcessor processor;
	
	//Reader object
	@Bean
	public FlatFileItemReader<ExamResult> createReader(){
		return new FlatFileItemReaderBuilder<ExamResult>()
				.name("csv-reader")
				.resource(new ClassPathResource("TopBrains.csv"))
				.delimited().delimiter(",")
				.names("id","dob","semester","percentage")
				.targetType(ExamResult.class)
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
	@Bean
	public MongoItemWriter<ExamResult> createWriter(){
		return new MongoItemWriterBuilder<ExamResult>()
				.collection("SuperBrains")
				.template(template)
				.build();
	}
	
	//Step preparation
	@Bean(name = "step1")
	public Step createStep1() {
		return sbFactory.get("step1")
				.<ExamResult,ExamResult>chunk(5)
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

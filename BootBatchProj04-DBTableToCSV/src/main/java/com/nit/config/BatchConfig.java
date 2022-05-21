package com.nit.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.nit.listener.JobMonitoringLitener;
import com.nit.model.ExamResult;
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
	private ExamResultItemProcessor processor;
	@Autowired
	private DataSource ds;
	
	//Reader (version1)
	/*@Bean
	public JdbcCursorItemReader<ExamResult> createReader(){
		//Create Reader class object
		JdbcCursorItemReader<ExamResult> reader = new JdbcCursorItemReader<ExamResult>();
		//Specify DataSource
		reader.setDataSource(ds);
		//specify SQL query to get the records
		reader.setSql("SELECT ID,DOB,SEMESTER,PERCENTAGE FROM EXAM_RESULT");
		//specify RowMapper to convert each record of RS to model class object
		reader.setRowMapper((rs,rowNum)->{
			return new ExamResult(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getDouble(4));
		});
		return reader;
	}*/
	
	//Reader(version2)
	@Bean
	public JdbcCursorItemReader<ExamResult> createReader(){
		return new JdbcCursorItemReaderBuilder<ExamResult>()
				.name("jdbc-reader")
				.dataSource(ds).sql("SELECT ID,DOB,SEMESTER,PERCENTAGE FROM EXAM_RESULT")
				.beanRowMapper(ExamResult.class).build();
	}
	
	//Writer (version1)
	/*@Bean
	public FlatFileItemWriter<ExamResult> createWriter(){
		//Create Writer class obj
		FlatFileItemWriter<ExamResult> writer = new FlatFileItemWriter<ExamResult>();
		//Specify the location of destination file
		writer.setResource(new FileSystemResource("e:\\csvs\\TopBrains.csv"));
		//Create FieldExtractor object
		BeanWrapperFieldExtractor<ExamResult> extractor = new BeanWrapperFieldExtractor<ExamResult>();
		extractor.setNames(new String[] {"id", "dob", "semester", "percentage"});
		//Create LineAggregator that builds the having Model class object data
		DelimitedLineAggregator<ExamResult> lineAggregator = new DelimitedLineAggregator<ExamResult>();
		lineAggregator.setDelimiter(",");
		lineAggregator.setFieldExtractor(extractor);
		//Set LineAggregator to writer object
		writer.setLineAggregator(lineAggregator);
		return writer;
	}*/
	
	//Writer (version2)
	/*@Bean
	public FlatFileItemWriter<ExamResult> createWriter(){
		//Create Writer class obj
		FlatFileItemWriter<ExamResult> writer = new FlatFileItemWriter<ExamResult>();
		//Specify the location of destination file
		writer.setResource(new FileSystemResource("e:\\csvs\\TopBrains.csv"));
		//Set LineAggregator having delimeter, field Extractor
		writer.setLineAggregator(new DelimitedLineAggregator<ExamResult>() {{
			setDelimiter(",");
			setFieldExtractor(new BeanWrapperFieldExtractor<ExamResult>() {{
				setNames(new String[] {"id", "dob", "semester", "percentage"});	
			}});
		}});
		return writer;
	}*/
	
	//Writer (version3)
	@Bean
	public FlatFileItemWriter<ExamResult> createWriter(){
		return new FlatFileItemWriterBuilder<ExamResult>()
				.name("writer-csv")
				.resource(new FileSystemResource("e:\\Deepak\\Classcontent\\csvs\\TopBrains.csv"))
				.delimited().delimiter(",")
				.names("id","dob","semester","percentage")
				.build();
	}
	
	@Bean(name = "step1")
	public Step createStep1() {
		return sbFactory.get("step1")
				.<ExamResult,ExamResult>chunk(10)
				.reader(createReader())
				.writer(createWriter())
				.processor(processor)
				.build();
	}
	
	@Bean(name = "job1")
	public Job createJob1() {
		return jbFactory.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(createStep1())
				.build();
	}
	
}
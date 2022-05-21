package com.nit.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nit.listener.JobMonitoringLitener;
import com.nit.model.Employee;
import com.nit.processor.EmployeeItemProcessor;

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
	private EmployeeItemProcessor processor;
	@Autowired
	private DataSource ds;

	//Reader (version 1)
	/*public FlatFileItemReader<Employee> createReader(){
		//Create object for FlatFileItemReader
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
		//Specify the source of csv file
		reader.setResource(new ClassPathResource("EmployeesInfo.csv"));
		//Create LineReader/LineMapper object
		DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<>();
		//Create LineTokenizer object
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setNames("empno","empname","empaddrs","salary");
		//Create FieldSetMapper to map each line content to Model class object properties
		BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Employee.class);
		//Add LineTokenizer, FieldSetMapper to LineMapper
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		//Add LineMapper to FlatFileItemReader
		reader.setLineMapper(lineMapper);
		return reader;*/

	//Reader (version 2)
	/*public FlatFileItemReader<Employee> createReader(){
		//Create object for FlatFileItemReader
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
		//Specify the source of csv file
		reader.setResource(new ClassPathResource("EmployeesInfo.csv"));
		//set LineMapper
		reader.setLineMapper(new DefaultLineMapper<Employee>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(",");
				setNames("empno","empname","empaddrs","salary");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {{
				setTargetType(Employee.class);
			}});
		}});
		return reader;
	}*/
	
	//Reader (version 3)
	@Bean(name = "reader")
	public FlatFileItemReader<Employee> createReader(){
		return new FlatFileItemReaderBuilder<Employee>()
				.name("file-reader")
				.resource(new ClassPathResource("EmployeesInfo.csv"))
				.delimited().delimiter(",")
				.names("empno","empname","empaddrs","salary")
				.targetType(Employee.class)
				.build();
	}
	
	//Writer (version 1)
	/*@Bean(name = "writer")
	public JdbcBatchItemWriter<Employee> createWriter(){
		//Create JdbcBatchItemWriter object
		JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<Employee>();
		//Set DataSource
		writer.setDataSource(ds);
		//Set SQL query
		writer.setSql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno, :empname, :empaddrs, :salary, :grossSalary, :netSalary)");
		//Specify the source provider (The names of named params in sql Query must match with Model class property names)
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		return writer;
	}*/
	
	//Writer (version 2)
	@Bean(name = "writer")
	public JdbcBatchItemWriter<Employee> createWriter(){
		return new JdbcBatchItemWriterBuilder<Employee>()
				.dataSource(ds)
				.sql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno, :empname, :salary, :empaddrs, :grossSalary, :netSalary)")
				.beanMapped()
				.build();
	}
	
	//Step Preparation
	@Bean(name = "step1")
	public Step createStep1() {
		return sbFactory.get("step1")
				.<Employee,Employee>chunk(3)
				.reader(createReader())
				.writer(createWriter())
				.processor(processor)
				.build();
	}
	
	@Bean(name = "job1")
	public Job createJob1() {
		return jbFactory.get("job1")
				.listener(listener)
				.incrementer(new RunIdIncrementer())
				.start(createStep1())
				.build();
	}
	
} 

package com.nit.runner;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BatchTestRunner{
	
	@Autowired
	private JobLauncher launcher;
	@Autowired
	private Job job;

	@Scheduled(cron="0 21 16 * * *")
	public void runBatch() throws Exception {
		//Prepare Job Parameter
		JobParameters params = new JobParametersBuilder().addDate("sysDate", new Date()).toJobParameters();
		//Run the job
		JobExecution execution = launcher.run(job, params);
		System.out.println("Job Execution Status :: "+execution.getExitStatus());
	}

}

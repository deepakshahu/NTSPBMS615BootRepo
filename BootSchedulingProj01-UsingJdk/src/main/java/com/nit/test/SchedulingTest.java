package com.nit.test;

import java.util.Date;
import java.util.Timer;

import com.nit.task.Task1;

public class SchedulingTest {

	public static void main(String[] args) {
		System.out.println("Start of the App :: "+new Date());
		Timer timer = new Timer();
		//timer.schedule(new Task1(), 5000, 3000);  //Period of time execution
		//timer.schedule(new Task1(), 5000);  //Point of time execution
		timer.schedule(new Task1(), new Date((2022-1900),04,01,19,54,10));  //Point of time execution
	}

}

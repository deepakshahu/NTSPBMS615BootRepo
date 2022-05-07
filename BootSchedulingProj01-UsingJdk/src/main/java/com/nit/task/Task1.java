package com.nit.task;

import java.util.Date;
import java.util.TimerTask;

public class Task1 extends TimerTask {

	@Override
	public void run() {
		System.out.println("-------------------");
		System.out.println("From Task1 :: "+new Date());
		System.out.println("-------------------");
	}

}

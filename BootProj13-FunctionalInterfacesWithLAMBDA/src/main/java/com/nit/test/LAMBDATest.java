package com.nit.test;

import com.nit.service.Arithmetic;

public class LAMBDATest {

	public static void main(String[] args) {

		//Style 1
		/*Arithmetic ar = (int a, int b)->{
			int c = a+b;
			return c;
		};
		System.out.println("Sum :: "+ar.add(10, 20));*/

		//Style 2
		/*Arithmetic ar = (int a, int b)->{
			return a+b;
		};
		System.out.println("Sum :: "+ar.add(10, 20));*/

		//Style 3
		/*Arithmetic ar = (int a, int b)->a+b;
		System.out.println("Sum :: "+ar.add(10, 20));*/

		//Style 4
		/*Arithmetic ar = (a,b)->a+b;
		System.out.println("Sum :: "+ar.add(10, 20));*/

		//Style 5
		Arithmetic ar = (x,y)->x+y;
		System.out.println("Sum :: "+ar.add(10, 20));
	}
}
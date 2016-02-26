package com.client;

public class Fibonacci {

	public static void main(String[] args) {
		int input=12;
		for(int i=0;i<input;i++){
			System.out.println(printFibonacci(i));
		}

	}

	private static int printFibonacci(int i) {
	
		if(i==1 || i==0){
			return 1;
		}
		else {
			return printFibonacci(i-1)+printFibonacci(i-2);
		}
	}

}

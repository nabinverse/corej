package com.nabin;

import java.util.List;

public class ProcessData {

	public static void main(String[] args) throws Exception{
		
		XLReader xr= new XLReader();
		List<LoanDetails> list = xr.readXL();
		System.out.println("list retrieved: ::::");
		DatabaseActivity.updateLoanAndItem(list);
		
	}

}

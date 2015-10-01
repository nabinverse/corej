package com.service;

import java.util.ArrayList;
import java.util.List;

import com.nabin.Pen;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		PenFactory pf = new PenFactory();
		try {
			pf.produce();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pen p =pf.getFinishedProduct();
		
	}

}

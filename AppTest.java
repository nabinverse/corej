package com.nabin;

import org.junit.Assert;
import org.junit.Test;

import com.service.MyApplication;


public class AppTest {

	@Test
	public void testLengthOfTheUniqueKey() {

		MyApplication obj = new MyApplication();
		System.out.println("hiya ss test");
		Assert.assertEquals(36, obj.generateUniqueKey().length());
		System.out.println( obj.generateUniqueKey());
		System.out.println( obj.multiply(10, 13));
		
	}
}

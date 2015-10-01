package com.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.nabin.Pen;

public class PenFactory extends Factory<Pen> {

	@Override
	public void make() {
	    Pen p = Pen.getInstance();
	   Constructor<?>[] con=p.getClass().getDeclaredConstructors();
	   con[0].setAccessible(true);
	   try {
		Object pp=con[0].newInstance();
		System.out.println("hi");
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    p.setColor("White");
	    p.setInkColor("blue");
	    p.setName("Blue Pen");
		System.out.println("making pen");
		setProduct(p);
	}

}

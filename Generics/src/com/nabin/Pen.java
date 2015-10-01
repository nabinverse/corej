package com.nabin;

public class Pen extends BaseProduct {
	
	String inkColor;
	
	private static Pen p;

	public String getInkColor() {
		return inkColor;
	}

	private Pen() {
		super();
	}

	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}
	
	public static Pen getInstance(){
		
		if(p==null){
				p= new Pen();
		}
		return p;
	}
}

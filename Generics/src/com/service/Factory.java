package com.service;

import javax.lang.model.element.QualifiedNameable;

import com.nabin.BaseProduct;

public abstract class Factory<T extends BaseProduct> {
	
	T product;
	
	public void setProduct(T product){
		this.product=product;
	}
	
	public T produce() throws Exception{
		
		make();
		validate(product);
		log();
		shift(product);
		return product;
	}

	private void log() {
		// TODO Auto-generated method stub
		
	}

	private void validate(T product2) throws Exception{
		if(product2.getPrice()<0 || product2.getColor()!=null){
			//throw new Exception();
		}
		
	}

	public abstract void make();
	
	public T getFinishedProduct(){
		return product;
	}

	private void shift(T product2) {
		System.out.println("I am shifting product to warehouse : "+product2.getName());
		
	}

	private void getRawMeterials(String name) {
		if("PEN".equals(name)){
			//meterial for pen
		}
		else if("PENCIL".equals(name)){
			//meterial for pencil
		}
		
	}
}

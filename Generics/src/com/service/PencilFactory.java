package com.service;

import com.nabin.Pencil;

public class PencilFactory extends Factory<Pencil> {

	@Override
	public void make() {
		Pencil pencil = new Pencil();
		pencil.setMetalType("steel");
		pencil.setWeight(5);
		pencil.setColor("white");
		setProduct(pencil);
	}

}

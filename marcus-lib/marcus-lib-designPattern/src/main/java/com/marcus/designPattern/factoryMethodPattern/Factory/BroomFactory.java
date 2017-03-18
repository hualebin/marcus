package com.marcus.designPattern.factoryMethodPattern.Factory;

public class BroomFactory extends VehicleFactory {

	@Override
	public Moveable create() {
		return new Broom();
	}

}

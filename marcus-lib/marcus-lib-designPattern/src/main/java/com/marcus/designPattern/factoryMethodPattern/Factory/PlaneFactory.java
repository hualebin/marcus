package com.marcus.designPattern.factoryMethodPattern.Factory;

public class PlaneFactory extends VehicleFactory {

	@Override
	public Moveable create() {
		return new Plane();
	}

}

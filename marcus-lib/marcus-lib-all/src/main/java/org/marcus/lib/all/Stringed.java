package org.marcus.lib.all;

public class Stringed extends Instrument {

	@Override
	public void play(Note n) {
		System.out.println("Stringed play()" + n);
	}

	@Override
	public String what() {
		return "Stringed";
	}
	
	@Override
	public void adjust() {
		
	}

}

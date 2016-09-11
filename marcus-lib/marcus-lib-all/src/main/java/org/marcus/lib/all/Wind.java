package org.marcus.lib.all;

public class Wind extends Instrument {

	@Override
	public void play(Note n) {
		System.out.println("Wind play()" + n);
		
	}

	@Override
	public String what() {
		return "Wind";
	}
	
	@Override
	public void adjust() {
			
	}

}

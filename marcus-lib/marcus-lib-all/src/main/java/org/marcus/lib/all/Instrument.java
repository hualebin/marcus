package org.marcus.lib.all;

public abstract class Instrument {
	
	private int i;
	public abstract void play(Note n);
	
	public String what() {
		return "Wind";
	}
	
	public abstract void adjust();
}

package org.marcus.lib.all;

public class Music {
	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}
	
	public static void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
			tune(i);
		}
	}
	
	public static void main(String[] args) {
		Instrument[] orchestra = {new Wind(), new Percussion(), new Stringed()};
		
		tuneAll(orchestra);
	}
}

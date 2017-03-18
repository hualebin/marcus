package thread.partThree;

public class MainTest1 {
	public static void main(String[] args) {
		Videoconference videoconference = new Videoconference(10);
		
		Thread thread = new Thread(videoconference);
		thread.start();
		
		for (int i = 0; i < 10; i++) {
			Participant participant = new Participant(videoconference, "Participant" + i);
			Thread t = new Thread(participant);
			t.start();
		}
	}
}

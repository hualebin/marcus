package observerPattern;

import java.util.Observable;
import java.util.Observer;

public class TestSubject extends Observable {
	
	public TestSubject() {
		Observer observer = new TestObserver();
		super.addObserver(observer);
		Observer observer1 = new TestObserver1();
		super.addObserver(observer1);
		Observer observer2 = new TestObserver2();
		super.addObserver(observer2);
	}
	
	public void notify(Object obj) {
		System.out.println(super.hasChanged());
		System.out.println(super.countObservers());
		super.setChanged();
		super.notifyObservers(obj);
	}
	
}

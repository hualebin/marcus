package observerPattern;

import java.util.Observable;
import java.util.Observer;

public class TestObserver2 implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("观察者个数：" + o.countObservers());
		if (arg instanceof Test) {
			System.out.println(((Test) arg).getName());
		}	
	} 

}

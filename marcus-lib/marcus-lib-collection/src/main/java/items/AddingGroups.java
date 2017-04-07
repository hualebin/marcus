package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AddingGroups {
	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		
		Integer[] moreInts = {6, 7, 8, 9, 10};
		collection.addAll(Arrays.asList(moreInts));
		
		Collections.addAll(collection, 11, 12, 13, 14, 15);
		Collections.addAll(collection, moreInts);
		for (int i = 0; i < collection.size(); i++) {
			
			System.out.println(((List) collection).get(i));
		}
		List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);	//其底层表示的是数组，因此不能改变其尺寸，如果add()或delete()则会引发改变数组尺寸的错误
		list.add(21);
		list.set(1, 99); 
		for (int i : list) {
			System.out.println(i); 
		}
	}
}

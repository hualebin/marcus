package algorithm;

public class TestOne {
	public static void main(String[] args) {
		int i = 1;
		int j = 1;
		while(true) {
			if (j % 2 == 0 || j % 3 == 0) {
				i++;
			} 
			if (i > 2333) {
				System.out.println(j);
				break;
			}
			j++;
		}
		/*while (i <= 2333) {
			if (j % 2 == 0 || j % 3 == 0) {
				i++;
			} 
			System.out.println(j);
			j++;
		}*/
		
	}
}

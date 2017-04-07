package algorithm;

public class Test {
	
	//选择出最小的元素与循环中的初始下标交换位置
	public static Integer[] select(Integer a[]){
		int length = a.length;
		for (int i = 0; i < length; i++) {
			int index = i;
			for (int j = i + 1; j < length; j++) {
				if (a[j] < a[index]) {
	 				index = j;
				}
			}
			int tmp = a[index];
			a[index] = a[i];
			a[i] = tmp;
		}
		return a;
	}
	
	public static Integer[] insertion(Integer a[]) {
		int length = a.length;
		for (int i = 1; i < length; i++) {
			for (int j = i; j > 0 && j < length; j--) {
				if (a[j] < a[j-1]) {
					int tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
				} else {
					break;
				}
			}
		}
		return a;
	}
	
	public static char[] shell(char a[]) {
		int length = a.length;
		int h = 1;
		while (h < length / 3) {
			h = h * 3 + 1;
		}
		while(h >= 1) {
			for (int i = h; i < length; i++) {
				for (int j = i; j >=h; j-=h) {
					if (a[j] < a[j-h]) {
						char tmp = a[j-h];
						a[j-h] = a[j];
						a[j] = tmp;
					}
				}
			}
			h = h / 3;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Integer a[] = {52, 3, 98, 231, -4, 23, 72};
		//Integer b[] = select(a);
		//Integer b[] = insertion(a);
		char[] c = {'S', 'H', 'E', 'L', 'L', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'S', 'L', 'E'};
		char b[] = shell(c);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		
	}	
	
	public static char[] test(char[] a) {
		int N = a.length;
		int h = 1;
		while (h < N/3) {
			h = 3*h + 1;
		}
		
		while(h >= 1) {
			for(int i = h; i < N; i++) {
				for (int j = i; j >= h; j-=h) {
					if (a[j] < a[j-h]) {
						char tmp = a[j];
						a[j] = a[j-h];
						a[j-h] = tmp;
					}
				}
			}
			h = h/3;
		}
		return a;
	}
	
}

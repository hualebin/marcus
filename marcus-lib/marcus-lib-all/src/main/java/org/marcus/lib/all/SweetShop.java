package org.marcus.lib.all;

public class SweetShop {
	public static void main(String[] args) {
		System.out.println("inside main");
		new Candy();
		System.out.println("After creating Candy");
		try {
			Class.forName("Gum");
		} catch (ClassNotFoundException e) {
			System.out.println("Coludn't find Gum");
		}
		
		System.out.println("After Class.forName(\"Gum\")");
		
		new Cookie();
		System.out.println("After creating Cookie");
		/*System.out.println(Math.sqrt(114));
		double d = Math.sqrt(114);
		String str = String.valueOf(d);
		System.out.println(str.substring(str.indexOf(".") + 1, str.length()));
		int i1 = Integer.parseInt(str.substring(str.indexOf(".") + 1, str.length()));
		if (i1 > 0) {
			
		}
		System.out.println(str.substring(0, str.indexOf(".")));
		int i = Integer.parseInt(str.substring(0, str.indexOf(".")));
		System.out.println(i);*/
		System.out.println(findNextSquare(676));
		System.out.println(reverse("hello world"));
	}
	
	public static long findNextSquare(long sq) {
	    Double d = Math.sqrt(sq);
	    String str = String.valueOf(d);
	    String s = str.substring(str.indexOf(".") + 1, str.length());
	    if (!"0".equals(s)) {
	    	return -1;
	    }
	    long i = d.longValue() + 1;
	    return i*i; 
	}
	
    public static String reverse(String str) {
        String reverseStr = str;
        for (int i = 0; i < str.length(); i++) {
            reverseStr = new StringBuilder(reverseStr).reverse().toString();
        }
       return reverseStr;
    }
}

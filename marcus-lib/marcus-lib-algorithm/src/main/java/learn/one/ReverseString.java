package learn.one;
/**
 * 反转字符串算法研究
 * @author Administrator
 *
 */
public class ReverseString {
	//所有字符全部反转，I am a student. => .tneduts a ma I 普通实现之一
	public static String reverse(String target) {
		char[] c = target.toCharArray();
		int i = 0;
		int length = c.length;
		while(true) {
			if (i >= length) {
				break;
			}
			char tmp = c[i];
			c[i++] = c[--length];
			c[length] = tmp;
		}
		return new String(c);
	}
	
	//所有字符全部反转，I am a student. => .tneduts a ma I 递归实现之一
	public static String reverse1(String target) {
		char[] c = target.toCharArray();
		int i = 0;
		int length = c.length;
		while(true) {
			if (i >= length) {
				break;
			}
			char tmp = c[i];
			c[i++] = c[--length];
			c[length] = tmp;
		}
		return new String(c);
	}
	
	//所有单词全部反转, I am a student. => student. a am I
	public static String reverse2(String target) {
		return "";
	}
	
	public static void main(String[] args) {
		String str = "I am a student.";
		System.out.println(reverse(str));
	}

}

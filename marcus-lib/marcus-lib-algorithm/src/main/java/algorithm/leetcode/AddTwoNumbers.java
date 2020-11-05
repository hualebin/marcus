package algorithm.leetcode;


public class AddTwoNumbers {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode l3 = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p3 = l3;
		int carry = 0;
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				carry += p1.getNum();
				p1 = p1.getNext();
			}
			if (p2 != null) {
				carry += p2.getNum();
				p2 = p2.getNext();
			}
			p3.setNum(carry % 10);
			carry = carry / 10;
			if (p1 != null || p2 != null) {
				p3.setNext(new ListNode(carry));
				p3 = p3.getNext();
			}
		}
		if (carry > 0) {
			p3.setNext(new ListNode(carry));
		}
		
		return l3;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
	/*	l1.setNext(new ListNode(4));
		l1.getNext().setNext(new ListNode(3));*/

		ListNode l2 = new ListNode(9);
		l2.setNext(new ListNode(9));
/*
		l2.setNext(new ListNode(6));
		l2.getNext().setNext(new ListNode(4));
*/

		ListNode l3 = addTwoNumbers(l1, l2);

		while (l3 != null) {
			System.out.println(l3.getNum());
			l3 = l3.getNext();
		}
	}
}



class ListNode {
	private ListNode next;
	private int num;
	
	public ListNode() {
	}
	
	public ListNode(int num) {
		this.num = num;
	}
	
	public ListNode(ListNode next, int num) {
		this.next = next;
		this.num = num;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public ListNode getNext() {
		return this.next;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public boolean hasNext() {
		if (this.next == null) {
			return false;
		}
		return true;
	}
}

package algorithm.leetcode;


public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode l3 = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		while (l1.hasNext() || l2.hasNext()) {
			int carry = 0;
			if (l1.hasNext()) {
				carry += l1.getNum();
			}
		}
		
		return l3;
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

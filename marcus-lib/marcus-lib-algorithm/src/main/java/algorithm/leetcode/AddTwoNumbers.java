package algorithm.leetcode;


public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode l3 = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		while (l1.hasNext() || l2.hasNext()) {
			int carry = 0;
			if (l1.hasNext()) {
				carry += l1.val;
			}
		}
		
		return l3;
	}

}

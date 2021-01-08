package algorithm.leetcode;

/**
 * ListNode
 *
 * @author marcus
 * @date 2020-12-23
 */
public class ListNode {
	ListNode next;
	int val;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(ListNode next, int val) {
		this.next = next;
		this.val = val;
	}

	public boolean hasNext() {
		if (this.next == null) {
			return false;
		}
		return true;
	}
}

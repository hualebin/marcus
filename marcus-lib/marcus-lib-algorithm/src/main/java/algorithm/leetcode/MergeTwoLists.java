package algorithm.leetcode;

/**
 * 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author marcus
 * @date 2020-12-17
 */
public class MergeTwoLists {
	// 递归
	public ListNode solution1(ListNode l1, ListNode l2) {

		ListNode node = null;
		while (l1.hasNext() && l2.hasNext()) {
			if (l1.val > l2.val) {

			}
		}

		return node;
	}

	// 迭代
	public ListNode solution2(ListNode l1, ListNode l2) {
		ListNode node = l1.val > l2.val ? l2 : l1;
		ListNode prev = null;
		while(l1.hasNext() && l2.hasNext()) {
			if (l1.val < l2.val) {
				prev = l1;
				l1 = l1.next;
			} else if (l1.val > l2.val){
				ListNode temp = l2;
				l2 = l2.next;
				if (prev == null) {
					prev = temp;
				} else {
					temp.next = prev.next;
					prev.next = temp;
					prev = temp;
				}
			} else {
				ListNode temp = l2;
				l2 = l2.next;
				temp.next = l1.next;
				l1.next = temp;
				l1 = temp.next;
			}
		}
		return node;
	}


}

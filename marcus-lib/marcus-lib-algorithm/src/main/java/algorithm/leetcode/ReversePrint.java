package algorithm.leetcode;

/**
 * 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * @author marcus
 * @date 2020-12-22
 */
public class ReversePrint {
	public static int[] solution1(ListNode head) {
		if(head == null) {
			return new int[0];
		}
		// 先计算链表的长度
		ListNode node = head;
		int size = 0;
		while(node != null) {
			node = node.next;
			size++;
		}
		// 根据链表的长度创建长度固定的数组，然后遍历链表放入数组对应的位置
		int[] result = new int[size];
		ListNode newNode = head;
		while(newNode != null ) {
			result[--size] = newNode.val;
			newNode = newNode.next;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(3);
		node.next.next = new ListNode(2);
		int[] result = solution1(node);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}

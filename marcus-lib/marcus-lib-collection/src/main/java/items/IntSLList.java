package items;

public class IntSLList {
	
	private IntNode head, tail;
	
	public IntSLList() {
		head = tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * 从链表头部插入元素
	 * @param el
	 */
	public void addToHead(int el) {
		//当第一次向链表插入头个元素时 new IntNode(el, null) 
		head = new IntNode(el, head);
		
		//当尾部元素为空，将头部元素设为尾部元素
		if (tail == null) {
			tail = head;
		}
	}
	
	/**
	 * 从链表尾部插入元素
	 * @param el
	 */
	public void addToTail(int el) {
		if (!isEmpty()) {
			tail.next = new IntNode(el);
			tail = tail.next;
		} else {
			head = tail = new IntNode(el);
		}
	}
	
	/**
	 * 从链表头部删除一个元素
	 * @return
	 */
	public int deleteFromHead() {
		int el = head.info;
		
		//仅剩一个元素则头部尾部都设为空
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.next; //将头部下一个元素设为头部
		}
		
		return el;
	}
	
	/**
	 * 从链表尾部删除一个元素
	 * @return
	 */
	public int deleteFromTail() {
		int el = tail.info;
		 
		if (head == tail) {
			head = tail = null;
		} else {
			IntNode temp;
			for (temp = head; temp != tail;) { //单向列表删除尾部时，每次都需遍历非常不方便
				temp = temp.next;
			}
			tail = temp;
			tail.next = null;
		}
		
		return el;
	}
	
	/**
	 * 打印链表所有元素
	 */
	public void printAll() {
		for (IntNode temp = head; temp != null; temp = temp.next) {
			System.out.print(temp.info + " ");
		}
	}
	
	/**
	 * 判断元素是否在链表中
	 * @param el
	 * @return
	 */
	public boolean isInList(int el) {
		IntNode temp;
		
		for (temp = head; temp != null && temp.info != el; temp = temp.next);
		
		return temp != null;
	}
	
	/**
	 * 删除链表对应的元素
	 * @param el
	 */
	public void delete(int el) {
		if (!isEmpty()) {
			if (head == tail && el == head.info) {
				head = tail = null;
			} else if (el == head.info) {
				head = head.next;
			} else {
				IntNode pred, temp;
				
				for (pred = head, temp = head.next; temp != null && temp.info != el; pred = pred.next, temp = temp.next);
				
				if (temp != null) {
					pred.next = temp.next;
					
					if (temp == tail) {
						tail = pred;
					}
				}
			}
		}
	}

}

package items;

public class IntDLList {
	
	private IntDLLNode head, tail;
	
	public IntDLList() {
		head = tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addToHead(int el){
		if (isEmpty()) {
			tail = head = new IntDLLNode(el);
		} else {
			IntDLLNode tmp = new IntDLLNode(el, null, head);
			head.prev = tmp;
			head = tmp;
		}
	}
	
	public void addToTail(int el) {
		if (isEmpty()) {
			head = tail = new IntDLLNode(el);
		} else {
			IntDLLNode tmp = new IntDLLNode(el, tail, null);
			tail.next = tmp;
			tail = tmp;
		}
	}
	
	public int deleteFromHead() {
		int el = head.info;
		
		if (head == tail) {
			head = tail = null;
		} else {
			head.next.prev = null;
			head = head.next;
		}
		
		return el;
	}
	
	public int deleteFromTail() {
		int el = tail.info;
		
		if (tail == head) {
			tail = head = null;
		} else {
			tail.prev.next = null;
			tail = tail.prev;
		}
		
		return el;
	}

}

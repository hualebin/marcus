package items;

public class SLList {
	
	private SLLNode head = null;
	
	public SLList() {
		
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public Object first() {
		return head.info;
	}
	
	public void printAll(java.io.PrintStream out) {
		for (SLLNode tmp = head; tmp != null; tmp = tmp.next) {
			out.print(tmp.info.toString());
		}
	}
	
	public void add(Object el) {
		head = new SLLNode(el, head);
	}
	
	public Object find(Object el) {
		SLLNode tmp = null;
		
		for (tmp = head; tmp != null && !el.equals(tmp.info); tmp = tmp.next);
		
		if (tmp == null) {
			return null;
		} else {
			return tmp.info;
		}
	}
	
	public Object deleteHead() {
		Object el = head.info;
		head = head.next;
		return el;
	}
	
	public void delete(Object el) {
		if (head != null) {
			if (el.equals(head.info)) {
				head = head.next;
			} else {
				SLLNode pred = head, tmp = head.next;
				for (; tmp != null && !el.equals(tmp.info); pred = pred.next, tmp = tmp.next);
				if (tmp != null) {
					pred.next = tmp.next;
				}
				
			}
		}
	}

}

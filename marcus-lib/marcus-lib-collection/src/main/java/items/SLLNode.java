package items;

public class SLLNode {
	
	public Object info;
	public SLLNode next;
	
	public SLLNode(Object info) {
		this(info, null);
	}
	
	public SLLNode(Object info, SLLNode next) {
		this.info = info;
		this.next = next;
	}

}

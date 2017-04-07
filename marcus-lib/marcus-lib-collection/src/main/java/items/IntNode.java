package items;

/**
 * 单向链表
 * 
 * @author marcus
 *
 */
public class IntNode {
	
	public int info;
	
	public IntNode next;
	
	public IntNode(int info) {
		this(info, null);
	}
	
	public IntNode(int info, IntNode next) { 
		this.info = info;
		this.next = next;
	}

}

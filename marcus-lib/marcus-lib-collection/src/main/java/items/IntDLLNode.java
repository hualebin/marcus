package items;

/**
 * 双向列表
 * @author marcus
 *
 */
public class IntDLLNode {
	
	public int info;
	
	public IntDLLNode prev;
	
	public IntDLLNode next;
	
	public IntDLLNode(int info) {
		this(info, null, null);
	}
	
	public IntDLLNode(int info, IntDLLNode prev, IntDLLNode next) {
		this.info = info;
		this.prev = prev;
		this.next = next;
	}

}

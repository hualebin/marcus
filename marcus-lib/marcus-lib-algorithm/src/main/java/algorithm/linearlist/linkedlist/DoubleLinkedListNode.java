package algorithm.linearlist.linkedlist;

/**
 * 双向链表节点
 *
 * @author marcus
 * @date 2020-01-11
 */
public class DoubleLinkedListNode<T> {

	private DoubleLinkedListNode prev;

	private T t;

	private DoubleLinkedListNode next;

	public DoubleLinkedListNode (T t) {
		this.prev = null;
		this.t  = t;
		this.next  = null;
	}

	public DoubleLinkedListNode(DoubleLinkedListNode prev, T t, DoubleLinkedListNode next) {
		this.prev = prev;
		this.t = t;
		this.next = next;
	}

	public DoubleLinkedListNode getPrev() {
		return prev;
	}

	public void setPrev(DoubleLinkedListNode prev) {
		this.prev = prev;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public DoubleLinkedListNode getNext() {
		return next;
	}

	public void setNext(DoubleLinkedListNode next) {
		this.next = next;
	}
}

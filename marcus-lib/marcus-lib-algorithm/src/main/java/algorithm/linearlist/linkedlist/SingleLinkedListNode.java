package algorithm.linearlist.linkedlist;

/**
 * 单链表节点
 *
 * @author marcus
 * @date 2020-01-05
 */
public class SingleLinkedListNode<T> {

	private T data;

	private SingleLinkedListNode<T> next;

	public SingleLinkedListNode() {

	}

	public SingleLinkedListNode(T data, SingleLinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SingleLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(SingleLinkedListNode<T> next) {
		this.next = next;
	}
}

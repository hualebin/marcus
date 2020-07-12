package algorithm.linearlist.linkedlist;

/**
 * DoubleLinkedList
 *
 * @author marcus
 * @date 2020-01-11
 */
public class DoubleLinkedList<T> {

	private DoubleLinkedListNode<T> head;

	private DoubleLinkedListNode<T> tail;

	public DoubleLinkedList() {
		this.head = this.tail = null;
	}

	public DoubleLinkedList(T t) {
		this.head = this.tail = new DoubleLinkedListNode<T>(t);
	}

	public Boolean isEmpty() {
		return this.head == null;
	}

	public DoubleLinkedListNode insertToHead(T t) {
		if (this.head == null) {
			this.head = this.tail = new DoubleLinkedListNode<T>(t);
		} else {
			DoubleLinkedListNode node = new DoubleLinkedListNode<T>(t);
			node.setNext(this.head);
			this.head.setPrev(node);
			this.head = node;
		}
		return this.head;
	}

	public DoubleLinkedListNode insertToTail(T t) {
		if (this.head == null) {
			this.head = this.tail = new DoubleLinkedListNode<T>(t);
		} else {
			DoubleLinkedListNode node = new DoubleLinkedListNode<T>(t);
			node.setPrev(this.tail);
			this.tail.setNext(this.head);
			this.tail = node;
		}

		return this.tail;
	}

	public DoubleLinkedListNode insert(DoubleLinkedListNode node, T t) {
		DoubleLinkedListNode nextNode = new DoubleLinkedListNode<T>(t);
		nextNode.setNext(node.getNext());
		nextNode.setPrev(node);

		node.getNext().setPrev(nextNode);
		node.setNext(nextNode);

		return nextNode;
	}

	public Boolean isExist(T t) {
		if (isEmpty()) {
			return null;
		}
		for (DoubleLinkedListNode node = this.head; node != null; node = node.getNext()) {
			if (t.equals(node.getT())) {
				return true;
			}
		}
		return false;
	}

	public DoubleLinkedListNode find(T t) {
		if (isEmpty()) {
			return null;
		}

		for (DoubleLinkedListNode node = this.head; node != null; node = node.getNext()) {
			if (t.equals(node.getT())) {
				return node;
			}
		}

		return null;
	}
}

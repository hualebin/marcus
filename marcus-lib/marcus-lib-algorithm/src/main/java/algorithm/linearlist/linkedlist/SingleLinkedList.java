package algorithm.linearlist.linkedlist;

import sun.invoke.empty.Empty;

/**
 * 单链表
 *
 * @author marcus
 * @date 2020-01-05
 */
public class SingleLinkedList<T> {
	/**
	 * 头节点
	 */
	private SingleLinkedListNode<T> head;

	/**
	 * 尾节点
	 */
	private SingleLinkedListNode<T> tail;

	public SingleLinkedList() {
		this.head = this.tail = null;
	}

	public SingleLinkedList(T t) {
		SingleLinkedListNode node = new SingleLinkedListNode<T>(t, null);
		this.head = this.tail = node;
	}

	/**
	 * 判断链表是否为空
	 * 时间复杂度O(1)
	 * @return
	 */
	public Boolean isEmpty() {
		return this.head == null;
	}

	/**
	 * 从头部节点插入元素
	 * 时间复杂度O(1)
	 * @param t
	 */
	public SingleLinkedListNode insertToHead(T t) {
		SingleLinkedListNode node = new SingleLinkedListNode<T>(t, null);
		if (this.head == null) {
			this.head = this.tail = node;
		} else {
			node.setNext(this.head);
			this.head = node;
		}
		return node;
	}

	/**
	 * 从尾部节点插入元素
	 * 时间复杂度O(1)
	 * @param t 元素
	 */
	public SingleLinkedListNode insertToTail(T t) {
		SingleLinkedListNode node = new SingleLinkedListNode<T>(t, null);
		if (this.head == null) {
			this.head = this.tail = node;
		} else {
			this.tail.setNext(node);
			this.tail = node;
		}
		return node;
	}

	/**
	 * 插入某个节点后面
	 * 时间复杂度O(1)
	 * @param node 链表节点
	 * @param t 元素
	 * @return
	 */
	public SingleLinkedListNode insert(SingleLinkedListNode node, T t) {
		SingleLinkedListNode insertNode = new SingleLinkedListNode<T>(t, node.getNext());
		node.setNext(insertNode);
		if (node == this.tail) {
			this.tail = insertNode;
		}
		return insertNode;
	}

	/**
	 * 判断是否存在
	 * 最好时间复杂度O(1)
	 * 最坏时间复杂度O(n)
	 * 平均时间复杂度O(n)
	 * @param t
	 * @return
	 */
	public Boolean isExist(T t) {
		for (SingleLinkedListNode node = this.head; node != null; node = node.getNext()) {
			if (t.equals(node.getData())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 查找节点
	 * 最好时间复杂度O(1)
	 * 最坏时间复杂度O(n)
	 * 平均时间复杂度O(n)
	 * @param t
	 * @return
	 */
	public SingleLinkedListNode find(T t) {
		if (isEmpty()) {
			
		}
		for (SingleLinkedListNode node = this.head; node != null; node = node.getNext()) {
			if (t.equals(node.getData())) {
				return node;
			}
		}
		return null;
	}

	/**
	 * 删除元素对应的链表节点
	 * 最好时间复杂度O(1)
	 * 最坏时间复杂度O(n)
	 * 平均时间复杂度O(n)
	 * @param t
	 * @return
	 */
	public void remove(T t) {
		if (this.head.getData().equals(t)) {
			removeFromHead();
		} else {
			SingleLinkedListNode prev, curr = null;
			for (prev = head, curr = head.getNext(); curr != null && !curr.getData().equals(t); prev = prev.getNext(), curr = curr.getNext());
			if (curr != null) {
				prev.setNext(curr.getNext());
				if (curr == this.tail) {
					this.tail = prev;
				}
			}
		}
	}

	/**
	 * 删除链表头部节点
	 * 时间复杂度O(1)
	 */
	public void removeFromHead() {
		if (!isEmpty()) {
			if (this.head == this.tail) {
				this.head = this.tail = null;
			} else {
				this.head = this.head.getNext();
			}
		}
	}

	/**
	 * 删除链表尾部节点
	 * 最好时间复杂度O(1)
	 * 最坏时间复杂度O(n)
	 * 平均时间复杂度O(n)
	 */
	public void removeFromTail() {
		if (!isEmpty()) {
			if (this.head == this.tail) {
				this.head = this.tail = null;
			} else {
				SingleLinkedListNode tmp = null;
				for (tmp = head; tmp.getNext() != tail; tmp = tmp.getNext());
				if (tmp != null) {
					tmp.setNext(null);
					this.tail = tmp;
				}
			}
		}
	}

	/**
	 * 单链表反转
	 *
	 * 时间复杂度O(n)
	 * 空间复杂度O(n)
	 *
	 * @return
	 */
	public SingleLinkedList reverse() {
		if (isEmpty()) {
			return new SingleLinkedList();
		}
		if (this.head == this.tail) {
			return this;
		}
		SingleLinkedList list = new SingleLinkedList();
		for (SingleLinkedListNode tmp = head; tmp != null; tmp = tmp.getNext()) {
			list.insertToHead(tmp.getData());
		}
		return list;
	}

	/**
	 * 判断回文字符串
	 */


	public void print() {
		System.out.print("[");
		for (SingleLinkedListNode tmp = head; tmp != null; tmp = tmp.getNext()) {
			System.out.print(tmp.getData().toString() + (tmp != tail ? ", " : ""));
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList<Integer>();
		list.insertToHead(1);
		list.insertToHead(2);
		list.insertToHead(3);
		list.insertToHead(4);
		list.insertToHead(5);
		list.insertToHead(6);
		list.insertToHead(7);
		list.insertToHead(8);
		list.insertToHead(9);

		list.print();

		SingleLinkedList reverseList = list.reverse();

		reverseList.insertToTail(10);

		reverseList.print();

		reverseList.remove(10);

		reverseList.print();

		reverseList.removeFromHead();

		reverseList.print();

		reverseList.removeFromTail();

		reverseList.print();

		System.out.println(reverseList.isExist(8));

	}
}



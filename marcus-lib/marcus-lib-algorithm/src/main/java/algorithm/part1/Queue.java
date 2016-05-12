package algorithm.part1;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node first;	//指向最早添加的结点的链接
	private Node last;	//指向最近添加的结点的链接
	private int N;	//队列中的元素数量
	
	
	private class Node{
		//定义了结点的嵌套类
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	/**
	 * 向表尾添加元素
	 * @param item
	 */
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()){
			first = last;
		}else{
			oldlast.next = last;
		}
		N++;
	}
	
	/**
	 * 从表头删除元素
	 * @return
	 */
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if(isEmpty()){
			last = null;
		}
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

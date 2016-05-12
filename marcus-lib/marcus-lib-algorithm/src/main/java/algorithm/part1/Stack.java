package algorithm.part1;


import java.util.Iterator;

/**
 * 
 * @author Administrator
 *
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item> {
	
	private Node first;	//栈顶
	private int N;	//元素数量
	//定义结点的嵌套类
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item){
		//向栈顶添加元素
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop(){
		//从栈顶删除元素
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		s.push("nihao");
		s.push("hello");
		s.push("521");
		s.push("hi");
		System.out.println(s.pop());
	}
	

}

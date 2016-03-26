package Model;


public interface ListModel<E> extends CollectionModel<E>{
	//list存储的元素个数
	int size();
	//list是否为空
	boolean isEmpty();
	//list是否包含这个对象
	boolean contains(Object o);
	//迭代器
	IteratorModel<E> iterator();
	
	Object[] toArray();
	
	<T> T[] toArray(T[] a);
	
	boolean add(E e);
	
	boolean remove(Object o);
	
	boolean containsAll(CollectionModel<?> c);
	
	boolean addAll(CollectionModel<? extends E> c);
	
	boolean addAll(int index, CollectionModel<? extends E> c);
	
	boolean removeAll(CollectionModel<?> c);
	
	boolean retainAll(CollectionModel<?> c);
	
	void clear();
	
	boolean equals(Object o);
	
	int hashCode();
	
	E get(int index);
	
	E set(int index, E element);
	
	void add(int index, E element);
	
	E remove(int index);
	
	int indexOf(Object o);
	
	int lastIndexOf(Object o);
	
	
}

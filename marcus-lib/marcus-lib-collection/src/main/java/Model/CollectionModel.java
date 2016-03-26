package Model;

/**
 * 
 * @author Administrator
 *
 * @param <E>
 */
public interface CollectionModel<E> extends IterableModel<E>{
	
	int size();
	
	boolean isEmpty();
	
	boolean contains(Object o);
	
	IteratorModel<E> iterator();

}

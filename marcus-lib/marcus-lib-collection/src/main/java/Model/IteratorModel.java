package Model;

/**
 * 
 * @author Administrator
 *
 * @param <E>
 */
public interface IteratorModel<E> {
	
	boolean hasNext();
	
	E next();
	
	void remove();

}

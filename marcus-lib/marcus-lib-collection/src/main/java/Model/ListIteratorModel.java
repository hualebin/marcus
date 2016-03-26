package Model;

public interface ListIteratorModel<E> extends IteratorModel<E> {
	
	boolean hasNext();
	
	E next();
	
	boolean hasPrevious();
	
	E previous();
	
	int nextIndex();
}

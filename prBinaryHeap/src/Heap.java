
public interface Heap<E extends Comparable<? super E>> {
	public boolean isEmpty();
	
	public int size();
	
	public void insert(E it);
	
	public E deleteMin();
	
}


class LList <E> implements List <E>{
	
	private Link<E> head;
	private Link<E> tail;
	protected Link<E> curr;
	private int cnt;
	
	/** Constructors */
	LList (int size) {this();}
	
	LList (){
		curr = tail = head = new Link<E>(null);
		cnt=0;
	}

	@Override
	public void clear() {
		cnt=0;	
	}

	@Override
	public void insert(E it) {
		curr.setNext(new Link<E>(it, curr.next()));
		if (tail == curr)
			tail = curr.next(); // New tail
		cnt++;
		
	}

	@Override
	public void append(E it) {
		tail = tail.setNext(new Link<E>(it, null));
		cnt++;
		
	}

	@Override
	public E remove() {
		if (curr.next() == null)
			return null; // Nothing to remove
		E it = curr.next().element(); // Remember value
		if (tail == curr.next()) tail = curr; // Remove last
		curr.setNext(curr.next().next()); // Remove from list
		cnt--; // Decrement count 
		return it; // Return value 
		
	}

	@Override
	public void moveToStart() {
		curr = head;
	}

	@Override
	public void moveToEnd() {
		curr = tail;
	}

	@Override
	public void prev() {
		if (curr == head) return; // No previous element
		Link<E> aux= head; // Traverse list until previous element found
		while (aux.next() != curr) aux = aux.next();
		curr = aux;
	}

	@Override
	public void next() {
		if (curr != tail) curr = curr.next();	
	}

	@Override
	public int lenght() {
		return cnt;
	}

	@Override
	public int currPos() {
		Link<E> aux = head;
		int i =0;
		while (aux!=curr){
			aux = aux.next();
			i++;
		}
		return i;
	}

	@Override
	public void moveToPos(int pos) {
		assert (pos>=0) && (pos<=cnt): "Out of range";
		curr = head;
		for (int i=0; i<pos; i++) curr = curr.next();
	}

	@Override
	public E getValue() {
		if (curr.next()==null) return null;
		return curr.next().element();
	}
	
	public void swap_ith(int i){
		if (cnt>1 && i<cnt){
			moveToPos(i);
			Link<E> aux = curr;
			prev();
			curr.setNext(curr.next().next());
			next();
			aux.setNext(curr.next());
			curr.setNext(aux);			
		}
	}
}

/* 
 * Emil Darío Vega Gualán
 * 0706950151
 * Sixth TIC's
 */
public class AHeap<E extends Comparable<? super E>> implements Heap<E> {
	private static final int defaultSize = 10;
	private int maxSize;
	private int heapSize;
	private E[] heapArray;

	AHeap(){
		this(defaultSize);
	}

	AHeap(int size){
		maxSize = size;
		heapSize = 0;
		heapArray = (E[]) new Comparable[size];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return heapSize==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return heapSize;
	}

	@Override
	public void insert(E it) {
		heapArray[heapSize]=it;
		heapSize++;
		bubbleUp();
	}

	@Override
	public E deleteMin() {
		E root =heapArray[0];
		bubbleDown();
		return root;
	}

	protected int leftIndex(int i) {
		return 2*i+1;
	}


	protected int rightIndex(int i) {
		return 2*(i+ 1);
	}

	protected int parentIndex(int i) {
		return (i-1)/2;
	}
	
	protected void swap(int index1, int index2) {
		E tmp = heapArray[index1];
		heapArray[index1] = heapArray[index2];
		heapArray[index2] = tmp;        
	}
	
	/**
	 * Performs the "bubble up" operation to place a newly inserted element 
	 * (i.e. the element that is at the size index) in its correct place so 
	 * that the heap maintains the heap order property.
	 */
	protected void bubbleUp() {
		int pos = heapSize-1;
		while(heapArray[pos].compareTo(heapArray[parentIndex(pos)])<0 && pos>0){
			swap(pos,parentIndex(pos));
			pos=parentIndex(pos);
		}
	}
	
	/**
	 * Performs the "bubble down" operation to place the element that is at the 
	 * root of the heap in its correct place so that the heap maintains the 
	 * min-heap order property.
	 */
	protected void bubbleDown() {
		heapArray[0]=heapArray[heapSize-1];
		heapSize--;
		int i=0;
		boolean stop=false;
		while(!stop){
			if (heapArray[leftIndex(i)]!=null){
				if(heapArray[rightIndex(i)]!=null){
					if (heapArray[leftIndex(i)].compareTo(heapArray[rightIndex(i)])<0){
						if(heapArray[i].compareTo(heapArray[leftIndex(i)])>0){
							swap(i,leftIndex(i));
							i=leftIndex(i);
						}else{
							stop=true;
						}
					}else{
						if(heapArray[i].compareTo(heapArray[rightIndex(i)])>0){
							swap(i,rightIndex(i));
							i=rightIndex(i);
						}else{
							stop = true;
						}
					}
				}else{
					if(heapArray[i].compareTo(heapArray[leftIndex(i)])>0){
						swap(i,leftIndex(i));
						i=leftIndex(i);
					}else{
						stop=true;
					}
				}
			}else{
				stop=true;
			}
			
		}
		
	}
			
	public String toString(){
		StringBuilder cad = new StringBuilder("<");
		for (int i=0;i<heapSize;i++){
			cad.append(heapArray[i]);
			if (i<heapSize-1){
				cad.append(",");
			}
		}
		cad.append(">");
		return cad.toString();
	}	
}

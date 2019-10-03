
public class HeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AHeap<Integer> myHeap = new AHeap<Integer>();

		myHeap.insert(5);
		System.out.println(myHeap.toString());
		myHeap.insert(9);
		System.out.println(myHeap.toString());
		myHeap.insert(3);	
		System.out.println(myHeap.toString());
		myHeap.insert(1);
		System.out.println(myHeap.toString());
		myHeap.insert(4);
		System.out.println(myHeap.toString());
		myHeap.insert(2);	  
		System.out.println(myHeap.toString());		
		System.out.println("Heap Size: " + myHeap.size());

		System.out.println("Removing " + myHeap.deleteMin());
		System.out.println(myHeap.toString());	    

		System.out.println("Removing " + myHeap.deleteMin());
		System.out.println(myHeap.toString());	
	}

}

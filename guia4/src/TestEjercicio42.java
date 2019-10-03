
public class TestEjercicio42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] weights = {1,2,2};
		int [] heights = {1,2,3};
		int M = 10;
		
		Antenna A = new Antenna(M);
		
		// Solution
		int value  = A.solveAtennaProblem(weights, heights);
		System.out.println("The optimal solution is " + value);
		System.out.println(A.toString());
		System.out.println();
		
		// Solution showing the number of blocks used
		value  = A.solveAtennaProblem2(weights, heights);
		System.out.println("The optimal solution is " + value);
		System.out.println(A.toString());
		
	}

}

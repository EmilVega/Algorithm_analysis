//
public class TestEjercicio45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] weights = {2,1,3,4};
		int [] weights = {3, 1, 4, 2, 2, 1};
		
		// Compute the sum of all elements
		int sum = 0;
		for (int i=0;i<weights.length;i++){
			sum += weights[i];
		}
		
		Split S = new Split(weights.length, sum);
		
		// Solution
		int value  = S.solveSplitProblem(weights);
		System.out.println("The minimum difference between two partitions is " + value);
		System.out.println(S.toString());
		System.out.println();
	}

}

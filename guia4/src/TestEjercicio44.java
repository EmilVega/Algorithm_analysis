
public class TestEjercicio44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int [][] bits = {
				{5,1,3},
				{1,2,2},
				{3,2,3},
				{2,4,1},
				{1,2,2}
				};		
		int [][] C = {
				{0,2,3},
				{2,0,4},
				{3,4,0}
				};
		int numSymbols = 5;
		int numCodes = 3;
		
		Communications Comm = new Communications(numSymbols, numCodes);
		
		// Solution
		int value  = Comm.solveSendMessage(bits, C);
		System.out.println("The optimal solution is " + value);
		System.out.println(Comm.table2String(Comm.V));
		System.out.println();
	}

}

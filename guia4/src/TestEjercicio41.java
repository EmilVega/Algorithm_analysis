
public class TestEjercicio41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] dims = {10,100,5,50};
		int n = dims.length-1;
		
		ProductNumber N = new ProductNumber(n);
		int value = N.getOptimalProductNumber(dims);		
		System.out.println("The optimal solution is " + value);
		System.out.println(N.toString());
		
		value = N.getOptimalProductNumberMemoization(dims);
		System.out.println("The optimal solution is " + value);
		System.out.println(N.toString());
	}

}

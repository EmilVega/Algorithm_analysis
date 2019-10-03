package recursive;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;

		// Factorial		
		System.out.println("FACTORIAL");
		System.out.println("The factorial of " + n + " is " + Recursive.factorial(n));

		// The Tower of Hanoi
		System.out.println("\nTHE TOWER OF HANOI");
		Recursive.hanoi(n,'A','B','C');

		// Fibonacci Sequence
		System.out.println("\nTHE FIBONACCI SEQUENCE");
		System.out.println("The Fibonacci sequence of " + n + " is " + Recursive.fibonacci(n));

		// Division
		System.out.println("\nDIVISION WITH SUCCESSIVE SUBSTRACTIONS");
		int a=8;
		int b=2;
		System.out.println(a + "/" + b + " is " + Recursive.division(a, b));

		// Addition of digits
		System.out.println("\nADDITION OF DIGITS");	
		int d=126;
		System.out.println("The addition of the digits " + d + " is " + Recursive.addDigits(d));

		// GCD
		System.out.println("\nGREATEST COMMON DIVISOR");			
		System.out.println("The gcd of " + a + " and " + b + " is " + Recursive.gcd(a, b));

		// Multiply
		System.out.println("\nMULTIPLY ARRAY ELEMENTS");			
		int[] array = {1,4,3,2};
		System.out.println("The multiplication of " + Arrays.toString(array) + " is " + Recursive.multiply(array, array.length-1));

		// Maximum
		System.out.println("\nMAXIMUM IN AN ARRAY");					
		System.out.println("The maximum of " + Arrays.toString(array) + " is " + Recursive.maximum(array, array.length-1));
	}

}

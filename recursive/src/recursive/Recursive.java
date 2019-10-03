/*
 * Emil Vega Gualán
 * 0706950151
 * Sexto semestre TICs
 */

package recursive;

public class Recursive {
	
	public static int factorial(int n){
		if (n==0){
			return 1;
		}else{
			return n*factorial(n-1);
		}
	}
	
	public static void hanoi(int n, char s, char a, char t){
		if (n>0){
			hanoi(n-1,s,t,a);
			System.out.println("Move from "+s+" to "+t);
			hanoi(n-1,a,s,t);
		}
	}
	
	public static int fibonacci(int n){
		if (n==0){
			return 0;	
		}else{
			if (n==1){
				return 1;
			} else{
				return fibonacci(n-1) + fibonacci(n-2);
			}
		}
	}
	
	public static int division(int a,int b){
		if (a<b){
			return 0;			
		}else{
			return division(a-b,b)+1;
		}
	}
	
	public static int addDigits(int n){
		if (n==0)
			return 0;
		else
			return addDigits(n/10)+(n%10);
	}
	
	public static int gcd(int a, int b){
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}
	
	public static int multiply(int[] a, int n){
		if (n==0){
			return a[n];
		}else{
			return multiply(a,n-1)*a[n];
		}
	}
	
	public static int maximum(int[] a, int n){
		int aux;
		if (n==0){
			return a[n];
		}else{
			aux=maximum(a,n-1);
			if (a[n]>aux){
				return a[n];
			}else{
				return maximum(a,n-1);
			}
		}
	}

}

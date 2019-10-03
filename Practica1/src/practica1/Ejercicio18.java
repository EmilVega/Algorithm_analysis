package practica1;

public class Ejercicio18 {

	public static void main(String[] args) {
		System.out.println(gcd(72,60));
	}
	
	public static int division(int a,int b){
		if (a<b){
			return 0;			
		}else{
			return division(a-b,b)+1;
		}
	}
	
	public static int sum_digits(int n){
		if (n==0)
			return 0;
		else
			return sum_digits(n/10)+(n%10);
	}
	
	public static int gcd(int a, int b){
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}

}

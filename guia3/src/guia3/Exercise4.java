package guia3;

public class Exercise4 {

	public static void main(String[] args) {
		int [] a = {-2, -5, 6, -2, -3, 1, 5 , -6};
		int m = maxSum(a,0,7);
		System.out.println(m);

	}
	public static int maxSum (int a[], int l, int r){
		if (l==r){
			return a[l];
		}else{
			int m = (l+r)/2;
			int mx = Math.max(maxSum(a,l,m), maxSum(a,m+1,r));
			return Math.max(mx, maxCrossingSum(a,l,m,r));
		}
	}
	
	public static int maxCrossingSum(int a[], int l, int m, int r){
		int sum=0;
		int leftSum=a[m];
		for(int i=m;i>=l;i--){
			sum+=a[i];
			if(sum>leftSum){
				leftSum=sum;
			}
		}
		sum=0;
		int rightSum=a[m+1];
		for(int i=m+1;i<=r;i++){
			sum+=a[i];
			if(sum>rightSum){
				rightSum=sum;
			}
		}
		return leftSum+rightSum;
	}
}

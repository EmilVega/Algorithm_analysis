

public class Exercise1 {

	public static void main(String[] args) {
		int [] d={10,100,100,5,5,50};
		//System.out.println(d.length);
		int r2 = multiplyingMat(d);
		int r = M(d, 0, d.length-2);
		System.out.println(r+"\n"+r2);

	}
	
	public static int multiplyingMat(int[] d){
		int n = d.length-1;
		int[][] M = new int[n][n];
		for (int i=0;i<=n-2;i++){
			M[i][i]=0;
			for (int j=i+1;j<n;j++){
				M[i][j]= Integer.MAX_VALUE;
				for (int k=i;k<j;k++){
					int aux = M[i][k]+M[k+1][j]+(d[i]*d[k+1]*d[j+1]);
					if (aux<M[i][j]){
						M[i][j]=aux;
					}
				}
			}
		}
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				System.out.print(M[i][j]+"\t");
			}
			System.out.print("\n");
		}
		return M[0][n-1];
	}
	
	public static int M(int[] d, int i, int j){
		int r;
		if (i==j){
			r=0;
		}else{
			r=Integer.MAX_VALUE;
			for (int k=i;k<j;k++){
				int aux = M(d,i,k)+M(d,k+1,j)+(d[i]*d[k+1]*d[j+1]);
				if (aux<r){
					r=aux;
				}
			}
		}
		return r;
	}

}

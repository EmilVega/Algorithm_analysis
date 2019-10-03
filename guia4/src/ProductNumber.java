
public class ProductNumber {
	
	int [][] M;
	
	public ProductNumber(int n){
		M = new int[n][n];			
	}
	
	public int getOptimalProductNumber(int [] dims){
		int n = dims.length-1;
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				if (i==j){
					M[i][j] = 0;
				}else{
					M[i][j] = Integer.MAX_VALUE;
					for (int k=i;k<j;k++){
						int cost = M[i][k] + M[k+1][j] + dims[i]*dims[k+1]*dims[j+1];
						if (cost<M[i][j]){
							M[i][j] = cost;
						}
					}
				}
			}
		}	
		return M[0][n-1];
	}
	
	public int getOptimalProductNumberMemoization(int [] dims){
		int n = dims.length-1;
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				if (i==j){
					M[i][j] = 0;
				}else{
					M[i][j] = -1;
				}
			}
		}
		return getOptimalProductNumberMemoizationRec(dims,0,n-1);
	}
	
	public int getOptimalProductNumberMemoizationRec(int [] dims, int i, int j){
		if (M[i][j]==-1){			
			M[i][j] = Integer.MAX_VALUE;
			for (int k=i;k<j;k++){
				int cost = getOptimalProductNumberMemoizationRec(dims,i,k) + 
						getOptimalProductNumberMemoizationRec(dims,k+1,j) +
						dims[i]*dims[k+1]*dims[j+1];
				if (cost<M[i][j]){
					M[i][j] = cost;
				}
			}
		}
		return M[i][j];
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("Table Content: \n");		
		sb.append("\t");
		for (int j=0;j<M[0].length;j++){
			sb.append(j + "\t");
		}
		sb.append("\n");
		for (int j=0;j<=M[0].length*9;j++){
			sb.append("-");
		}
		sb.append("\n");
		for (int i=0;i<M.length;i++){
			for (int j=0;j<=M[i].length;j++){
				if (j==0){
					sb.append(i + "|\t");
				}else{
					sb.append(M[i][j-1] + "\t");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}

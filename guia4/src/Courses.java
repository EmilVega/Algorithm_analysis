import java.util.Arrays;

public class Courses {
	int maximumHours;
	int numCourses;
	int [][] V;

	public Courses(int maximumHours_, int numCourses_){
		maximumHours = maximumHours_;
		numCourses = numCourses_;
		V = new int[numCourses+1][maximumHours+1];			
	}

	public int solveHoursCourse(int [][] scores){
		int [][] hours = new int[V.length][V[0].length];
		for (int i=0;i<V.length;i++){
			for (int j=0;j<V[i].length;j++){
				if ((i==0) || (j==0)){
					V[i][j] = 0;				
				}else{
					V[i][j] = V[i-1][j];
					for (int k=1;k<=j;k++){
						int score = scores[i-1][k-1] + V[i-1][j-k];
						if (score>V[i][j]){
							V[i][j] = score;
							hours[i][j] = k;
						}
					}
				}
			}			
		}
		// Assign to each course the minimum number of devoted hours
		int [] assignments = new int[numCourses];
		int j = maximumHours;
		for (int i=numCourses;i>=1;i--){
			assignments[i-1] = hours[i][j];
			j = j - hours[i][j];
		}
		System.out.println(table2String(hours));
		System.out.println("Hours devoted per course: " + Arrays.toString(assignments));
		return V[numCourses][maximumHours];
	}

	public String table2String(int [][] t){
		StringBuilder sb = new StringBuilder("\n");
		sb.append("Table Content: \n");
		sb.append("\t");
		for (int j=0;j<t[0].length;j++){
			sb.append(j + "\t");
		}
		sb.append("\n");
		for (int j=0;j<=t[0].length*9;j++){
			sb.append("-");
		}
		sb.append("\n");
		for (int i=0;i<t.length;i++){
			for (int j=0;j<=t[i].length;j++){
				if (j==0){
					sb.append(i + "|\t");
				}else{
					sb.append(t[i][j-1] + "\t");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
import java.util.List;

public class FootballPools {
	public enum Result{UNO,X,DOS};
	
	public int getAllFootballPools(List<Result> l, int K, int num){
		if (l.size()==K){
			num++;
			System.out.println(l.toString());		
		}else{
			for (Result r : Result.values()){
				l.add(r);
				num = getAllFootballPools(l,K,num);
				l.remove(l.lastIndexOf(r));
			}
		}	
		return num;
	}
}

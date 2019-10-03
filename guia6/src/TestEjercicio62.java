import java.util.ArrayList;
import java.util.List;


public class TestEjercicio62 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FootballPools F = new FootballPools();
		List<FootballPools.Result> l = new ArrayList<FootballPools.Result>();
		int num = F.getAllFootballPools(l, 5, 0);
		System.out.println("\nThere are " + num + " possible football pools.");
	}
}

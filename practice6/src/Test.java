import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String args[]){
		int [][] maze = {
				{0,0,0,0,0,1,0,1,0,0},
				{1,1,0,1,1,1,0,1,1,0},
				{0,0,0,1,0,1,0,1,0,0},
				{0,1,1,1,0,0,0,1,0,1},
				{0,0,0,1,0,1,1,1,0,0},
				{1,1,0,1,0,0,0,1,1,0},
				{0,1,0,0,0,1,0,0,0,0},
				{0,1,0,1,1,1,1,1,1,0},
				{0,1,0,0,0,1,0,0,1,0},
				{0,0,0,1,0,1,0,0,0,0}};
		int [] entrance = {8,0};
		int [] exit = {1,9};
		
		MazeProblem M = new MazeProblem(maze, entrance, exit);
		M.printMaze();
		
		List<Integer> p = new ArrayList<Integer>();
		if (M.Maze(p, entrance)){
			System.out.println("A solution for the given maze is " + p.toString());
		}else{
			System.out.println("There is not solution for the given maze.");
		}
	}
}

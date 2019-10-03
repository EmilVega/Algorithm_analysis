/*
 * Emil Darío Vega Gualán
 * 0706950151
 */

import java.util.List;

public class MazeProblem {
	private int [][] maze;
	private int [] entrance, exit;
	
	public MazeProblem(int [][] maze, int [] entrance, int [] exit){
		this.maze = maze;
		this.entrance = entrance;
		this.exit = exit;
	}
	
	public boolean isInMaze(int [] pos){		
		return (pos[0]>=0 && pos[0]<maze.length) && (pos[1]>=0 && pos[1]<maze[pos[0]].length);
	}
	
	public void printMaze(){
		System.out.println("MAZE:");
		String s = "";
		for (int i=0;i<maze.length;i++){
			for (int j=0;j<maze[i].length;j++){
				if (i==entrance[0] && j==entrance[1]){
					s += "E ";
				}else if (i==exit[0] && j==exit[1]){
					s += "S ";
				}else{
					s += maze[i][j] + " ";
				}
			}
			s += "\n";
		}
		System.out.println(s);
	}
	
	public boolean Maze(List<Integer> p, int [] pos){
		boolean ok =false;
		if (pos[0]==exit[0] && pos[1]==exit[1]){
			ok=true;
			return ok;
		}else{
			maze[pos[0]][pos[1]] = 1; 
			int k=1;
			while (!ok && k<=4){
				int [] newPos = applyMovement(pos,k);
				if (maze[newPos[0]][newPos[1]] != 1){
					p.add(k);
					ok = Maze(p,newPos);
				}
				k++;
			}
			if(!ok && !p.isEmpty())
				p.remove(p.size()-1);
			return ok;
		}
		
	}
	
	public int [] applyMovement(int [] pos, int k){
		int [] newPos = new int[pos.length];
		System.arraycopy(pos, 0, newPos, 0, pos.length);
		switch(k){
		case 1: newPos[0]--;
				break;
		case 2: newPos[1]++;
				break;
		case 3: newPos[0]++;
				break;
		case 4: newPos[1]--;
				break;
		}
		if(!isInMaze(newPos)){
			newPos=pos;
		}
		return newPos;
	}
}

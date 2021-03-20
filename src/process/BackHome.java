package process;

import java.util.ArrayList;
import java.util.LinkedList;
import data.Cell;
import data.Element;
import data.Position;

/**
 * This class is inspired by the Breadth First Search (BFS) algorithm to find the shortest path between the position of the ant and the nest
 * 
 * @author Arthur Mimouni
 *
 */

public class BackHome {
	
	private static int[][] DIRECTIONS  = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 },{-1,-1},{-1,1},{1,1},{1,-1} };
	
	public ArrayList<Position> findPath(Map map,Element ant) {
	    
		boolean[][]visited = new boolean[map.getXmax()][map.getYmax()];
		Cell[][]grid=map.getGrid();
		for(int i=0;i<map.getXmax();i++) {
			for(int j=0;j<map.getYmax();j++) {
				visited[i][j]=false;
			}
		}
		
		LinkedList<Position> nextToVisit = new LinkedList<>();
	    Position start = ant.getPosition();
	    nextToVisit.add(start);
	 
	    while (!nextToVisit.isEmpty()) {
	        Position cur = nextToVisit.remove();
	        int x=cur.getX();
	        int y=cur.getY();
	 
	        if (!map.isValidLocation(x,y) || visited[x][y]) {
	            continue;
	        }
	 
	        if (grid[x][y].getTypeElement()==2 || grid[x][y].getTypeElement()==3 || grid[x][y].getTypeElement()==4 || grid[x][y].getTypeElement()==5 
	        		|| grid[x][y].getTypeElement()==6) {

	        	visited[x][y]=true;
	            continue;
	        }
	 
	        if (grid[x][y].getTypeElement()==1) {
	            return backtrackPath(cur);
	        }
	 
	        for (int[] direction : DIRECTIONS) {
	            Position coordinate = new Position(x + direction[0], y + direction[1], cur);
	            nextToVisit.add(coordinate);
	            visited[x][y]=true;
	        }
	    }
	    return new ArrayList<Position>();
	}
	
	private ArrayList<Position> backtrackPath(Position cur) {
			    ArrayList<Position> path = new ArrayList<>();
			    Position iter = cur;
			
			    while (iter != null) {
			        path.add(iter);
			        iter = iter.getParent();
			    }
			 
			    return path;
	}
}
	
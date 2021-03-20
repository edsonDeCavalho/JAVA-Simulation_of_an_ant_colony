package process;

import java.util.ArrayList;
import data.Element;
import data.Position;
import data.Cell;

/**
 * This class checks each cell around an insect and returns the free positions to the class {@link AntMove} if the insect is an ant or the class {@link PredatorMove} 
 * if the insect is a predator.
 * 
 * @author Arthur Mimouni 
 *
 */
public class InsectVision {
	
	public static ArrayList<Position> visionOfAnt (Element ant, Cell[][]grid, int xmax, int ymax) {
		
		ArrayList<Position> positions = new ArrayList<Position>();
		
			Position p;
			int x=ant.getPosition().getX();
			int y=ant.getPosition().getY();
			
			if(x!=0) {
			
				p = new Position(x-1,y);
				Cell left =grid[x-1][y];
			
				if(left.getTypeElement()==1 || left.getTypeElement()==3 || left.getTypeElement()==4 || left.getTypeElement()==2 ||  left.getTypeElement()==7 ) {
	
				}
				
				else {
					p.setDirection("LEFT");
					positions.add(p);
				}
				
				if(y!=0) {
					p = new Position(x-1,y-1);
					Cell leftTop =grid[x-1][y-1];
				
					if(leftTop.getTypeElement()==1 || leftTop.getTypeElement()==3 || leftTop.getTypeElement()==4 || leftTop.getTypeElement()==2 || leftTop.getTypeElement()==7){
		
					}
					
					else {
						p.setDirection("LEFT-TOP");
						positions.add(p);
					}
				}
				
				if(y!=ymax-1) {
					p = new Position(x-1,y+1);
					Cell leftBottom =grid[x-1][y+1];
				
					if(leftBottom.getTypeElement()==1 || leftBottom.getTypeElement()==3 || leftBottom.getTypeElement()==4 || leftBottom.getTypeElement()==2 
							|| leftBottom.getTypeElement()==7 ) {
		
					}
					else {
						p.setDirection("LEFT-BOTTOM");
						positions.add(p);
					}
				}
			}
			
			if(x!=xmax-1) {
				p = new Position(x+1,y);
				Cell right = grid[x+1][y];
			
				if(right.getTypeElement()==1 || right.getTypeElement()==3 || right.getTypeElement()==4 || right.getTypeElement()==2
						|| right.getTypeElement()==7) {
				
				}
				
				else {
					p.setDirection("RIGHT");
					positions.add(p);
				}
				
				if(y!=0) {
					p = new Position(x+1,y-1);
					Cell rightTop =grid[x+1][y-1];
				
					if(rightTop.getTypeElement()==1 || rightTop.getTypeElement()==3 || rightTop.getTypeElement()==4 || rightTop.getTypeElement()==2
							|| rightTop.getTypeElement()==7) {
		
					}
					
					else {
						p.setDirection("RIGHT-TOP");
						positions.add(p);
					}
				}
				
				if(y!=ymax-1) {
					p = new Position(x+1,y+1);
					Cell rightBottom =grid[x+1][y+1];
				
					if(rightBottom.getTypeElement()==1 || rightBottom.getTypeElement()==3 || rightBottom.getTypeElement()==4 || rightBottom.getTypeElement()==2
							|| rightBottom.getTypeElement()==7) {
		
					}
					
					else {
						p.setDirection("RIGHT-BOTTOM");
						positions.add(p);
					}
				}	
			}
		
			if(y!=0) {
				p = new Position(x,y-1);
				Cell top =grid[x][y-1];
			
				if(top.getTypeElement()==1 || top.getTypeElement()==3 || top.getTypeElement()==4 || top.getTypeElement()==2
						|| top.getTypeElement()==7) {
				
				}
				
				else {
					p.setDirection("TOP");
					positions.add(p);
				}
			}
				
			if(y!=ymax-1) {
				p = new Position(x,y+1);
				Cell bottom = grid[x][y+1];
			
				if(bottom.getTypeElement()==1 || bottom.getTypeElement()==3 || bottom.getTypeElement()==4 || bottom.getTypeElement()==2
						|| bottom.getTypeElement()==7) {
				
				}
				
				else {
					p.setDirection("BOTTOM");
					positions.add(p);
				}
			}
			
		return positions;
	}
	
	public static ArrayList<Position> visionOfPredator (Element predator, Cell[][]grid, int xmax, int ymax) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position p;
		int x=predator.getPosition().getX();
		int y=predator.getPosition().getY();
		
		if(x!=0) {
			p = new Position(x-1,y);
			Cell left =grid[x-1][y];
		
			if(left.getTypeElement()!=0 && left.getTypeElement()!=2) {

			}
			
			else {
				positions.add(p);
			}
			
			if(y!=0) {
				p = new Position(x-1,y-1);
				Cell leftTop =grid[x-1][y-1];
			
				if(leftTop.getTypeElement()!=0 && leftTop.getTypeElement()!=2) {
	
				}
				
				else {
					positions.add(p);
				}
			}
			
			if(y!=ymax-1) {
				p = new Position(x-1,y+1);
				Cell leftBottom =grid[x-1][y+1];
			
				if(leftBottom.getTypeElement()!=0 && leftBottom.getTypeElement()!=2) {
	
				}
				
				else {
					positions.add(p);
				}
			}
		}
		
		if(x!=xmax-1) {
			p = new Position(x+1,y);
			Cell right = grid[x+1][y];
		
			if(right.getTypeElement()!=0 && right.getTypeElement()!=2) {
			
			}
			
			else {
				positions.add(p);
			}
			
			if(y!=0) {
				p = new Position(x+1,y-1);
				Cell rightTop =grid[x+1][y-1];
			
				if(rightTop.getTypeElement()!=0 && rightTop.getTypeElement()!=2) {
	
				}
				else {
					positions.add(p);
				}
			}
			
			if(y!=ymax-1) {
				p = new Position(x+1,y+1);
				Cell rightBottom =grid[x+1][y+1];
			
				if(rightBottom.getTypeElement()!=0 && rightBottom.getTypeElement()!=2) {
	
				}
				else {
					positions.add(p);
				}
			}
		}
	
		if(y!=0) {
			p = new Position(x,y-1);
			Cell top =grid[x][y-1];
		
			if(top.getTypeElement()!=0 && top.getTypeElement()!=2) {
			
			}
			
			else {
				positions.add(p);
			}
		}
		
		if(y!=ymax-1) {
			p = new Position(x,y+1);
			Cell bottom = grid[x][y+1];
		
			if(bottom.getTypeElement()!=0 && bottom.getTypeElement()!=2) {
			
			}
			
			else {
				positions.add(p);
			}
		}
	return positions;
	}
}


			
			
		
		

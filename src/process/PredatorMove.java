package process;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.apache.log4j.Logger;

import data.Cell;
import data.Element;
import data.Position;
import log.LoggerUtility;

/**
 * This class represents the movement of a Predator.
 * 
 * @author Arthur Mimouni
 *
 */
public class PredatorMove {
	
	private Map map;
	private Cell[][] grid;
	private Element predator;
	private ArrayList<Ant> ants;
	private static Logger logger = LoggerUtility.getLogger(PredatorMove.class, "html");
	public PredatorMove(Element predator) {
		this.predator=predator;
	}

	public void move(Map map,int xmax, int ymax) {
		this.map=map;
		this.grid = map.getGrid();
		this.ants=map.getAnts();
		int x;
		int y;
	
		ArrayList<Position> positions= InsectVision.visionOfPredator(predator,grid,xmax,ymax);
		if(!positions.isEmpty()) {
			Iterator<Position> it =positions.iterator();
			while(it.hasNext()) {
				Position p = it.next();
				x=p.getX();
				y=p.getY();
				
				if(grid[x][y].getTypeElement()==2) {					
					goToAnt(x,y);
					return;
				}
			}
			randomMove(positions);	
		}
	}
	
	private void goToAnt(int x, int y) {
		grid[predator.getPosition().getX()][predator.getPosition().getY()].setTypeElement(0);
		predator.getPosition().setX(x);
		predator.getPosition().setY(y);
		Ant ant=(Ant)grid[x][y].getElement();
		ant.die();
		ants.remove((Ant)grid[x][y].getElement());
		logger.info("A predator has eaten an ant");
		ants.add(ant);
		grid[x][y].setTypeElement(7);
		map.setAnts(ants);
		map.setGrid(grid);
	}
	
	private void randomMove(ArrayList<Position> positions) {
		Random r = new Random();
		int valeur = 0 + r.nextInt(positions.size() - 0);
		int x=positions.get(valeur).getX();
		int y=positions.get(valeur).getY();
	
		if(grid[predator.getPosition().getX()][predator.getPosition().getY()].getTypeElement()!=1) {
			grid[predator.getPosition().getX()][predator.getPosition().getY()].setTypeElement(0);
		}
	
		predator.getPosition().setX(x);
		predator.getPosition().setY(y);
		grid[predator.getPosition().getX()][predator.getPosition().getY()].setTypeElement(7);	
	}
	
	public Map getMap() {
		return map;
	}
}

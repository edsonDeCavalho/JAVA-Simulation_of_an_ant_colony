package data;
import java.util.ArrayList;

/**
 *Grid cell that build the map. 
 *This class allows to find the element in the cell, the type and the rate of pheromones
 * The environment (map) where ants move is a array of two dimensions (Cel[][]).
 * 
 * @author Arthur Mimouni
 */
public class Cell {
	
	private Position position;
	private Cell[][] grid;
	private Element element;
	private int quantitePheromones;
	public static final int dosePheroMax =40;
	private boolean occupied=false;
	private boolean needHelp=false;
	private ArrayList<Position> homepath;
	
	/*Type Element:
	 * 0 for nothing
	 * 1 for nid
	 * 2 for ant
	 * 3 for nonLethalObstacle
	 * 4 for lethalObstacle
	 * 5 for smallFood
	 * 6 for bigFood
	 * 7 for predator
	 */
	private int typeElement;
	
	public Cell(Cell[][] grid, int x, int y) {
		this.grid=grid;
		this.position= new Position(x,y);
		this.typeElement=0;
		this.quantitePheromones=0;
		
	}
	
	public Cell(Cell[][] grid, int x, int y, int typeElement) {
		this.grid=grid;
		this.position= new Position(x,y);
		this.typeElement=typeElement;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

	public int getTypeElement() {
		return typeElement;
	}
	
	public void setTypeElement(int typeElement) {
		this.typeElement=typeElement;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}
	
	public int getQuantitePheromones() {
		return quantitePheromones;
	}

	public void setQuantitePheromones(String state) {
		if(state.contentEquals("max")) {
			quantitePheromones=dosePheroMax;
		}
	
		else if (state.equals("less")) {
			
			if(quantitePheromones>0) {
				this.quantitePheromones--;
			}
		}
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public ArrayList<Position> getHomepath() {
		return homepath;
	}

	public void setHomepath(ArrayList<Position> homepath) {
		this.homepath = homepath;
	}

	public boolean isNeedHelp() {
		return needHelp;
	}

	public void setNeedHelp(boolean needHelp) {
		this.needHelp = needHelp;
	}
}

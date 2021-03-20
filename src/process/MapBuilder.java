package process;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import data.Element;
import data.Cell;
import data.MapCharacteristics;


/**
 * This class initializes the grid as well as all the elements of the map. It also contains methods for adding elements to the map during the simulation.
 * To instantiate the element, it calls the class {@link ElementFactory}
 * 
 * @author Arthur Mimouni
 *
 */
public class MapBuilder {
	
	private ArrayList<Element> foods;
	private ArrayList<Element> obstacles;
	private ArrayList<Ant> ants;
	private Cell[][] grid;
	private MapCharacteristics mapCharacteristics;
	private int xmax;
	private int ymax;
	private int idNumber=0;
	private static int[][] DIRECTIONS  = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 },{-1,-1},{-1,1},{1,1},{1,-1} };
	
	public MapBuilder(MapCharacteristics mapCharacteristics) throws IOException, URISyntaxException  {
		this.xmax=mapCharacteristics.getXmax();
		this.ymax=mapCharacteristics.getYmax();
		this.mapCharacteristics=mapCharacteristics;
		this.grid = new Cell[xmax][ymax];
		
		this.foods = new ArrayList<Element>();
		this.obstacles= new ArrayList<Element>();
		this.ants = new ArrayList<Ant>();
		
		initGrid();
		this.ants=creatAnt(mapCharacteristics.getNbrAntsInTheMap());
		this.obstacles=creatObstacle(mapCharacteristics.getNbrBlackRock(),mapCharacteristics.getNbrGreenRock(),xmax,ymax);
		this.foods=creatFood(mapCharacteristics.getNbrMAXSmallFood(), mapCharacteristics.getNbrMAXBigFood(), xmax, ymax);
		initElement();
	}

	/**
	 * Initialize grid cells
	 */
	
	private void initGrid() {
		for(int i=0; i<xmax; i++) {
			for(int j=0; j<ymax; j++) {
				grid[i][j] = new Cell(grid,i,j);
			}
		}	
		grid[mapCharacteristics.getxNid()][mapCharacteristics.getyNid()].setTypeElement(1);
	}
	
	/**
	 * Initializes each cell of the grid with its element and type
	 */
	
	private void initElement() {
		int x,y;
		Iterator <Element> it = foods.iterator();
		
		while (it.hasNext()) {
			Element food = it.next();
			x=food.getPosition().getX();
			y=food.getPosition().getY();
			grid[x][y].setTypeElement(food.getType());
			grid[x][y].setElement(food);
		}
		
		it=obstacles.iterator();
		
		while(it.hasNext()) {
			Element obstacle = it.next();
				x=obstacle.getPosition().getX();
				y=obstacle.getPosition().getY();
				grid[x][y].setTypeElement(obstacle.getType());
				grid[x][y].setElement(obstacle);
		}
	}
	
	/**
	 * Create ants at the start of the simulation
	 * @param number
	 * @return ArrayList<Ant>
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	private ArrayList<Ant> creatAnt(int number) throws IOException, URISyntaxException {
		Element ant;
		for (int i=0;i<number;i++) {
			
			int numberAleatory = 0 + (int)(Math.random() * ((2 - 0) +1));
			if(numberAleatory == 0) {
				ant = ElementFactory.creatAnt(mapCharacteristics.getxNid()-1,mapCharacteristics.getyNid(),idNumber);
				ants.add((Ant) ant);
			}
			else {
				ant = ElementFactory.creatAnt(mapCharacteristics.getxNid()+1,mapCharacteristics.getyNid(),idNumber);
				ants.add((Ant) ant);
			}
			idNumber++;

		}
		return ants;
	}
	
	/**
	 * This method creates obstacles according to their number requested at the start of the simulation
	 * @param blackRock
	 * @param greenRock
	 * @param xmax
	 * @param ymax
	 * @return ArrayList<Element>
	 */
	
	private ArrayList<Element> creatObstacle(int blackRock, int greenRock,int xmax,int ymax){
		Element obstacle;
		Iterator<Element> it;
		Iterator<Element> it2;
		int bool=0;
		
		while (greenRock!=0) {
			it = obstacles.iterator();
			it2 = foods.iterator();
			int xAleatory = 0 + (int)(Math.random() * ((xmax - 1) +1));
			int yAleatory = 0 + (int)(Math.random() * ((ymax - 1) +1));
			obstacle=ElementFactory.creatGreenRock(xAleatory,yAleatory);

	        for (int[] direction : DIRECTIONS) {
	        	if (obstacle.getPosition().getX()==mapCharacteristics.getxNid()+direction[0] && obstacle.getPosition().getY()==mapCharacteristics.getyNid()+direction[1]) {
					bool=1;
				}
	        	
	        	if(obstacle.getPosition().getX()==mapCharacteristics.getxNid() && obstacle.getPosition().getY()==mapCharacteristics.getyNid()) {
					bool=1;
				}
	        }
			
			while(it2.hasNext() && bool==0) {
				Element food = it2.next();
				int x1 = food.getPosition().getX();
				int y1 = food.getPosition().getY();
				int x2 = obstacle.getPosition().getX();
				int y2 = obstacle.getPosition().getY();
				if ((x1==x2 && y1==y2)) {
					bool=1;
				}
			}
			
			while(it.hasNext() && bool==0) {
				Element obs = it.next();
				int x1=obs.getPosition().getX();
				int y1= obs.getPosition().getY();
				int x2=obstacle.getPosition().getX();
				int y2=obstacle.getPosition().getY();
				if ((x1==x2 && y1==y2)) {
					bool=1;
				}
			}
			
			if(bool==0) {
				obstacles.add(obstacle);
				greenRock--;
			}
			
			else{
				bool=0;
			}
		}
		
		while (blackRock!=0) {
			it = obstacles.iterator();
			it2 = foods.iterator();
			int xAleatory = 0 + (int)(Math.random() * ((xmax - 1) +1));
			int yAleatory = 0 + (int)(Math.random() * ((ymax - 1) +1));
			obstacle = ElementFactory.creatBlackRock(xAleatory,yAleatory);
			
			for (int[] direction : DIRECTIONS) { 
	        	if (obstacle.getPosition().getX()==mapCharacteristics.getxNid()+direction[0] && obstacle.getPosition().getY()==mapCharacteristics.getyNid()+direction[1]) {
					bool=1;
				}
	        	
	        	if(obstacle.getPosition().getX()==mapCharacteristics.getxNid() && obstacle.getPosition().getY()==mapCharacteristics.getyNid()) {
					bool=1;
				}
	        }
			
			while(it2.hasNext() && bool==0) {
				Element food = it2.next();
				int x1 = food.getPosition().getX();
				int y1 = food.getPosition().getY();
				int x2 = obstacle.getPosition().getX();
				int y2 = obstacle.getPosition().getY();
				if ((x1==x2 && y1==y2)) {
					bool=1;
				}
			}
			
			while(it.hasNext() && bool==0) {
				Element obs = it.next();
				int x1=obs.getPosition().getX();
				int y1= obs.getPosition().getY();
				int x2=obstacle.getPosition().getX();
				int y2=obstacle.getPosition().getY();
				if (x1==x2 && y1==y2) {
					bool=1;
				}
			}
			
			if(bool==0) {
				obstacles.add(obstacle);
			}
			
			else{
				bool=0;
			}
			blackRock--;
		}
		return obstacles;
	}
	
	/**
	 * This method creates foods according to their number requested at the start of the simulation
	 * @param numberSmall
	 * @param numberBig
	 * @param xmax
	 * @param ymax
	 * @return ArrayList<Element>
	 */
	
	private ArrayList<Element> creatFood(int numberSmall, int numberBig,int xmax, int ymax){
		Element food;
		Iterator<Element> it;
		Iterator<Element> it2;
		int bool=0;
		
		while (numberSmall!=0) {
			it=foods.iterator();
			it2 =obstacles.iterator();
			int xAleatory = 0 + (int)(Math.random() * ((xmax - 1) +1));
			int yAleatory = 0 + (int)(Math.random() * ((ymax - 1) +1));
			int numberFoodAleatory =  3 + (int)(Math.random() * ((6- 1) +1));
			food=ElementFactory.creatSmallFood(numberFoodAleatory,xAleatory,yAleatory);
			
			for (int[] direction : DIRECTIONS) {
	        	if (food.getPosition().getX()==mapCharacteristics.getxNid()+direction[0] && food.getPosition().getY()==mapCharacteristics.getyNid()+direction[1]) {
					bool=1;
				}
	        	
	        	if(food.getPosition().getX()==mapCharacteristics.getxNid() && food.getPosition().getY()==mapCharacteristics.getyNid()) {
					bool=1;
				}
	        }
			
			while(it2.hasNext() && bool==0) {
				Element obstacle = it2.next();
				int x1 = obstacle.getPosition().getX();
				int y1 = obstacle.getPosition().getY();
				int x2 = food.getPosition().getX();
				int y2 = food.getPosition().getY();
				if ((x1==x2 && y1==y2)) {
					bool=1;
				}
			}
			
			while(it.hasNext() && bool==0) {
				Element e = it.next();
				int x1=e.getPosition().getX();
				int y1= e.getPosition().getY();
				int x2=food.getPosition().getX();
				int y2=food.getPosition().getY();
				if (x1==x2 && y1==y2) {
					bool=1;
				}
			}
			
			if(bool==0) {
				foods.add(food);
			}
			
			else{
				bool=0;
			}
			numberSmall--;
		}
		
		while (numberBig!=0) {
			it = foods.iterator();
			it2 =obstacles.iterator();
			int xAleatory = 0 + (int)(Math.random() * ((xmax - 1) +1));
			int yAleatory = 0 + (int)(Math.random() * ((ymax - 1) +1));
			int numberFoodAleatory =  2 + (int)(Math.random() * ((3- 1) +1));
			food=ElementFactory.creatBigFood(numberFoodAleatory,xAleatory,yAleatory);
			
			for (int[] direction : DIRECTIONS) {
	        	if (food.getPosition().getX()==mapCharacteristics.getxNid()+direction[0] && food.getPosition().getY()==mapCharacteristics.getyNid()+direction[1]) {
					bool=1;
				}
	        	
	        	if(food.getPosition().getX()==mapCharacteristics.getxNid() && food.getPosition().getY()==mapCharacteristics.getyNid()) {
					bool=1;
				}
	        }
			
			while(it2.hasNext() && bool==0) {
				Element obstacle = it2.next();
				int x1 = obstacle.getPosition().getX();
				int y1 = obstacle.getPosition().getY();
				int x2 = food.getPosition().getX();
				int y2 = food.getPosition().getY();
				if ((x1==x2 && y1==y2)) {
					bool=1;
				}
			}
			
			while(it.hasNext() && bool==0) {
				Element e = it.next();
				int x1=e.getPosition().getX();
				int y1= e.getPosition().getY();
				int x2=food.getPosition().getX();
				int y2=food.getPosition().getY();
				if (x1==x2 && y1==y2) {
					bool=1;
				}
			}
			
			if(bool==0) {
				foods.add(food);
			}
			
			else{
				bool=0;
			}
			numberBig--;
		}
		return foods;
	}
	
	/**
	 * This method regenerates ants during the simulation
	 * @param ants
	 * @return ArrayList<Ant>
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public ArrayList<Ant> recreateAnt(ArrayList<Ant> ants) throws IOException, URISyntaxException {
		Ant ant = ElementFactory.creatAnt(mapCharacteristics.getxNid()-1,mapCharacteristics.getyNid(),idNumber);
		idNumber++;
		ants.add(ant);
		return ants; 
	}
	
	public ArrayList<Predator> creatPredator(Map map,ArrayList<Predator> predators) {
		Predator predator;
		grid=map.getGrid();
		boolean bool=false;
		
		int x = 1 + (int)(Math.random() * ((xmax - 2) +1));
		int y = 1 + (int)(Math.random() * ((ymax - 2) +1));
		
		while(grid[x][y].getTypeElement()!=0 && bool==false) {
			x = 1 + (int)(Math.random() * ((xmax - 2) +1));
			y = 1 + (int)(Math.random() * ((ymax - 2) +1));
			
			if ((x==map.getMapCharacteristics().getxNid()-1|| x==map.getMapCharacteristics().getxNid()+1) && y==map.getMapCharacteristics().getyNid()) {
				continue;
			}
			
			else if (x==map.getMapCharacteristics().getxNid() && y==map.getMapCharacteristics().getyNid()) {
				continue;
			}
			else {
				bool=true;
			}
		}
		
		predator= ElementFactory.creatPredator(x, y);
		predators.add(predator);
		grid[x][y].setTypeElement(predator.getType());
		return predators;
	}
	
	/**
	 * This method regenerates foods during the simulation
	 * @param map
	 * @param foods
	 * @return Element
	 */
	public Element recreatFood(Map map,ArrayList<Element> foods) {
		Element food;
		grid=map.getGrid();
		boolean bool=false;
		boolean bool2=true;
		
		int x = 1 + (int)(Math.random() * ((xmax - 2) +1));
		int y = 1 + (int)(Math.random() * ((ymax - 2) +1));
		
		while(grid[x][y].getTypeElement()!=0 && bool==false) {
			x = 1 + (int)(Math.random() * ((xmax - 2) +1));
			y = 1 + (int)(Math.random() * ((ymax - 2) +1));
			
			if(x==mapCharacteristics.getxNid() && y==mapCharacteristics.getyNid()) {
					continue;
			}
			
			
			for (int[] direction : DIRECTIONS) {
	        	if (x==mapCharacteristics.getxNid()+direction[0] && y==mapCharacteristics.getyNid()+direction[1]) {
					bool2=false;
	        		break;
	        	}
			}
			
			if(bool2==true) {
				bool=true;
			}
		}
		
		int aleatoryNumber = 0 + (int)(Math.random() * ((1 - 0) + 1));
		
		if(aleatoryNumber == 0) {
			int numberFoodAleatory =  3 + (int)(Math.random() * ((6- 1) +1));
			food=ElementFactory.creatSmallFood(numberFoodAleatory,x,y);
		}
		else {
			int numberFoodAleatory =  2 + (int)(Math.random() * ((3- 1) +1));
			food=ElementFactory.creatSmallFood(numberFoodAleatory,x,y);
		}
		
		grid[x][y].setTypeElement(food.getType());
		grid[x][y].setElement(food);
		return food;
	}
	
	/**
	 * This method regenerates obstacles during the simulation
	 * @param map
	 * @param obstacles
	 * @return Element
	 */
	
	public Element recreatObstacle(Map map,ArrayList<Element> obstacles) {
		Element obstacle;
		grid=map.getGrid();
		boolean bool=false;
		boolean bool2=true;
		
		int x = 1 + (int)(Math.random() * ((xmax - 2) +1));
		int y = 1 + (int)(Math.random() * ((ymax - 2) +1));
		
		while(grid[x][y].getTypeElement()!=0 && bool==false) {
			x = 1 + (int)(Math.random() * ((xmax - 2) +1));
			y = 1 + (int)(Math.random() * ((ymax - 2) +1));
			
			if(x==mapCharacteristics.getxNid() && y==mapCharacteristics.getyNid()) {
				continue;
			}
		
		
			for (int[] direction : DIRECTIONS) {
				if (x==mapCharacteristics.getxNid()+direction[0] && y==mapCharacteristics.getyNid()+direction[1]) {
					bool2=false;
					break;
				}
			}
		
			if(bool2==true) {
				bool=true;
				}
		}
		
		int aleatoryNumber = 0 + (int)(Math.random() * ((1 - 0) + 1));
		
		if( aleatoryNumber==0) {
			obstacle= ElementFactory.creatBlackRock(x, y);
		}
		
		else {
			obstacle= ElementFactory.creatGreenRock(x, y);
		}
		
		grid[x][y].setTypeElement(obstacle.getType());
		grid[x][y].setElement(obstacle);
		return obstacle;
	}

	
	public ArrayList<Element> getFoods() {
		return foods;
	}


	public ArrayList<Element> getObstacles() {
		return obstacles;
	}


	public ArrayList<Ant> getAnts() {
		return ants;
	}


	public Cell[][] getGrid() {
		return grid;
	}
}



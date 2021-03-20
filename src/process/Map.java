package process;

import java.io.IOException;
import org.apache.log4j.Logger;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import data.Element;
import data.InformationCollector;
import data.Cell;
import data.MapCharacteristics;
import log.LoggerUtility;

/**
 * Stores all datas of the simulation and calls the class {@link MapBuilder} to build the map and all the elements.
 * 
 * @author Arthur Mimouni, Edson De Carvalho
 *
 */
public class Map {
	
	private ArrayList<Element> foods;
	private ArrayList<Element> obstacles;
	private ArrayList<Ant> ants;
	private ArrayList<Predator> predators;
	private MapBuilder mapBuilder;
	private Cell[][] grid;
	private InformationCollector informationCollector;
	private MapCharacteristics mapCharacteristics;
	private HashMap<Integer,Ant> cimiteryAnt;
	
	private static Logger logger = LoggerUtility.getLogger(Map.class, "html");
	
	public Map(MapCharacteristics mapCharacteristics) throws IOException, URISyntaxException  {
		this.mapCharacteristics=mapCharacteristics;
		this.mapBuilder=new MapBuilder(mapCharacteristics);
		this.predators=new ArrayList<Predator>();
		foods = mapBuilder.getFoods();
		obstacles = mapBuilder.getObstacles();
		ants = mapBuilder.getAnts();
		grid = mapBuilder.getGrid();
		cimiteryAnt=new HashMap<Integer,Ant>();
		this.informationCollector=new InformationCollector();
	}
	
	/**
	 * This method gives the possibility of add ants to the map.
	 * 
	 * @return void 
	 */
	
	public void addAnt() throws IOException, URISyntaxException{
		while(grid[mapCharacteristics.getxNid()-1][mapCharacteristics.getyNid()].getTypeElement()==2) {
			continue;
		}
		ants=mapBuilder.recreateAnt(ants);
	}
	
	/**
	 * This method gives the possibility of add obstacles to the map.
	 * 
	 * @return void 
	 */
	
	public void addObstacle(){
		if(obstacles.size()<190) {
			//this.mapCharacteristics.incrementationNbTotalOfObstacle();
			Element obstacle=mapBuilder.recreatObstacle(this, obstacles);
			
			if(obstacle.getType()==3) {
				this.mapCharacteristics.incrementationNbrGreenRock();
			}
			else {
				this.mapCharacteristics.incrementationNbrBlackRock();
			}
			
			obstacles.add(obstacle);
			logger.info("Adding an obstacle to the Map");
		}
	} 
	
	/**
	 * This method gives the possibility of add predators to the map.
	 * 
	 * @return void 
	 */
	
	public void addPredator() {
		if(predators.size()!=10) {
			this.mapCharacteristics.incrementationNbrPredators();;
			predators=mapBuilder.creatPredator(this, predators);
			logger.info("Adding an Predator to the Map");
		}
	}	
	
	/**
	 * This method gives the possibility of add Food to the map.
	 * 
	 * @return void 
	 */
	
	public void addFood(){
		
		Element food =mapBuilder.recreatFood(this, foods);
		if(food.getType()==5) {
			this.mapCharacteristics.incrementationNbrSmallFood();;
		}
		else {
			this.mapCharacteristics.incrementationNbrBigFood();;
		}
		
		foods.add(food);
		logger.info("Adding more Food to the Map");
	}
	

	public void setPredators(ArrayList<Predator> predators) {
		this.predators = predators;
	}
	
	public void removeDeadAnt(int indiceAnt,Ant ant) {
		this.mapCharacteristics.decrementationNbrAntsInTheMap();
		
		if(ants.get(indiceAnt).getTypeOfDead().equals(" ")){
			ants.get(indiceAnt).setTypeOfDead("I died of old age");
		}
		
		this.cimiteryAnt.put(ant.getIdentity().getIdNumber(),ant);
		this.informationCollector.antDeathStoreInformation(ant);
		this.ants.remove(indiceAnt); 
		this.mapCharacteristics.incrementationNbrDeadAnts();
		logger.info("An ant is dead");
	}
	
	public void removeDeadPredator(int indicePredator,Predator predator) {
		this.mapCharacteristics.decrementationNbrPredators();
		this.mapCharacteristics.incrementationNbrDeadPredators();
		this.predators.remove(indicePredator);
		logger.info("A Predator is dead");
	}
	
	
	public boolean isValidLocation(int row, int col) {
        if (row < 0 || row >= mapCharacteristics.getXmax() || col < 0 || col >=mapCharacteristics.getYmax()) {
            return false;
        }
        return true;
    }

	public void inputInformationCollector()  {
		this.informationCollector.process(mapCharacteristics);
	}
	
	public void mapUpdate() {
		this.mapCharacteristics.setNbrTotalFood(getFoods().size());
	}
		
	public MapCharacteristics getMapCharacteristics() {
		return mapCharacteristics;
	}

	public ArrayList<Element> getFoods() {
		return foods;
	}

	public void setFoods(ArrayList<Element> foods) {
		this.foods = foods;
	}

	public ArrayList<Element> getObstacles() {
		return obstacles;
	}

	public void setObstacles(ArrayList<Element> obstacles) {
		this.obstacles = obstacles;
	}

	public ArrayList<Ant> getAnts(){ 		
		return ants;
	}

	public void setAnts(ArrayList<Ant> ants) {
		this.ants = ants;
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}
	
	public int getXmax() {
		return mapCharacteristics.getXmax();
	}


	public int getYmax() {
		return mapCharacteristics.getYmax();
	}
		
	public HashMap<Integer, Ant> getCimiteryAnt() {
		return cimiteryAnt;
	}
	
	public void setCimiteryAnt(HashMap<Integer, Ant> cimiteryAnt) {
		this.cimiteryAnt = cimiteryAnt;
	}

	public ArrayList<Predator> getPredators() {
		return predators;
	}
	
	public InformationCollector getInformationCollector() {
		return informationCollector;
	}

	public void setInformationCollector(InformationCollector informationCollector) {
		this.informationCollector = informationCollector;
	}

	public void setMapCharacteristics(MapCharacteristics mapCharacteristics) {
		this.mapCharacteristics = mapCharacteristics;
	}
}
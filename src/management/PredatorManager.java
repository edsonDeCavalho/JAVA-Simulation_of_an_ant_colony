package management;
import java.util.ArrayList;

import process.Map;
import process.Predator;

/**
 * This class helps the core in the management of predators.
 * 
 * @author Edson De Carvalho 
 */
public class PredatorManager {
	private ArrayList<Predator> predators;
	
	public PredatorManager() {
		this.predators=new  ArrayList<Predator>();
	}
	
	/**
	 * This method manages all the ants in the simulation. She sorts live ants and dead ants
	 * @param map
	 */
	public void  liveManager(Map map) {
		predators=map.getPredators();
	
		for(int i=0;i<predators.size();i++){
			predators.get(i).lessLive();
		}
	
		for(int i=0;i<predators.size();i++) {
			if(predators.get(i).getHealth()<=0) {
				map.removeDeadPredator(i,predators.get(i));
			}	
		}
	}
	
	/**
	 * This method calls the method of moving of each predator
	 * @param map
	 */
	
	public void mouvementManager(Map map) {
		int xmax=map.getXmax();
		int ymax=map.getYmax();
		predators=map.getPredators();
			
		for(int i=0;i<predators.size();i++) {
			map=predators.get(i).move(xmax, ymax, map);
			map.getPredators().set(i, predators.get(i));
		}
	}
}
	

package data;

import java.util.ArrayList;

import process.Ant;
import data.MapCharacteristics;

/**
 * This class allows the recovery of useful information for the user during the simulation.
 * 
 * @author Edson De Carvalho
 *
 */


public class InformationCollector {
	
	private String InformationCollector;
	private ArrayList<String> deathAntInfo;

	
	
	public InformationCollector() {
		
		this.InformationCollector="***********************************************UTIL INFORMATION*************************************";
		this.deathAntInfo=new ArrayList<String>();
	}
	
	/**
	 * This method allows to build a string that contains all the useful information through a MapCharacteristiques object.
	 * 
	 * @param mach
	 * @return void
	 */
	
	public void process(MapCharacteristics mach) {
		this.InformationCollector=" ";
		this.firstLine();
		this.antsInTheMap(mach.getNbrAntsInTheMap());
		this.numberOfFoodIntheMap(mach.getNbrTotalFood());
		this.foodCaptured(mach.getNbrCapturedFood());
		this.predatorInfo(mach.getNbrPredatorsIntheMap());
		this.deathToollInfo(mach.getNbrDeadAnts());
		if(deathAntInfo.size()!=0) {
			for(int i=0;i<deathAntInfo.size();i++) {
				//this.InformationCollector+=deathAntInfo.get(i);
			}
			for(int i=0;i<deathAntInfo.size();i++) {
				deathAntInfo.remove(i);
			}
		}
		this.InformationCollector+=" \n SMALL FOOD :"+mach.getNbrSmallFoodCaptured();
		this.InformationCollector+=" \n BIG FOOD :"+mach.getNbrBigFoodCaptured();
		this.lastLine();
		
	}
	
	public void firstLine() {
		this.InformationCollector+=("\n- - - - - - - - - - -  - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - \n");
		this.InformationCollector+="***********************************************UTIL INFORMATION********************************************";
	}
	
	public void lastLine() {
		this.InformationCollector+=("\n- - - - - - - - - - -  - - - - - - - - - - - - - - - - - -- - - - -- - - - - - - -- - - -- - - - - - - \n");
	}
	
	public void predatorInfo(int nbrPredator) {
		String deathT="\n |"+nbrPredator+" Predators in the Map";
		this.InformationCollector+=deathT;
	}
	
	public void antsInTheMap(int numberOfAntsIntheMap) {
		String antinfo="\n \n Global Infomations : \n";
		antinfo+="\n |"+numberOfAntsIntheMap+" Ants in the Map ";
		this.InformationCollector+=antinfo;
	}
	
	public void antDeathStoreInformation(Ant ant) {
		String antInfo="\n | The Ant with th id: "+ant.getIdentity().getIdNumber()+" is Dead ";
		this.deathAntInfo.add(antInfo);
	}
	
	public void deathToollInfo(int deathToll) {
		String deathT="\n |"+deathToll+" Ants have died since the start of the simulation";
		this.InformationCollector+=deathT;
	}
	
	public void foodCaptured(int numberOfCaptured) {//
		String foodInfo="Food Information :";
		foodInfo="\n |"+numberOfCaptured+" captured food";
		this.InformationCollector+=foodInfo;
	}
	

	public void numberOfFoodIntheMap(int numberOfFoodIntheMap) {
		String foodInfo="\n |"+numberOfFoodIntheMap+" food in the Map ";
		this.InformationCollector+=foodInfo;
	}

	public String getInformationCollection() {
		return InformationCollector;
	}


	public void setInformationCollection(String informationCollection) {
		this.InformationCollector = informationCollection;
	}	
}
package data;

import data.MapCharacteristics;

/** 
 * This class creates numeric statistics from simulation data.
 * 
 * @author Arthur Mimouni
 */
public class NumericStat {
	
	public static String getNumericStat(MapCharacteristics mapCharacteristics) {
		return "<html>Number of ants in the map: "+mapCharacteristics.getNbrAntsInTheMap()
				+"<br/>Number of predators in the map: "+mapCharacteristics.getNbrPredatorsIntheMap()
				+"<br/>Number of dead ants:"+mapCharacteristics.getNbrDeadAnts()
				+"<br/>Number of capturedFood: "+mapCharacteristics.getNbrCapturedFood()+"</html>";		
	}
}
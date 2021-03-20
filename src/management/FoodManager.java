package management;
import process.Map;

/**
 * This class helps the core in the management of Foods.
 * 
 * @author Edson De Carvalho 
 */
public class FoodManager {
	
	public FoodManager() {

	}
	
	/**
	 * This method generates food on the map according to a frequency of appearance
	 * @param map
	 */
	public void moreFoods(Map map) {
		int frequency=map.getMapCharacteristics().getFrequencyFood();
		if(map.getMapCharacteristics().getTime()%frequency==0 && map.getMapCharacteristics().getNbrTotalFood()<map.getMapCharacteristics().getNbrMAXTotalFood()) {
			map.addFood();
		}
	}
}

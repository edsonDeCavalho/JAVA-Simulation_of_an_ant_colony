package data;

public class MapCharacteristics {
	
	/**
	 * This class is used for the storage of basic information and data during simulation
	 * This class uses Singleton design pattern.
	 * 
	 * @author Edson De Carvalho Pedro
	 */
	private int xmax=61;
	private int ymax=48;
	
	private int nbrAntsInTheMap=1;
	private int nbrMaxAnts=20;
	private int nbrPredatorsIntheMap=0;
	
	private int nbrDeadAnts=0;
	private int nbrDeadPredators=0;
	
	private int nbrSmallFood=0;
	private int nbrBigFood=0;
	private int nbrBlackRock=70;
	private int nbrGreenRock=70;
	private int nbrTotalObstacle=nbrBlackRock+nbrGreenRock;
	private int frequencyFood=200;

	private int nbrMAXSmallFood=60;
	private int nbrMAXBigFood=40;
	private int nbrMAXTotalFood=nbrMAXBigFood+nbrMAXSmallFood;
	private int nbrTotalFood=nbrMAXTotalFood;
	private int nbrCapturedFood=0;
	private int nbrSmallFoodCaptured=0;
	private int nbrBigFoodCaptured=0;
	
	private int time;
	private int windowWidth = 1480;
	private int windowHeight = 929;
	private int widthSquare=17;
	private int heightSquare=17;
	private int scale = 16;
	private int xNid = 25;
	private int yNid = 25; 

	private static MapCharacteristics instance = new MapCharacteristics();
	
	private MapCharacteristics() {
		
	}
		
	/**
	 * Static method allows users to get the unique instance of the class.
	 * 
	 * @return the unique instance of MapCharacteristics.
	 */
	
	public static MapCharacteristics getInstance() {
		return instance;
	}


	public int getXmax() {
		return xmax;
	}

	public void setXmax(int xmax) {
		this.xmax = xmax;
	}

	public int getYmax() {
		return ymax;
	}

	public void setYmax(int ymax) {
		this.ymax = ymax;
	}
	
	public void incrementationTime() {
		this.time++;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}

	public int getWidthSquare() {
		return widthSquare;
	}

	public void setWidthSquare(int widthSquare) {
		this.widthSquare = widthSquare;
	}

	public int getHeightSquare() {
		return heightSquare;
	}

	public void setHeightSquare(int heightSquare) {
		this.heightSquare = heightSquare;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public int getxNid() {
		return xNid;
	}

	public void setxNid(int xNid) {
		this.xNid = xNid;
	}

	public int getyNid() {
		return yNid;
	}

	public void setyNid(int yNid) {
		this.yNid = yNid;
	}

	public int getNbrGreenRock() {
		return nbrGreenRock;
	}

	public void setNbrGreenRock(int nbrGreenRock) {
		this.nbrGreenRock = nbrGreenRock;
	}

	public int getNbrBlackRock() {
		return nbrBlackRock;
	}

	public void setNbrBlackRock(int nbrBlackRock) {
		this.nbrBlackRock = nbrBlackRock;
	}
	
	public int getNbrSmallFood() {
		return nbrSmallFood;
	}

	public void setNbrSmallFood(int nbrSmallFood) {
		this.nbrSmallFood = nbrSmallFood;
	}

	public int getNbrBigFood() {
		return nbrBigFood;
	}

	public void setNbrBigFood(int nbrBigFood) {
		this.nbrBigFood = nbrBigFood;
	}
	
	public int getNbrCapturedFood() {
		return nbrCapturedFood;
	}
	
	public int getFrequencyFood() {
		return frequencyFood;
	}

	public void setFrequencyFood(int frequencyFood) {
		this.frequencyFood = frequencyFood;
	}

	public int getNbrAntsInTheMap() {
		return nbrAntsInTheMap;
	}

	public void setNbrAntsInTheMap(int nbrAntsInTheMap) {
		this.nbrAntsInTheMap = nbrAntsInTheMap;
	}
	
	public int getNbrPredatorsIntheMap() {
		return nbrPredatorsIntheMap;
	}

	public void setNbrPredatorsIntheMap(int nbrPredatorsIntheMap) {
		this.nbrPredatorsIntheMap = nbrPredatorsIntheMap;
	}

	public int getNbrMaxAnts() {
		return nbrMaxAnts;
	}

	public void setNbrMaxAnts(int nbrMaxAnts) {
		this.nbrMaxAnts = nbrMaxAnts;
	}
	
	public int getNbrDeadAnts() {
		return nbrDeadAnts;
	}
	
	public int getNbrDeadPredators() {
		return nbrDeadPredators;
	}

	public int getNbrMAXSmallFood() {
		return nbrMAXSmallFood;
	}

	public void setNbrMAXSmallFood(int nbrMAXSmallFood) {
		this.nbrMAXSmallFood = nbrMAXSmallFood;
	}

	public int getNbrMAXBigFood() {
		return nbrMAXBigFood;
	}
	
	public void setNbrMAXBigFood(int nbrMAXBigFood) {
		this.nbrMAXBigFood = nbrMAXBigFood;
	}

	public int getNbrMAXTotalFood() {
		return nbrMAXTotalFood;
	}
	
	public void setNbrMAXTotalFood() {
		this.nbrMAXTotalFood = nbrMAXSmallFood+nbrMAXBigFood;
	}

	public int getNbrTotalFood() {
		return nbrTotalFood;
	}

	public void setNbrTotalFood(int nbrTotalFood) {
		this.nbrTotalFood = nbrTotalFood;
	}
	
	public void setNbrCapturedFood(int nbrCapturedFood) {
		this.nbrCapturedFood = nbrCapturedFood;
	}
	
	public int getNbrSmallFoodCaptured() {
		return nbrSmallFoodCaptured;
	}
	
	public void setNbrSmallFoodCaptured(int nbrSmallFoodCaptured) {
		this.nbrSmallFoodCaptured = nbrSmallFoodCaptured;
	}

	public int getNbrBigFoodCaptured() {
		return nbrBigFoodCaptured;
	}

	public void setNbrBigFoodCaptured(int nbrBigFoodCaptured) {
		this.nbrBigFoodCaptured = nbrBigFoodCaptured;
	}
	
	public int getNbrTotalObstacle() {
		return nbrTotalObstacle;
	}

	public void setNbrTotalObstacle(int nbrTotalObstacle) {
		this.nbrTotalObstacle = nbrTotalObstacle;
	}
	
	public void incrementationNbrPredators() {
		this.nbrPredatorsIntheMap++;
	}
	
	public void decrementationNbrPredators() {
		this.nbrPredatorsIntheMap--;
	}
	
	public void incrementationNbrBigFood() {
		this.nbrSmallFood++;
		this.nbrTotalFood++;
	}
	
	public void decrementationNbrBigFood() {
		this.nbrBigFood--;
		this.nbrTotalFood--;
	}
	
	public void incrementationNbrSmallFood() {
		this.nbrSmallFood++;
		nbrTotalFood++;
	}
	
	public void decrementationNbrSmallFood() {
		this.nbrSmallFood--;
		nbrTotalFood--;
	}
	
	public void incrementationNbrCapturedFood() {
		nbrCapturedFood++;
	}
	
	public void incrementationNbrBlackRock() {
		this.nbrBlackRock++;
		this.nbrTotalObstacle++;
	}
	
	public void incrementationNbrGreenRock() {
		this.nbrGreenRock++;
		this.nbrTotalObstacle++;
	}
	
	public void incrementationNbrAntsInTheMap() {
		this.nbrAntsInTheMap++;
	}
	
	public void decrementationNbrAntsInTheMap() {
		this.nbrAntsInTheMap--;
	}
	
	public void incrementationNbrDeadAnts(){
		this.nbrDeadAnts++;
	}

	public void incrementationNbrDeadPredators(){
		this.nbrDeadPredators++;
	}
}
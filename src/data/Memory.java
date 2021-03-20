package data;

/**
 * 
 * This class represents the memory of a ant (captured food and number of steps since the birth of the ant).
 * 
 * @author Arthur Mimouni, Edson De Carvalho , Paul Gasquet 
 */

public class Memory {
	
	private int capturedBigFood;
	private int capturedSmallFood;
	private int numberOfSteps;

	public Memory() {
		this.capturedBigFood=0;
		this.capturedSmallFood=0;
		this.numberOfSteps=0;
	}

	public void incrementeCapturedSmallFood() {
		this.capturedSmallFood++;
	}
	
	public void incrementeCapturedBigFood() {
		this.capturedBigFood++;
	}
	
	public void incrementeNumberOfSteps() {
		this.numberOfSteps++;
	}
	
	public int getCapturedBigFood() {
		return capturedBigFood;
	}

	public int getCapturedSmallFood() {
		return capturedSmallFood;
	}

	public int getNumberOfSteps() {
		return numberOfSteps;
	}
}

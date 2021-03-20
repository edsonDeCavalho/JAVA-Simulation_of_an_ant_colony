package data;

/**
 * This class is the representation of the health of an ant which decreases over the simulation.
 * 
 * @author Arthur Mimouni, Edson De Carvalho , Paul Gasquet
 */
public class Health {
	
	private int health;
	private String death;

	public Health() {
		this.health=300+ (int)(Math.random() * ((1000 - 1) +1));;
		this.death=" ";
	}
	
	public void lessLive() {
		this.health--;
	}
	
	public void die(String typeOfDie) {
		this.health=0;
		this.death=typeOfDie;
	}
	
	public int getHealth() {
		return health;
	}

	public String getDeath() {
		return death;
	}

	public void setDeath(String death) {
		this.death = death;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public String toString() {
		return "Health [health=" + health + ", death=" + death + "]";
	}	
	
}
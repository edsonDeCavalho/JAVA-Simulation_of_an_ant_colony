package process;

import data.Position;



import data.Element;
import data.Health;
import data.Identity;

/**
 * This class represents a predator.
 * 
 * @author Arthur Mimouni, Edson De Carvalho , Paul Gasquet
 */
public class Predator implements Element{
	
	private Position position;
	private int type=7;
	private PredatorMove movePredator;
	private int quantity;
	private Health health;
	private Identity identity;

	public Predator(int x, int y) {
		this.position = new Position (x,y);
		movePredator = new PredatorMove(this);
		health = new Health();
	}
	
	public Map move(int xmax, int ymax, Map map) {
		movePredator.move(map, xmax, ymax);
		
		return movePredator.getMap();
	}
	
	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

	public int getType() {
		return type;
	}
	
	public void setType (int type) {
		this.type=type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getHealth() {
		return health.getHealth();
	}
	

	public void setHealth(Health health) {
		this.health = health;
	}
	
	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	
	public void lessLive() {
		this.health.lessLive();
	}
	
	@Override
	public String toString() {
		return "Predator: [position=" + position + ", type=" + type + ", deplacement=  quantite="
				+ quantity + ", health=" + health.toString() + ", identity=" + identity.toString() + "]";
	}
}
	
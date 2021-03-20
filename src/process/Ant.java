package process;

import data.Position;

import java.io.IOException;
import java.net.URISyntaxException;
import data.Element;
import data.Health;
import data.Identity;
import data.Memory;

public class Ant implements Element{
	
	/**
	 * This class represents an ant.
	 * 
	 * @author Arthur Mimouni, Edson De Carvalho 
	 */
	
	private Position position;
	private int type=2;
	private AntMove moveAnt;
	private int quantity;
	private Health health;
	private Identity identity;
	private Memory memory;
	private String direction="az";
	

	public Ant(int x, int y,int idNumber) throws IOException, URISyntaxException {
		this.position = new Position (x,y);
		this.moveAnt = new AntMove(this);
		this.health = new Health();
		this.memory = new Memory();
		this.identity =new Identity(idNumber);

	}
	
	public Map move(int xmax, int ymax, Map map) {
		moveAnt.move(map, xmax, ymax);
		//health.lessLive();
		return moveAnt.getMap();
	}
	
	public void lessLive() {
		this.health.lessLive();
	}
	
	public void die() {
		String typeOfDie="I was eaten by a spider.";
		this.health.die(typeOfDie);
	}
	
	public String whoAmI() {
		String name=identity.getFirstName();
		int id=identity.getIdNumber();
		int smallFood=memory.getCapturedSmallFood();
		int bigFood = memory.getCapturedBigFood();
		int steps=memory.getNumberOfSteps();
		return "<html>My name is "+name+", Im the ant n°"+id+".<br/> I've catch "+smallFood+" small foods and "+bigFood+" big foods. <br/>I make "+steps+" steps since my birth. <br/>"+health.getDeath()+"</html>";
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
	
	public String getTypeOfDead() {
		return health.getDeath();
	}
	public void setTypeOfDead(String death) {
		this.health.setDeath(death);
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
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Memory getMemory() {
		return memory;
	}

	@Override
	public String toString() {
		return "Ant [position=" + position + ", type=" + type + ", deplacement=  quantite="
				+ quantity + ", health=" + health.toString() + ", identity=" + identity.toString() + "]";
	}
}
	

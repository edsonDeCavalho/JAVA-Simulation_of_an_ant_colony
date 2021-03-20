package data;

/**
 * This class is the representation of an obstacle of type Green Rock.
 * Implement the interface {@link Element}
 * 
 * @author Arthur Mimouni, Edson De Carvalho , Paul Gasquet
 */
public class GreenRock implements Element {
	
	private Position position;
	private int type=4;
	private int quantity;
	
	public GreenRock(int x, int y) {
		this.position=new Position(x,y);
	}
	
	public int getType() {
		return type;
	}
	
	public void setType (int type) {
		this.type=type;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public void setPosition(Position position) {
		this.position=position;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	
}

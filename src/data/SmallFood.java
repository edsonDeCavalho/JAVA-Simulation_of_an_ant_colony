package data;

/**
 * This class represents a small food that can be transported by a single ant.
 * Implement the interface {@link Element}
 * 
 * @author Arthur Mimouni, Edson De Carvalho , Paul Gasquet
 *
 */
public class SmallFood implements Element {
	private int type=5;
	private Position position;
	private int quantity;
	
	public SmallFood(int quantity,int x, int y) {
		this.position = new Position(x,y);
		this.quantity=quantity;
	}
	
	public SmallFood(int x, int y) {
		this.position = new Position(x,y);
		this.quantity=1;
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
		this.quantity+=quantity;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public void setPosition(Position position) {
		this.position=position;
	}

}

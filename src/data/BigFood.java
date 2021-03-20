package data;

/**
 * This class is the representation of a heavy food that needs two ants to be transported.
 * Implement the interface {@link Element}
 * 
 * @author Arthur Mimouni, Edson De Carvalho, Paul Gasquet
 */
public class BigFood implements Element {
		
	private int type=6;
	private Position position;
	private int quantity;
	
	public BigFood(int quantity,int x, int y) {
		this.position = new Position(x,y);
		this.quantity=quantity;
	}
	
	public BigFood(int x, int y) {
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
	
	public BigFood getInstance() {
		return this;
	}
}
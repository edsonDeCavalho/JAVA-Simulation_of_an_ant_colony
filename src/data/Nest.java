package data;

import data.Element;
import data.Position;

/**
 * This class represents the nest of ants
 * Implement the interface {@link Element}
 * 
 * @author Arthur Mimouni, Edson De Carvalho , Paul Gasquet
 *
 */
public class Nest implements Element{

	private Position position;
	private int type=1;
	private int quantity=1;
	
	public Nest (int x, int y) {
		position = new Position (x,y);
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type=type;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}
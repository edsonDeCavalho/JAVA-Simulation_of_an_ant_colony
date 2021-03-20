package data;

/**
 * This is the interface that all the elements of the Map implement.
 * 
 * @author Arthur Mimouni, Edson De Carvalho , Paul Gasquet
 */
public interface Element {
	
	public Position getPosition();
	
	public void setPosition(Position position);

	public int getType();
	
	public void setType(int type);
	
	public int getQuantity();
	
	public void setQuantity(int quantity);
	
}

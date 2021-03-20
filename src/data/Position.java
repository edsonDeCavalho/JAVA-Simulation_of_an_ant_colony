package data;

/**
 * This class represents a position of a @link{Element}
 * 
 * @author Arthur Mimouni, Edson De Carvalho , Paul Gasquet
 */
public class Position {

	private int x;
	private int y;
	private Position parent;
	private String direction;
	
	public Position() {
		this.x=50;
		this.y=50;
	}
	
	public Position(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public Position(int x,int y,Position parent) {
		this.x=x;
		this.y=y;
		this.parent=parent;
	}
	
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public Position getParent() {
		return parent;
	}
	
	public void setParent(Position parent) {
		this.parent = parent;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
}

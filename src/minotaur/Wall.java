package minotaur;

public class Wall {
	
	public Wall(int loc, int d){
		location = loc;
		direction = d;
	}
	static final int VERTICAL = 0;
	static final int HORIZONTAL = 1;
	private int direction;
	private int location;
	
	public void rotate(){
		if (direction == VERTICAL){
			direction = HORIZONTAL;
		}
		else {
			direction = VERTICAL;
		}
	}
	public int getLocation(){
		return location;
	}
	public void setLocation(int i){
		location = i;
	}
	public int getDirection(){
		return direction;
	}
	public void setDirection(int i){
		direction  = i;
	}

}

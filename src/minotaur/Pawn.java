package minotaur;

import java.awt.Color;

public class Pawn {
	
	public Pawn(int c, String t){
		location = c;
		team = t;
	}
	
	int location;
	String team;
	
	public int getLocation(){
		return location;
	}
	public void setLocation(int i){
		location = i;
	}
	
	public String getTeam(){
		return team;
	}
	
	public void moveUp(){
		// if location is evenly divided by 30 then the pawn is at the top and cannot go farther up
		int top = location%30;
		if (top != 0){
			location -= 1;
		}
	}
	public void moveDown(){
		// if location divided by 30 has a remainder of 29
		int down = location % 30;
		if (down != 29){
			location += 1;
		}
	}
	public void moveLeft(){
		if (location > 29){
			location -= 30;
		}
	}
	public void moveRight(){
		if (location < 870){
			location += 30;
		}
	}

}

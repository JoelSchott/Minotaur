package minotaur;

public class Minotar extends Pawn{

	public Minotar(int c, String t) {
		super(c, t);
		team = "Minotar";
		location = 432;
	}
	public void setTeam(String s){
		team = s;
	}


}

package minotaur;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Maze extends JPanel{
	
	public Maze(int numPlayers){
		
		System.out.println("the number of players are " + numPlayers);
		players = numPlayers;
		
		mino = new Minotar(0,"Minotar");
		turn = "white";
		moves = 3;
		for (int i = 0; i < 30; i ++){
			for (int h=0; h < 30; h++){
				ArrayList<Integer> a = new ArrayList<Integer>();
				a.add(i);
				a.add(h);
				Cell c = new Cell(a,(i*30 + h));
				cells.add(c);
			}
		}
		Pawn p = new Pawn(0,"white");
		pawns.add(p);
		Pawn p1 = new Pawn(1,"white");
		pawns.add(p1);
		Pawn p2 = new Pawn(30,"white");
		pawns.add(p2);
		
		if (numPlayers > 1){
			Pawn p3 = new Pawn(28,"blue");
			pawns.add(p3);
			Pawn p4 = new Pawn(29,"blue");
			pawns.add(p4);
			Pawn p5 = new Pawn(59,"blue");
			pawns.add(p5);
		}
		
		if (numPlayers > 2){
			Pawn p9 = new Pawn(899,"yellow");
			pawns.add(p9);
			Pawn p10 = new Pawn(898,"yellow");
			pawns.add(p10);
			Pawn p11 = new Pawn(869,"yellow");
			pawns.add(p11);
			
			
		}
		
		else if (numPlayers > 3){
			Pawn p6 = new Pawn(899-28,"red");
			pawns.add(p6);
			Pawn p7 = new Pawn(899-29,"red");
			pawns.add(p7);
			Pawn p8 = new Pawn(899-59,"red");
			pawns.add(p8);
		}
		

		selected = pawns.get(1);
		needToRollDice = true;
		
		Wall w = new Wall(92, Wall.HORIZONTAL);
		walls.add(w);
		Wall w0 = new Wall(248, Wall.VERTICAL);
		walls.add(w0);
		Wall w1 = new Wall(260, Wall.VERTICAL);
		walls.add(w1);
		Wall w2 = new Wall(117, Wall.HORIZONTAL);
		walls.add(w2);
		Wall w3 = new Wall(899-122, Wall.HORIZONTAL);
		walls.add(w3);
		Wall w4 = new Wall(899-249, Wall.VERTICAL);
		walls.add(w4);
		Wall w5 = new Wall(899-261, Wall.VERTICAL);
		walls.add(w5);
		Wall w6 = new Wall(899-147, Wall.HORIZONTAL);
		walls.add(w6);
		
		placeWalls();
		
		selectedWall = walls.get(0);
		
		cells.get(0).setBase("white");
		cells.get(0).setAsStart();
		cells.get(1).setBase("white");
		cells.get(1).setAsStart();
		cells.get(30).setBase("white");
		cells.get(30).setAsStart();
		
		cells.get(403).setBase("white");
		cells.get(403).setAsTarget();
		cells.get(404).setBase("white");
		cells.get(404).setAsTarget();
		cells.get(433).setBase("white");
		cells.get(433).setAsTarget();
		
		cells.get(28).setBase("blue");
		cells.get(28).setAsStart();
		cells.get(29).setBase("blue");
		cells.get(29).setAsStart();
		cells.get(59).setBase("blue");
		cells.get(59).setAsStart();
		
		cells.get(405).setBase("blue");
		cells.get(405).setAsTarget();
		cells.get(406).setBase("blue");
		cells.get(406).setAsTarget();
		cells.get(436).setBase("blue");
		cells.get(436).setAsTarget();
		
		cells.get(899-28).setBase("red");
		cells.get(899-28).setAsStart();
		cells.get(899-29).setBase("red");
		cells.get(899-29).setAsStart();
		cells.get(899-59).setBase("red");
		cells.get(899-59).setAsStart();
		
		cells.get(493).setBase("red");
		cells.get(493).setAsTarget();
		cells.get(494).setBase("red");
		cells.get(494).setAsTarget();
		cells.get(463).setBase("red");
		cells.get(463).setAsTarget();
		
		cells.get(899-0).setBase("yellow");
		cells.get(899-0).setAsStart();
		cells.get(899-1).setBase("yellow");
		cells.get(899-1).setAsStart();
		cells.get(899-30).setBase("yellow");
		cells.get(899-30).setAsStart();
		
		cells.get(466).setBase("yellow");
		cells.get(466).setAsTarget();
		cells.get(495).setBase("yellow");
		cells.get(495).setAsTarget();
		cells.get(496).setBase("yellow");
		cells.get(496).setAsTarget();
		
		cells.get(434).add(Cell.TEMPLE);
		cells.get(435).add(Cell.TEMPLE);
		cells.get(464).add(Cell.TEMPLE);
		cells.get(465).add(Cell.TEMPLE);
		
		cells.get(65).add(Cell.HEDGE);
		cells.get(66).add(Cell.HEDGE);
		cells.get(67).add(Cell.HEDGE);
		cells.get(70).add(Cell.HEDGE);
		cells.get(71).add(Cell.HEDGE);
		cells.get(72).add(Cell.HEDGE);
		cells.get(73).add(Cell.HEDGE);
		cells.get(76).add(Cell.HEDGE);
		cells.get(77).add(Cell.HEDGE);
		cells.get(78).add(Cell.HEDGE);
		cells.get(79).add(Cell.HEDGE);
		cells.get(82).add(Cell.HEDGE);
		cells.get(83).add(Cell.HEDGE);
		cells.get(84).add(Cell.HEDGE);
		
		cells.get(95).add(Cell.HEDGE);
		cells.get(100).add(Cell.HEDGE);
		cells.get(109).add(Cell.HEDGE);
		cells.get(114).add(Cell.HEDGE);
		
		cells.get(130).add(Cell.HEDGE);
		cells.get(139).add(Cell.HEDGE);
		
		cells.get(158).add(Cell.HEDGE);
		cells.get(159).add(Cell.HEDGE);
		cells.get(160).add(Cell.HEDGE);
		cells.get(169).add(Cell.HEDGE);
		cells.get(170).add(Cell.HEDGE);
		cells.get(171).add(Cell.HEDGE);
		
		cells.get(185).add(Cell.HEDGE);
		cells.get(193).add(Cell.HEDGE);
		cells.get(196).add(Cell.HEDGE);
		cells.get(204).add(Cell.HEDGE);
		
		cells.get(212).add(Cell.HEDGE);
		cells.get(213).add(Cell.HEDGE);
		cells.get(214).add(Cell.HEDGE);
		cells.get(215).add(Cell.HEDGE);
		cells.get(223).add(Cell.HEDGE);
		cells.get(226).add(Cell.HEDGE);
		cells.get(234).add(Cell.HEDGE);
		cells.get(235).add(Cell.HEDGE);
		cells.get(236).add(Cell.HEDGE);
		cells.get(237).add(Cell.HEDGE);
		
		cells.get(245).add(Cell.HEDGE);
		cells.get(252).add(Cell.HEDGE);
		cells.get(253).add(Cell.HEDGE);
		cells.get(256).add(Cell.HEDGE);
		cells.get(257).add(Cell.HEDGE);
		cells.get(264).add(Cell.HEDGE);
		
		cells.get(332).add(Cell.HEDGE);
		cells.get(333).add(Cell.HEDGE);
		cells.get(334).add(Cell.HEDGE);
		cells.get(335).add(Cell.HEDGE);
		cells.get(338).add(Cell.HEDGE);
		cells.get(339).add(Cell.HEDGE);
		cells.get(340).add(Cell.HEDGE);
		cells.get(341).add(Cell.HEDGE);
		cells.get(344).add(Cell.HEDGE);
		cells.get(345).add(Cell.HEDGE);
		cells.get(348).add(Cell.HEDGE);
		cells.get(349).add(Cell.HEDGE);
		cells.get(350).add(Cell.HEDGE);
		cells.get(351).add(Cell.HEDGE);
		cells.get(354).add(Cell.HEDGE);
		cells.get(355).add(Cell.HEDGE);
		cells.get(356).add(Cell.HEDGE);
		cells.get(357).add(Cell.HEDGE);
		
		cells.get(362).add(Cell.HEDGE);
		cells.get(365).add(Cell.HEDGE);
		cells.get(368).add(Cell.HEDGE);
		cells.get(381).add(Cell.HEDGE);
		cells.get(384).add(Cell.HEDGE);
		cells.get(387).add(Cell.HEDGE);
		
		cells.get(392).add(Cell.HEDGE);
		cells.get(395).add(Cell.HEDGE);
		cells.get(398).add(Cell.HEDGE);
		cells.get(411).add(Cell.HEDGE);
		cells.get(414).add(Cell.HEDGE);
		cells.get(417).add(Cell.HEDGE);
		
		cells.get(431).add(Cell.HEDGE);
		cells.get(438).add(Cell.HEDGE);
		
		
		cells.get(899 - 65).add(Cell.HEDGE);
		cells.get(899 -66).add(Cell.HEDGE);
		cells.get(899 -67).add(Cell.HEDGE);
		cells.get(899 -70).add(Cell.HEDGE);
		cells.get(899 -71).add(Cell.HEDGE);
		cells.get(899 -72).add(Cell.HEDGE);
		cells.get(899 -73).add(Cell.HEDGE);
		cells.get(899 -76).add(Cell.HEDGE);
		cells.get(899 -77).add(Cell.HEDGE);
		cells.get(899 -78).add(Cell.HEDGE);
		cells.get(899 -79).add(Cell.HEDGE);
		cells.get(899 -82).add(Cell.HEDGE);
		cells.get(899 -83).add(Cell.HEDGE);
		cells.get(899 -84).add(Cell.HEDGE);
		
		cells.get(899 -95).add(Cell.HEDGE);
		cells.get(899 -100).add(Cell.HEDGE);
		cells.get(899 -109).add(Cell.HEDGE);
		cells.get(899 -114).add(Cell.HEDGE);
		
		cells.get(899 -130).add(Cell.HEDGE);
		cells.get(899 -139).add(Cell.HEDGE);
		
		cells.get(899 -158).add(Cell.HEDGE);
		cells.get(899 -159).add(Cell.HEDGE);
		cells.get(899 -160).add(Cell.HEDGE);
		cells.get(899 -169).add(Cell.HEDGE);
		cells.get(899 -170).add(Cell.HEDGE);
		cells.get(899 -171).add(Cell.HEDGE);
		
		cells.get(899 -185).add(Cell.HEDGE);
		cells.get(899 -193).add(Cell.HEDGE);
		cells.get(899 -196).add(Cell.HEDGE);
		cells.get(899 -204).add(Cell.HEDGE);
		
		cells.get(899 -212).add(Cell.HEDGE);
		cells.get(899 -213).add(Cell.HEDGE);
		cells.get(899 -214).add(Cell.HEDGE);
		cells.get(899 -215).add(Cell.HEDGE);
		cells.get(899 -223).add(Cell.HEDGE);
		cells.get(899 -226).add(Cell.HEDGE);
		cells.get(899 -234).add(Cell.HEDGE);
		cells.get(899 -235).add(Cell.HEDGE);
		cells.get(899 -236).add(Cell.HEDGE);
		cells.get(899 -237).add(Cell.HEDGE);
		
		cells.get(899 -245).add(Cell.HEDGE);
		cells.get(899 -252).add(Cell.HEDGE);
		cells.get(899 -253).add(Cell.HEDGE);
		cells.get(899 -256).add(Cell.HEDGE);
		cells.get(899 -257).add(Cell.HEDGE);
		cells.get(899 -264).add(Cell.HEDGE);
		
		cells.get(899 -332).add(Cell.HEDGE);
		cells.get(899 -333).add(Cell.HEDGE);
		cells.get(899 -334).add(Cell.HEDGE);
		cells.get(899 -335).add(Cell.HEDGE);
		cells.get(899 -338).add(Cell.HEDGE);
		cells.get(899 -339).add(Cell.HEDGE);
		cells.get(899 -340).add(Cell.HEDGE);
		cells.get(899 -341).add(Cell.HEDGE);
		cells.get(899 -344).add(Cell.HEDGE);
		cells.get(899 -345).add(Cell.HEDGE);
		cells.get(899 -348).add(Cell.HEDGE);
		cells.get(899 -349).add(Cell.HEDGE);
		cells.get(899 -350).add(Cell.HEDGE);
		cells.get(899 -351).add(Cell.HEDGE);
		cells.get(899 -354).add(Cell.HEDGE);
		cells.get(899 -355).add(Cell.HEDGE);
		cells.get(899 -356).add(Cell.HEDGE);
		cells.get(899 -357).add(Cell.HEDGE);
		
		cells.get(899 -362).add(Cell.HEDGE);
		cells.get(899 -365).add(Cell.HEDGE);
		cells.get(899 -368).add(Cell.HEDGE);
		cells.get(899 -381).add(Cell.HEDGE);
		cells.get(899 -384).add(Cell.HEDGE);
		cells.get(899 -387).add(Cell.HEDGE);
		
		cells.get(899 -392).add(Cell.HEDGE);
		cells.get(899 -395).add(Cell.HEDGE);
		cells.get(899 -398).add(Cell.HEDGE);
		cells.get(899 -411).add(Cell.HEDGE);
		cells.get(899 -414).add(Cell.HEDGE);
		cells.get(899 -417).add(Cell.HEDGE);
		
		cells.get(899 -431).add(Cell.HEDGE);
		cells.get(899 -438).add(Cell.HEDGE);

		
	}
	
	ArrayList<Cell> cells = new ArrayList<Cell>();
	ArrayList<Pawn> pawns = new ArrayList<Pawn>();
	ArrayList<Wall> walls = new ArrayList<Wall>();
	private final int CELL_LENGTH = 15;
	
	private Pawn selected;
	private Wall selectedWall;
	private int moves;
	private String turn;
	
	private boolean needToRollDice;
	private boolean moveWall;
	private boolean showMouseWall;
	
	private Minotar mino;
	
	int newDirection;
	int mouseLocation;
	
	private int players;
	
	private boolean finished = false;

	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		for (int i = 0; i < cells.size(); i ++){
			if (cells.get(i).contains(Cell.HEDGE)){
				g.setColor(new Color(0,150,50));
			}
			else if (cells.get(i).contains(Cell.WALL)){
				g.setColor(Color.GRAY);
			}
			else if (cells.get(i).getBase() != null){
				String baseString = cells.get(i).getBase();
				if (baseString.equals("blue")){
					g.setColor(Color.BLUE);
				}
				else if (baseString.equals("red")){
					g.setColor(Color.RED);
				}
				else if (baseString.equals("yellow")){
					g.setColor(Color.YELLOW);
				}
				else if (baseString.equals("white")){
					g.setColor(Color.WHITE);
				}
			}
			else if (cells.get(i).contains(Cell.MINOTAR)){
				g.setColor(Color.BLACK);
			}
			else if (cells.get(i).contains(Cell.TEMPLE)){
				g.setColor(new Color(250,150,0));
			}
			else{
				g.setColor(Color.green);
			}
			g.fillRect(cells.get(i).getLocation().get(0) * CELL_LENGTH, cells.get(i).getLocation().get(1) * CELL_LENGTH, CELL_LENGTH, CELL_LENGTH);
			g.setColor(Color.WHITE);
			g.drawRect(cells.get(i).getLocation().get(0) * CELL_LENGTH, cells.get(i).getLocation().get(1) * CELL_LENGTH, CELL_LENGTH, CELL_LENGTH);
		}
		for (int i =0; i < pawns.size(); i ++){
			int columns = (int)(pawns.get(i).getLocation()/30);
			int rows = pawns.get(i).getLocation()%30;

			if (pawns.get(i).getTeam() == "white"){
				g.setColor(Color.WHITE);
			}
			if (pawns.get(i).getTeam() == "blue"){
				g.setColor(Color.BLUE);
			}
			if (pawns.get(i).getTeam() == "red"){
				g.setColor(Color.RED);
			}
			if (pawns.get(i).getTeam() == "yellow"){
				g.setColor(Color.YELLOW);
			}
			g.fillOval(columns*15, rows*15, 15, 15);
			if (pawns.get(i).getTeam() == "white" || pawns.get(i).getTeam() == "yellow" ){
				g.setColor(Color.BLACK);
			}
			else{
				g.setColor(Color.WHITE);
			}
			g.drawOval(columns*15, rows*15, 15, 15);
		}
		g.fillOval((int)mino.getLocation()/30 * 15, mino.getLocation()%30 * 15, 15, 15);
		if (selected.getTeam() == "blue" || selected.getClass() == Minotar.class){
			g.setColor(Color.WHITE);
		}
		else{
			g.setColor(Color.BLACK);
		}
		if (!moveWall){
			g.fillOval(((int)selected.getLocation()/30) * 15 + 5, (selected.getLocation()%30) * 15 + 5, 5, 5);
		}
		else{
			int x;
			int y;
			g.setColor(Color.BLUE);
			if (selectedWall.getDirection() == Wall.HORIZONTAL){
				x = 30;
				y = 15;
			}
			else{
				x = 15;
				y = 30;
			}
			g.drawRect(((int)selectedWall.getLocation()/30) * 15, (selectedWall.getLocation()%30) *15, x, y);
			if (showMouseWall){
				if (newDirection == Wall.HORIZONTAL){
					x = 30;
					y = 15;
				}
				else{
					x = 15;
					y = 30;
				}
				g.drawRect(((int)mouseLocation/30) * 15, (mouseLocation%30) *15, x, y);
			}
		}
		
	}
	public void changeSelected(int x, int y){
		double shortest = 999999999;
		if (selected.getClass() != Minotar.class && !moveWall){
			for (int i = 0; i < pawns.size(); i++){
				if (pawns.get(i).getTeam() == turn){
					int xLoc = ((int) pawns.get(i).getLocation()/30) * 15 + 7;
					int yLoc = (pawns.get(i).getLocation()%30 * 15) + 7;
					double deltax = Math.abs(xLoc - x);
					double deltay = Math.abs(yLoc - y);
					double distance = Math.sqrt((Math.pow(deltax, 2)) + (Math.pow(deltay, 2)));
					if ( distance < shortest) {
						selected = pawns.get(i);
						shortest = distance;
					}
				}
			}
		}
		shortest = 999999999;
		if (moveWall){
			for (int w = 0; w < walls.size(); w ++){
				int xLoc = ((int) walls.get(w).getLocation()/30) * 15 + 7;
				int yLoc = (walls.get(w).getLocation()%30 * 15) + 7;
				double deltax = Math.abs(xLoc - x);
				double deltay = Math.abs(yLoc - y);
				double distance = Math.sqrt((Math.pow(deltax, 2)) + (Math.pow(deltay, 2)));
				if (distance < shortest) {
					selectedWall = walls.get(w);
					shortest = distance;
				}
			}
		}
		
	}
	public void moveRight(){
		if (selected.getLocation()< 870){
			if (cells.get(selected.getLocation() + 30).isEmpty()){
				if ((! pawnInWay("right") && ! wrongBase("right")) || (selected.getClass() == Minotar.class && !wrongBase("right"))){
					selected.moveRight();
					moves -= 1;
					checkMinotar();
					if (victory()){
						endgame();
					}
					changeTurns();
				}	
			}
		}	
	}
	public void moveLeft(){
		if (selected.getLocation()> 29){
			if (cells.get(selected.getLocation() - 30).isEmpty()){
				if ((! pawnInWay("left")  && ! wrongBase("left")) || (selected.getClass() == Minotar.class && !wrongBase("left"))){
					selected.moveLeft();
					moves -= 1;
					checkMinotar();
					if (victory()){
						endgame();
					}
					changeTurns();

				}	
			}
		}	
	}
	public void moveUp(){
		if (selected.getLocation()%30 != 0){
			if (cells.get(selected.getLocation() - 1).isEmpty()){
				if ((! pawnInWay("up")  && ! wrongBase("up")) || (selected.getClass() == Minotar.class && !wrongBase("up"))){
					selected.moveUp();
					moves -= 1;
					checkMinotar();
					if (victory()){
						endgame();
					}
					changeTurns();

				}
			}
		}	
	}
	public void moveDown(){
		if (selected.getLocation()%30 != 29){
			if (cells.get(selected.getLocation() + 1).isEmpty()){
				if ((! pawnInWay("down")  && ! wrongBase("down")) || (selected.getClass() == Minotar.class && !wrongBase("down"))){
					selected.moveDown();
					moves -=1;
					checkMinotar();
					if (victory()){
						endgame();
					}
					changeTurns();

				}
			}
		}	
		
	}
	public void moveSelectedWall(int x, int y){
		int columns = x/15;
		int rows = y/15;
		int newLocation = (columns*30) + rows;
		int formerDirection = selectedWall.getDirection();
		selectedWall.setDirection(newDirection);
		if ((selectedWall.getDirection() == Wall.HORIZONTAL && newLocation + 30 < 870) || (selectedWall.getDirection() == Wall.VERTICAL && newLocation%30 != 29)){
			if (isEmptyCell(newLocation)){
				if ((selectedWall.getDirection() == Wall.HORIZONTAL && isEmptyCell(newLocation+30)) || (selectedWall.getDirection() == Wall.VERTICAL && isEmptyCell(newLocation+1))){
					selectedWall.setLocation(newLocation);
					placeWalls();
					changeTurns();
					moveWall = false;
				}
				else{
					selectedWall.setDirection(formerDirection);
				}	
			}
			else{
				selectedWall.setDirection(formerDirection);
			}
		}
		else{
			selectedWall.setDirection(formerDirection);
		}
	}
	public void moveMinotar(){
		String minoTeam = selected.getTeam();
		mino.setTeam(minoTeam);
		selected = mino;
		moves = 8;
	}
	public void moveWall(){
		moveWall = true;
	}
	public void placeWalls(){
		for (int c = 0; c < cells.size(); c ++){
			if (cells.get(c).contains(Cell.WALL)){
				cells.get(c).remove(Cell.WALL);
			}
		}
		for (int w = 0; w < walls.size(); w++){
			cells.get(walls.get(w).getLocation()).add(Cell.WALL);
			if (walls.get(w).getLocation() < 870 && walls.get(w).getDirection() == Wall.HORIZONTAL){
				cells.get(walls.get(w).getLocation() + 30).add(Cell.WALL);
			}
			else if (walls.get(w).getLocation()% 30 != 29){
				cells.get(walls.get(w).getLocation() + 1).add(Cell.WALL);
			}
		}
	}
	public boolean isEmptyCell(int i){
		boolean anwser = true;
		if (! cells.get(i).isEmpty()){
			anwser = false;
		}
		if (cells.get(i).getBase() != null){
			anwser = false;
		}
		for (int p = 0; p < pawns.size(); p ++){
			if (pawns.get(p).getLocation() == i){
				anwser = false;
			}
		}
		return anwser;		
		
	}
	public void rotateSelected(){
		if (newDirection == Wall.VERTICAL){
			newDirection = Wall.HORIZONTAL;
		}
		else {
			newDirection = Wall.VERTICAL;
		}
	}
	public void checkMinotar(){
		boolean pawnHere = false;
		if (selected.getClass() == Minotar.class){
			for (int i = 0; i < pawns.size(); i ++){
				if (selected.getLocation() == pawns.get(i).getLocation()){
					for (int g = 0; g < cells.size(); g ++){
						if (cells.get(g).getBase() == pawns.get(i).getTeam() && cells.get(g).isStart() && cells.get(g).isEmpty()){
							pawnHere = false;
							for (int h = 0; h < pawns.size(); h ++){
								if (pawns.get(h).getLocation() == cells.get(g).getID()){
									pawnHere = true;
								}
							}
							if (! pawnHere){
								pawns.get(i).setLocation(cells.get(g).getID());
							}
						}
					}
				}
			}
		}
	}
	public boolean pawnInWay(String s){
		boolean inWay = false;
		int variation = 0;
		if (s == "up"){
			variation = -1;
		}
		else if (s == "down"){
			variation = 1;
		}
		else if (s == "right"){
			variation = 30;
		}
		else if (s == "left"){
			variation = -30;
		}
		for (int i = 0; i < pawns.size(); i ++){
			if (pawns.get(i).getLocation() == selected.getLocation() + variation || mino.getLocation() == selected.getLocation() + variation){
				inWay = true;
			}
		}
		return inWay;
	}
	public boolean wrongBase(String s){

		boolean wrongBase = false;
		int variation = 0;
		if (s == "up"){
			variation = -1;
		}
		else if (s == "down"){
			variation = 1;
		}
		else if (s == "right"){
			variation = 30;
		}
		else if (s == "left"){
			variation = -30;
		}
		if (selected.getTeam() == "white"){
			if (cells.get(selected.getLocation() + variation).getBase() == "blue" || cells.get(selected.getLocation() + variation).getBase() == "red" || cells.get(selected.getLocation() + variation).getBase() == "yellow" ){
				wrongBase = true;
			}
		}
		else if (selected.getTeam() == "red"){
			if (cells.get(selected.getLocation() + variation).getBase() == "blue" || cells.get(selected.getLocation() + variation).getBase() == "white" || cells.get(selected.getLocation() + variation).getBase() == "yellow" ){
				wrongBase = true;
			}
		}
		else if (selected.getTeam() == "blue"){
			if (cells.get(selected.getLocation() + variation).getBase() == "white" || cells.get(selected.getLocation() + variation).getBase() == "red" || cells.get(selected.getLocation() + variation).getBase() == "yellow" ){
				wrongBase = true;
			}
		}
		if (selected.getTeam() == "yellow"){
			if (cells.get(selected.getLocation() + variation).getBase() == "blue" || cells.get(selected.getLocation() + variation).getBase() == "red" || cells.get(selected.getLocation() + variation).getBase() == "white" ){
				wrongBase = true;
			}
		}
		if (cells.get(selected.getLocation()+ variation).getBase() != null && selected.getClass() == Minotar.class){
			wrongBase = true;
		}
		return wrongBase;
	}
	public void changeTurns(){
		System.out.println("changing turns");
		if (moves == 0){
			if (selected.getTeam() == "white"){
				if (players > 1){
					turn = "blue";
					selected = pawns.get(pawnOfColor("blue"));
				}
				else{
					selected = pawns.get(pawnOfColor("white"));
				}
				
			}
			else if (selected.getTeam() == "blue"){
				if (players > 2){
					turn = "yellow";
					selected = pawns.get(pawnOfColor("yellow"));
				}
				else{
					turn = "white";
					selected = pawns.get(pawnOfColor("white"));
				}
			}
			else if (selected.getTeam() == "yellow"){
				if (players > 3){
					turn = "red";
					selected = pawns.get(pawnOfColor("red"));
				}
				else{
					turn = "white";
					selected = pawns.get(pawnOfColor("white"));
				}
			}
			else if (selected.getTeam() == "red"){
				turn = "white";
				selected = pawns.get(pawnOfColor("white"));
			}
			needToRollDice = true;
		}
	}
	private int pawnOfColor(String s){
		int answer = 0;
		for (int i = 0; i < pawns.size(); i ++){
			if (pawns.get(i).getTeam() == s){
				answer = i;
				break;
			}
		}
		return answer;
	}
	
	public boolean victory(){
		boolean won = false;
		int onBase = 0;
		for (int p =0; p < pawns.size(); p ++){
			if (pawns.get(p).getTeam() == selected.getTeam()){
				if (cells.get(pawns.get(p).getLocation()).getBase() == selected.getTeam() && cells.get(pawns.get(p).getLocation()).isTarget()){
					onBase ++;
				}
			}
		}
		if (onBase == 3){
			won = true;
		}
		return won;
	}
	public void endgame(){
		System.out.println(selected.getTeam() + " won");
		finished = true;
	}
	public boolean isDone(){
		return finished;
	}
	public boolean getNeedToRollDice(){
		return needToRollDice;
	}
	public void setNeedToRollDice(boolean b){
		needToRollDice = b;
	}
	public void setMoves(int i){
		moves = i;
	}
	public String getTeam(){
		return selected.getTeam();
	}
	public int getMoves(){
		return moves;	
	}
	public boolean isMovingWall(){
		return moveWall;
	}
	public int getDirection(){
		return newDirection;
	}
	public void setShowWall(boolean b){
		showMouseWall = b;
	}
	public void setMouseLocation(int x, int y){
		int col = (int)(x/15);
		int row = (int)(y/15);
		mouseLocation = (col * 30) + row;
	}

}

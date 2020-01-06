package minotaur;

import java.awt.*;
import javax.swing.*;

public class Die extends JPanel {

	public Die() {
		this.setPreferredSize(new Dimension(470, 81));
		this.setBackground(Color.LIGHT_GRAY);
	}

	private boolean rolling = false;
	private String result;
	private String team;
	private int moves;
	private int direction;
	private boolean showDirection;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(150, 5, 40, 40);
		if (result == "3") {
			g.fillOval(155, 10, 10, 10);
			g.fillOval(165, 20, 10, 10);
			g.fillOval(175, 30, 10, 10);
		} else if (result == "4") {
			g.fillOval(157, 10, 10, 10);
			g.fillOval(174, 10, 10, 10);
			g.fillOval(157, 30, 10, 10);
			g.fillOval(174, 30, 10, 10);
		} else if (result == "5") {
			g.fillOval(155, 10, 10, 10);
			g.fillOval(176, 10, 10, 10);
			g.fillOval(155, 30, 10, 10);
			g.fillOval(176, 30, 10, 10);
			g.fillOval(165, 20, 10, 10);
		} else if (result == "6") {
			g.fillOval(157, 7, 10, 10);
			g.fillOval(157, 20, 10, 10);
			g.fillOval(157, 33, 10, 10);
			g.fillOval(174, 7, 10, 10);
			g.fillOval(174, 20, 10, 10);
			g.fillOval(174, 33, 10, 10);
		}
		if (result == "wall" || result == "minotar") {
			if (result == "wall") {
				g.setColor(Color.GRAY);
			} else {
				g.setColor(Color.BLACK);
			}
			g.fillRect(151, 6, 39, 39);
		}

		g.setColor(Color.BLACK);
		g.drawString(team + " rolled a " + result, 20, 20);
		if (moves == 1){
			g.drawString(team + " has " + moves + " move left", 20, 40);
		}
		else{
			g.drawString(team + " has " + moves + " moves left", 20, 40);
		}
		if (direction == Wall.HORIZONTAL || direction == Wall.VERTICAL){
			String direct;
			if (direction == Wall.HORIZONTAL){
				direct = "horizontal";
			}
			else{
				direct = "vertical";
			}
			if (showDirection){
				g.drawString("Hold shift to place the wall, press r to rotate", 200, 20);
				g.drawString("The placed wall will be " + direct, 200,40);
			}
			
		}
		
	}

	public String roll() {
		rolling = true;
		double randint = Math.random();

		if (randint < (1.0 / 6.0)) {
			result = "3";
		} else if (randint < (2.0 / 6.0)) {
			result = "4";
		} else if (randint < (3.0 / 6.0)) {
			result = "5";
		} else if (randint < (4.0 / 6.0)) {
			result = "6";
		}
		else if (randint < (5.0/6.0)){
			result = "wall";
		}
		else {
			result = "minotar";
		}
		return result;
	}

	public void setTeam(String s) {
		team = s;
	}
	public void setMoves(int i){
		moves = i;
	}
	public void setDirection(int i){
		direction = i;
	}
	public void setShowDirection(boolean b){
		showDirection = b;
	}
}

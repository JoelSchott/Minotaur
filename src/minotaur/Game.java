package minotaur;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Game extends JFrame {
	
	boolean finished = false;
	MinotarInit init;
	Maze m;
	Die d = new Die();
	MouseLis myListener = new MouseLis();
	
	File iconFile = new File("C:\\Users\\Computer\\IdeaProjects\\Minotaur\\src\\images\\bull.png");
	Image iconImage;
	
	
	public static void main(String [] args){
		Game g = new Game();
		g.start();
		g.loop();
	}
	
	public void start(){
		
		init = new MinotarInit();
		while (init.getRunning()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		init.setVisible(false);
		m = new Maze(init.numHumans() + init.numComp());
		try{
			iconImage = ImageIO.read(iconFile);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		this.setTitle("Minotaur");
		this.setIconImage(iconImage);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new KeyLis());
		this.addMouseListener(new MouseLis());
		m.addMouseListener(myListener);
		m.addMouseMotionListener(myListener);
		//m.setLayout(new BoxLayout(m, BoxLayout.Y_AXIS));
		//d.setLayout(new BoxLayout(d, BoxLayout.Y_AXIS));
		this.add(m);
		this.add(d, BorderLayout.SOUTH);
		this.pack();
		this.setResizable(true);
		this.setSize(470, 570);
		
		this.setVisible(true);
	}
	public void loop(){
		while (! finished){
			try{
				Thread.sleep(100);
			}
			catch(Exception e){e.printStackTrace();}
			repaint();
			d.setMoves(m.getMoves());
			d.setDirection(m.getDirection());
			d.setShowDirection(m.isMovingWall());
			if(m.getNeedToRollDice()){
				d.setTeam(m.getTeam());
				String result = d.roll();
				if (result == "3" || result == "4" || result == "5" || result == "6"){
					int moves = Integer.parseInt(result);
					m.setMoves(moves);
				}
				else if (result == "minotar"){
					m.moveMinotar();
				}
				else if (result == "wall"){
					m.setMoves(0);
					m.moveWall();
				}
				m.setNeedToRollDice(false);
			}
			if (m.isDone()){
				finished =  true;
				System.out.println("shutting down");
				System.exit(ABORT);
				break;
			}
			//System.out.println("looping");
		}	
		
		
	}
	
	private class KeyLis extends KeyAdapter {
	      @Override
	      public void keyPressed(KeyEvent e) {
	         switch (e.getKeyCode()) {
	         case KeyEvent.VK_LEFT:
	        	 if (! m.isMovingWall()){
	        		 m.moveLeft();
	        	 }
	            break;
	         case KeyEvent.VK_RIGHT:
	        	 if (! m.isMovingWall()){
	        		 m.moveRight();
	        	 }
	            break;
	         case KeyEvent.VK_DOWN:
	        	 if (! m.isMovingWall()){
	        		 m.moveDown();
	        	 }
	        	 break;
	         case KeyEvent.VK_UP:
	        	 if (! m.isMovingWall()){
	        		 m.moveUp();
	        	 }
	        	 break;
	         case KeyEvent.VK_R:
	        	 if (m.isMovingWall()){
	        		 m.rotateSelected();
	        	 }
	         }
	      }
	  }
	private class MouseLis extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e){
			if (e.isShiftDown() && m.isMovingWall()){
				m.moveSelectedWall(e.getX(),e.getY());
				m.setShowWall(false);
			}
			else{
				m.changeSelected(e.getX(),e.getY());
			}	
		}
		@Override
		public void mouseMoved(MouseEvent e){
			if (m.isMovingWall() && e.isShiftDown()){
				m.setMouseLocation(e.getX(), e.getY());
				m.setShowWall(true);
			}
			else{
				m.setShowWall(false);
			}
		}
	}
	

}

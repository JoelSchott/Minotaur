package minotaur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MinotarInit extends JFrame{
	
	public MinotarInit(){
		playerLabel = new JLabel("There are " + numPlayers + " human players");
		playerPlus = new JButton("+");
		playerPlus.addActionListener(new PlayerPlusListener());
		playerMinus = new JButton("-");
		playerMinus.addActionListener(new PlayerMinusListener());
		playerPanel = new JPanel();
		
		playerPanel.add(BorderLayout.WEST,playerLabel);
		playerPanel.add(playerPlus);
		playerPanel.add(BorderLayout.EAST,playerMinus);
		computerLabel = new JLabel("There are " + numComputers + " computer players");
		comPlus = new JButton("+");
		comPlus.addActionListener(new ComPlusListener());
		comMinus = new JButton("-");
		comMinus.addActionListener(new ComMinusListener());
		computerPanel = new JPanel();
		computerPanel.add(BorderLayout.WEST,computerLabel);
		computerPanel.add(comPlus);
		computerPanel.add(BorderLayout.EAST,comMinus);
		
		finishButton  = new JButton("Create Game !");
		finishButton.addActionListener(new FinalButtonListener());
		
		warningLabel = new JLabel();
		main = new MainPanel();
		main.add(BorderLayout.NORTH,playerPanel);
		main.add(computerPanel);
		main.add(BorderLayout.SOUTH,finishButton);
		main.add(BorderLayout.SOUTH,warningLabel);
		this.add(main);
		this.setSize(new Dimension(300,175));
		this.setResizable(false);
		this.setVisible(true);
	}
	
	JPanel playerPanel;
	JButton playerPlus;
	JButton playerMinus;
	JPanel computerPanel;
	JButton comPlus;
	JButton comMinus;
	JLabel playerLabel;
	JLabel computerLabel;
	JButton finishButton;
	JLabel warningLabel;
	MainPanel main;
	
	
	private int numPlayers = 0;
	private int numComputers = 0;
	
	private boolean run = true;
	
	public boolean getRunning(){
		return run;
	}
	
	public int numHumans(){
		return numPlayers;
	}
	
	public int numComp(){
		return numComputers;
	}
	
	private void updateLabels(){
		if (numPlayers == 1){
			playerLabel.setText("There is " + numPlayers + " human player");
		}
		else{
			playerLabel.setText("There are " + numPlayers + " human players");
		}
		if (numComputers == 1){
			computerLabel.setText("There is " + numComputers + " computer player");
		}
		else{
			computerLabel.setText("There are " + numComputers + " computer players");
		}
	}
	
	private class MainPanel extends JPanel{
		
		public MainPanel(){
			this.setBackground(Color.WHITE);
		}	
	}
	
	private class PlayerPlusListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (numPlayers < 4){
				numPlayers ++;
			}
			updateLabels();
		}
	}
	private class PlayerMinusListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (numPlayers > 0){
				numPlayers -= 1;
			}
			updateLabels();
		}
	}
	private class ComPlusListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (numComputers < 4){
				numComputers ++;
			}
			updateLabels();
		}
	}
	private class ComMinusListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (numComputers > 0){
				numComputers -= 1;
			}
			updateLabels();
		}
	}
	private class FinalButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (numPlayers + numComputers > 4){
				warningLabel.setText("There can be a maximum of four players");
			}
			else if (numPlayers + numComputers < 1){
				warningLabel.setText("There must be at least one player");
			}
			else{
				run = false;
			}
			
		}
		
	}
}

package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class Game extends Form {

	private GameWorld gameworld;
	
	public Game() {
	
		gameworld = new GameWorld();
		gameworld.init();
		play();
		
	}
	
	public void play() { 
	// code to accept commands and execute
	Label myLabel = new Label("Enter a Command: ");
	this.addComponent(myLabel);
	final TextField myTextField= new TextField(); 
	this.addComponent(myTextField);
	this.show();
	// added UI components now add a listener
	myTextField.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			String sCommand = myTextField.getText().toString();
			myTextField.clear();
			switch(sCommand.charAt(0)) {
			
			case 'a':
				gameworld.addNewAsteroid();
				break;
			case 'y':
				gameworld.addNewNps();
			case 'b':
				gameworld.addNewBlinkingStation();
			case 's':
				gameworld.addPlayerShip();
				break;
			case 'i':
				gameworld.increaseSpeedPS();
				break;
			case 'd':
				gameworld.decreaseSpeedPS();
				break;
			case 'l':
				gameworld.turnPSLeft();
				break;
			case 'r':
				gameworld.turnPSRight();
				break;
			case '>':
				gameworld.turnMissleLauncher();
				break;
			case 'f':
				gameworld.fireMisslePS();
				break;
			case 'L':
				gameworld.fireMissleNPS();
				break;
			case 'j':
				gameworld.jumpHyperspace();
				break;
			case 'n':
				gameworld.loadNewMisslesPS();
				break;
			case 'k':
				gameworld.missleStrikePStoAs();
				break;
			case 'e':
				gameworld.missleStrikePStoNPS();
				break;
			case 'E':
				gameworld.missleStrikeNPStoPS();
				break;
			case 'c':
				gameworld.crashPStoAs();
				break;
			case 'h':
				gameworld.crashPStoNPS();
				break;
			case 'x':
				gameworld.crashAstoAs();
				break;
			case 'I':
				gameworld.crashAstoNPS();
				break;
			case 't':
				gameworld.clockTicked();
				break;
			case 'p':
				gameworld.printState();
				break;
			case 'm':
				gameworld.printMap();
				break;
			case 'q':
				gameworld.quitGame();
				break;
				
			}// switch
		}// end action performed 
		
	}//new action listener
	);// add action listener
		
	}// end of play 
}

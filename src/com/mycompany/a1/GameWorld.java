package com.mycompany.a1;
import java.util.Vector;

import com.mycompany.a1.GameWorldObjects.*;
import com.mycompany.a1.MovableObject.Asteroid;
import com.mycompany.a1.MovableObject.NPShip;
public class GameWorld {

	Vector<GameObject> objectCollection = new Vector<GameObject>();
	
	private int ticks;
	private int score; 
	
	private int width = 1024;
	private int lenght = 768; 
	
	public void init() {
		score = 0; 
	}
	
	public void addNewAsteroid(){
		Asteroid asteroid = new Asteroid(); 
		objectCollection.add(asteroid);
		
		
	}
	
	public void addNewNps(){
		NPShip npship= new NPShip(); 
		objectCollection.add(npship);
	}
	
	
	public void addNewBlinkingStation(){}
	
	public void addPlayerShip(){}
	
	public void increaseSpeedPS(){}

	public void decreaseSpeedPS(){}
	
	public void turnPSLeft(){}
	
	
	public void turnPSRight(){}
	
	public void turnMissleLauncher(){}

	public void fireMisslePS(){}
	
	public void fireMissleNPS() {}
	
	public void jumpHyperspace() {}
	
	public void loadNewMisslesPS() {}
	
	public void missleStrikePStoAs() {}
	
	public void missleStrikePStoNPS() {}
	
	public void missleStrikeNPStoPS() {}
	
	public void crashPStoAs() {}

	public void crashPStoNPS() {}

	public void crashAstoAs() {}
	
	
	public void crashAstoNPS() {}
	
	public void clockTicked() {}

	public void printState() {
		
	}
	public void printMap() {
		for(GameObject obj: objectCollection) {
			System.out.println(obj.toString());
		}
	}
	public void eliminatedPsToNps(){}
	
	public void quitGame(){}
	
	
}

package com.mycompany.a1;
import java.util.Vector;

import com.mycompany.a1.FixedObject.SpaceStation;
import com.mycompany.a1.GameWorldObjects.*;
import com.mycompany.a1.MovableObject.Asteroid;
import com.mycompany.a1.MovableObject.Missile;
import com.mycompany.a1.MovableObject.MissileLauncher;
import com.mycompany.a1.MovableObject.NPShip;
import com.mycompany.a1.MovableObject.PShip;
import com.mycompany.a1.MovableObject.SteerableLauncher;
public class GameWorld {

	Vector<GameObject> objectCollection = new Vector<GameObject>();
	
	private int ticks;
	private int score; 
	
	private int width = 1024;
	private int lenght = 768; 
	
	public void init() {
		score = 0; 
	}
	public boolean PlayerShipExists() {
		boolean Exists = false;
		for(GameObject obj:objectCollection ) {
			if(obj instanceof PShip) {
				Exists = true;
			}
		}
		if(!Exists) {
			System.out.println(" PS does not exis. Enter S to create ");
		}
		return Exists; 
	}
	public boolean asteroidExists() {
		boolean Exists = false;
		for(GameObject obj:objectCollection ) {
			if(obj instanceof Asteroid) {
				Exists = true;
			}
		}
		if(!Exists) {
			System.out.println(" Asteroid does not exist. Enter command to create ");
		}
		return Exists; 
	}
	
	public boolean missileExists() {
		boolean Exists = false;
		for(GameObject obj:objectCollection ) {
			if(obj instanceof Missile) {
				Exists = true;
			}
		}
		if(!Exists) {
			System.out.println(" Missile does not exist. Enter command to create ");
		}
		return Exists; 
	}
	
	public int PSLocationInVector() {
		int x = 0; 
		for(GameObject obj:objectCollection ) {
			if(obj instanceof PShip) {
				x = objectCollection.indexOf(obj);
			}
		}
		return x; 
	}
	public int NPSLocationInVector() {
		int x = 0; 
		for(GameObject obj:objectCollection ) {
			if(obj instanceof NPShip) {
				x = objectCollection.indexOf(obj);
			}
		}
		return x; 
	}
	
	public boolean NonPlayerShipExists() {
		boolean Exists = false;
		for(GameObject obj:objectCollection ) {
			if(obj instanceof NPShip) {
				Exists = true;
			}
		}
		if(!Exists) {
			System.out.println(" NPS does not exis. Enter Y to create ");
		}
		return Exists; 
	}
	
	public void addNewAsteroid(){
		Asteroid asteroid = new Asteroid(); 
		objectCollection.add(asteroid);
		
		
	}
	
	public void addNewNps(){
		NPShip npship= new NPShip(); 
		objectCollection.add(npship);
		
		System.out.println(npship);
	}
	
	
	public void addNewBlinkingStation(){
		
		SpaceStation s = new SpaceStation();
		objectCollection.add(s); 
		System.out.println(s); 
	}
	
	public void addPlayerShip(){
		if(!PlayerShipExists()) {
			PShip ps = new PShip();
			objectCollection.add(ps); 
			System.out.println("player ship created. "); 
			System.out.println(ps);
			
			
		}else {
			System.out.println("PlaterShip already exists. Can have only 1"); 
		}
	}
	/*
	 * template for next few funcs. 
	 * if(PlayerShipExists()== true) {
	 * 
	 * }else { System.out.println(""); }
	 */

	/*
	 * template for next few funcs. for(GameObject obj:objectCollection ){ if (obj
	 * instanceof PShip){
	 * 
	 * 
	 * }else{
	 * 
	 * }
	 * 
	 * }
	 */
	public void increaseSpeedPS() {
		if (PlayerShipExists()) {
			for (GameObject obj : objectCollection) {
				if (obj instanceof PShip) {
					int speed = ((PShip) obj).getspeed();
					if (speed > 15) {

					}else if(speed>=0) {
						((PShip) obj).increaseSpeed();
						System.out.println("Speed increased");
					}
				} 
			}

		} else {
			System.out.println("ship dne");
		}
	}

	public void decreaseSpeedPS(){
		if (PlayerShipExists()) {
			for (GameObject obj : objectCollection) {
				if (obj instanceof PShip) {
					int speed = ((PShip) obj).getspeed();
					if (speed == 0) {
						System.out.println("speed is already at 0"); 
					}else if(speed<=15) {
						((PShip) obj).decreaseSpeed();
						System.out.println("Speed decreased");
					}
				} 
			}

		} else {
			System.out.println("ship dne");
		}
		
	}
	
	public void turnPSLeft(){
		if (PlayerShipExists() == true) {
			for (GameObject obj : objectCollection) {
				if (obj instanceof PShip) {
					 ((PShip) obj).changeHeading(-10);
					System.out.println("Left turn");
					
			}
			}
		} else {
			System.out.println("ship dne");
		}
	}
	
	
	public void turnPSRight(){
		if (PlayerShipExists() == true) {
			for (GameObject obj : objectCollection) {
				if (obj instanceof PShip) {
					 ((PShip) obj).changeHeading(10);
					System.out.println("right turn");
					
			}
			}
		} else {
			System.out.println("ship dne");
		}
	}
	
	public void turnMissleLauncher(){
		if (PlayerShipExists() == true) {
			for (GameObject obj : objectCollection) {
				if (obj instanceof PShip) {
					SteerableLauncher sl = ((PShip) obj).getPsMissleLauncher();
					sl.changeHeading(5);
					
			}
			}
		} else {
			System.out.println(" ship dne ");
		}
	}

	public void fireMisslePS(){
		
		if (PlayerShipExists()) {
			int i = PSLocationInVector();
			int missileCount; 
			PShip ship = (PShip) objectCollection.get(i); 
			
			missileCount = ship.getMissleCount(); 
			
			if(missileCount>0) {
				ship.setMissleCount(missileCount-1);
				SteerableLauncher sl = ship.getPsMissleLauncher();
				Missile missile = new Missile(ship.getX(),ship.getY(),ship.getHeading(),ship.getspeed());
				objectCollection.add(missile); 
				System.out.println("missle fired and added to collection");
			}else {
				System.out.println("out of missles"); 
				
			}
			
			
		} else {
			System.out.println(" ship dne ");
		}
		
	}
	
	public void fireMissleNPS() {
		if (NonPlayerShipExists()) {
			int i = NPSLocationInVector();
			int missileCount; 
			NPShip ship = (NPShip) objectCollection.get(i); 
			
			missileCount = ship.getMissleCount(); 
			
			if(missileCount>0) {
				ship.setMissleCount(missileCount-1);
				MissileLauncher sl = ship.getNPML();
				Missile missile = new Missile(ship.getX(),ship.getY(),ship.getHeading(),ship.getspeed());
				objectCollection.add(missile); 
				System.out.println("NP missle fired and added to collection");
			}else {
				System.out.println("NP out of missles"); 
				
			}
			
			
		} else {
			System.out.println(" ship dne ");
		}
	}
	
	public void jumpHyperspace() {
		int x = 512;
		int y = 384; 
		
		if (PlayerShipExists()) {
			for (GameObject obj : objectCollection) {
				if (obj instanceof PShip) {
					SteerableLauncher sl = ((PShip) obj).getPsMissleLauncher();
					//ship
					obj.setX(x);
					obj.setY(y); 
					//launcher
					sl.setX(x);
					sl.setY(y);	
				} 
			}

		} else {
			System.out.println("ship dne");
		}
		
	}
	
	public void loadNewMisslesPS() {
		if (PlayerShipExists()) {
			for (GameObject obj : objectCollection) {
				if (obj instanceof PShip) {
				((PShip) obj).setMissleCount(10);
				
				} 
			}

		} else {
			System.out.println("ship dne");
		}
	}
	
	public void missleStrikePStoAs() {
		
	}
	
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
	
	public void quitGame(){
		System.exit(0);
	}
	
	
}

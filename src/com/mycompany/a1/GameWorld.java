package com.mycompany.a1;
import java.util.Vector;

import com.mycompany.a1.FixedObject.SpaceStation;
import com.mycompany.a1.GameWorldObjects.*;
import com.mycompany.a1.Interfaces.IMovable;
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
	public boolean decrementPSLife() {
		boolean exit = false;
		int life;
		if(PlayerShipExists()) {
			for(GameObject obj:objectCollection ) {
				if(obj instanceof PShip) {
					life = ((PShip)obj).getLife(); 
				if(life>1) {
					((PShip)obj).setLife(life-1);
					return true;
				}else {
					((PShip)obj).setLife(life-1);
					exit = true; 
				}	
				
				
				}
			}
		}
		if(exit==true) {
			endGame(); 
			System.out.println("END GAME. Thanks for playing"); 
		}
		return false; 
	}
	private void endGame() {
		objectCollection.removeAllElements();
	}
	public boolean PlayerShipExists() {
		boolean Exists = false;
		for(GameObject obj:objectCollection ) {
			if(obj instanceof PShip) {
				Exists = true;
			}
		}
		if(!Exists) {
			
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
			
		}
		return Exists; 
	}
	public boolean spaceStationExists() {
		boolean Exists = false;
		for(GameObject obj:objectCollection ) {
			if(obj instanceof SpaceStation) {
				Exists = true;
			}
		}
		if(!Exists) {
			
		}
		return Exists; 
	}
	public boolean deleteMissile() {
		
		for(GameObject obj:objectCollection ) {
			if(obj instanceof Missile) {
				objectCollection.remove(obj);
				return true; 
			}
		}
		return false; 
		
	}
public boolean deletePS() {
		
		for(GameObject obj:objectCollection ) {
			if(obj instanceof PShip) {
				objectCollection.remove(obj);
				return true; 
			}
		}
		return false; 
		
	}
	public boolean deleteAsteroid() {
		
		for(GameObject obj:objectCollection ) {
			if(obj instanceof Asteroid) {
				objectCollection.remove(obj); 
				return  true;
			}
		}
		return false; 
		
	}
public boolean deleteNPS() {
		
		for(GameObject obj:objectCollection ) {
			if(obj instanceof NPShip) {
				objectCollection.remove(obj); 
				return  true;
			}
		}
		return false; 
		
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
	public int MissleLocationInVector() {
		int x = 0; 
		for(GameObject obj:objectCollection ) {
			if(obj instanceof Missile) {
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
				
			}else {
				
				
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
		if(missileExists() && asteroidExists()) {
			deleteAsteroid();
			deleteMissile();
			score+=1; 
			System.out.println("removed ast and missile");
		}else {
			
		}
	}
	
	public void missleStrikePStoNPS() {
		if(PlayerShipExists() && NonPlayerShipExists()) {
			deleteNPS(); 
			score+=8; 
			System.out.println("removed nps");
		}
	}
	
	
	public void missleStrikeNPStoPS() {
		if(PlayerShipExists() && NonPlayerShipExists()) {
			deletePS(); 
			System.out.println("removed ps");
		}
	}
	
	public void crashPStoAs() {
		if(PlayerShipExists() && asteroidExists()) {
			deletePS(); 
			deleteAsteroid(); 
			System.out.println("removed ps and asteroid");
		}
	}

	public void crashPStoNPS() {
		if(PlayerShipExists() && NonPlayerShipExists()) {
			deleteNPS(); 
			decrementPSLife();
			
			System.out.println("removed ps and asteroid");
		}
	}

	public void crashAstoAs() {
		if( asteroidExists()) {
		 
		deleteAsteroid(); 
		System.out.println("removed 1 asteroid");
	}
		if( asteroidExists()) {
			 
			deleteAsteroid(); 
			System.out.println("removed 2nd asteroid");
		}
		}
	
	
	public void crashAstoNPS() {
		if(asteroidExists() && NonPlayerShipExists()) {
			deleteNPS(); 
			deleteAsteroid(); 
			System.out.println("removed nps");
		}
	}
	
	
	public void clockTicked() {
		moveObjects();
		changeFuel(); 
		blinkSpaceStation(); 
		ticks++; 
		
	}
	public void moveObjects() {
		boolean moving = false; 
		for (GameObject obj : objectCollection) {
			if (obj instanceof IMovable) {
				((IMovable) obj).move();
				moving = true; 
			
			} 
		}
		// moving steerablemissle for PS
		if(moving = true) {
			if (PlayerShipExists() == true) {
				for (GameObject obj : objectCollection) {
					if (obj instanceof PShip) {
						SteerableLauncher sl = ((PShip) obj).getPsMissleLauncher();
						sl.setX(obj.getX());
						sl.setY(obj.getY());
				}
				}
			} else {
				System.out.println(" ship dne ");
			}
		}
		
	}
	public void changeFuel() {
		if(missileExists()) {
			Missile m = (Missile) objectCollection.get(MissleLocationInVector());
			int fuel = m.getFuel();
			if(fuel <=1) {
				objectCollection.remove(m);
			}else {
				m.setFuel(fuel-1);
			}
		}
	}
	public void blinkSpaceStation(){
		if(spaceStationExists()) {
			for (GameObject obj : objectCollection) {
				if (obj instanceof SpaceStation) {
					((SpaceStation)obj).blinkLight();
			}
			}
		}
	} 

	public void printState() {
		if(PlayerShipExists()){
			int i = PSLocationInVector();
			PShip Ship = (PShip)objectCollection.get(i); 
			int missleCount = Ship.getMissleCount();
			
			
			System.out.println(" PLAYER SHIP MISSLE COUNT: "+missleCount);
		}
		System.out.println("SCORE : "+score+" Time is at : "+ticks);
	}
	public void printMap() {
		for(GameObject obj: objectCollection) {
			System.out.println(obj.toString());
		}
	}
	
	
	public void quitGame(){
		System.exit(0);
	}
	
	
}

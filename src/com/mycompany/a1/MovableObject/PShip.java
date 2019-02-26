package com.mycompany.a1.MovableObject;

import com.mycompany.a1.Interfaces.ISteerable;

public class PShip extends Ship implements ISteerable {
	private int life; 
	private SteerableLauncher psMissleLauncher;
	
	
	public PShip() {
		super.setX(512);
		super.setY(384);
		// TODO Auto-generated constructor stub
		super.setspeed(0);
		super.setHeading(0);
		super.setMissleCount(10);
		psMissleLauncher = new SteerableLauncher(super.getX(), super.getY(), super.getHeading(), super.getspeed());
		
	}
	public void PSincreaseSpeed() {
		super.increaseSpeed();
		psMissleLauncher.increaseSpeed(); 
	}
	public void PSdecreaseSpeed() {
		super.decreaseSpeed();
		psMissleLauncher.decreaseSpeed();
	}

	public int getLife() {
		return life = 3;
	}


	public void setLife(int life) {
		this.life = life;
	}


	public SteerableLauncher getPsMissleLauncher() {
		return psMissleLauncher;
	}


	public void setPsMissleLauncher(SteerableLauncher psMissleLauncher) {
		this.psMissleLauncher = psMissleLauncher;
	}
	public void changeHeading(int heading) {
		 
		this.setHeading(this.getHeading()+ heading);
		
	}
	// same code from steerable missile launcher to turn Ship. 
	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		int heading = super.getHeading();
		if (heading-10<=0) {
			super.setHeading(heading-10+360);
		}else {
			super.setHeading(heading-10);
		}
	}
	
	@Override
	public void turnRight() {
		// TODO Auto-generated method stub
		int heading = super.getHeading();
		if (heading+10<=0) {
			super.setHeading(heading+10);
		}else {
			super.setHeading(heading+10-360);
		}// test to see if it works correctly. 
	} 
	
	public String toString() {
		String s = "";
		s += "/n Player Ship "; 
		s += super.toString();
		s += "ShipLife= "+ this.getLife();
		return s;
	}
}

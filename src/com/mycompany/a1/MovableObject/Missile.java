package com.mycompany.a1.MovableObject;

import com.codename1.charts.util.ColorUtil;
import com.mycompany.a1.GameWorldObjects.MovableObject;

public class Missile extends MovableObject{
	private int fuel; 
	
	public Missile(int x, int y, int heading, int speed) {
		super.setColor(ColorUtil.LTGRAY );
		super.setX(x);
		super.setY(y);
		super.setHeading(heading);
		super.setspeed(speed+5);
		this.setFuel(10); 

	}
	
	public int getFuel() {
		return fuel;
	}
	
	public void setFuel(int fuel ) {
		this.fuel = fuel;
	}
}

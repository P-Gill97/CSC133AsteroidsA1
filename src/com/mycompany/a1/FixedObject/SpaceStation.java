package com.mycompany.a1.FixedObject;

import com.codename1.charts.util.ColorUtil;
import com.mycompany.a1.GameWorldObjects.fixedGameObject;

public class SpaceStation extends fixedGameObject {
	private int blinkRate; 
	private int blinker ; 
	
	public SpaceStation() {
		super.setId();
		setRate(); 

		super.setColor(ColorUtil.YELLOW);
		super.setRandomXY();
	}
	public void blinkLight() {
		blinker++;
		if((blinker % this.getrate())==0) {
			super.setColor(ColorUtil.WHITE);
		}
	}
	
	private void setRate () {
		this.blinkRate = rand.nextInt(3)+1; 
		
	}
	private int getrate() {
		return this.blinkRate; 
	}
	public String toString() {
		String s = "";
		s+= "Space Station: ";
		s+= super.toString();
		s+= "Blink rate: "+ this.blinkRate; 
		return s; 
	}
}

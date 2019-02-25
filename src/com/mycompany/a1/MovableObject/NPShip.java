package com.mycompany.a1.MovableObject;

import com.codename1.charts.util.ColorUtil;

public class NPShip extends Ship{
	private int size; 
	private MissileLauncher NPML;
	
	public NPShip() {
		super.setRandomXY();
		super.setRandomSpeed();
		super.setColor(ColorUtil.MAGENTA);
		super.setRandomHeading();
		super.setMissleCount(2);
		
		
	}
	public void smallSize() {
		this.size = 10; 
	}
	public void largeSize() {
		this.size = 20; 
	}
	
}

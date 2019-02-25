package com.mycompany.a1.MovableObject;

import java.util.*;

import com.codename1.charts.util.ColorUtil;

public class NPShip extends Ship{
	private int size; 
	private MissileLauncher NPML;
	
	public NPShip() {
		
		NPML = new MissileLauncher(super.getX(), super.getY(), super.getHeading(),super.getspeed());
		super.setRandomXY();
		super.setRandomSpeed();
		super.setColor(ColorUtil.MAGENTA);
		super.setRandomHeading();
		super.setMissleCount(2);
		this.NPrandomSize();
		
		
	}
	public MissileLauncher getNPML() {
		return NPML; 
	}
	public void NPrandomSize() {
		if(rand.nextInt(10)<= 5) {
			size = 10;
		}else {
			size = 20;
		}
		
	}
	
	public String toString() {
		String s = "";
		s+= "NonPlayerShip: ";
		s+= super.toString();
		s+= "Size="+this.size;
		return s; 
		
	}
	
	
}

package com.mycompany.a1.MovableObject;

import com.mycompany.a1.GameWorldObjects.MovableObject;

public class Ship extends MovableObject{
	private int missileCount; 
	
	
	public void setMissleCount(int missle) {
		this.missileCount = missle; 
	}
	
	public int getMissleCount() {
		return this.missileCount;
	}
	
	public void maxMissleCount() {
		this.missileCount = 10; 
	}
	
	public String toString() {
		String s = "";
		s+= super.toString();
		s+= "missles = "+ this.getMissleCount(); 
		
		return s;
	}
}

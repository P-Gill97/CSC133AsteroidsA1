package com.mycompany.a1.GameWorldObjects;
import java.util.Random;
public abstract class GameObject {

	private float x=0;
	private float y=0; 
	private int color;
	protected Random rand = new Random ();
	
	public void setRandomXY() {
		float tx = 0;
		float ty = 0;
		
		
		
		tx = rand.nextFloat()*1024;
		ty = rand.nextFloat()*763; 
		
		this.x = tx;
		this.y = ty; 
		
	}

		
	public float getX() {
		return x;
	}
	public void setX(float x) {
		if(x>=0 && x<= 1024) {
		this.x = x;}
		else {
			System.out.println("x must be between 0 and 1024");
		}
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		if(y>=0 && y<= 768) {
			this.y = y;}
			else {
				System.out.println("y must be between 0 and 768");
			}
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	@Override
	public String toString() {
		
		return "Location "  + x + ", y=" + y + ", color=" + color + "]";
	} 
	
	

}

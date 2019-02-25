package com.mycompany.a1.GameWorldObjects;

import com.mycompany.a1.Interfaces.IMovable;

public abstract class MovableObject extends GameObject implements IMovable{

	private int speed;
	private int heading;
	
	
	public MovableObject() {
		this.heading = getHeading();
		
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		float newX;
		float newY;
		float dx;
		float dy; 
		
		dx = (float) Math.cos(90-this.heading);
		dy = (float) Math.sin(90-this.heading);
		newX =(float) ((Math.toDegrees(dx)*this.speed) + super.getX()); 
		newY =(float) ((Math.toDegrees(dy)*this.speed) + super.getY());
		
		super.setX(newX);
		super.setY(newY);
	
	}
	@Override
	public int getspeed() {
		
		return this.speed;
	}
	
	public int getHeading() {
		
		return this.heading;
	}
	
	
	public void setHeading( int heading) {
		
		if(heading> 360) {
			this.heading = heading - 360;
			
		}else if(heading<0) {
			this.heading =360 + heading;
			 
			
		}else {
			this.heading = heading;
		}
		
	}
	
	public void increaseSpeed() {
			if(this.speed <15&& this.speed>=0) {
				this.speed++;
			}
			else {
				System.out.print(" speed is out of range. Something went wrong");
			}
	}
	public void decreaseSpeed() {
		if(this.speed< 15 && this.speed >=0) {
			this.speed --; 
		}
	}
	@Override
	public void setspeed(int speed) {
		this.speed=speed;
	}
	
	public void setRandomSpeed() {
		this.speed = rand.nextInt(14)+1;
	}
	
	public void setRandomHeading() {
		
		this.heading = rand.nextInt(359)+1; 
	}
	public String toString() {
		String s = ""; 
		s += super.toString();
		s += "speed=" + this.getspeed(); 
		s += "heading="+this.getHeading(); 
		// maybe add new line
		return s;
	}
}

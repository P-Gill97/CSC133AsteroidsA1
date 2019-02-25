package com.mycompany.a1.GameWorldObjects;

import com.mycompany.a1.Interfaces.IMovable;

public abstract class MovableObject extends GameObject implements IMovable{

	private int speed;
	private int direction;
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getspeed() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getheading(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setspeed(int speed) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int setheading() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

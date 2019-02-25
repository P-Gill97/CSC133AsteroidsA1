package com.mycompany.a1.GameWorldObjects;

public abstract class fixedGameObject extends GameObject{
	private int id;
	private static int sid; 
	
	public int getId() {
		return this.id;
	}
	public void setId() {
		id = ++sid; // maybe try to see if incrementing after would work. 
	}
	public String toString() {
		String s = "";
		s += super.toString();
		s += " Station ID= "+ this.getId(); // new line maybe?
		
		return s;
	}
	
}

package com.mycompany.a1.MovableObject;

import com.codename1.charts.util.ColorUtil;
import com.mycompany.a1.GameWorldObjects.MovableObject;

public class MissileLauncher extends MovableObject{
	
	public MissileLauncher(int x, int y, int heading, int speed) {
		super.setColor(ColorUtil.YELLOW);
		super.setX(x);
		super.setY(y);
		this.setHeading(heading);
		this.setspeed(speed);
		
	}
	
	public String toString() {
		String s = "";
		s += super.toString();
		s += "Launcher: ";
		return s;
	}
}

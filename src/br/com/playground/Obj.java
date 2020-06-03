package br.com.playground;

import java.io.Serializable;

public class Obj implements Serializable {
	private static final long serialVersionUID = 1L;
	int x;
	String y;
	
	public int getX() {
		return x;
	}
	
	public String getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(String y) {
		this.y = y;
	}
}

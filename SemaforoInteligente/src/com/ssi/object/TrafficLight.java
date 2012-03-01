package com.ssi.object;

import java.awt.Color;

public class TrafficLight {

	private int x;
	private int y;
	private int rX;
	private int rY;
	private Color color;
	private int tiempo; /*seconds*/
	private boolean on;	
	
	public TrafficLight()
	{
		
	}

	public TrafficLight(int x, int y, int rX, int rY, Color color, int tiempo, boolean on)
	{
		this.x = x;
		this.y = y;
		this.rX = rX;
		this.rY = rY;
		this.color = color;
		this.tiempo = tiempo;
		this.on = on;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getrX() {
		return rX;
	}

	public void setrX(int rX) {
		this.rX = rX;
	}

	public int getrY() {
		return rY;
	}

	public void setrY(int rY) {
		this.rY = rY;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	public boolean isOn() {
		return on;
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}

}

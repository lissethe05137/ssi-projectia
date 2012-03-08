package com.ssi.object;

import java.awt.Image;
import java.awt.Rectangle;


public class Automovil {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private Image image;
	public enum TipoCar { RIGHT, UP, LEFT, DOWN };
	private TipoCar tipo;
	public enum TipoVehiculo { Ambulancia, Policia, Bomberos  };
	private TipoVehiculo tipoV;
	private double prioridad;
	
	public Automovil()
	{
		
	}
	
	public Automovil(int x, int y, int dx, int dy, Image image, TipoCar tipo, TipoVehiculo tipoV)
	{
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.image = image;
		this.tipo = tipo;
		this.tipoV = tipoV;
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
	
	public int getDx() {
		return dx;
	}
	
	public void setDx(int dx) {
		this.dx = dx;
	}
	
	public int getDy() {
		return dy;
	}
	
	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}

	public Rectangle getPerimetro()
	{
		if( TipoCar.RIGHT != null )
			return new Rectangle(x, y, image.getWidth(null) + 4, image.getHeight(null));
		else if( TipoCar.UP != null )
			return new Rectangle(x, y, image.getWidth(null), image.getHeight(null) - 4);
		else if( TipoCar.LEFT != null )
			return new Rectangle(x, y, image.getWidth(null) - 4, image.getHeight(null));
		else if( TipoCar.DOWN != null )
			return new Rectangle(x, y, image.getWidth(null), image.getHeight(null) + 4);
		else
			return null;
	}

	public TipoCar getTipo() {
		return tipo;
	}

	public void setTipo(TipoCar tipo) {
		this.tipo = tipo;
	}
	
	public TipoVehiculo getTipoV() {
		return tipoV;
	}
	public void setTipoV(TipoVehiculo tipoV) {
		this.tipoV = tipoV;
	}

	public double getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(double prioridad) {
		this.prioridad = prioridad;
	}
	
}

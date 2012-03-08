package com.ssi.planificacion;

public class Plan {

	String operador;
	String accion;
	String nombre;
	String Estadofinal;
	double prioridad;
	
	
	public String getEstadofinal() {
		return Estadofinal;
	}
	public void setEstadofinal(String estadofinal) {
		Estadofinal = estadofinal;
	}
	public double getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(double d) {
		this.prioridad = d;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}

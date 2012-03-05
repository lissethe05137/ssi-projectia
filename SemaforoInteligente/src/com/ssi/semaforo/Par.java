package com.ssi.semaforo;

import java.util.ArrayList;
import java.util.List;

public class Par {
	List<Semaforo> lista = new ArrayList<Semaforo>();
	Semaforo[] semaforo = new Semaforo[4];
	
	public List<Semaforo> getLista() {
		return lista;
	}
	public void setLista(List<Semaforo> lista) {
		this.lista = lista;
	}
	public Semaforo[] getSemaforo() {
		return semaforo;
	}
	public void setSemaforo(Semaforo[] semaforo) {
		this.semaforo = semaforo;
	}

}

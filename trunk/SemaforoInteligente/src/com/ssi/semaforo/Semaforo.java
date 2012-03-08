package com.ssi.semaforo;

/**
 * 
 * @author Jose Perez
 *
 *		Julio Muchacho
 *		Fernando Osuna
 *		Antonio López
 */

public class Semaforo {
	
	private String nombre; //nombre semaforo
    private int peso1;
    private int peso2;
    private int peso3;
    private int cce; //cantidad de carros esperados.
    private int cca; //cantidad de carros actual.
    private int ta; //Tiempo actual de espera
    private int tev; //Tiempo de luz verde Esperado
    private int timeVerdeV; //Tiempo verde "Verdadero"
    private int numSemaforo;
    private String colorLuz; 
    private int prioridadVehOf;
	
    public Semaforo()
    {
    	
    }
    
    public Semaforo(String nombre, int peso1, int peso2, int peso3, int cce, int cca, int ta, int tev, int numSemaforo)
    {
        this.nombre = nombre;
        this.peso1 = peso1;
        this.peso2 = peso2;
        this.peso3 = peso3;
        this.cce = cce;
        this.cca = cca;
        this.ta = ta;
        this.tev = tev;
        this.numSemaforo = numSemaforo;
      //  this.colorLuz = color;
    }
    
    public Semaforo(Semaforo semaforo){
        this.nombre = semaforo.nombre;
        this.peso1 = semaforo.peso1;
        this.peso2 = semaforo.peso2;
        this.peso3 = semaforo.peso3;
        this.cce = semaforo.cce;
        this.cca = semaforo.cca;
        this.ta = semaforo.ta;
        this.tev = semaforo.tev;
        this.numSemaforo = semaforo.numSemaforo;
    }
    
    public String getNombre() {
		return nombre;
	}
    
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPeso1() {
		return peso1;
	}
	
	public void setPeso1(int peso1) {
		this.peso1 = peso1;
	}
	
	public int getPeso2() {
		return peso2;
	}
	
	public void setPeso2(int peso2) {
		this.peso2 = peso2;
	}
	
	public int getPeso3() {
		return peso3;
	}
	
	public void setPeso3(int peso3) {
		this.peso3 = peso3;
	}
	
	public int getCce() {
		return cce;
	}
	
	public void setCce(int cce) {
		this.cce = cce;
	}
	
	public int getCca() {
		return cca;
	}
	
	public void setCca(int cca) {
		this.cca = cca;
	}
	
	public int getTa() {
		return ta;
	}
	
	public void setTa(int ta) {
		this.ta = ta;
	}
	
	public int getTev() {
		return tev;
	}
	
	public void setTev(int tev) {
		this.tev = tev;
	}
	
	public int getTimeVerdeV() {
		return timeVerdeV;
	}
	
	public void setTimeVerdeV(int timeVerdeV) {
		this.timeVerdeV = timeVerdeV;
	}
	
	public int funcionUtilidad()
	{
		return peso1*cce + peso2*cca + peso3*ta;
	}
	
	public int funcionTiempoVerde()
	{
	    return tev -( ((cce-cca)/cce)*tev );
	}

	public int getNumSemaforo() {
		return numSemaforo;
	}

	public void setNumSemaforo(int numSemaforo) {
		this.numSemaforo = numSemaforo;
	}

	public String getColorLuz() {
		return colorLuz;
	}

	public void setColorLuz(String colorLuz) {
		this.colorLuz = colorLuz;
	}

	public int getPrioridadVehOf() {
		return prioridadVehOf;
	}

	public void setPrioridadVehOf(int prioridad) {
		this.prioridadVehOf = prioridad;
	}
	

}

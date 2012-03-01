package com.ssi.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.ssi.object.Automovil;
import com.ssi.object.TrafficLight;
import com.ssi.semaforo.Algoritmo;
import com.ssi.semaforo.Semaforo;

public class SimulationPanel extends JPanel{

	private int ancho;
	private int alto;

	private List<Semaforo> listSecuencia = new ArrayList<Semaforo>();

	private List<TrafficLight> listSemaforo1 = new ArrayList<TrafficLight>();
	private List<TrafficLight> listSemaforo2 = new ArrayList<TrafficLight>();
	private List<TrafficLight> listSemaforo3 = new ArrayList<TrafficLight>();
	private List<TrafficLight> listSemaforo4 = new ArrayList<TrafficLight>();

	private int secuenciaColor1 = 1;
	private int secuenciaColor2 = 1;
	private int secuenciaColor3 = 1;
	private int secuenciaColor4 = 1;

	private int secuenciaSemaforo = 0;

	private Timer time = new Timer(1000, new TimeListener());

	private int tiempo1 = 0;
	private int tiempo2 = 0;
	private int tiempo3 = 0;
	private int tiempo4 = 0;

	private int iterator = 0;

	private int tam;

	private Automovil vehiculo1, vehiculo12, vehiculo2, vehiculo3, vehiculo4;
	private int xInicial, x12Inicial, x2Inicial, x3Inicial, x4Inicial;
	private int yInicial, y12Inicial, y2Inicial, y3Inicial, y4Inicial;

	private Rectangle rectVehiculo1;
	private Rectangle rectVehiculo12;


	public SimulationPanel() 
	{
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		ancho = d.width;
		alto = d.height;

		Algoritmo algoritmo = new Algoritmo();
		listSecuencia = algoritmo.algoritmoBusqueda();

		tam = listSecuencia.size();

		initSemaforo();
		initVehiculo();
		initBotonera();
	}

	public void initSemaforo()
	{
		if( listSecuencia.get(0).getNombre().equals("Semaforo 1") ) {
			initSemaforoState1(Color.GREEN, Color.BLACK, listSecuencia.get(0).getTimeVerdeV(), true);
			initSemaforoState2(Color.BLACK, Color.RED, 0, false);
			initSemaforoState3(Color.BLACK, Color.RED, 0, false);
			initSemaforoState4(Color.BLACK, Color.RED, 0, false);
			secuenciaSemaforo = 1;
		}
		else if( listSecuencia.get(0).getNombre().equals("Semaforo 2") )
		{
			initSemaforoState1(Color.BLACK, Color.RED, 0, false);
			initSemaforoState2(Color.GREEN, Color.BLACK, listSecuencia.get(0).getTimeVerdeV(), true);
			initSemaforoState3(Color.BLACK, Color.RED, 0, false);
			initSemaforoState4(Color.BLACK, Color.RED, 0, false);
			secuenciaSemaforo = 2;
		}
		else if( listSecuencia.get(0).getNombre().equals("Semaforo 3") )
		{
			initSemaforoState1(Color.BLACK, Color.RED, 0, false);
			initSemaforoState2(Color.BLACK, Color.RED, 0, false);
			initSemaforoState3(Color.GREEN, Color.BLACK, listSecuencia.get(0).getTimeVerdeV(), true);
			initSemaforoState4(Color.BLACK, Color.RED, 0, false);
			secuenciaSemaforo = 3;
		}
		else if( listSecuencia.get(0).getNombre().equals("Semaforo 4") )
		{
			initSemaforoState1(Color.BLACK, Color.RED, 0, false);
			initSemaforoState2(Color.BLACK, Color.RED, 0, false);
			initSemaforoState3(Color.BLACK, Color.RED, 0, false);
			initSemaforoState4(Color.GREEN, Color.BLACK, listSecuencia.get(0).getTimeVerdeV(), true);
			secuenciaSemaforo = 4;
		}
	}

	public void initSemaforoState1( Color colorLight1, Color colorLight2, int tiempo, boolean on )
	{

		TrafficLight greenLight, orangeLight, redLight;
		//Semaforo 1
		greenLight = new TrafficLight();
		greenLight.setX(315);
		greenLight.setY(615);
		greenLight.setrX(55);
		greenLight.setrY(55);
		greenLight.setColor(colorLight1);
		greenLight.setTiempo(tiempo);
		listSemaforo1.add(greenLight);

		orangeLight = new TrafficLight();
		orangeLight.setX(315);
		orangeLight.setY(555);
		orangeLight.setrX(55);
		orangeLight.setrY(55);
		orangeLight.setColor(Color.BLACK);
		orangeLight.setTiempo(3);
		listSemaforo1.add(orangeLight);

		redLight = new TrafficLight();
		redLight.setX(315);
		redLight.setY(495);
		redLight.setrX(55);
		redLight.setrY(55);
		redLight.setColor(colorLight2);
		redLight.setOn(on);
		redLight.setTiempo(0);
		listSemaforo1.add(redLight);
	}

	public void initSemaforoState2( Color colorLight1, Color colorLight2, int tiempo, boolean on )
	{

		TrafficLight greenLight, orangeLight, redLight;
		//Semaforo 2
		greenLight = new TrafficLight();
		greenLight.setX(795);
		greenLight.setY(465);
		greenLight.setColor(colorLight1);
		greenLight.setrX(55);
		greenLight.setrY(55);
		greenLight.setTiempo(tiempo);
		listSemaforo2.add(greenLight);

		orangeLight = new TrafficLight();
		orangeLight.setX(735);
		orangeLight.setY(465);
		orangeLight.setColor(Color.BLACK);
		orangeLight.setrX(55);
		orangeLight.setrY(55);
		orangeLight.setTiempo(3);
		listSemaforo2.add(orangeLight);

		redLight = new TrafficLight();
		redLight.setX(675);
		redLight.setY(465);
		redLight.setColor(colorLight2);
		redLight.setrX(55);
		redLight.setrY(55);
		redLight.setOn(on);
		redLight.setTiempo(0);
		listSemaforo2.add(redLight);
	}

	public void initSemaforoState3( Color colorLight1, Color colorLight2, int tiempo, boolean on )
	{	

		TrafficLight greenLight, orangeLight, redLight;
		//Semaforo 3
		greenLight = new TrafficLight();
		greenLight.setX(648);
		greenLight.setY(45);
		greenLight.setColor(colorLight1);
		greenLight.setrX(55);
		greenLight.setrY(55);
		greenLight.setTiempo(tiempo);
		listSemaforo3.add(greenLight);

		orangeLight = new TrafficLight();
		orangeLight.setX(648);
		orangeLight.setY(105);
		orangeLight.setColor(Color.BLACK);
		orangeLight.setrX(55);
		orangeLight.setrY(55);
		orangeLight.setTiempo(3);
		listSemaforo3.add(orangeLight);

		redLight = new TrafficLight();
		redLight.setX(648);
		redLight.setY(165);
		redLight.setColor(colorLight2);
		redLight.setrX(55);
		redLight.setrY(55);
		redLight.setOn(on);
		redLight.setTiempo(0);
		listSemaforo3.add(redLight);
	}

	public void initSemaforoState4( Color colorLight1, Color colorLight2, int tiempo, boolean on )
	{

		TrafficLight greenLight, orangeLight, redLight;
		//Semaforo 4
		greenLight = new TrafficLight();
		greenLight.setX(170);
		greenLight.setY(192);
		greenLight.setColor(colorLight1);
		greenLight.setrX(55);
		greenLight.setrY(55);
		greenLight.setTiempo(tiempo);
		listSemaforo4.add(greenLight);

		orangeLight = new TrafficLight();
		orangeLight.setX(230);
		orangeLight.setY(192);
		orangeLight.setColor(Color.BLACK);
		orangeLight.setrX(55);
		orangeLight.setrY(55);
		orangeLight.setTiempo(3);
		listSemaforo4.add(orangeLight);

		redLight = new TrafficLight();
		redLight.setX(290);
		redLight.setY(192);
		redLight.setColor(colorLight2);
		redLight.setrX(55);
		redLight.setrY(55);
		redLight.setOn(on);
		redLight.setTiempo(0);
		listSemaforo4.add(redLight);
	}

	public void initVehiculo()
	{
		xInicial = -50;
		yInicial = 362;

		vehiculo1 = new Automovil();
		vehiculo1.setX(xInicial);
		vehiculo1.setY(yInicial);
		vehiculo1.setDx(1);
		vehiculo1.setImage(new ImageIcon(getClass().getResource("../images/CarroRight.png")).getImage());
		vehiculo1.setTipo(Automovil.TipoCar.RIGHT);

		x12Inicial = -200;
		y12Inicial = 362;

		vehiculo12 = new Automovil();
		vehiculo12.setX(x12Inicial);
		vehiculo12.setY(y12Inicial);
		vehiculo12.setDx(1);
		vehiculo12.setImage(new ImageIcon(getClass().getResource("../images/CarroRight.png")).getImage());
		vehiculo12.setTipo(Automovil.TipoCar.RIGHT);

		
		x2Inicial = 525;
		y2Inicial = alto - 100;

	    vehiculo2 = new Automovil();
	    vehiculo2.setX(x2Inicial);
	    vehiculo2.setY(y2Inicial);
	    vehiculo2.setDx(1);
	    vehiculo2.setDy(1);
	    vehiculo2.setImage(new ImageIcon(getClass().getResource("../images/CarroUp.png")).getImage());
		vehiculo2.setTipo(Automovil.TipoCar.UP);

	    x3Inicial = ancho;
	    y3Inicial = 280;

	    vehiculo3 = new Automovil();
	    vehiculo3.setX(x3Inicial);
	    vehiculo3.setY(y3Inicial);
	    vehiculo3.setDx(1);
	    vehiculo3.setDy(1);
	    vehiculo3.setImage(new ImageIcon(getClass().getResource("../images/CarroLeft.png")).getImage());
		vehiculo3.setTipo(Automovil.TipoCar.LEFT);

	    x4Inicial = 420;
	    y4Inicial = -50;

	    vehiculo4 = new Automovil();
	    vehiculo4.setX(x4Inicial);
	    vehiculo4.setY(y4Inicial);
	    vehiculo4.setDx(1);
	    vehiculo4.setDy(1);
	    vehiculo4.setImage(new ImageIcon(getClass().getResource("../images/CarroDown.png")).getImage());
		vehiculo4.setTipo(Automovil.TipoCar.DOWN);
		
	}

	public void initBotonera()
	{

	    
	}

	public void paint(Graphics g)
	{
		Image imageFondo = new ImageIcon(getClass().getResource("../images/fondo.png")).getImage();

		g.drawImage(imageFondo, 0, 0, getWidth(), getHeight(), this);

		for( int i = 0; i < 3; i++ )
		{
			g.setColor(listSemaforo1.get(i).getColor());
			g.fillOval(listSemaforo1.get(i).getX(), listSemaforo1.get(i).getY(), //
					listSemaforo1.get(i).getrX(), listSemaforo1.get(i).getrY());

			g.setColor(listSemaforo2.get(i).getColor());
			g.fillOval(listSemaforo2.get(i).getX(), listSemaforo2.get(i).getY(), //
					listSemaforo2.get(i).getrX(), listSemaforo2.get(i).getrY());

			g.setColor(listSemaforo3.get(i).getColor());
			g.fillOval(listSemaforo3.get(i).getX(), listSemaforo3.get(i).getY(), //
					listSemaforo3.get(i).getrX(), listSemaforo3.get(i).getrY());

			g.setColor(listSemaforo4.get(i).getColor());
			g.fillOval(listSemaforo4.get(i).getX(), listSemaforo4.get(i).getY(), //
					listSemaforo4.get(i).getrX(), listSemaforo4.get(i).getrY());
		}

		g.drawImage(vehiculo1.getImage(), vehiculo1.getX(), vehiculo1.getY(), this);
		g.drawImage(vehiculo12.getImage(), vehiculo12.getX(), vehiculo12.getY(), this);
		g.drawImage(vehiculo2.getImage(), vehiculo2.getX(), vehiculo2.getY(), this);
		g.drawImage(vehiculo3.getImage(), vehiculo3.getX(), vehiculo3.getY(), this);
		g.drawImage(vehiculo4.getImage(), vehiculo4.getX(), vehiculo4.getY(), this);
		
		
		//		if( listBotonera1.get(0).isPulsado() ) { 
		//			g.drawRect(1,1/*listBotonera1.get(0).getX(), listBotonera1.get(0).getY()*/, //
		//					   listBotonera1.get(0).getAncho(), listBotonera1.get(0).getAlto());
		//		}else { 
		//			g.drawRect(-1,-1/*-listBotonera1.get(0).getX(), -listBotonera1.get(0).getY()*/, //
		//						listBotonera1.get(0).getAncho(), listBotonera1.get(0).getAlto());
		//		}

		//		g.drawImage(listBotonera1.get(0).getImageBoton(), listBotonera1.get(0).getX(), //
		//					listBotonera1.get(0).getY(), this);





		//		super.paint(g);

		sincronizarSemaforo();

		logicCarSemaforo1();
		logicCarSemaforo2();
		logicCarSemaforo3();
		logicCarSemaforo4();
	}

	public void changeColor(List<TrafficLight> listLight, Color color1, Color color2, Color color3)
	{
		listLight.get(0).setColor(color1);
		listLight.get(1).setColor(color2);
		listLight.get(2).setColor(color3);
	}

	public void sincronizarSemaforo()
	{
		time.start();

		if( iterator < tam ) {

			// Semaforo 1
			if( secuenciaSemaforo == 1 ) {

				if( (secuenciaColor1 == 1) && (tiempo1 == listSemaforo1.get(2).getTiempo()) ) {
					changeColor(listSemaforo1, Color.GREEN, Color.BLACK, Color.BLACK);	
					tiempo1 = 0;
					secuenciaColor1 = 2;
				}
				else if( (secuenciaColor1 == 2) && (tiempo1 == listSecuencia.get(iterator).getTimeVerdeV()) ) {
					changeColor(listSemaforo1, Color.BLACK, new Color(255,128,0), Color.BLACK);
					tiempo1 = 0;
					secuenciaColor1 = 3;
					listSemaforo1.get(2).setOn(false);
					iterator++;
				}
				else if( (secuenciaColor1 == 3) && (tiempo1 == listSemaforo1.get(1).getTiempo()) ) {
					changeColor(listSemaforo1, Color.BLACK, Color.BLACK, Color.RED);
					tiempo1 = 0;
					secuenciaColor1 = 1;
					secuenciaSemaforo = listSecuencia.get(iterator).getNumSemaforo();
					tiempo2 = listSemaforo2.get(2).getTiempo();
					listSemaforo1.get(2).setOn(false);
					secuenciaSemaforoOn(secuenciaSemaforo);

				}

			}
			// Semaforo 2
			else if( secuenciaSemaforo == 2 ) {

				if( (secuenciaColor2 == 1) && (tiempo2 == listSemaforo2.get(2).getTiempo()) ) {
					changeColor(listSemaforo2, Color.GREEN, Color.BLACK, Color.BLACK);
					tiempo2 = 0;
					secuenciaColor2 = 2;
				}
				else if( (secuenciaColor2 == 2) && (tiempo2 == listSecuencia.get(iterator).getTimeVerdeV()) ) {
					changeColor(listSemaforo2, Color.BLACK, new Color(255,128,0), Color.BLACK);
					tiempo2 = 0;
					secuenciaColor2 = 3;
					listSemaforo2.get(2).setOn(false);
					iterator++;
				}
				else if( (secuenciaColor2 == 3) && (tiempo2 == listSemaforo2.get(1).getTiempo()) ) {
					changeColor(listSemaforo2, Color.BLACK, Color.BLACK, Color.RED);
					tiempo2 = 0;
					secuenciaColor2 = 1;
					secuenciaSemaforo = listSecuencia.get(iterator).getNumSemaforo();
					tiempo3 = listSemaforo3.get(2).getTiempo();
					listSemaforo2.get(2).setOn(false);
					secuenciaSemaforoOn(secuenciaSemaforo);
				}

			}
			// Semaforo 3
			else if( secuenciaSemaforo == 3 ) {

				if( (secuenciaColor3 == 1) && (tiempo3 == listSemaforo3.get(2).getTiempo()) ) {
					changeColor(listSemaforo3, Color.GREEN, Color.BLACK, Color.BLACK);
					tiempo3 = 0;
					secuenciaColor3 = 2;
				}
				else if( (secuenciaColor3 == 2) && (tiempo3 == listSecuencia.get(iterator).getTimeVerdeV()) ) {
					changeColor(listSemaforo3, Color.BLACK, new Color(255,128,0), Color.BLACK);
					tiempo3 = 0;
					secuenciaColor3 = 3;
					listSemaforo3.get(2).setOn(false);
					iterator++;
				}
				else if( (secuenciaColor3 == 3) && (tiempo3 == listSemaforo3.get(1).getTiempo()) ) {
					changeColor(listSemaforo3, Color.BLACK, Color.BLACK, Color.RED);
					tiempo3 = 0;
					secuenciaColor3 = 1;
					secuenciaSemaforo = listSecuencia.get(iterator).getNumSemaforo();
					tiempo4 = listSemaforo4.get(2).getTiempo();
					listSemaforo3.get(2).setOn(false);
					secuenciaSemaforoOn(secuenciaSemaforo);
				}

			}
			// Semaforo 4
			else if( secuenciaSemaforo == 4 ) {

				if( (secuenciaColor4 == 1) && (tiempo4 == listSemaforo4.get(2).getTiempo()) ) {
					changeColor(listSemaforo4, Color.GREEN, Color.BLACK, Color.BLACK);
					tiempo4 = 0;
					secuenciaColor4 = 2;
				}
				else if( (secuenciaColor4 == 2) && (tiempo4 == listSecuencia.get(iterator).getTimeVerdeV()) ) {
					changeColor(listSemaforo4, Color.BLACK, new Color(255,128,0), Color.BLACK);
					tiempo4 = 0;
					secuenciaColor4 = 3;
					listSemaforo4.get(2).setOn(false);
					iterator++;
				}
				else if( (secuenciaColor4 == 3) && (tiempo4 == listSemaforo4.get(1).getTiempo()) ) {
					changeColor(listSemaforo4, Color.BLACK, Color.BLACK, Color.RED);
					tiempo4 = 0;
					secuenciaColor4 = 1;
					secuenciaSemaforo = listSecuencia.get(iterator).getNumSemaforo();
					tiempo1 = listSemaforo1.get(2).getTiempo();
					listSemaforo4.get(2).setOn(false);
					secuenciaSemaforoOn(secuenciaSemaforo);
				}

			}
		}
		else {
			iterator = 0;
		}


		repaint();	
	}

	public void secuenciaSemaforoOn(int secuenciaSemaforo)
	{
		if( secuenciaSemaforo == 1 )
			listSemaforo1.get(2).setOn(true);
		else if( secuenciaSemaforo == 2 )
			listSemaforo2.get(2).setOn(true);	
		else if( secuenciaSemaforo == 3 )
			listSemaforo3.get(2).setOn(true);
		else if( secuenciaSemaforo == 4 )
			listSemaforo4.get(2).setOn(true);
	}

	public void logicCarSemaforo1()
	{
		int x = vehiculo1.getX();
		int x12 = vehiculo12.getX();

		if( vehiculo1.getX() > ancho )
			x = xInicial;

		if( (listSemaforo1.get(2).isOn() == false) && (vehiculo1.getX() == 305) )
			vehiculo1.setImage(vehiculo1.getImage());
		else
			vehiculo1.setX( x + vehiculo1.getDx() );


		if( vehiculo12.getX() > ancho )
			x12 = x12Inicial;

		if( (listSemaforo1.get(2).isOn() == false) && (vehiculo12.getX() == 305) )
			vehiculo12.setImage(vehiculo12.getImage());
		else
			vehiculo12.setX( x12 + vehiculo12.getDx() );

		rectVehiculo1 = vehiculo1.getPerimetro();
		rectVehiculo12 = vehiculo12.getPerimetro();

		if( (rectVehiculo12.intersects(rectVehiculo1) ) ) {
			vehiculo12.setImage(vehiculo12.getImage());
			vehiculo12.setX(x12);
		}

		if( rectVehiculo1.intersects(rectVehiculo12) ) {
			vehiculo1.setImage(vehiculo1.getImage());
			vehiculo1.setX(x);
		}

		repaint();
	}
	
	public void logicCarSemaforo2()
	{
	    int x2, y2;

	    x2 = vehiculo2.getX();
	    y2 = vehiculo2.getY();

	    if( vehiculo2.getX() < 0 || vehiculo2.getX() > ancho )
	        x2 = x2Inicial;

	    if( vehiculo2.getY() < 0 )
	        y2 = y2Inicial;

	    if( (vehiculo2.getY() == 480) && (listSemaforo2.get(2).isOn() == false) )
	    {
	        vehiculo2.setImage(vehiculo2.getImage());

	    }else
	        vehiculo2.setY( y2 - vehiculo2.getDy() );
	
	    repaint();
	}

	public void logicCarSemaforo3()
	{
	    int x3, y3;

	    x3 = vehiculo3.getX();
	    y3 = vehiculo3.getY();

	    if( vehiculo3.getX() < 0 )
	        x3 = x3Inicial;

	    if( vehiculo3.getY() < 0 || vehiculo3.getY() > alto )
	        y3 = y3Inicial;

	    if( (vehiculo3.getX() == 665) && (listSemaforo3.get(2).isOn() == false) )
	    {
	        vehiculo3.setImage(vehiculo3.getImage());

	    }else
	        vehiculo3.setX( x3 - vehiculo3.getDx() );
	
	    repaint();
	}

	public void logicCarSemaforo4()
	{
	    int x4, y4;

	    x4 = vehiculo4.getX();
	    y4 = vehiculo4.getY();

	    if( vehiculo4.getX() < 0 || vehiculo4.getX() > ancho )
	        x4 = x4Inicial;

	    if( vehiculo4.getY() > alto )
	        y4 = y4Inicial;

	    if( (vehiculo4.getY() == 175) && (listSemaforo4.get(2).isOn() == false) )
	    {
	        vehiculo4.setImage(vehiculo4.getImage());

	    }else
	        vehiculo4.setY( y4 + vehiculo4.getDy() );

	    repaint();
	}

	// Clase actionListener Timer
	class TimeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if( secuenciaSemaforo == 1 ) 
				tiempo1++; 
			else if( secuenciaSemaforo == 2 )
				tiempo2++; 
			else if( secuenciaSemaforo == 3 )
				tiempo3++; 
			else if( secuenciaSemaforo == 4 )
				tiempo4++; 
		}
	}

}
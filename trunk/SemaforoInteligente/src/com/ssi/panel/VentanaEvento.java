package com.ssi.panel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaEvento extends JFrame {
	
	
	
	public VentanaEvento(){
		super("Evento");
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		GridLayout grid = new GridLayout(6, 2);
		
		//this.setLayout(grid);
		Container contenedor = new Container();
		contenedor = getContentPane();
		contenedor.setLayout(grid);
		//this.setSize(200, 150);
		contenedor.add(new JLabel("Evento: "));
		
		String[] listEvento = {"Incendio","Accidente","Evento Publico","Disturbio"};

		JComboBox boxEvent = new JComboBox(listEvento);
		boxEvent.setSelectedIndex(0);
		this.add(boxEvent);
		
		this.add(new JLabel("Semaforo 1: "));
		String[] listVehiculo = {" ","Ambulancia","Bombero","Policia","Funcionario"};

		boxEvent = new JComboBox(listVehiculo);
		boxEvent.setSelectedIndex(0);
		this.add(boxEvent);

		this.add(new JLabel("Semaforo 2: "));
		
		boxEvent = new JComboBox(listVehiculo);
		boxEvent.setSelectedIndex(0);
		this.add(boxEvent);
		
		this.add(new JLabel("Semaforo 3: "));
		
		boxEvent = new JComboBox(listVehiculo);
		boxEvent.setSelectedIndex(0);
		this.add(boxEvent);
		
		this.add(new JLabel("Semaforo 4: "));
		
		boxEvent = new JComboBox(listVehiculo);
		boxEvent.setSelectedIndex(0);
		this.add(boxEvent);
		
		
		
		this.add(cancelar);
		this.add(aceptar);
		
		
		
		this.setLocation(75, 82);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
	}

}

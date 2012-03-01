package com.ssi.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.ssi.panel.SimulationPanel;
import com.ssi.semaforo.Semaforo;

public class Main {

	private static List<Semaforo> listSecuencia = new ArrayList<Semaforo>();

	public static void main( String argv[] )
	{
//		Algoritmo algoritmo = new Algoritmo();
//		listSecuencia = algoritmo.algoritmoBusqueda();
//		
//		System.out.println( "\n\n\n" );
//		for( int i = 0; i < listSecuencia.size(); i++ )
//			System.out.println( listSecuencia.get(i).getNombre() + " -> " + listSecuencia.get(i).getTimeVerdeV() );
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame v = new JFrame();
		v.setSize(d.width, d.height);
//		v.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		SimulationPanel simulationPanel = new SimulationPanel();
		
		v.getContentPane().add(simulationPanel);
		v.add(simulationPanel, BorderLayout.CENTER); 
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        v.setVisible(true);
		
	}

}

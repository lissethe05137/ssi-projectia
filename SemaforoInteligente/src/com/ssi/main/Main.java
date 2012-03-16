package com.ssi.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import com.ssi.panel.SimulationPanel;
import com.ssi.panel.VentanaEvento;

public class Main extends JFrame{

	private JMenuBar barra;
	private JMenu archivo,ayuda;
	private JMenuItem evento,salir,creditos,help;
	
	
	public Main() {
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setSize(d.width, d.height);
		
		this.getContentPane().add(new SimulationPanel());
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		barra = new JMenuBar();
		archivo = new JMenu("Archivo");
		ayuda = new JMenu("Ayuda");
		barra.add(archivo);
		barra.add(ayuda);
		evento = new JMenuItem("Iniciar Evento");
		salir = new JMenuItem("Salir");
		archivo.add(evento);
		archivo.add(salir);
		help = new JMenuItem("Ayuda");
		creditos = new JMenuItem("Creditos");
		ayuda.add(help);
		ayuda.add(creditos);
		
		this.setJMenuBar(barra);
		
		evento.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				VentanaEvento ve = new VentanaEvento();
			}
		});
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
	}
	
	public static void main( String argv[] )
	{
		new Main();	
	}

}

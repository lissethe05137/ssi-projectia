package ui;


import javax.print.attribute.Size2DSyntax;
import javax.swing.*;
import javax.tools.ForwardingFileObject;

import xfuzzy.Prioridadv;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Dimension2D;


public class Interfaz extends JPanel implements ItemListener{
	
	double val;
	JRadioButton ambulancia;
	JRadioButton bombero;
	JRadioButton policia;
	JRadioButton funcionario;
	JSlider sliderEvI = new JSlider(0,60);
	JSlider sliderEvA = new JSlider(0,60);
    JSlider sliderEvD = new JSlider(0,60);
    JSlider sliderEvF = new JSlider(0,60);
    JLabel prioridadI = new JLabel();
    JLabel prioridadA = new JLabel();
    JLabel prioridadD = new JLabel();
    JLabel prioridadF = new JLabel();
    double[] prioridad;

	public Interfaz(){
		
		
		ambulancia = new JRadioButton("Ambulancia");
		ambulancia.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				val = 2;

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		bombero = new JRadioButton("Bombero");
		bombero.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				val = 5;

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		policia = new JRadioButton("Policia");
		policia.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				val = 8;

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		funcionario = new JRadioButton("Funcionario");
		funcionario.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				val = 11;

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		ButtonGroup vehiculos = new ButtonGroup(); 
		vehiculos.add(ambulancia);
		vehiculos.add(bombero);
		vehiculos.add(policia);
		vehiculos.add(funcionario);
		
        GridBagLayout gridPanelVehiculo = new GridBagLayout();
        GridBagConstraints gridPanelConstraintsVehiculo = new GridBagConstraints();
        gridPanelConstraintsVehiculo.gridx = 0;
        gridPanelConstraintsVehiculo.gridy = 0;
        this.setLayout(gridPanelVehiculo);
        this.add(new JLabel("Vehiculo : "),gridPanelConstraintsVehiculo);
        gridPanelConstraintsVehiculo.gridx = 1;
        gridPanelConstraintsVehiculo.gridy = 0;
        this.add(ambulancia,gridPanelConstraintsVehiculo);
        gridPanelConstraintsVehiculo.gridx = 2;
        gridPanelConstraintsVehiculo.gridy = 0;
        this.add(bombero,gridPanelConstraintsVehiculo);
        gridPanelConstraintsVehiculo.gridx = 3;
        gridPanelConstraintsVehiculo.gridy = 0;
        this.add(policia,gridPanelConstraintsVehiculo);
        gridPanelConstraintsVehiculo.gridx = 3;
        gridPanelConstraintsVehiculo.gridy = 0;
        this.add(funcionario,gridPanelConstraintsVehiculo);

        
        JButton botoncalcular = new JButton("Calcular");
        this.add(botoncalcular);
        botoncalcular.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double [] variables = new double[5];
				variables[0] = val;
				variables[1] = sliderEvI.getValue();
				variables[2] = sliderEvA.getValue();
				variables[3] = sliderEvD.getValue();
				variables[4] = sliderEvF.getValue();
				Prioridadv rai = new Prioridadv();
				prioridad = rai.crispInference(variables);
				for(int x=0;x<4;x++){
					System.out.println(prioridad[x]);
				}
				
				
					prioridadI.setText(Double.toString(prioridad[0]));
					prioridadA.setText(Double.toString(prioridad[1]));
					prioridadD.setText(Double.toString(prioridad[2]));
					prioridadF.setText(Double.toString(prioridad[3]));

			}
		});
        
        sliderEvD.setMajorTickSpacing( 10 );
        sliderEvD.setMinorTickSpacing(5);
        sliderEvD.setPaintTicks(true);
        sliderEvD.setPaintLabels(true);
        
        sliderEvI.setMajorTickSpacing(10);
        sliderEvI.setMinorTickSpacing(5);
        sliderEvI.setPaintTicks(true);
        sliderEvI.setPaintLabels(true);

        sliderEvA.setMajorTickSpacing(10);
        sliderEvA.setMinorTickSpacing(5);
        sliderEvA.setPaintTicks(true);
        sliderEvA.setPaintLabels(true);
        
        sliderEvF.setMajorTickSpacing(10);
        sliderEvF.setMinorTickSpacing(5);
        sliderEvF.setPaintTicks(true);
        sliderEvF.setPaintLabels(true);
        
        
        GridBagLayout gridPanelEventos = new GridBagLayout();
        GridBagConstraints gridPanelConstraintsEventos = new GridBagConstraints();
        this.setLayout(gridPanelEventos);
        
        gridPanelConstraintsEventos.gridx = 0;
        gridPanelConstraintsEventos.gridy = 1;
        this.add(new JLabel("Incendio:"),gridPanelConstraintsEventos);
        
        gridPanelConstraintsEventos.gridx = 1;
        gridPanelConstraintsEventos.gridy = 1;
        this.add(sliderEvI, gridPanelConstraintsEventos);
        
        gridPanelConstraintsVehiculo.gridx = 2;
        gridPanelConstraintsVehiculo.gridy = 1;
        this.add(new JLabel("PrioridadI: "),gridPanelConstraintsVehiculo);
        gridPanelConstraintsVehiculo.gridx = 3;
        gridPanelConstraintsVehiculo.gridy = 1;
        this.add(prioridadI,gridPanelConstraintsVehiculo);
        
        gridPanelConstraintsEventos.gridx = 0;
        gridPanelConstraintsEventos.gridy = 2;
        this.add(new JLabel("Accidente:"),gridPanelConstraintsEventos);
        
        gridPanelConstraintsEventos.gridx = 1;
        gridPanelConstraintsEventos.gridy = 2;
        this.add(sliderEvA, gridPanelConstraintsEventos);
        
        gridPanelConstraintsVehiculo.gridx = 2;
        gridPanelConstraintsVehiculo.gridy = 2;
        this.add(new JLabel("PrioridadA: "),gridPanelConstraintsVehiculo);
        gridPanelConstraintsVehiculo.gridx = 3;
        gridPanelConstraintsVehiculo.gridy = 2;
        this.add(prioridadA,gridPanelConstraintsVehiculo);
        
        gridPanelConstraintsEventos.gridx = 0;
        gridPanelConstraintsEventos.gridy = 3;
        this.add(new JLabel("Disturbio:"),gridPanelConstraintsEventos);
        
        gridPanelConstraintsEventos.gridx = 1;
        gridPanelConstraintsEventos.gridy = 3;
        this.add(sliderEvD, gridPanelConstraintsEventos);
        
        gridPanelConstraintsVehiculo.gridx = 2;
        gridPanelConstraintsVehiculo.gridy = 3;
        this.add(new JLabel("PrioridadD: "),gridPanelConstraintsVehiculo);
        gridPanelConstraintsVehiculo.gridx = 3;
        gridPanelConstraintsVehiculo.gridy = 3;
        this.add(prioridadD,gridPanelConstraintsVehiculo);
        
        gridPanelConstraintsEventos.gridx = 0;
        gridPanelConstraintsEventos.gridy = 4;
        this.add(new JLabel("Funcionario:"),gridPanelConstraintsEventos);
        
        gridPanelConstraintsEventos.gridx = 1;
        gridPanelConstraintsEventos.gridy = 4;
        this.add(sliderEvF, gridPanelConstraintsEventos);
        
        gridPanelConstraintsVehiculo.gridx = 2;
        gridPanelConstraintsVehiculo.gridy = 4;
        this.add(new JLabel("PrioridadF: "),gridPanelConstraintsVehiculo);
        gridPanelConstraintsVehiculo.gridx = 3;
        gridPanelConstraintsVehiculo.gridy = 4;
        this.add(prioridadF,gridPanelConstraintsVehiculo);

	}

	public static void crearYmostrarGUI(){

        JFrame frame = new JFrame("Prioridad Vehiculos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent newContentPane = new Interfaz();
        
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(900, 300);

	}
	
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearYmostrarGUI();
            }
        });
    }
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
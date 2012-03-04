package ui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.*;

public class Aprendizaje extends JPanel implements ItemListener{
	
	int hora;
	int [] cola = new int [4];
	int [] entreno = new int [4];
	
	int aux =0;
	int prio;
	int via;
	List<Recompensa> prioridades = new ArrayList<Recompensa>();
	
	int medicion = 0;
	int resultado;
	
	Recompensa valor;		
	Random rnd = new Random();
	
	JLabel s1 = new JLabel();
	JLabel s2 = new JLabel();
	JLabel s3 = new JLabel();
	JLabel s4 = new JLabel();
	JLabel r = new JLabel();
	
	public Aprendizaje(){
		
		hora = 12;
		
		for( int i = 0; i<4; i++){
			cola[i]=0;
		}
		
		cola[0] += rnd.nextDouble() * 20.0;
		cola[1] += rnd.nextDouble() * 30.0;
		cola[2] += rnd.nextDouble() * 20.0;
		cola[3] += rnd.nextDouble() * 15.0;
		
		System.out.println("");
		System.out.println("Hora :"+hora);
		for( int i = 0; i<4; i++){
			System.out.println(cola[i]);
		}
		
        JButton botoncalcular = new JButton("Aprender");
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
				
				valor  = new Recompensa();
				
				cola[0] +=  (rnd.nextDouble() * 20.0);
				cola[1] +=  (rnd.nextDouble() * 40.0);
				cola[2] +=  (rnd.nextDouble() * 20.0);
				cola[3] +=  (rnd.nextDouble() * 15.0);
				
				prio = 0;
				
				for( int i = 0; i<4; i++){
					entreno[i] = 0;
				}
				
				for( int i = 0; i<4; i++){
					if ( cola[i] > prio){
						prio = cola[i];
						via = i;
					}
				}
				
				valor.setCola( via);
								
				medicion = 0;
				
				for( int i = 0; i<4; i++){
					medicion += cola[i];
				}				
				
				if(medicion < aux){
					valor.setRecompensa(1000);					
				}
				if(medicion == aux){
					valor.setRecompensa(10);						
				}
				if(medicion > aux && medicion <= 100){
					valor.setRecompensa(100);						
				}
				if(medicion > aux+45){
					valor.setRecompensa(-1000);
				}
				
				prioridades.add(valor);				
				aux = medicion;				
			
				System.out.println("");
				System.out.println("Hora :"+hora);
				for( int i = 0; i<4; i++){
					System.out.println(cola[i]);
				}
				System.out.println("Trafico : "+medicion);
				System.out.println("Mas larga : "+prio);
								
				cola[0] -=  10;
				cola[1] -=  15;
				cola[2] -=  10;
				cola[3] -=  7;
				
				for( int i =0; i<4; i++){
					if(prio == cola[i])
						cola[i] -= 8;
				}
				
				for( int i =0; i<4; i++){
					if(cola[i]<0)
						cola[i] = 0;
				}
			}
		});
        
        
        JButton botoncalcular2 = new JButton("Aprender +50");
        this.add(botoncalcular2);
        botoncalcular2.addMouseListener(new MouseListener() {
			
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
				
				for(int j = 0; j<50; j++){
				
					valor  = new Recompensa();
					
					cola[0] +=  (rnd.nextDouble() * 20.0);
					cola[1] +=  (rnd.nextDouble() * 40.0);
					cola[2] +=  (rnd.nextDouble() * 20.0);
					cola[3] +=  (rnd.nextDouble() * 15.0);
					
					prio = 0;
					
					for( int i = 0; i<4; i++){
						entreno[i] = 0;
					}
					
					for( int i = 0; i<4; i++){
						if ( cola[i] > prio){
							prio = cola[i];
							via = i;
						}
					}
					
					valor.setCola( via);
									
					medicion = 0;
					
					for( int i = 0; i<4; i++){
						medicion += cola[i];
					}				
					
					if(medicion < aux){
						valor.setRecompensa(1000);					
					}
					if(medicion == aux){
						valor.setRecompensa(10);						
					}
					if(medicion > aux && medicion <= 100){
						valor.setRecompensa(100);						
					}
					if(medicion > aux+45){
						valor.setRecompensa(-1000);
					}
					
					prioridades.add(valor);				
					aux = medicion;				
				
					System.out.println("");
					System.out.println("Hora :"+hora);
					for( int i = 0; i<4; i++){
						System.out.println(cola[i]);
					}
					System.out.println("Trafico : "+medicion);
					System.out.println("Mas larga : "+prio);
									
					cola[0] -=  10;
					cola[1] -=  15;
					cola[2] -=  10;
					cola[3] -=  7;
					
					for( int i =0; i<4; i++){
						if(prio == cola[i])
							cola[i] -= 8;
					}
					
					for( int i =0; i<4; i++){
						if(cola[i]<0)
							cola[i] = 0;
					}
				}
				
			}
		});
        
        JButton botonResultado = new JButton("Resultado");
        this.add(botonResultado);
        botonResultado.addMouseListener(new MouseListener() {
			
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
				
				resultado = 0;
				
				for(int i = 0; i<prioridades.size(); i++){					
					entreno[prioridades.get(i).getCola()] += prioridades.get(i).getRecompensa();
					System.out.println(prioridades.get(i).getCola()+"  "+prioridades.get(i).getRecompensa());					
				}
				
				System.out.println("-------");
				for(int i = 0; i<4; i++){
					
					if ( entreno[i] > resultado){
						resultado = entreno[i];
					}
					System.out.println(entreno[i]);	
					
				}
				System.out.println("RESULTADO DEL ENTRENAMIENTO "+resultado);				
				s1.setText("Semaforo 1 : "+ Integer.toString(entreno[0]));
				s2.setText("Semaforo 2 : "+ Integer.toString(entreno[1]));
				s3.setText("Semaforo 3 : "+ Integer.toString(entreno[2]));
				s4.setText("Semaforo 4 : "+ Integer.toString(entreno[3]));
				r.setText("+Prioridad : "+resultado);
				save_file();

			}
		});	
        
        this.add(s1);
        this.add(s2);
        this.add(s3);
        this.add(s4);
        this.add(r);
        
        
	}
	
	public void save_file()
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("bd.txt");
            pw = new PrintWriter(fichero);

			for(int i = 0; i<4; i++){
				
				pw.println(entreno[i]);
				
			}

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
	
	public static void crearYmostrarGUI(){

        JFrame frame = new JFrame("Aprendizaje");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent newContentPane = new Aprendizaje();
        
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(200, 300);

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

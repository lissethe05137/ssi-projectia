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
	List<Recompensa> listRecompensa = new ArrayList<Recompensa>();
	List<Trafico> listTrafico = new ArrayList<Trafico>();
	List<Trafico> listPrioridad = new ArrayList<Trafico>();
	
	int medicion = 0;
	int resultado;
	
	Recompensa valor;
	Trafico trafico;
	Trafico prioridad;
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
		
//		cola[0] += rnd.nextDouble() * 10.0;
//		cola[1] += rnd.nextDouble() * 15.0;
//		cola[2] += rnd.nextDouble() * 10.0;
//		cola[3] += rnd.nextDouble() * 7.0;
//		
//		trafico = new Trafico();
//		trafico.setS1(cola[0]);
//		trafico.setS2(cola[1]);
//		trafico.setS3(cola[2]);
//		trafico.setS4(cola[3]);
//		
//		listTrafico.add(trafico);
//		
//		System.out.println("");
//		System.out.println("Hora :"+hora);
//		for( int i = 0; i<4; i++){
//			System.out.println(cola[i]);
//		}
		
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
				
				cola[0] +=  (rnd.nextDouble() * 10.0);
				cola[1] +=  (rnd.nextDouble() * 15.0) + 5;
				cola[2] +=  (rnd.nextDouble() * 10.0);
				cola[3] +=  (rnd.nextDouble() * 7.0);
				
				trafico = new Trafico();
				trafico.setS1(cola[0]);
				trafico.setS2(cola[1]);
				trafico.setS3(cola[2]);
				trafico.setS4(cola[3]);
				
				listTrafico.add(trafico);
				
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
					valor.setRecompensa(2);					
				}else
				if(medicion == aux){
					valor.setRecompensa(1);						
				}else
				if(medicion > aux && medicion <= 40){
					valor.setRecompensa(-1);						
				}else
				if(medicion > aux){
					valor.setRecompensa(-2);
				}
				
				listRecompensa.add(valor);				
				aux = medicion;				
			
				System.out.println("");
				System.out.println("Hora :"+hora);
				for( int i = 0; i<4; i++){
					System.out.println(cola[i]);
				}
				System.out.println("Trafico : "+medicion);
				System.out.println("Mas larga : "+prio);
								
				cola[0] -=  9;
				cola[1] -=  15;
				cola[2] -=  9;
				cola[3] -=  6;
				
				for( int i =0; i<4; i++){
					if(prio == cola[i])
						cola[i] -= 4;
				}
				
				for( int i =0; i<4; i++){
					if(cola[i]<0)
						cola[i] = 0;
				}
			}
		});
        
        
        JButton botoncalcular2 = new JButton("Aprender +30");
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
				
				for(int j = 0; j<30; j++){
				
					valor  = new Recompensa();
					
					cola[0] +=  (rnd.nextDouble() * 10.0);
					cola[1] +=  (rnd.nextDouble() * 15.0) + 5;
					cola[2] +=  (rnd.nextDouble() * 10.0);
					cola[3] +=  (rnd.nextDouble() * 7.0);
					
					trafico = new Trafico();
					trafico.setS1(cola[0]);
					trafico.setS2(cola[1]);
					trafico.setS3(cola[2]);
					trafico.setS4(cola[3]);
					
					listTrafico.add(trafico);
					
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
						valor.setRecompensa(2);					
					}else
					if(medicion == aux){
						valor.setRecompensa(1);						
					}else
					if(medicion > aux && medicion <= 40){
						valor.setRecompensa(-1);						
					}else
					if(medicion > aux){
						valor.setRecompensa(-2);
					}
					
					listRecompensa.add(valor);				
					aux = medicion;				
				
					System.out.println("");
					System.out.println("Hora :"+hora);
					for( int i = 0; i<4; i++){
						System.out.println(cola[i]);
					}
					System.out.println("Trafico : "+medicion);
					System.out.println("Mas larga : "+prio);
									
					cola[0] -=  9;
					cola[1] -=  15;
					cola[2] -=  9;
					cola[3] -=  6;
					
					for( int i =0; i<4; i++){
						if(prio == cola[i])
							cola[i] -= 4;
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
				
				System.out.println("-------");

				save_file_trafico();
				save_file_recompensa();
				save_file_prioridad();
				
				if(resultado<listPrioridad.get(listPrioridad.size()-1).getS1())
					resultado = listPrioridad.get(listPrioridad.size()-1).getS1();
				if(resultado<listPrioridad.get(listPrioridad.size()-1).getS2())
					resultado = listPrioridad.get(listPrioridad.size()-1).getS2();
				if(resultado<listPrioridad.get(listPrioridad.size()-1).getS3())
					resultado = listPrioridad.get(listPrioridad.size()-1).getS3();
				if(resultado<listPrioridad.get(listPrioridad.size()-1).getS4())
					resultado = listPrioridad.get(listPrioridad.size()-1).getS4();

				System.out.println("RESULTADO DEL ENTRENAMIENTO ");
				System.out.println(""+listPrioridad.get(listPrioridad.size()-1).getS1());
				System.out.println(""+listPrioridad.get(listPrioridad.size()-1).getS2());
				System.out.println(""+listPrioridad.get(listPrioridad.size()-1).getS3());
				System.out.println(""+listPrioridad.get(listPrioridad.size()-1).getS4());
				System.out.println("Resultado : "+resultado);

				s1.setText("Semaforo 1 : "+ Integer.toString(listPrioridad.get(listPrioridad.size()-1).getS1()));
				s2.setText("Semaforo 2 : "+ Integer.toString(listPrioridad.get(listPrioridad.size()-1).getS2()));
				s3.setText("Semaforo 3 : "+ Integer.toString(listPrioridad.get(listPrioridad.size()-1).getS3()));
				s4.setText("Semaforo 4 : "+ Integer.toString(listPrioridad.get(listPrioridad.size()-1).getS4()));
				r.setText("+Prioridad : "+resultado);

			}
		});	
        
        this.add(s1);
        this.add(s2);
        this.add(s3);
        this.add(s4);
        this.add(r);
        
        
	}
	
	public void save_file_trafico()
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("trafico.txt",false);
            pw = new PrintWriter(fichero);

			for(int i = 0; i<listTrafico.size(); i++){
				
				pw.print(listTrafico.get(i).getS1());
				pw.print(",");
				pw.print(listTrafico.get(i).getS2());
				pw.print(",");
				pw.print(listTrafico.get(i).getS3());
				pw.print(",");
				pw.print(listTrafico.get(i).getS4());
				pw.println("");
				
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
	
	public void save_file_recompensa()
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("recompensa.txt", false);
            pw = new PrintWriter(fichero);

			for(int i = 0; i<listRecompensa.size(); i++){
				
				pw.print(listRecompensa.get(i).getCola());
				pw.print(",");
				pw.print(listRecompensa.get(i).getRecompensa());
				pw.println("");
				
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
	
	public void save_file_prioridad()
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        Trafico prioridad = new Trafico();
		prioridad.setS1(0);
		prioridad.setS2(0);
		prioridad.setS3(0);
		prioridad.setS4(0);
		
		listPrioridad.clear();
        try
        {
            fichero = new FileWriter("prioridad.txt", false);
            pw = new PrintWriter(fichero);

			for(int i = 0; i<listRecompensa.size(); i++){

				if(listRecompensa.get(i).getCola() == 0){
					prioridad.setS1(prioridad.getS1()+listRecompensa.get(i).getRecompensa());
				}else
				if(listRecompensa.get(i).getCola() == 1){
					prioridad.setS2(prioridad.getS2()+listRecompensa.get(i).getRecompensa());
				}else
				if(listRecompensa.get(i).getCola() == 2){
					prioridad.setS3(prioridad.getS3()+listRecompensa.get(i).getRecompensa());
				}else
				if(listRecompensa.get(i).getCola() == 3){
					prioridad.setS4(prioridad.getS4()+listRecompensa.get(i).getRecompensa());
				}
				
				pw.print(prioridad.getS1());
				pw.print(",");
				pw.print(prioridad.getS2());
				pw.print(",");
				pw.print(prioridad.getS3());
				pw.print(",");
				pw.print(prioridad.getS4());
				pw.println("");
				listPrioridad.add(prioridad);
				
				
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

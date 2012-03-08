package com.ssi.planificacion;

import java.util.ArrayList;
import java.util.List;

import xfuzzy.Prioridadv;

import jpl.Query;

import com.ssi.object.Automovil;
import com.ssi.object.Automovil.TipoCar;
import com.ssi.object.Automovil.TipoVehiculo;
import com.ssi.semaforo.Semaforo;
import com.sun.jmx.remote.util.OrderClassLoaders;


public class Planificacion {



	List<Plan> planVe = new ArrayList<Plan>();
	List<Integer> plan = new ArrayList<Integer>();

	public List<Integer> getPlan() {
		return plan;
	}

	public boolean estadoInicial( Semaforo semaforo, Automovil Vo){
		
		if(semaforo.getColorLuz().equals("rojo") && ( Vo.getTipoV().equals(Automovil.TipoVehiculo.Bomberos) || Vo.getTipoV().equals(Automovil.TipoVehiculo.Ambulancia) || Vo.getTipoV().equals(Automovil.TipoVehiculo.Policia) ) )
		return true;
		
		else
			return false;
	}
	
	public void OperadorCambiarLuz(Semaforo semaforo, Automovil vof){
				
		
		Plan planAux = new Plan();
		
		String t1 = "consult('semaforo.pl')";
		Query q1 = new Query(t1);
		System.out.println( t1 + " " + (q1.hasSolution() ? "succeeded" : "failed") );
		
		String t2 = "semaforoRojo("+semaforo.getNombre()+","+semaforo.getColorLuz()+")";
		Query q2 = new Query(t2);
		System.out.println( t2 + " is " + (q2.hasSolution() ? "true" : "false") );

		String t3 = "semaforoAmarillo("+semaforo.getNombre()+","+semaforo.getColorLuz()+")";
		Query q3 = new Query(t3);
		System.out.println( t3 + " is " + (q3.hasSolution() ? "true" : "false") );
		
		String t4 = "semaforoVerde("+semaforo.getNombre()+","+semaforo.getColorLuz()+")";
		Query q4 = new Query(t4);
		System.out.println( t4 + " is " + (q4.hasSolution() ? "true" : "false") );
		
		if(q2.hasSolution()){
			semaforo.setColorLuz("verde");
			planAux.setOperador("CambiarLuz");
			planAux.setAccion("Luz Verde");
			planAux.setEstadofinal(vof.getTipoV()+" pasa luz roja");
			planAux.setNombre(semaforo.getNombre());
			
			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Ambulancia)){	
				planAux.setPrioridad(vof.getPrioridad());
				planVe.add(planAux);		
			}
			
			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Bomberos)){
				planAux.setPrioridad(vof.getPrioridad());
				planVe.add(planAux);	
			}
			
			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Policia)){
				planAux.setPrioridad(vof.getPrioridad());
				planVe.add(planAux);	
			}
			
		}
	
		
		else if(q3.hasSolution()){
			planAux.setOperador("CambiarLuz");
			planAux.setAccion("Luz Verde");
			planAux.setEstadofinal(vof.getTipoV()+" pasa luz roja");
			planAux.setNombre(semaforo.getNombre());
			
			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Ambulancia)){	
				planAux.setPrioridad(vof.getPrioridad());
				planVe.add(planAux);		
			}
			
			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Bomberos)){
				planAux.setPrioridad(vof.getPrioridad());
				planVe.add(planAux);	
			}
			
			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Policia)){
				planAux.setPrioridad(vof.getPrioridad());
				planVe.add(planAux);	
			}
		}	
		
		else if(q4.hasSolution()){
			planAux.setOperador("CambiarLuz");
			planAux.setAccion("Luz dejada en Verde");
			planAux.setEstadofinal( vof.getTipoV()+"  pasa luz roja");
			planAux.setNombre(semaforo.getNombre());
			
			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Ambulancia)){	
				planAux.setPrioridad(vof.getPrioridad());
				planVe.add(planAux);		
			}
			
			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Bomberos)){
				planAux.setPrioridad(vof.getPrioridad());
				planVe.add(planAux);	
			}
			
			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Policia)){
				planAux.setPrioridad(vof.getPrioridad());
				planVe.add(planAux);	
			}
			
		}
			
	}
		
	
	public List<Plan> ordenar (List<Plan> plan){
			double max = plan.get(0).getPrioridad();
			List<Plan> aux = new ArrayList<Plan>();
			
			int max1=0;
			int tam = plan.size(); 
			for(int i=0; i<plan.size();i++){

				for(int j=0;j<plan.size();j++){
					if(plan.get(j).getPrioridad()>=plan.get(max1).getPrioridad()){
					    max1=j;
						
					}
					
				}

				aux.add(plan.get(max1));
		//		System.out.println(aux.size());
				plan.remove(max1);
				i=0;
			}
		
		for(int i=0;i<aux.size();i++){
			
			//System.out.println(aux.get(i).getPrioridad());
			
		}
		
		return aux;
	}
	
	
	public void setPlan(Semaforo semaforo, Automovil vof ){
			
//		//Aplicar operador
//		OperadorCambiarLuz(semaforo);
//		
//		
//			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Ambulancia)){	
//				semaforo.setPeso1(semaforo.getPeso1() + 100);
//				secuencia.add(semaforo);		
//			}
//			
//			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Bomberos)){
//				semaforo.setPeso1(semaforo.getPeso1() + 50);
//				secuencia.add(semaforo);	
//			}
//			
//			if(vof.getTipoV().equals(Automovil.TipoVehiculo.Policia)){
//				semaforo.setPeso1(semaforo.getPeso1() + 20);
//				secuencia.add(semaforo);	
//			}
//
//			for (int i=0;i<secuencia.size();i++){
//
//				System.out.print(secuencia.get(i).getNombre()+"Prioridad" + secuencia.get(i).getPeso1()+"\n");
//				
//			}
			
	}
	
	public static void main(String[] args) {
        
		Planificacion pl = new Planificacion();
		Semaforo sem = new Semaforo("semaforo1", 14, 12, 13, 4, 4, 5, 7, 1);
		sem.setColorLuz("rojo");
		Semaforo sem2 = new Semaforo("semaforo4", 10, 12, 13, 4, 4, 5, 7,2);
		sem2.setColorLuz("verde");
		Automovil auto = new Automovil(1, 1, 2, 2, null, TipoCar.RIGHT, TipoVehiculo.Ambulancia);
		Automovil auto2 = new Automovil(1, 1, 2, 2, null, TipoCar.RIGHT, TipoVehiculo.Bomberos);
		
		
		// Integracion con logica difusa
		Prioridadv prio = new Prioridadv();
		double [] prioridades;  
		double [] prioridades2; 
		double [] vector = new double[5];
		double [] vector2 = new double[5];
		
		if( auto.getTipoV().equals(Automovil.TipoVehiculo.Ambulancia)){
			
			vector[0] = 2;
			
		}else
		if( auto.getTipoV().equals(Automovil.TipoVehiculo.Bomberos)){
			
			vector[0] = 5;
			
		}else
		if( auto.getTipoV().equals(Automovil.TipoVehiculo.Policia)){
			
			vector[0] = 7;
			
		}
		
		if( auto2.getTipoV().equals(Automovil.TipoVehiculo.Ambulancia)){
			
			vector2[0] = 2;
			
		}else
		if( auto2.getTipoV().equals(Automovil.TipoVehiculo.Bomberos)){
			
			vector2[0] = 5;
			
		}else
		if( auto2.getTipoV().equals(Automovil.TipoVehiculo.Policia)){
			
			vector2[0] = 7;
			
		}
		
		vector[1]=0;
		vector[2]=0;
		vector[3]=0;
		vector[4]=0;
		
		vector2[1]=0;
		vector2[2]=0;
		vector2[3]=0;
		vector2[4]=0;
		
		prioridades = prio.crispInference(vector);
		prioridades2 = prio.crispInference(vector2);
		
		auto.setPrioridad(prioridades[0]);
		auto2.setPrioridad(prioridades2[0]);
		
		pl.OperadorCambiarLuz(sem, auto2);
		pl.OperadorCambiarLuz(sem2, auto);
		System.out.println(pl.planVe.size());
		for (int i=0;i<pl.planVe.size();i++){

			System.out.println(pl.planVe.get(i).getNombre()+" Operador: " + pl.planVe.get(i).getOperador()+" Accion: " + pl.planVe.get(i).getAccion()+" Estado Final: " + pl.planVe.get(i).getEstadofinal()+" Prioridad: " + pl.planVe.get(i).getPrioridad()+"\n");
			
		}
		
		
		pl.ordenar(pl.planVe);
		
    }
}

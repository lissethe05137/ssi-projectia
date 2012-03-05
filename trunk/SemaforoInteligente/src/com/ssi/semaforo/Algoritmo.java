package com.ssi.semaforo;

import java.util.ArrayList;
import java.util.List;

public class Algoritmo {
	
	Semaforo[] vecSem = new Semaforo[4];
	Par par = new Par();
	int temp;
	int congestion;
	int congestion_aux;

	public Par algoritmoBusqueda(Semaforo [] semaforo)
	{
		List<Semaforo> listSecuencia = new ArrayList<Semaforo>();
		int count = 1;
		
		vecSem = semaforo;
		congestion =0;
		
		for(int i =0; i<4; i++){
			congestion += vecSem[i].getCca();
		}
		System.out.println("Congestion "+congestion);
		
		congestion = 0;
		
		while( count < 4 )
		{
			int max,pos = 0;

			max = vecSem[0].funcionUtilidad();

			for( int i = 1; i < 4; i++)
			{
				if ( max < vecSem[i].funcionUtilidad() ){
					max = vecSem[i].funcionUtilidad();
					pos = i;
				}
			}

			if( vecSem[pos].funcionTiempoVerde() != 0 )
			{
				Semaforo sem;
				if( listSecuencia.size() == 0 ){
					sem = new Semaforo(vecSem[pos]);
					listSecuencia.add(sem);
				}
				else
				{
					int flag = 0;

					for( int j = 0; j < listSecuencia.size(); j++ )
					{
						if( listSecuencia.get(j).getNombre() == vecSem[pos].getNombre() )
						{
							flag = 1;
							break;
						}
					}										
					sem = new Semaforo(vecSem[pos]);
					listSecuencia.add(sem);

					if( flag == 0 )
						count++;
				}				
			}
			printsem();
			update(pos);			
			
		}
		for(int i =0; i<4; i++){
			congestion += vecSem[i].getCca();
		}
		System.out.println("Congestion "+congestion);
		
		System.out.println( "\n\n\n" );
	    for(int i = 0; i < listSecuencia.size(); i++ )
	    {
	    	listSecuencia.get(i).setTimeVerdeV(listSecuencia.get(i).funcionTiempoVerde());
	    	System.out.println( listSecuencia.get(i).getNombre() + " -> " + listSecuencia.get(i).getTimeVerdeV() );
	    }
	    	
	    int j;
	    for( int i = 0; i < listSecuencia.size(); i++ )
	    {
	    	j = i + 1;
	        if( ( j < listSecuencia.size() ) && (listSecuencia.get(i).getNombre().equals(listSecuencia.get(j).getNombre())) )
	        {
	        	listSecuencia.get(i).setTimeVerdeV(listSecuencia.get(i).getTimeVerdeV() + listSecuencia.get(j).getTimeVerdeV());
	        	listSecuencia.remove(j);
	        	i--;
	        }
	    }
	    
	    par.setLista(listSecuencia);
	    par.setSemaforo(vecSem);

		return par;
	}
	
	public void printsem(){
		for(int i = 0; i<4; i++){
			System.out.println( vecSem[i].getNombre() + " -> |Peso 1  " + vecSem[i].getPeso1() + "| |Peso 2 " 
					+ vecSem[i].getPeso2() + "| |Peso 3 " + vecSem[i].getPeso3() + "| |Cce " + //
					vecSem[i].getCce() + "| |Cca " + vecSem[i].getCca() + "| |Ta " + vecSem[i].getTa() + "| |Tev " + vecSem[i].getTev() + "| FOO = " + vecSem[i].funcionUtilidad() //
					+ " TV = " + vecSem[i].funcionTiempoVerde() );
		}
	}
	
	public void update(int pos){
		temp = vecSem[pos].funcionTiempoVerde();
		int carros = (int) (vecSem[pos].getCca() - temp * (Math.random()*0.3+0.7) );
		
		for(int i = 0; i<4 ; i++){
			if(i == pos){
				if(carros >= 0)
					vecSem[pos].setCca(carros);
				else
					vecSem[pos].setCca(0);
				
				vecSem[pos].setTa(0);
			}
			else{
				vecSem[i].setCca((int) (vecSem[i].getCca() + vecSem[i].getCce() * (Math.random()*0.6+0.7)));
				vecSem[i].setTa(vecSem[i].getTa()+temp);
			}			
		}
		update_peso();		
	}
	
	public void update_peso(){
		for(int i=0; i<4; i++){
			if(vecSem[i].getTa() <= 60){
				vecSem[i].setPeso3(1);
			}else
				if(vecSem[i].getTa() <= 110){
					vecSem[i].setPeso3(2);
				}else
					{
						vecSem[i].setPeso3(3);
					}
			
			if(vecSem[i].getCca() <= 15){
				vecSem[i].setPeso2(1);
			}else
				if(vecSem[i].getCca() <= 30){
					vecSem[i].setPeso2(2);
				}else
					{
						vecSem[i].setPeso2(3);
					}
			
			if(vecSem[i].getCce() <= 10){
				vecSem[i].setPeso1(1);
			}else
				if(vecSem[i].getCce() <= 15){
					vecSem[i].setPeso1(2);
				}else
					{
						vecSem[i].setPeso1(3);
					}
		}
	}
}

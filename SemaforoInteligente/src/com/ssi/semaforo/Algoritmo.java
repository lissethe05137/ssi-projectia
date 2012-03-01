package com.ssi.semaforo;

import java.util.ArrayList;
import java.util.List;

public class Algoritmo {

	public List<Semaforo> algoritmoBusqueda()
	{
		List<Semaforo> listSecuencia = new ArrayList<Semaforo>();
		int count = 1;
		
		while( count < 4 )
		{

			int peso1 = (int) (Math.random()*3 + 1);
			int peso2 = (int) (Math.random()*3 + 1);
			int peso3 = (int) (Math.random()*3 + 1);
			int cce = (int) (Math.random()*20 + 1);
			int cca = (int) (Math.random()*30);
			int ta = (int) (Math.random()*60);
			int tev = (int) (Math.random()*25);

			Semaforo semaforo1 = new Semaforo("Semaforo 1", peso1, peso2, peso3, cce, cca, ta,tev,1);
			System.out.println( semaforo1.getNombre() + " -> " + peso1 + " " + peso2 + " " + peso3 + " " + //
					cce + " " + cca + " " + ta + " " + tev + " FOO = " + semaforo1.funcionUtilidad() //
					+ " TV = " + semaforo1.funcionTiempoVerde() );

			peso1 = (int) (Math.random()*3 + 1);
			peso2 = (int) (Math.random()*3 + 1);
			peso3 = (int) (Math.random()*3 + 1);
			cce = (int) (Math.random()*20 + 1);
			cca = (int) (Math.random()*30);
			ta = (int) (Math.random()*60);
			tev = (int) (Math.random()*25);

			Semaforo semaforo2 = new Semaforo("Semaforo 2", peso1, peso2, peso3, cce, cca, ta,tev,2);
			System.out.println( semaforo2.getNombre() + " -> " + peso1 + " " + peso2 + " " + peso3 + " " + //
					cce + " " + cca + " " + ta + " " + tev + " FOO = " + semaforo2.funcionUtilidad() //
					+ " TV = " + semaforo2.funcionTiempoVerde() );

			peso1 = (int) (Math.random()*3 + 1);
			peso2 = (int) (Math.random()*3 + 1);
			peso3 = (int) (Math.random()*3 + 1);
			cce = (int) (Math.random()*20 + 1);
			cca = (int) (Math.random()*30);
			ta = (int) (Math.random()*60);
			tev = (int) (Math.random()*25);

			Semaforo semaforo3 = new Semaforo("Semaforo 3", peso1, peso2, peso3, cce, cca, ta,tev,3);
			System.out.println( semaforo3.getNombre() + " -> " + peso1 + " " + peso2 + " " + peso3 + " " + //
					cce + " " + cca + " " + ta + " " + tev + " FOO = " + semaforo3.funcionUtilidad() //
					+ " TV = " + semaforo3.funcionTiempoVerde() );

			peso1 = (int) (Math.random()*3 + 1);
			peso2 = (int) (Math.random()*3 + 1);
			peso3 = (int) (Math.random()*3 + 1);
			cce = (int) (Math.random()*20 + 1);
			cca = (int) (Math.random()*30);
			ta = (int) (Math.random()*60);
			tev = (int) (Math.random()*25);

			Semaforo semaforo4 = new Semaforo("Semaforo 4", peso1, peso2, peso3, cce, cca, ta,tev,4);
			System.out.println( semaforo4.getNombre() + " -> " + peso1 + " " + peso2 + " " + peso3 + " " + //
					cce + " " + cca + " " + ta + " " + tev + " FOO = " + semaforo4.funcionUtilidad() //
					+ " TV = " + semaforo4.funcionTiempoVerde() );

			Semaforo[] vecSem = new Semaforo[4];

			vecSem[0] = semaforo1;
			vecSem[1] = semaforo2;
			vecSem[2] = semaforo3;
			vecSem[3] = semaforo4;

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
				if( listSecuencia.size() == 0 )
					listSecuencia.add(vecSem[pos]);
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

					listSecuencia.add(vecSem[pos]);

					if( flag == 0 )
						count++;
				}
			}
		}
		
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

	    int tam = listSecuencia.size();
	    for( int i = 0; i < 3*tam; i++ )
	    	listSecuencia.add(listSecuencia.get(i));

		return listSecuencia;
	}
}

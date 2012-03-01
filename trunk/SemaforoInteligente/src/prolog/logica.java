package prolog;

import jpl.Query;

public class logica {
	
	public static void main( String argv[] )
	{
		String t1 = "consult('semaforo.pl')";
		Query q1 = new Query(t1);
		System.out.println( t1 + " " + (q1.hasSolution() ? "succeeded" : "failed") );
		//--------------------------------------------------
		String t2 = "semaforoRojo(Semaforo1, rojo)";
		Query q2 = new Query(t2);
		System.out.println( t2 + " is " + (q2.hasSolution() ? "true" : "false") );

		//----------------------------------------------------
		String t3 = "solo1Verde(semaforo1,verde,semaforo2,rojo,semaforo3,rojo,semaforo4,rojo)";
		Query q3 = new Query(t3);
		System.out.println( t3 + " is " + (q3.hasSolution() ? "true" : "false") );

		//----------------------------------------------------
		String t5 = "cambiarLuz(semaforo1,cambiar)";
		Query q5 = new Query(t5);
		System.out.println( t5 + " is " + (q5.hasSolution() ? "true" : "false") );
		
		//----------------------------------------------------
		
		String t6 = "cambiarVerdeHora(semaforo1,12)";
		Query q6 = new Query(t6);
		System.out.println( t6 + " is " + (q6.hasSolution() ? "true" : "false") );
		
		//----------------------------------------------------
		
		String t4 = "semaforo(X)";
		Query q4 = new Query(t4);
//		System.out.println( "first solution of " + t4 + ": X = " +
//				q4.oneSolution().get("X"));
		//--------------------------------------------------
		java.util.Hashtable[] ss4 = q4.allSolutions();
		System.out.println( "Los semaforos " + t4);
		for ( int i=0 ; i<ss4.length ; i++ ) {
			System.out.println( "X = " + ss4[i].get("X"));
		}
		
	}	
				
}

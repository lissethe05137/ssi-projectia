luzAmarilla(amarillo).
luzRoja(rojo).
luzVerde(verde).
senal(cambiar).
semaforo(semaforo1).
semaforo(semaforo2).
semaforo(semaforo3).
semaforo(semaforo4).
vehiculoOficial(ambulancia).
vehiculoOficial(policia).
hora(12).
hora(1).
hora(2).
semaforoRojo(A,B):-semaforo(A),luzRoja(B).
semaforoVerde(A,B):-semaforo(A),luzVerde(B).
semaforoAmarillo(A,B):-semaforo(A),luzAmarilla(B).
cambiaVerde(A,B):-semaforo(A),semaforoRojo(A,B).
cambiarVerde(A,B,C):-semaforo(A),vehiculoOficial(B),semaforoRojo(C).
cambiarRojo(A,B):-semaforo(A),semaforoAmarillo(B).
cambiarLuz(A,B):-semaforo(A),senal(B).
solo1Verde(A,B,C,D,E,F,G,H):-semaforoVerde(A,B),semaforoRojo(C,D),semaforoRojo(E,F),semaforoRojo(G,H).
solo1Verde(A,B,C,D,E,F,G,H):-semaforoRojo(C,D),semaforoRojo(A,B),semaforoRojo(E,F),semaforoRojo(G,H).
solo1Verde(A,B,C,D,E,F,G,H):-semaforoRojo(E,F),semaforoRojo(C,D),semaforoRojo(A,B),semaforoRojo(G,H).
solo1Verde(A,B,C,D,E,F,G,H):-semaforoRojo(G,H),semaforoRojo(C,D),semaforoRojo(E,F),semaforoRojo(A,B).
solo1Amarillo(A,B,C,D,E,F,G,H):-semaforoRojo(A,B),semaforoRojo(C,D),semaforoRojo(E,F),semaforoRojo(G,H).
solo1Amarillo(A,B,C,D,E,F,G,H):-semaforoRojo(C,D),semaforoRojo(A,B),semaforoRojo(E,F),semaforoRojo(G,H).
solo1Amarillo(A,B,C,D,E,F,G,H):-semaforoRojo(E,F),semaforoRojo(C,D),semaforoRojo(A,B),semaforoRojo(G,H).
solo1Amarillo(A,B,C,D,E,F,G,H):-semaforoRojo(G,H),semaforoRojo(C,D),semaforoRojo(E,F),semaforoRojo(A,B).
cambiarVerdeHora(A,B):-A='semaforo1', B=12.
cambiarRojoHora(A,B):-semaforo(A),hora(B).
analizar(A,B):-semaforo(A),semaforoRojo(B).
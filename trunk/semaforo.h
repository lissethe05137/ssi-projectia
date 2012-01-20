#include <iostream>
#include<string.h>

using namespace std;

#ifndef SEMAFORO_H
#define SEMAFORO_H

class Semaforo
{

    string nombre; //nombre semaforo
    int peso1;
    int peso2;
    int peso3;
    int cce; //cantidad de carros esperados.
    int cca; //cantidad de carros actual.
    int Ta; //Tiempo actual de espera
    int Tev; //Tiempo de luz verde

public:
    Semaforo();
    Semaforo(string, int, int, int, int, int, int, int);

    string getNombre();
    void setNombre(string nombre);
    int getPeso1();
    void setPeso1(int peso1);
    int getPeso2();
    void setPeso2(int peso2) ;
    int getPeso3();
    void setPeso3(int peso3);
    int getCce();
    void setCce(int cce);
    int getCca();
    void setCca(int cca);
    int getTa();
    void setTa(int ta);
    int getTev();
    void setTev(int tev);

    int TiempoVerde();
    int funcionUtilidad();

};

#endif // SEMAFORO_H

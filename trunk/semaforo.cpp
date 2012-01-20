#include "semaforo.h"

Semaforo::Semaforo()
{
}

Semaforo::Semaforo(string nombre, int peso1, int peso2, int peso3, int cce, int cca, int Ta, int Tev)
{
    this->nombre = nombre;
    this->peso1 = peso1;
    this->peso2 = peso2;
    this->peso3 = peso3;
    this->cce = cce;
    this->cca = cca;
    this->Ta = Ta;
    this->Tev = Tev;
}

string Semaforo::getNombre() {
                return nombre;
        }
void Semaforo::setNombre(string nombre) {
                this->nombre = nombre;
        }

int Semaforo::getPeso1() {
                return peso1;
        }
void Semaforo::setPeso1(int peso1) {
                this->peso1 = peso1;
        }

int Semaforo::getPeso2() {
                return peso2;
        }
void Semaforo::setPeso2(int peso2) {
                this->peso2 = peso2;
        }
int Semaforo::getPeso3() {
                return peso3;
        }
 void Semaforo::setPeso3(int peso3) {
                this->peso3 = peso3;
        }
 int Semaforo::getCce() {
                return cce;
        }
 void Semaforo::setCce(int cce) {
                this->cce = cce;
        }
 int Semaforo::getCca() {
                return cca;
        }
 void Semaforo::setCca(int cca) {
                this->cca = cca;
        }
 int Semaforo::getTa() {
                return Ta;
        }
 void Semaforo::setTa(int ta) {
                Ta = ta;
        }

 int Semaforo::getTev() {
         return Tev;
 }

 void Semaforo::setTev(int tev) {
         this->Tev = tev;
 }

 int Semaforo::funcionUtilidad(){

     return ( peso1*cce + peso2*cca + peso3*Ta );

 }

 int Semaforo::TiempoVerde(){

     return Tev -( ((cce-cca)/cce)*Tev );

 }

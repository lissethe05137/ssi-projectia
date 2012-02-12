#ifndef ANIMATIONWIDGET_H
#define ANIMATIONWIDGET_H

#include <QMainWindow>
#include <QtGui>
#include <automovil.h>
#include <trafficlight.h>

class AnimationWidget : public QMainWindow
{
    Q_OBJECT
public:
    explicit AnimationWidget(QWidget *parent = 0);
    
private:
    void initAutomovil();
    void initSemaforo();
    void paintEvent(QPaintEvent *);
    void timerEvent(QTimerEvent *);
    void sincronizarSemaforo();
    void changeColor(TrafficLight [], QColor, QColor, QColor);
    void logicCarSemaforo1();
    void logicCarSemaforo2();
    void logicCarSemaforo3();
    void logicCarSemaforo4();

private slots:
    void countTime();

private:

    QPainter *pCar;
    QString hora;

    int ancho;
    int alto;
    int velocidadAnimation;
    int tiempo1,tiempo2,tiempo3,tiempo4;
    int secuenciaColor1,secuenciaColor2,secuenciaColor3,secuenciaColor4;
    int secuenciaSemaforo;

    QList<Automovil *> listCar1;
    QList<Automovil *> listCar2;
    QList<Automovil *> listCar3;
    QList<Automovil *> listCar4;

    Automovil *vehiculo, *vehiculo2, *vehiculo3, *vehiculo4;

    int yInicial, xInicial, y2Inicial, x2Inicial, x3Inicial, y3Inicial, x4Inicial, y4Inicial;
    int angle, dt1, tiempoPrueba;

    TrafficLight listSemaforo1[3];
    TrafficLight listSemaforo2[3];
    TrafficLight listSemaforo3[3];
    TrafficLight listSemaforo4[3];

};

#endif // ANIMATIONWIDGET_H

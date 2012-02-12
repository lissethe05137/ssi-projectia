#ifndef TRAFFICLIGHT_H
#define TRAFFICLIGHT_H

#include <QPoint>
#include <QColor>

class TrafficLight
{

public:
    QPoint centro;
    QPoint tamano;
    QColor color;
    int tiempo; /*seconds*/
    bool on;

public:
    TrafficLight();

    void setPoint(QPoint );
    void setPoint(int , int );
    void setX(int );
    void setY(int );
    void setColor(QColor );
    void setCircle(QPoint );
    void setCircle(int, int);
    void setTiempo(int);
    void setOn(bool );

    QPoint getPoint();
    int getX();
    int getY();
    QColor getColor();
    QPoint getCircle();
    int getTiempo();
    bool getIson();

};

#endif // TRAFFICLIGHT_H

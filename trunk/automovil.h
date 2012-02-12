#ifndef AUTOMOVIL_H
#define AUTOMOVIL_H

#include <QPoint>
#include <QImage>
#include <QTransform>

class Automovil
{

public:
    QPoint centro;
    QImage image;
    int dx;
    int dy;
    double angle;
    double dAngle;

public:
    Automovil();

    void setPoint(QPoint );
    void setPoint(int , int );
    void setX(int );
    void setY(int );
    void setDx(int );
    void setDy(int );
    void setImage(QImage );
    void setRotarImage(double );
    void setDAngle(double );

    QPoint getPoint();
    int getX();
    int getY();
    int getDx();
    int getDy();
    QImage getImage();
    QImage getRotarImage();
    double getDAngle();

};

#endif // AUTOMOVIL_H

#include "automovil.h"

Automovil::Automovil()
{
}

void Automovil::setPoint(QPoint centro)
{
    this->centro = centro;
}

void Automovil::setPoint(int x, int y)
{
    this->centro.setX(x);
    this->centro.setY(y);
}

void Automovil::setX(int x)
{
    this->centro.setX(x);
}

void Automovil::setY(int y)
{
    this->centro.setY(y);
}

void Automovil::setDx(int dx)
{
    this->dx = dx;
}

void Automovil::setDy(int dy)
{
    this->dy = dy;
}

void Automovil::setImage(QImage image)
{
    this->image = image;
}

void Automovil::setRotarImage(double angle)
{
    QTransform transform;
    transform.rotate(angle);
    this->image = image.transformed(transform);
}

void Automovil::setDAngle(double dAngle)
{
    this->dAngle = dAngle;
}

QPoint Automovil::getPoint()
{
    return centro;
}

int Automovil::getX()
{
    return centro.x();
}

int Automovil::getY()
{
    return centro.y();
}

int Automovil::getDx()
{
    return dx;
}

int Automovil::getDy()
{
    return dy;
}

QImage Automovil::getImage()
{
    return image;
}

QImage Automovil::getRotarImage()
{
    return image;
}

double Automovil::getDAngle()
{
    return dAngle;
}


#include "trafficlight.h"

TrafficLight::TrafficLight()
{
}

void TrafficLight::setPoint(QPoint centro)
{
    this->centro = centro;
}

void TrafficLight::setPoint(int x, int y)
{
    this->centro.setX(x);
    this->centro.setY(y);
}

void TrafficLight::setX(int x)
{
    this->centro.setX(x);
}

void TrafficLight::setY(int y)
{
    this->centro.setY(y);
}

void TrafficLight::setColor(QColor color)
{
    this->color = color;
}

void TrafficLight::setCircle(QPoint tamano)
{
    this->tamano = tamano;
}

void TrafficLight::setCircle(int ancho, int alto)
{
    this->tamano.setX(ancho);
    this->tamano.setY(alto);
}

void TrafficLight::setTiempo(int tiempo)
{
    this->tiempo = tiempo;
}

void TrafficLight::setOn(bool on)
{
    this->on = on;
}

QPoint TrafficLight::getPoint()
{
    return centro;
}

int TrafficLight::getX()
{
    return centro.x();
}

int TrafficLight::getY()
{
    return centro.y();
}

QColor TrafficLight::getColor()
{
    return color;
}

QPoint TrafficLight::getCircle()
{
    return tamano;
}

int TrafficLight::getTiempo()
{
    return tiempo;
}

bool TrafficLight::getIson()
{
    return on;
}

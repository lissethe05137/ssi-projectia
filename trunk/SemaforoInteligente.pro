#-------------------------------------------------
#
# Project created by QtCreator 2012-01-20T14:05:22
#
#-------------------------------------------------

QT       += core gui

TARGET = SemaforoInteligente
TEMPLATE = app


SOURCES += main.cpp\
        mainwindow.cpp \
    semaforo.cpp \
    trafficlight.cpp \
    automovil.cpp \
    animationwidget.cpp

HEADERS  += mainwindow.h \
    semaforo.h \
    trafficlight.h \
    automovil.h \
    animationwidget.h

FORMS    += mainwindow.ui

RESOURCES += \
    recursos.qrc

#Incluir de libreria swipl5.11 y gsl.
CONFIG += warn_off

INCLUDEPATH += /home/antonio/Escritorio/swipl-5.10.3/include
INCLUDEPATH += /usr/local/include/gsl

LIBS += -L/home/antonio/Escritorio/swipl-5.10.3/lib/i686-linux
LIBS += -L/usr/local/include/gsl -lgsl -lgslcblas -lm

DEPENDPATH += /home/antonio/Escritorio/swipl-5.10.3/include
DEPENDPATH += /usr/local/include/gsl

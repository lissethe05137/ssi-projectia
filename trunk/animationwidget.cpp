#include "animationwidget.h"

AnimationWidget::AnimationWidget(QWidget *parent) :
    QMainWindow(parent)
{

    setWindowTitle("SSI - Sistema de Semaforo Inteligente");
    setWindowIcon(QIcon(":/images/semaforo.png"));
    showMaximized();

    ancho = QApplication::desktop()->width();
    alto = QApplication::desktop()->height();
    setGeometry(0,0,ancho,alto);

    initAutomovil();
    initSemaforo();

    QTimer * timer = new QTimer();
    connect(timer, SIGNAL(timeout()), this, SLOT(countTime()));
    timer->start(1000);

    tiempo1 = 0;
    tiempo2 = 0;
    tiempo3 = 0;
    tiempo4 = 0;

    secuenciaColor1 = 1;
    secuenciaColor2 = 1;
    secuenciaColor3 = 1;
    secuenciaColor4 = 1;

    secuenciaSemaforo = 1;

    QTime tiempo = QTime::currentTime();
    hora = tiempo.toString("hh:mm:ss ap");

    startTimer(velocidadAnimation);
}

void AnimationWidget::initAutomovil()
{

    velocidadAnimation = 20;

    xInicial = -50;
    yInicial = 362;

    vehiculo = new Automovil();
    vehiculo->setPoint(xInicial,yInicial);
    vehiculo->setDx(1);
    vehiculo->setDy(1);
    vehiculo->setImage(QImage(":/images/CarroRight.png"));
    vehiculo->setDAngle(5);

    x2Inicial = 525;
    y2Inicial = alto - 100;

    vehiculo2 = new Automovil();
    vehiculo2->setPoint(x2Inicial,y2Inicial);
    vehiculo2->setDx(1);
    vehiculo2->setDy(1);
    vehiculo2->setImage(QImage(":/images/CarroUp.png"));
    vehiculo2->setDAngle(5);

    x3Inicial = ancho;
    y3Inicial = 280;

    vehiculo3 = new Automovil();
    vehiculo3->setPoint(x3Inicial,y3Inicial);
    vehiculo3->setDx(1);
    vehiculo3->setDy(1);
    vehiculo3->setImage(QImage(":/images/CarroLeft.png"));
    vehiculo3->setDAngle(5);

    x4Inicial = 420;
    y4Inicial = -50;

    vehiculo4 = new Automovil();
    vehiculo4->setPoint(x4Inicial,y4Inicial);
    vehiculo4->setDx(1);
    vehiculo4->setDy(1);
    vehiculo4->setImage(QImage(":/images/CarroDown.png"));
}

void AnimationWidget::initSemaforo()
{
    TrafficLight greenLight, orangeLight, redLight;

    //Semaforo 1
    greenLight.setPoint(344,510);
    greenLight.setColor(Qt::green);
    greenLight.setCircle(25,25);
    greenLight.setTiempo(10);
    listSemaforo1[0] = greenLight;

    orangeLight.setPoint(344,565);
    //orangeLight.setColor(QColor(255,128,0));
    orangeLight.setColor(Qt::black);
    orangeLight.setCircle(25,25);
    orangeLight.setTiempo(3);
    listSemaforo1[1] = orangeLight;

    redLight.setPoint(344,620);
    //redLight.setColor(Qt::red);
    redLight.setColor(Qt::black);
    redLight.setCircle(25,25);
    redLight.setTiempo(13);
    redLight.setOn(true);
    listSemaforo1[2] = redLight;

    //Semaforo 2
    greenLight.setPoint(695,485);
    greenLight.setColor(Qt::black);
    greenLight.setCircle(25,25);
    greenLight.setTiempo(10);
    listSemaforo2[0] = greenLight;

    orangeLight.setPoint(750,485);
    orangeLight.setColor(Qt::black);
    orangeLight.setCircle(25,25);
    orangeLight.setTiempo(3);
    listSemaforo2[1] = orangeLight;

    redLight.setPoint(805,485);
    redLight.setColor(Qt::red);
    redLight.setCircle(25,25);
    redLight.setTiempo(13);
    redLight.setOn(false);
    listSemaforo2[2] = redLight;

    //Semaforo 3
    greenLight.setPoint(668,180);
    greenLight.setColor(Qt::black);
    greenLight.setCircle(25,25);
    greenLight.setTiempo(10);
    listSemaforo3[0] = greenLight;

    orangeLight.setPoint(668,125);
    orangeLight.setColor(Qt::black);
    orangeLight.setCircle(25,25);
    orangeLight.setTiempo(3);
    listSemaforo3[1] = orangeLight;

    redLight.setPoint(668,70);
    redLight.setColor(Qt::red);
    redLight.setCircle(25,25);
    redLight.setTiempo((13));
    redLight.setOn(false);
    listSemaforo3[2] = redLight;

    //Semaforo 4
    greenLight.setPoint(320,218);
    greenLight.setColor(Qt::black);
    greenLight.setCircle(25,25);
    greenLight.setTiempo(10);
    listSemaforo4[0] = greenLight;

    orangeLight.setPoint(265,218);
    orangeLight.setColor(Qt::black);
    orangeLight.setCircle(25,25);
    orangeLight.setTiempo(3);
    listSemaforo4[1] = orangeLight;

    redLight.setPoint(210,218);
    redLight.setColor(Qt::red);
    redLight.setCircle(25,25);
    redLight.setTiempo((13));
    redLight.setOn(false);
    listSemaforo4[2] = redLight;

}

void AnimationWidget::sincronizarSemaforo()
{

    //Semaforo 1
    if( secuenciaSemaforo == 1 )
    {
        if( (secuenciaColor1 == 1) && (tiempo1 == listSemaforo1[0].getTiempo()) )
        {
            changeColor(listSemaforo1,Qt::black,QColor(255,128,0),Qt::black);
            tiempo1 = 0;
            secuenciaColor1 = 2;
        }
        else if( (secuenciaColor1 == 2) && (tiempo1 == listSemaforo1[1].getTiempo()) )
        {
            changeColor(listSemaforo1,Qt::black,Qt::black,Qt::red);
            tiempo1 = 0;
            secuenciaColor1 = 3;
            secuenciaSemaforo = 2;
            tiempo2 = listSemaforo2[2].getTiempo();
            listSemaforo1[2].setOn(false);
            listSemaforo2[2].setOn(true);
        }
        else if( (secuenciaColor1 == 3) && (tiempo1 == listSemaforo1[2].getTiempo()) )
        {
            changeColor(listSemaforo1,Qt::green,Qt::black,Qt::black);
            tiempo1 = 0;
            secuenciaColor1 = 1;

        }
    }

    //Semaforo 2
    if( secuenciaSemaforo == 2 )
    {
        if( (secuenciaColor2 == 1) && (tiempo2 == listSemaforo2[2].getTiempo()) )
        {
            changeColor(listSemaforo2,Qt::green,Qt::black,Qt::black);
            tiempo2 = 0;
            secuenciaColor2 = 2;
        }
        else if( (secuenciaColor2 == 2) && (tiempo2 == listSemaforo2[0].getTiempo()) )
        {
            changeColor(listSemaforo2,Qt::black,QColor(255,128,0),Qt::black);
            tiempo2 = 0;
            secuenciaColor2 = 3;
        }
        else if( (secuenciaColor2 == 3) && (tiempo2 == listSemaforo2[1].getTiempo()) )
        {
            changeColor(listSemaforo2,Qt::black,Qt::black,Qt::red);
            tiempo2 = 0;
            secuenciaColor2 = 1;
            secuenciaSemaforo = 3;
            tiempo3 = listSemaforo3[2].getTiempo();
            listSemaforo2[2].setOn(false);
            listSemaforo3[2].setOn(true);
        }
    }

    //Semaforo 3
    if( secuenciaSemaforo == 3 )
    {
        if( (secuenciaColor3 == 1) && (tiempo3 == listSemaforo3[2].getTiempo()) )
        {
            changeColor(listSemaforo3,Qt::green,Qt::black,Qt::black);
            tiempo3 = 0;
            secuenciaColor3 = 2;
        }
        else if( (secuenciaColor3 == 2) && (tiempo3 == listSemaforo3[0].getTiempo()) )
        {
            changeColor(listSemaforo3,Qt::black,QColor(255,128,0),Qt::black);
            tiempo3 = 0;
            secuenciaColor3 = 3;
        }
        else if( (secuenciaColor3 == 3) && (tiempo3 == listSemaforo3[1].getTiempo()) )
        {
            changeColor(listSemaforo3,Qt::black,Qt::black,Qt::red);
            tiempo3 = 0;
            secuenciaColor3 = 1;
            secuenciaSemaforo = 4;
            tiempo4 = listSemaforo4[2].getTiempo();
            listSemaforo3[2].setOn(false);
            listSemaforo4[2].setOn(true);
        }
    }

    //Semaforo 4
    if( secuenciaSemaforo == 4 )
    {
        if( (secuenciaColor4 == 1) && (tiempo4 == listSemaforo4[2].getTiempo()) )
        {
            changeColor(listSemaforo4,Qt::green,Qt::black,Qt::black);
            tiempo4 = 0;
            secuenciaColor4 = 2;
        }
        else if( (secuenciaColor4 == 2) && (tiempo4 == listSemaforo4[0].getTiempo()) )
        {
            changeColor(listSemaforo4,Qt::black,QColor(255,128,0),Qt::black);
            tiempo4 = 0;
            secuenciaColor4 = 3;
        }
        else if( (secuenciaColor4 == 3) && (tiempo4 == listSemaforo4[1].getTiempo()) )
        {
            changeColor(listSemaforo4,Qt::black,Qt::black,Qt::red);
            tiempo4 = 0;
            secuenciaColor4 = 1;
            secuenciaSemaforo = 1;
            tiempo1 = listSemaforo1[2].getTiempo();
            listSemaforo4[2].setOn(false);
            listSemaforo1[2].setOn(true);
        }
    }
}

void AnimationWidget::changeColor(TrafficLight semaforo[], QColor color1, QColor color2, QColor color3)
{
    semaforo[0].setColor(color1);
    semaforo[1].setColor(color2);
    semaforo[2].setColor(color3);
}

void AnimationWidget::paintEvent(QPaintEvent *)
{

    QPainter p(this);

    p.drawImage(12,5,QImage(":/images/fondo.png"));
    p.drawText((ancho - 135),30,("Hora: " + hora));

    for( int i = 0; i < 3; i++ )
    {
        p.setBrush(QBrush(listSemaforo1[i].getColor()));
        p.drawEllipse(listSemaforo1[i].getPoint(),listSemaforo1[i].getCircle().x(),listSemaforo1[i].getCircle().y());
        p.setBrush(QBrush(listSemaforo2[i].getColor()));
        p.drawEllipse(listSemaforo2[i].getPoint(),listSemaforo2[i].getCircle().x(),listSemaforo2[i].getCircle().y());
        p.setBrush(QBrush(listSemaforo3[i].getColor()));
        p.drawEllipse(listSemaforo3[i].getPoint(),listSemaforo3[i].getCircle().x(),listSemaforo3[i].getCircle().y());
        p.setBrush(QBrush(listSemaforo4[i].getColor()));
        p.drawEllipse(listSemaforo4[i].getPoint(),listSemaforo4[i].getCircle().x(),listSemaforo4[i].getCircle().y());
    }

    p.drawImage(vehiculo->getPoint(),vehiculo->getImage());
    p.drawImage(vehiculo2->getPoint(),vehiculo2->getImage());
    p.drawImage(vehiculo3->getPoint(),vehiculo3->getImage());
    p.drawImage(vehiculo4->getPoint(),vehiculo4->getImage());

    sincronizarSemaforo();
}

void AnimationWidget::timerEvent(QTimerEvent *)
{

    logicCarSemaforo1();

    logicCarSemaforo2();

    logicCarSemaforo3();

    logicCarSemaforo4();


    repaint();
}

void AnimationWidget::logicCarSemaforo1()
{
    int x, y;

    x = vehiculo->getX();
    y = vehiculo->getY();

    if( vehiculo->getX() > ancho )
        x = xInicial;

    if( vehiculo->getY() < 0 ||vehiculo->getY() > alto )
        y = yInicial;

    if( (vehiculo->getX() == 305) && (listSemaforo1[2].getIson() == false) )
        vehiculo->setImage(vehiculo->getImage());
    else
        vehiculo->setX( x + vehiculo->getDx() );

}

void AnimationWidget::logicCarSemaforo2()
{
    int x2, y2;

    x2 = vehiculo2->getX();
    y2 = vehiculo2->getY();

    if( vehiculo2->getX() < 0 || vehiculo2->getX() > ancho )
        x2 = x2Inicial;

    if( vehiculo2->getY() < 0 )
        y2 = y2Inicial;

    if( (vehiculo2->getY() == 480) && (listSemaforo2[2].getIson() == false) )
    {
        vehiculo2->setImage(vehiculo2->getImage());

    }else
        vehiculo2->setY( y2 - vehiculo2->getDy() );
}

void AnimationWidget::logicCarSemaforo3()
{
    int x3, y3;

    x3 = vehiculo3->getX();
    y3 = vehiculo3->getY();

    if( vehiculo3->getX() < 0 )
        x3 = x3Inicial;

    if( vehiculo3->getY() < 0 || vehiculo3->getY() > alto )
        y3 = y3Inicial;

    if( (vehiculo3->getX() == 665) && (listSemaforo3[2].getIson() == false) )
    {
        vehiculo3->setImage(vehiculo3->getImage());

    }else
        vehiculo3->setX( x3 - vehiculo3->getDx() );
}

void AnimationWidget::logicCarSemaforo4()
{
    int x4, y4;

    x4 = vehiculo4->getX();
    y4 = vehiculo4->getY();

    if( vehiculo4->getX() < 0 || vehiculo4->getX() > ancho )
        x4 = x4Inicial;

    if( vehiculo4->getY() > alto )
        y4 = y4Inicial;

    if( (vehiculo4->getY() == 175) && (listSemaforo4[2].getIson() == false) )
    {
        vehiculo4->setImage(vehiculo4->getImage());

    }else
        vehiculo4->setY( y4 + vehiculo4->getDy() );

}

void AnimationWidget::countTime()
{
    if( secuenciaSemaforo == 1 )
        tiempo1++;
    else if( secuenciaSemaforo == 2 )
        tiempo2++;
    else if( secuenciaSemaforo == 3 )
        tiempo3++;
    else
        tiempo4++;

    QTime tiempo = QTime::currentTime();
    hora = tiempo.toString("hh:mm:ss ap");


}



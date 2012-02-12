#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    setWindowTitle("SSI - Sistema de Semaforo Inteligente");
    setWindowIcon(QIcon(":/images/semaforo.png"));
    showMaximized();

    crearAction();
    crearMenuBar();

    srand(time(NULL));

}

void MainWindow::crearAction()
{
    actionNuevo = new QAction(QIcon(":/images/nuevo.svg"),"&Nuevo", this);
    actionNuevo->setShortcut(tr("Ctrl+n"));
    actionNuevo->setStatusTip(tr("Crear un Archivo Nuevo"));
    connect(actionNuevo, SIGNAL(triggered()), this, SLOT(slot_nuevo()));

    actionAbrir = new QAction(QIcon(":/images/abrir.png"),"&Abrir", this);
    actionAbrir->setShortcut(tr("Ctrl+o"));
    actionAbrir->setStatusTip(tr("Abrir un Archivo"));
    connect(actionAbrir, SIGNAL(triggered()), this, SLOT(close()));

    actionSalir = new QAction(QIcon(":/images/cerrar.png"),"&Salir", this);
    actionSalir->setShortcut(tr("Ctrl+s"));
    actionSalir->setStatusTip(tr("Salir del Sistema"));
    connect(actionSalir, SIGNAL(triggered()), this, SLOT(close()));

    actionAcerca = new QAction(QIcon(":/images/acercade.png"),"&Acerca de", this);
    actionAcerca->setStatusTip(tr("Acerca de SSI"));
    connect(actionAcerca, SIGNAL(triggered()), this, SLOT(slot_acercade()));

}

void MainWindow::crearMenuBar()
{
    archivoMenu = menuBar()->addMenu(tr("&Archivo"));
    archivoMenu->addAction(actionNuevo);
    archivoMenu->addAction(actionAbrir);
    archivoMenu->addSeparator();
    archivoMenu->addAction(actionSalir);

    ayudaMenu = menuBar()->addMenu(tr("A&yuda"));
    ayudaMenu->addAction(actionAcerca);
}

void MainWindow::slot_nuevo()
{

    QLabel *titulo = new QLabel("<h2> Crear Simulaci&oacute;n </h2>");

    QVBoxLayout *vLayout = new QVBoxLayout();
    vLayout->setAlignment(Qt::AlignCenter);
    vLayout->setSpacing(25);
    vLayout->addWidget(titulo);

    QLabel *lblInterseccion = new QLabel("Tipo de interseccion: ");
    boxInterseccion = new QComboBox(this);
    boxInterseccion->addItem("Interseccion 1");
    boxInterseccion->addItem("Interseccion 2");
    boxInterseccion->addItem("Interseccion 3");

    QFormLayout *fLayout = new QFormLayout();
    fLayout->setAlignment(Qt::AlignCenter);
    fLayout->addRow(lblInterseccion,boxInterseccion);

    QImage imageInterseccion(":/images/interseccion.png");

    lblImagen = new QLabel();
    lblImagen->setPixmap(QPixmap::fromImage(imageInterseccion));

    QHBoxLayout *hLayout = new QHBoxLayout();
    hLayout->setAlignment(Qt::AlignCenter);
    hLayout->addLayout(fLayout);
    hLayout->addSpacing(20);
    hLayout->addWidget(lblImagen);

    vLayout->addLayout(hLayout);

    QPushButton *btnAceptar = new QPushButton(QIcon(":/images/aceptar.png"),"&Aceptar");
    QPushButton *btnCancelar = new QPushButton(QIcon(":/images/cancel.png"),"&Cancelar");

    connect(btnAceptar, SIGNAL(clicked()), this, SLOT(slot_aceptar()));
    connect(btnCancelar, SIGNAL(clicked()), this, SLOT(slot_limpiar()));

    hLayout = new QHBoxLayout();
    hLayout->setAlignment(Qt::AlignCenter);
    hLayout->addWidget(btnAceptar);
    hLayout->addSpacing(5);
    hLayout->addWidget(btnCancelar);

    vLayout->addLayout(hLayout);

    marco = new QScrollArea();
    marco->setAlignment(Qt::AlignCenter);
    marco->setLayout(vLayout);

    setCentralWidget(marco);

}

void MainWindow::slot_acercade()
{
    QMessageBox::about(this,"Acerca de SSI","<h3>SSI - Sistema Semaforo Inteligente</h3><center>Versi&oacute;n 1.0</center>");
}

void MainWindow::slot_limpiar()
{
    marco = new QScrollArea();
    marco->setAlignment(Qt::AlignCenter);

    setCentralWidget(marco);
}

void MainWindow::AlgoritmoBusqueda()
{

    int peso1 = (1 + rand() % 3);
    int peso2 = (1 + rand() % 3);
    int peso3 = (1 + rand() % 3);
    int cce = (1 + rand() % 20);
    int cca = (0 + rand() % 30);
    int ta = (0 + rand() % 60);
    int tev = (0 + rand() % 25);

    Semaforo sem1("Semaforo 1", peso1, peso2, peso3, cce, cca, ta,tev);
    cout << "Semaforo 1 -> " << peso1 << " " << peso2 << " " << peso3 << " " << cce << " " << cca << " " << ta << " " << tev << " FOO= " << sem1.funcionUtilidad() << " TV= "<< sem1.TiempoVerde()<< endl;


    peso1 = (1 + rand() % 3);
    peso2 = (1 + rand() % 3);
    peso3 = (1 + rand() % 3);
    cce = (1 + rand() % 20);
    cca = (0 + rand() % 30);
    ta = (0 + rand() % 60);
    tev = (0 + rand() % 25);

    Semaforo sem2("Semaforo 2", peso1, peso2, peso3, cce, cca, ta,tev);
    cout << "Semaforo 2 -> " << peso1 << " " << peso2 << " " << peso3 << " " << cce << " " << cca << " " << ta << " " << tev << " FOO= " << sem2.funcionUtilidad() << " TV= "<< sem2.TiempoVerde()<< endl;


    peso1 = (1 + rand() % 3);
    peso2 = (1 + rand() % 3);
    peso3 = (1 + rand() % 3);
    cce = (1 + rand() % 20);
    cca = (0 + rand() % 30);
    ta = (0 + rand() % 60);
    tev = (0 + rand() % 25);

    Semaforo sem3("Semaforo 3", peso1, peso2, peso3, cce, cca, ta,tev);
    cout << "Semaforo 3 -> " << peso1 << " " << peso2 << " " << peso3 << " " << cce << " " << cca << " " << ta << " " << tev << " FOO= " << sem3.funcionUtilidad() << " TV= "<< sem3.TiempoVerde()<< endl;


    peso1 = (1 + rand() % 3);
    peso2 = (1 + rand() % 3);
    peso3 = (1 + rand() % 3);
    cce = (1 + rand() % 20);
    cca = (0 + rand() % 30);
    ta = (0 + rand() % 60);
    tev = (0 + rand() % 25);

    Semaforo sem4("Semaforo 4", peso1, peso2, peso3, cce, cca, ta,tev);
    cout << "Semaforo 4 -> " << peso1 << " " << peso2 << " " << peso3 << " " << cce << " " << cca << " " << ta<< " " << tev << " FOO= " << sem4.funcionUtilidad() << " TV= "<< sem4.TiempoVerde() << endl;


    Semaforo vecSem[4];


    vecSem[0] = sem1;
    vecSem[1] = sem2;
    vecSem[2] = sem3;
    vecSem[3] = sem4;


    int max,pos = 0;

    max = vecSem[0].funcionUtilidad();


    for( int i = 1; i < 4; i++)
    {

        if (max < vecSem[i].funcionUtilidad()){
            max = vecSem[i].funcionUtilidad();
            pos = i;
        }

    }

    secuencia.push_back(vecSem[pos]);

}

void MainWindow::slot_aceptar()
{


    AnimationWidget *ventana = new AnimationWidget();
    ventana->show();

    marco = new QScrollArea();
    marco->setAlignment(Qt::AlignCenter);

    setCentralWidget(marco);
    setEnabled(false);

//    for(int i = 0; i < 2; i++){
//        AlgoritmoBusqueda();
//    }

//    QString cadena;
//    QLabel *lblSecuencia;

//    QVBoxLayout *vLayout = new QVBoxLayout();
//    vLayout->setAlignment(Qt::AlignCenter);

//    for(int i = 0; i < secuencia.size(); i++)
//    {
//        cadena = secuencia[i].getNombre().c_str() + tr(" -> ") + QString::number(secuencia[i].TiempoVerde());
//        lblSecuencia = new QLabel();
//        lblSecuencia->setText(cadena);
//        vLayout->addWidget(lblSecuencia);


//    }

//    marco = new QScrollArea();
//    marco->setAlignment(Qt::AlignCenter);
//    marco->setLayout(vLayout);

//    setCentralWidget(marco);

//    secuencia.clear();

}

MainWindow::~MainWindow()
{
    delete ui;
}



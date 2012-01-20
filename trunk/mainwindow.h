#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QtGui>
#include <semaforo.h>
#include <vector>

namespace Ui {
    class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    void crearAction();
    void crearMenuBar();
    void AlgoritmoBusqueda();
    ~MainWindow();

private slots:
    void Nuevo();
    void Acercade();
    void Limpiar();
    void Aceptar();

private:
    Ui::MainWindow *ui;

    QAction * actionNuevo;
    QAction * actionAbrir;
    QAction * actionGuardar;
    QAction * actionSalir;
    QAction * actionAcerca;

    QMenu * archivoMenu;
    QMenu * editarMenu;
    QMenu * ayudaMenu;

    QScrollArea * marco;
    QLabel *lblImagen;
    QComboBox *boxInterseccion;

    vector <Semaforo> secuencia;

};

#endif // MAINWINDOW_H

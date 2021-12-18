package Entidades;

import Recursos.Chrono;
import Recursos.Constantes;

import java.awt.*;
import java.util.Random;

public class GrupoAliens {

    private Alien tablaDeAliens[][] = new Alien[5][10];
    private boolean alienTocaDerecha, pos1;
    private int velocidad;
    private int[] tablaDeDeadAliens = {-1,1};

    Random random = new Random();
    private int cantidadAliens = Constantes.CANTIDAD_ALIENS;


    //Constructor
    public GrupoAliens(){
        this.enTablaDeAliens();
        this.alienTocaDerecha = true;
        this.velocidad = Constantes.VELOCIDAD_ALIEN;
        this.pos1 = true;
    }


    //Metodos
    private void enTablaDeAliens(){ //Completa todos los aliens en la matriz
        for(int columna = 0; columna<10; columna=columna+1){
            this.tablaDeAliens[0][columna] = new Alien(Constantes.X_POS_ALIEN + (Constantes.LARGO_ALIEN + Constantes.ESP_COLUMNA_ALIEN)*columna, Constantes.ALT_ALIEN, "/Imagenes/alienHaut1.png", "/Imagenes/alienHaut2.png");
            for(int fila = 1; fila <3; fila = fila+1){
                this.tablaDeAliens[fila][columna] = new Alien(Constantes.X_POS_ALIEN + (Constantes.LARGO_ALIEN + Constantes.ESP_COLUMNA_ALIEN)*columna,Constantes.ALT_ALIEN + Constantes.ESP_FILA_ALIEN*fila, "/Imagenes/alienMilieu1.png", "/Imagenes/alienMilieu2.png");
            }
            for(int fila =3; fila <5; fila = fila+1){
                this.tablaDeAliens[fila][columna] = new Alien(Constantes.X_POS_ALIEN + (Constantes.LARGO_ALIEN + Constantes.ESP_COLUMNA_ALIEN)*columna, Constantes.ALT_ALIEN + Constantes.ESP_FILA_ALIEN*fila, "/Imagenes/alienBas1.png", "/Imagenes/alienBas2.png");
            }
        }
    }


    public void dibujandoAliens(Graphics g) {
        if(Chrono.cuentaBucle % (100-10*this.velocidad) == 0){
            this.desplazamientoAliens();
        }
        for(int columna = 0; columna < 10; columna=columna+1) {
            for(int fila = 0; fila < 5; fila=fila+1) {
                if (this.tablaDeAliens[fila][columna] != null) {
                    this.tablaDeAliens[fila][columna].cambiaImagen(pos1); //Simula el movimiento
                    g.drawImage(this.tablaDeAliens[fila][columna].getImg(), this.tablaDeAliens[fila][columna].getxPos(), this.tablaDeAliens[fila][columna].getyPos(), null);
                }
            }
        }
    }

    public boolean tocoBordeIzquierdoDeVentana(){
        boolean resp = false;
        for(int columna=0; columna<10; columna=columna+1){
            for(int fila=0; fila<5; fila=fila+1){
                if (this.tablaDeAliens[fila][columna] != null) {
                    if (this.tablaDeAliens[fila][columna].getxPos() < Constantes.MARGEN_VENTANA) {
                        resp = true;
                        break;
                    }
                }
            }
        }
        return resp;
    }

    public boolean tocoBordeDerechoDeVentana(){
        boolean resp = false;
        for(int columna=0; columna<10; columna=columna+1){
            for(int fila=0; fila<5; fila=fila+1){
                if (this.tablaDeAliens[fila][columna] != null) {
                    if (this.tablaDeAliens[fila][columna].getxPos() > Constantes.LARGO_VENTANA - Constantes.LARGO_ALIEN - Constantes.DX_ALIEN - Constantes.MARGEN_VENTANA) {
                        resp = true;
                        break;
                    }
                }
            }
        }
        return resp;
    }

    public void alienGiraYDesciende() {
        //Alien choca con el borde de la ventana y regresa pero mas cerca a la nave
        if(this.tocoBordeDerechoDeVentana() == true) {
            for(int columna=0; columna<10; columna++) {
                for(int fila=0; fila<5; fila++) {
                    if (this.tablaDeAliens[fila][columna] != null) {
                        this.tablaDeAliens[fila][columna].setyPos(this.tablaDeAliens[fila][columna].getyPos() + Constantes.DY_ALIEN);
                    }
                }
            }
            this.alienTocaDerecha = false;
            if(this.velocidad < 9) {
                this.velocidad = this.velocidad + 1;
            }
        }
        else {
            if(this.tocoBordeIzquierdoDeVentana() == true) {
                for(int columna=0; columna<10; columna++) {
                    for(int fila=0; fila<5; fila++) {
                        if (this.tablaDeAliens[fila][columna] != null) {
                            this.tablaDeAliens[fila][columna].setyPos(this.tablaDeAliens[fila][columna].getyPos() + Constantes.DY_ALIEN);
                        }
                    }
                }
                this.alienTocaDerecha = true;
                if(this.velocidad < 9) {
                    this.velocidad = this.velocidad + 1;
                }
            }
        }
    }

    public void desplazamientoAliens() {

        if(tablaDeDeadAliens[0] != -1){
            eliminarDeadAlien(tablaDeDeadAliens);
            tablaDeDeadAliens[0] = -1;
        }
        if(this.alienTocaDerecha == true) { //Cuando va hacia la derecha
            for(int columna=0; columna<10; columna++) {
                for(int fila=0; fila<5; fila++) {
                    if (this.tablaDeAliens[fila][columna] != null) {
                        this.tablaDeAliens[fila][columna].setxPos(this.tablaDeAliens[fila][columna].getxPos() + Constantes.DX_ALIEN);
                    }
                }
            }
        }else{ // Cuando va hacia la izquierda
            for(int columna=0; columna<10; columna++) {
                for(int fila=0; fila<5; fila++) {
                    if (this.tablaDeAliens[fila][columna] != null) {
                        this.tablaDeAliens[fila][columna].setxPos(this.tablaDeAliens[fila][columna].getxPos() - Constantes.DX_ALIEN);
                    }
                }
            }
        }
        //Cambiar imagen del alien
        if(this.pos1 == true) {
            this.pos1 = false;
        }
        else {
            this.pos1 = true;
        }
        this.alienGiraYDesciende(); //Actualiza si el alien toca los bordes de la ventana
    }


    //Disparo de la embarcacion alienigena
    public void tiroEmbarcacionAlien(TiroEmbarcacion tiroEmbarcacion){
        for(int columna=0; columna<10; columna=columna+1){
            for(int fila=0;fila<5;fila=fila+1){
                if(this.tablaDeAliens[fila][columna] != null){
                    if(tiroEmbarcacion.killAlien(this.tablaDeAliens[fila][columna])==true){
                        this.tablaDeAliens[fila][columna].viviendo = false; //alien ya no vive
                        tiroEmbarcacion.yPos = -1;
                        this.tablaDeDeadAliens[0] = fila;
                        this.tablaDeDeadAliens[1] = columna;
                        break;
                    }
                }
            }
        }
    }

    public void eliminarDeadAlien(int[] tablaDeDeadAliens){
        this.tablaDeAliens[tablaDeDeadAliens[0]][tablaDeDeadAliens[1]] = null;
        this.cantidadAliens = this.cantidadAliens - 1;
    }

    public int[] eleccionAlienTiro() {
        int posicionAlien[] = {-1,-1};
        if(this.cantidadAliens != 0) { //si aun queda aliens vivos
            do {int columna = random.nextInt(10); // se elige al azar una columna de aliens
                for(int fila = 4; fila >= 0; fila=fila-1) { // Se busca 1er alien vivo de abajo hacia arriba
                    if(tablaDeAliens[fila][columna]!= null) {
                        posicionAlien[0] = this.tablaDeAliens[fila][columna].getxPos();
                        posicionAlien[1] = this.tablaDeAliens[fila][columna].getyPos();
                        break;
                    }
                }
            } while(posicionAlien[0] == -1);
        }
        return posicionAlien;
    }



}

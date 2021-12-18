package Juego;

import Entidades.Embarcacion;
import Entidades.GrupoAliens;
import Entidades.TiroAlien;
import Entidades.TiroEmbarcacion;
import Recursos.Chrono;
import Recursos.Constantes;
import Recursos.Teclado;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {

    public Embarcacion embarcacion = new Embarcacion();
    public GrupoAliens grupAliens = new GrupoAliens();
    public TiroEmbarcacion tirEmbarcacion = new TiroEmbarcacion();
    public TiroAlien tiroAlien1, tiroAlien2, tiroAlien3;

    //Constructor
    public Scene(){
        super();
        //Inicializacion del teclado
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Teclado());

        //Inicializacion del Chrono
        Thread chronoPantalla = new Thread(new Chrono());
        chronoPantalla.start();
    }

    //Metodos
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        //Disenho del fondo de la ventana
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constantes.LARGO_VENTANA, Constantes.ALTURA_VENTANA);

        //Disenho del limite
        g2.setColor(Color.GREEN);
        g2.fillRect(30,530,535,5);

        //Disenho de la embarcacion
        this.embarcacion.dibujandoEmbarcacion(g2);

        //Disenho de los aliens
        this.grupAliens.dibujandoAliens(g2);

        //Disenho del tiro de la embarcacion o nave
        this.tirEmbarcacion.dibujandoTiroEmbarcacion(g2);

        //Se confirma que hubo contacto del disparo al alien
        this.grupAliens.tiroEmbarcacionAlien(this.tirEmbarcacion);

        //Disenho del tiro del alien
        if(Chrono.cuentaBucle % 500 == 0) {
            tiroAlien1 = new TiroAlien(this.grupAliens.eleccionAlienTiro());
        }
        if(this.tiroAlien1 != null) {
            this.tiroAlien1.dibujandoTiroAlien(g2);
            if(this.tiroAlien1.disparoTocaEmbarcacion(embarcacion) == true){
                this.embarcacion.setViviendo(false);
            }
        }
        if(Chrono.cuentaBucle % 750 == 0) {
            tiroAlien2 = new TiroAlien(this.grupAliens.eleccionAlienTiro());
        }
        if(this.tiroAlien2 != null) {
            this.tiroAlien2.dibujandoTiroAlien(g2);
            if(this.tiroAlien1.disparoTocaEmbarcacion(embarcacion) == true){
                this.embarcacion.setViviendo(false);
            }
        }
        if(Chrono.cuentaBucle % 900 == 0) {
            tiroAlien3 = new TiroAlien(this.grupAliens.eleccionAlienTiro());
        }
        if(this.tiroAlien3 != null) {
            this.tiroAlien3.dibujandoTiroAlien(g2);
            if(this.tiroAlien1.disparoTocaEmbarcacion(embarcacion) == true){
                this.embarcacion.setViviendo(false);
            }
        }
    }

}


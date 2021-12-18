package Entidades;

import Juego.Main;
import Recursos.Chrono;
import Recursos.Constantes;

import javax.swing.*;
import java.awt.*;

public class Embarcacion extends Entidad{

    private int contador = 0;

    public Embarcacion(){

        super.viviendo = true;
        super.xPos = Constantes.X_POS_EMBARCACION;
        super.yPos = Constantes.Y_POS_EMBARCACION;
        super.largo = Constantes.LARGO_EMBARCACION;
        super.altura = Constantes.ALTURA_EMBARCACION;
        super.dx = 0;
        super.dy = 0;

        //Ubicacion de imagenes de la embarcacion
        super.strimg1 = "/Imagenes/vaisseau.png";
        super.strimg2 = "/Imagenes/vaisseauDetruit.png";
        super.strimg3 = "/Imagenes/vaisseau.Detruit2.png";

        //Carga de imagen de la embarcacion
        super.ico = new ImageIcon(getClass().getResource(super.strimg1));
        super.img = this.ico.getImage();

    }

    //Metodos
    public int desplazamientoEmbarcacion() {
        //Limites posibles para moverse
        if(this.dx < 0){if(this.xPos > Constantes.LIMITE_IZQUIERDO) {this.xPos = this.xPos + this.dx;}
        }else if(dx > 0) {if(this.xPos + this.dx < Constantes.LIMITE_DERECHO) {this.xPos = this.xPos + this.dx;}}
        return this.xPos;
    }

    public void dibujandoEmbarcacion(Graphics g){
        if(this.viviendo == false){
            this.destruccionEmbarcacion();
        }
        g.drawImage(this.img, this.desplazamientoEmbarcacion(), this.yPos,null);
    }

    public void destruccionEmbarcacion(){
        if(contador < 300){
            if(Chrono.cuentaBucle % 2 == 0){
                super.ico= new ImageIcon(getClass().getResource(super.strimg2));
            }
            else
                {super.ico = new ImageIcon(getClass().getResource(super.strimg3));}
            contador = contador + 1;
        }
        else
            {Main.sigueEnJuego = false;}
        super.img = this.ico.getImage();
    }


}

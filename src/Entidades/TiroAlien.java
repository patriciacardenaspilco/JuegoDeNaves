package Entidades;

import Recursos.Chrono;
import Recursos.Constantes;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TiroAlien extends Entidad{

    Random random = new Random();


    public TiroAlien(int [] tablaPosicionAlien) {

        // Inicia variables de la super clase
        super.xPos = tablaPosicionAlien[0] + Constantes.LARGO_ALIEN /2 - 1;
        super.yPos = tablaPosicionAlien[1] + Constantes.ALTURA_ALIEN;
        super.largo = Constantes.LARGO_TIRO_ALIEN;
        super.altura = Constantes.ALTURA_TIRO_ALIEN;
        super.dx = 0;
        super.dy = Constantes.DY_TIRO_ALIEN;

        //Ubicacion de imagenes del tiro del alien
        super.strimg1 = "/Imagenes/tirAlien1.png";
        super.strimg2 = "/Imagenes/tirAlien2.png";
        super.strimg3 = "";

        //Carga de imagen del tiro del alien
        if(random.nextInt(2) == 0) {
            super.ico = new ImageIcon(getClass().getResource(super.strimg1));
        }
        else
            {super.ico = new ImageIcon(getClass().getResource(super.strimg2));}
        super.img = this.ico.getImage();
    }


    //Metodos

    public int desplazamientoTiroAlien() {
        if(Chrono.cuentaBucle % 4 == 0) {
            if(this.yPos < 600) {
                this.yPos = this.yPos + Constantes.DY_TIRO_ALIEN;
            }
        }
        return yPos;
    }

    public void dibujandoTiroAlien(Graphics g) {
        g.drawImage(this.img, this.xPos, this.desplazamientoTiroAlien(), null);
    }

    public boolean disparoTocaEmbarcacion(Embarcacion embarcacion){
        if(this.yPos < embarcacion.getyPos() + embarcacion.getAltura() && this.yPos + this.altura > embarcacion.getyPos() && this.xPos + this.largo > embarcacion.getxPos() && this.xPos < embarcacion.getxPos() + embarcacion.getLargo()){
            this.yPos = 700;
            return true;
        }
        else
            {return false;}
    }

}

package Entidades;

import Recursos.Constantes;

import javax.swing.*;
import java.awt.*;

public class TiroEmbarcacion extends Entidad{

    private boolean tiroAEmbarcacion = false;



    public TiroEmbarcacion(){
        super.xPos=0;
        super.yPos= Constantes.Y_POS_EMBARCACION - Constantes.ALTURA_TIRO_EMBARCACION;
        super.largo=Constantes.LARGO_TIRO_EMBARCACION;
        super.altura=Constantes.ALTURA_TIRO_EMBARCACION;
        super.dx=0;
        super.dy=Constantes.DY_TIRO_EMBARCACION;

        //Ubicacion de imagenes del tiro de la nave
        super.strimg1 = "/Imagenes/tirVaisseau.png";
        super.strimg2 = "";
        super.strimg3 = "";

        //Carga de imagen del tiro de la nave
        super.ico = new ImageIcon(getClass().getResource(super.strimg1));
        super.img = this.ico.getImage();

    }

    //Metodos

    public boolean isTiroEmbarcacion() {
        return tiroAEmbarcacion;
    }

    public void setTiroEmbarcacion(boolean tiroEmbarcacion) {
        this.tiroAEmbarcacion = tiroEmbarcacion;
    }

    public int desplazamientoTiroEmbarcacion(){
        if(this.tiroAEmbarcacion){
            if(this.yPos>0){
                this.yPos = this.yPos - Constantes.DY_TIRO_EMBARCACION;
            }
            else
                this.tiroAEmbarcacion =false;
        }
        return yPos;
    }

    public void dibujandoTiroEmbarcacion(Graphics g){
        if(this.tiroAEmbarcacion){
            g.drawImage(this.img,this.xPos,this.desplazamientoTiroEmbarcacion(),null);
        }
    }

    public boolean killAlien(Alien alien){
        //El tiro destruye al alien
        if(this.yPos < alien.getyPos() + alien.getAltura() && this.yPos + this.altura > alien.getyPos() && this.xPos + this.largo > alien.getxPos() && this.xPos < alien.getxPos() + alien.getLargo()){
            return true;
        }
        else
            return false;
    }


}

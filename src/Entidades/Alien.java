package Entidades;

import Recursos.Constantes;

import javax.swing.*;

public class Alien extends Entidad{

    //Constructor
    public Alien(int xPos, int yPos, String strimg1, String strimg2){
        //Inicializacion de var de super clase
        super.xPos = xPos;
        super.yPos = yPos;
        super.largo = Constantes.LARGO_ALIEN;
        super.altura = Constantes.ALTURA_ALIEN;
        super.dx = 0;
        super.dy = 0;
        super.viviendo = true;

        //Ubicacion de imagenes del alien
        super.strimg1 = strimg1;
        super.strimg2 = strimg2;
        super.strimg3 = "/Imagenes/alienMeurt.png";

        //Carga de imagen del alien
        super.ico = new ImageIcon(getClass().getResource(super.strimg1));
        super.img = this.ico.getImage();

    }

    //Metodos
    public void cambiaImagen(boolean pos1) {
        if (this.viviendo == true) {
            if (pos1 == true) {
                super.ico = new ImageIcon(getClass().getResource(strimg1));
            } else {
                super.ico = new ImageIcon(getClass().getResource(strimg2));
            }

        } else
            super.ico = new ImageIcon(getClass().getResource(strimg3));
        super.img = this.ico.getImage();
    }


}

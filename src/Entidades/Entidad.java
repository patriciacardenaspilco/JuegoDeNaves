package Entidades;

import javax.swing.*;
import java.awt.*;

public abstract class Entidad {

    protected int largo, altura, xPos, yPos, dx, dy;
    protected boolean viviendo;
    protected String strimg1, strimg2, strimg3;
    protected ImageIcon ico;
    protected Image img;



    //Getter and setter
    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public boolean isViviendo() {
        return viviendo;
    }

    public void setViviendo(boolean viviendo) {
        this.viviendo = viviendo;
    }

    public String getString1() {
        return strimg1;
    }

    public void setString1(String string1) {
        this.strimg1 = string1;
    }

    public String getString2() {
        return strimg2;
    }

    public void setString2(String string2) {
        this.strimg2 = string2;
    }

    public String getString3() {
        return strimg3;
    }

    public void setString3(String string3) {
        this.strimg3 = string3;
    }

    public ImageIcon getIco() {
        return ico;
    }

    public void setIco(ImageIcon ico) {
        this.ico = ico;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}

package Recursos;

import Juego.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(Main.scene.embarcacion.isViviendo() == true) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                Main.scene.embarcacion.setDx(Constantes.DX_EMBARCACION);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                Main.scene.embarcacion.setDx(-Constantes.DX_EMBARCACION);
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (Main.scene.tirEmbarcacion.isTiroEmbarcacion() == false) {
                    Main.scene.tirEmbarcacion.setyPos(Constantes.Y_POS_EMBARCACION - Constantes.ALTURA_TIRO_EMBARCACION);
                    Main.scene.tirEmbarcacion.setxPos(Main.scene.embarcacion.getxPos() + (Constantes.LARGO_EMBARCACION) / 2 - 1);
                    Main.scene.tirEmbarcacion.setTiroEmbarcacion(true);
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.scene.embarcacion.setDx(0);

    }
}

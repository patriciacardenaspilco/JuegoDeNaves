package Juego;

import Recursos.Constantes;

import javax.swing.*;

public class Main {

    public static Scene scene;
    public static boolean sigueEnJuego = true;

    public static void main(String[] args) {
        //Creacion de la ventana del juego
        JFrame ventana = new JFrame("Game Space Invaders ");
        ventana.setSize(Constantes.LARGO_VENTANA, Constantes.ALTURA_VENTANA);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setAlwaysOnTop(true);

        //Asociacion de paneles en la ventana
        scene = new Scene();
        ventana.setContentPane(scene);

        ventana.setVisible(true);

    }
}

package Recursos;

import Juego.Main;

public class Chrono implements Runnable {

    private final int PAUSE = 5;
    public static int cuentaBucle = 0;

    //Metodos
    @Override
    public void run() {
        while(Main.sigueEnJuego == true){
            cuentaBucle = cuentaBucle + 1;
            Main.scene.repaint();
            try {Thread.sleep(PAUSE);}
            catch (InterruptedException e) {}
        }
    }



}

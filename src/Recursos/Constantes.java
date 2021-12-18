package Recursos;

public abstract class Constantes {

    //_____________CARACTERISTICAS DE LA VENTANA_______________
    // Dimensions de la ventana del juego
    public static final int LARGO_VENTANA = 600;
    public static final int ALTURA_VENTANA = 600;
    public static final int MARGEN_VENTANA = 50;

    //_____________CARACTERISTICAS DE LA EMBARCACION_______________
    //Dimensiones de la embarcacion
    public static final int LARGO_EMBARCACION = 39;
    public static final int ALTURA_EMBARCACION = 24;

    //Posicion inicial de la embarcacion
    public static final int X_POS_EMBARCACION = (LARGO_VENTANA - LARGO_EMBARCACION)/2;
    public static final int Y_POS_EMBARCACION = 490;

    //Unidad de desplazamiento de la embarcacion
    public static final int DX_EMBARCACION = 1;

    //Limites de desplazamiento de la embarcacion
    public static final int LIMITE_IZQUIERDO = 60;
    public static final int LIMITE_DERECHO = 500;

    //_____________CARACTERISTICAS DE LOS ALIENIGENAS (INVASORES)_______________
    //Cantidad de alienigenas en bloque 5x10
    public static final int CANTIDAD_ALIENS = 50;

    //Dimensiones del alien
    public static final int LARGO_ALIEN = 33;
    public static final int ALTURA_ALIEN = 25;

    //Posicion del alien
    public static final int ALT_ALIEN = 120;
    public static final int X_POS_ALIEN = 29 + MARGEN_VENTANA;
    public static final int ESP_FILA_ALIEN = 40;
    public static final int ESP_COLUMNA_ALIEN = 10;

    //Unidad de desplazamiento de la embarcacion
    public static final int DX_ALIEN = 2;
    public static final int DY_ALIEN = 20;
    public final static int VELOCIDAD_ALIEN = 1;

    //__________________CARACTERISTICAS DEL TIRO DE LA EMBARCACION_______________
    //Dimensiones del tiro de la nave
    public static final int LARGO_TIRO_EMBARCACION = 3;
    public static final int ALTURA_TIRO_EMBARCACION = 13;

    //Unidad de desplazamiento del tiro de la nave
    public static final int DY_TIRO_EMBARCACION = 2;

    //__________________CARACTERITICAS DEL TIRO DEL ALIEN_______________
    //Dimension del tiro del alien
    public static final int LARGO_TIRO_ALIEN = 5;
    public static final int ALTURA_TIRO_ALIEN = 15;

    //Unidad de desplazamiento del tiro del alien
    public static final int DY_TIRO_ALIEN = 3;


}

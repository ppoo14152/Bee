import greenfoot.*;
import java.util.LinkedList;
/**
 * Esta clase representa al personaje principal que se maneja
 * en la primer parte de cada nivel.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 30/abril/2015
 */
public class Bee extends Elemento
{
    private int frame;
    private int numeroNectar;
    private int vida;
    private int puntaje;
    private boolean choque;
    private LinkedList <GreenfootImage> imagenes;
    private GreenfootSound get;
    private GreenfootSound knock;
    
    /**
     * Constructor de la clase Bee. Fija frame, vida, puntaje
     * y numeroNectar a 0, además de definir los sonidos e
     * imágenes que utiliza el objeto de esta clase.
     */
    public Bee()
    {
        super();
        frame = 0;
        numeroNectar = 0;
        vida = 0;
        puntaje = 0;
        get = new GreenfootSound("get.wav");
        get.setVolume(85);
        knock = new GreenfootSound("knock.wav");
        knock.setVolume(85);
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("abeja1.png"));         //0
        imagenes.add(new GreenfootImage("abeja2.png"));         //1
        imagenes.add(new GreenfootImage("abeja3.png"));         //2
        imagenes.add(new GreenfootImage("abejachoque.png"));    //3
        setImage(getImagen(0));
    }
    
    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Ejecuta las funciones que representan lo que el
     * objeto de esta clase debe hacer cuando es agregado al mundo.
     */
    public void act()
    {
        animar();
        desplazar();
        setContador();
        muestraContador();
    }
    
    /**
     * Este método define el valor de la variable puntaje con el
     * valor especificado en la llamada al método.
     * 
     * @param int Valor que va a tomar la variable puntaje.
     */
    public void setPuntaje(int puntos)
    {
        puntaje = puntos;
    }
    
    /**
     * Este método regresa el valor de la variable puntaje.
     * 
     * @return int - Valor actual de la variable puntaje.
     */
    public int getPuntaje()
    {
        return puntaje;
    }
    
    /**
     * Este método muestra en pantalla los valores de las
     * variables vida, numeroNectar y puntaje (con letrero).
     */
    public void muestraContador()
    {
        World world = getWorld();
        world.showText("x " + numeroNectar, 80, getAlto() - 48);
        world.showText("x " + vida, 152, getAlto() - 48);
        world.showText("Puntaje", 400, getAlto() - 58);
        world.showText("" + puntaje, 400, getAlto() - 38);
        world.showText("" , 250, getAlto() - 60);
    }
    
    /**
     * Este método regresa la imágen (tipo GreenfootImage)
     * contenida en una Lista de la posición específicada
     * por el valor asignado en la llamada a este método.
     * 
     * @param int Valor de la posición de la imágen que se
     * desea obtener.
     * @return GreenfootImage - Imágen contenida en la Lista
     * en la posición especificada.
     */
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
    /**
     * Este método permite desplazar al objeto creado de
     * está clase a la izquierda o a la derecha.
     * Dicho movimiento se especifica por la tecla 'a' o
     * la flecha izquierda para ir a la izquierda; la
     * tecla 'd' o la flecha derecha para ir a la derecha.
     */
    public void desplazar()
    {
        if((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) && getX() < getAncho() - BORDE) {
            move(PASOS);
        }
        if((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) && getX() > BORDE) {
            move(-PASOS);
        }
    }
    
    /**
     * Este método realiza la animación del objeto,
     * intercambiando entre imágenes bajo condiciones
     * determinadas.
     */
    public void animar()
    {
        if(choque == false) {
            switch(frame) {
                case 5: setImage(getImagen(0));
                break;
                case 10: setImage(getImagen(1));
                break;
                case 15: setImage(getImagen(2));
                break;
                case 20: setImage(getImagen(1));
                     frame = 0;
                break;
            }
        }
        if(frame == 25) {
            choque = false;
            frame = 0;
        }
        frame++;
    }
    
    /**
     * Este método regresa el valor de la variable numeroNectar.
     * 
     * @return int - Valor actual de la variable numeroNectar.
     */
    public int getNectar()
    {
        return numeroNectar;
    }
    
    /**
     * Este método define el valor de la variable numeroNectar
     * con el valor especificado en la llamada al método.
     * 
     * @param int Valor que va a tomar la variable numeroNectar.
     */
    public void setNectar(int nectar)
    {
       numeroNectar = nectar;
    }
    
    /**
     * Este método incrementa el valor de la variable
     * numeroNectar y el de la variable puntaje. La base
     * a este incremento es: si hubo colision con un
     * objeto de la clase burbujaNectar.
     * 
     * @see BurbujaNectar.class
     */
    public void setContador()
    {
        Actor b = colisionar(BurbujaNectar.class);
        if(b != null) {
            numeroNectar++;
            retirar(b);
            puntaje = puntaje + 10;
            get.play();
        }
    }
    
    /**
     * Este método decrece el valor de la variable vida.
     */
    public void setVida()
    {
        vida--;
    }
    
    /**
     * Este método define el valor de la variable vida con el
     * valor especificado en la llamada al método.
     * 
     * @param int Valor que va a tomar la variable vida.
     */
    public void setVida(int numVidas)
    {
        vida = numVidas;
    }
    
    /**
     * Este método realiza la animación de la abeja al recibir daño.
     */
    public void chocar()
    {
        setImage(getImagen(3));
        knock.play();
        choque = true;
        frame = 0;
    }
    
    /**
     * Este método define la imágen (tipo GreenfootImage)
     * que el objeto de esta clase va a tomar. Dicha imágen
     * es obtenida de una Lista de la posición específicada
     * por el valor asignado en la llamada a este método.
     * 
     * @param int Valor de la posición de la imágen que se
     * desea obtener.
     */
    public void setImagen(int n)
    {
        setImage(getImagen(n));
    }
    
    /**
     * Este método regresa el valor de la variable vida.
     * 
     * @return int - Valor actual de la variable vida.
     */
    public int getVida()
    {
        return vida;
    }
}

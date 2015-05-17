import greenfoot.*;
import java.util.LinkedList;

/**
 * Esta clase es un elemento de la interfaz del juego,
 * es agregado en en la fase dos de cada nivel.
 * Representa el número de  paneles que se pueden construir.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 30/abril/2015
 */
public class Carga extends Elemento
{
    private LinkedList <GreenfootImage> imagenes;
    private int contador;
    private int limite;
    private int frame;
    private int tempo;

    /**
     * Constructor de la clase Bee. Fija frame y tempo a 0, 
     * limite y contador a 6, además define las
     * imágenes que utiliza el objeto de esta clase.
     */
    public Carga()
    {
        super();
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("carga0.png")); //0
        imagenes.add(new GreenfootImage("carga1.png")); //1
        imagenes.add(new GreenfootImage("carga2.png")); //2
        imagenes.add(new GreenfootImage("carga3.png")); //3
        imagenes.add(new GreenfootImage("carga4.png")); //4
        imagenes.add(new GreenfootImage("carga5.png")); //5
        imagenes.add(new GreenfootImage("carga6.png")); //6
        setImage(getImagen(6));
        contador = 6;
        limite = 6;
        frame = 0;
        tempo = 0;
    }
    
    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Ejecuta las funciones que representan lo que el
     * objeto de esta clase debe hacer cuando es agregado al mundo.
     */
    public void act() 
    {
        frame++;
        setImage(getImagen(contador));
        incrementaContador();
    }    
    
    /**
     * Este método aumenta la variable contador si se cumplen
     * las condiciones establecidas.
     */
    public void incrementaContador()
    {
        if(frame > tempo && contador < 6) {
            contador++;
            frame = 0;
        }
    }
    
    /**
     *Este método decrementa la variable contador si se cumplen
     * las condiciones establecidas.
     */
    public void setContador()
    {
        if(contador > 0) {
            contador--;
            frame = 0;
        }
    }
    
     /**
     * Método utilizado para cambiar el valor de la variable contador.
     * 
     * @param int Valor que va a tomar la variable contador.
     */
    public void setCarga(int n)
    {
        contador = n;
    }

     /**
     * Este método regresa el valor de la variable contador.
     * 
     * @return int - Valor actual de la variable contador.
     */
    public int getCotador()
    {
        return contador;
    }
    
    /**
     * Método utilizado para cambiar el valor de la variable tempo.
     * 
     * @param int Valor que va a tomar la variable tempo.
     */
    public void setTempo(int n)
    {
        tempo = n;
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
}

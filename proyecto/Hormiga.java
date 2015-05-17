import greenfoot.*;
import java.util.LinkedList;
/**
 * Esta clase representa un enemigo en la fase dos de cada nivel
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 05/mayo/2015
 */
public class Hormiga extends Enemigo
{
    private LinkedList <GreenfootImage> imagenes;
    private int frame;
    
     /**
     * Constructor de la clase Hormiga. Fija frame a 0, además de definir las
     * imágenes que utiliza el objeto de esta clase.
     */
    public Hormiga()
    {
        super();
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("h1.png"));         //0
        imagenes.add(new GreenfootImage("h2.png"));         //1
        setImage(getImagen(0));
        frame = 0;
    }
    
    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Ejecuta las funciones que representan lo que el
     * objeto de esta clase debe hacer cuando es agregado al mundo.
     */
    public void act() 
    {
        turnTowards(getAncho() / 2, getAlto() / 5 * 2);
        mover();
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
     * Este método intercambia las imagenes del objeto
     * para generar una animación ademas de moverlo 
     * en la dirección establecida.
     *
     */   
    public void mover()
    {
        switch(frame) {
            case 4: setImage(getImagen(0));
            break;
            case 8: setImage(getImagen(1));
                    move(6);
                    frame = 0;
            break;
        }
        frame++;
    }
}

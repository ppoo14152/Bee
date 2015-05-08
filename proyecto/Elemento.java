import greenfoot.*;
import java.util.LinkedList;
/**
 * Está clase se encarga de proporcionar métodos específicos para ser
 * usados por cualquier subclase en general. Además de proporcionar
 * variables globales que también son utilizadas por las mismas.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 26/abril/2015
 */
public class Elemento extends Actor
{
    /**
     * Variable global constante (int) que representa el número de pixeles que
     * se puede avanzar.
     */
    public final int PASOS = 5;
    
    /**
     * Variable global constante (int) que representa el número de pixeles
     * limite máximo antes de tocar el borde del escenario.
     */
    public final int BORDE = 61;
    
    /**
     * Constructor de la clase Elemento.
     */
    public Elemento()
    {
        super();
    }
    
    /**
     * Este método remueve del mundo al Actor dado en la llamada al
     * mismo. Dicho actor debe ser definido antes de ser ingresado.
     * 
     * @param Actor El actor que será removido del Juego (mundo).
     */
    public void retirar(Actor a)
    { 
        World world = getWorld();
        world.removeObject(a);
    }
    
    /**
     * Este método remueve del mundo la LinkedList dada en la llamada al
     * mismo. Dicha Lista y su contenido deben ser definidos antes de
     * ser ingresada.
     * 
     * @param LinkedList La lista que será removida del Juego (mundo).
     */
    public void retirarLista(LinkedList l)
    { 
        World world = getWorld();
        world.removeObjects(l);
    }
    
    /**
     * Este método regresa el Ancho del mundo.
     * 
     * @return int - El Ancho en pixeles del mundo.
     */
    public int getAncho()
    {
        World world = getWorld();
        return world.getWidth();
    }
    
    /**
     * Este método regresa el Alto del mundo.
     * 
     * @return int - El Alto en pixeles del mundo.
     */
    public int getAlto()
    {
        World world = getWorld();
        return world.getHeight();
    }
    
    /**
     * Este método regresa a un Actor de la clase especificada con el
     * que se haya tenido contacto. Dicho Actor será aquel que haya
     * tenido contacto con el punto 0,0 del objeto de la clase en
     * donde se hace llamada al método.
     * 
     * @param Class La clase que especifica al objeto con el que se
     * verificará cuando haya contacto.
     * @return Actor - El actor de la clase especificada con el que se
     * hizo contacto.
     */
    public Actor colisionar(Class c)
    {
        return getOneObjectAtOffset(0, 0, c);
    }
}

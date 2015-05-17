import greenfoot.*;
import java.util.List;
/**
 * Esta clase representa la explosion que se puede realizar
 * en la en la segunda fase de cada nivel.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 30/abril/2015
 */
public class Explosion extends Elemento
{
    private int frame;
    private GreenfootImage sprite;
    private Juego mundo;
    private List <Enemigo> Enemigos;
      /**
     * Constructor de la clase Explosion. Fija frame,
     * define y asigna la imagen que utiliza el objeto de esta clase.
     */
    public Explosion()
    {
        super();
        frame = 0;
        sprite = new GreenfootImage("explosion.png");
        setImage(sprite);
    }
    
    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Ejecuta las funciones que representan lo que el
     * objeto de esta clase debe hacer cuando es agregado al mundo.
     */
    public void act() 
    {
        contactoEnemigo();
        degradar();
    }  
   
     /**
     * Este método iguala la variable mundo a el World de juego.
     *
     *@param World Variable que representa el mundo del proyecto. 
     */
    public void addedToWorld(World world) 
    {
        mundo = (Juego) world;        
    }
    
     /**
     * Este método se encarga de eliminar el objeto despues
     * de terminar el tiempo de acción.
     */
    public void degradar()
    {
        frame++;
        if(frame == 100)
        {
            mundo.removeObject(this);
            frame = 0;
        }
    }
    
     /**
     * Este método se encarga de eliminar los objetos de la clase
     * Enemigo que esten en contacto con el despues de un determinado 
     * tiempo, además de incrementar el puntaje del nivel.
     */
    public void contactoEnemigo()
    {
        Enemigos = getObjectsInRange(50, Enemigo.class);
        if(Enemigos.size() > 0 && frame > 25) {
            mundo.removeObjects(Enemigos);
            Actor b = mundo.getReyna();
            ((Queen)b).aumentaPuntaje();
        }
    }
}

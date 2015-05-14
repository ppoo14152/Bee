import greenfoot.*;
import java.util.List;

public class Explosion extends Elemento
{
    private int frame;
    private GreenfootImage sprite;
    private Juego mundo;
    private List <Enemigo> Enemigos;
    
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
    
    public void addedToWorld(World world) 
    {
        mundo = (Juego) world;        
    }
    
    public void degradar()
    {
        frame++;
        if(frame == 100)
        {
            mundo.removeObject(this);
            frame = 0;
        }
    }
    
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

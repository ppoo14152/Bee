import greenfoot.*;
import java.util.LinkedList;

public class Elemento extends Actor
{
    public final int PASOS = 5;
    public final int BORDE = 61;
    
    public Elemento()
    {
        super();
    }
    
    public void retirar(Actor a)
    { 
        World world = getWorld();
        world.removeObject(a);
    }
    
    public void retirarLista(LinkedList l)
    { 
        World world = getWorld();
        world.removeObjects(l);
    }
    
    public int getAncho()
    {
        World world = getWorld();
        return world.getWidth();
    }
    
    public int getAlto()
    {
        World world = getWorld();
        return world.getHeight();
    }
    
    public Actor colisionar(Class c)
    {
        return getOneObjectAtOffset(0, 0, c);
    }
    
}

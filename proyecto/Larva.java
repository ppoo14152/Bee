import greenfoot.*;
import java.util.LinkedList;
/**
 * Escribe una descrición de la clase Larva aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Larva extends Enemigo
{
    /**
     * Act - hace lo que Larva quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    private LinkedList <GreenfootImage> imagenes;
    private int frame;
    
    public Larva(int sprite)
    {
        super();
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("gusano1.png"));         //0
        imagenes.add(new GreenfootImage("gusano2.png"));         //1
        setImage(getImagen(sprite));
        frame = 0;
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
    public void act() 
    {
        turnTowards(getAncho() / 2, getAlto() / 5 * 2);
        mover();
    }    
    
    public void mover()
    {
        if(frame > 10) {
            move(4);
            frame = 0; 
        } 
        frame++;
    }
}

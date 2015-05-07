import greenfoot.*;
import java.util.LinkedList;
/**
 * Escribe una descrición de la clase Hormiga aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Hormiga extends Enemigo
{
    private LinkedList <GreenfootImage> imagenes;
    private int frame;
    
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
     * Act - hace lo que Hormiga quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    public void act() 
    {
        turnTowards(getAncho() / 2, getAlto() / 5 * 2);
        mover();
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
    public void mover()
    {
        switch(frame) {
            case 4: setImage(getImagen(0));
            break;
            case 8: setImage(getImagen(1));
                    move(5);
                    frame = 0;
            break;
        }
        frame++;
    }
}

import greenfoot.*;
import java.util.LinkedList;
/**
 * Escribe una descrición de la clase Polilla aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Polilla extends Enemigo
{
    private LinkedList <GreenfootImage> imagenes;
    private int frame;
    /**
     * Act - hace lo que Polilla quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    public Polilla()
    {
        super();
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("polilla1.png"));         //0
        imagenes.add(new GreenfootImage("polilla2.png"));         //1
        setImage(getImagen(0));
        frame = 0;
    }
    
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
            case 0: setImage(getImagen(1));
            break;
            case 10: setImage(getImagen(1));
                     move(4);
            break;
            case 20: move(4);
                     frame = 0;
            break;
        }
        frame++;
    }
}

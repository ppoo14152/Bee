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
    private int imagen;
    
    public Larva(int sprite)
    {
        super();
        imagen = sprite;
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("gusano1.png"));         //0
        imagenes.add(new GreenfootImage("gusano2.png"));         //1
        imagenes.add(new GreenfootImage("gusano1-2.png"));       //2
        imagenes.add(new GreenfootImage("gusano2-2.png"));       //3
        setImage(getImagen(imagen));
        frame = 0;
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
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
        animar();
        frame++;
    }    
    
    public void animar()
    {
        switch(frame)
        {
            case 10: if(imagen == 0)
                     {
                         setImage(getImagen(2));
                     }
                     else
                     {
                         setImage(getImagen(3));
                     }
            break;
            case 20: if(imagen == 0)
                     {
                         setImage(getImagen(0));
                     }
                     else
                     {
                         setImage(getImagen(1));
                     }
                     frame = 0;
            break;
        }
    }
    
    public void mover()
    {
        if(frame % 10 == 0) {
            move(4);
        } 
    }
}

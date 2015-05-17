import greenfoot.*;
import java.util.LinkedList;
/**
 * Esta clase representa un enemigo en la fase dos de cada nivel
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 30/abril/2015
 */
public class Larva extends Enemigo
{
   
    private LinkedList <GreenfootImage> imagenes;
    private int frame;
    private int imagen;
    
     /**
     * Constructor de la clase Hormiga. Fija frame a 0, además de definir las
     * imágenes que utiliza el objeto de esta clase.
     * 
     * @param int Valor que va a tomar la variable imagen.
     */
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
   
    /**
     * Este método intercambia las imagenes del objeto
     * para generar una animación.
     */   
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
     
    /**
     * Este método mueve el objeto en la dirección establecida.
     *
     */   
    public void mover()
    {
        if(frame % 10 == 0) {
            move(4);
        } 
    }
}

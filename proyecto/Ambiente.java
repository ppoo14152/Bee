import greenfoot.*;
import java.util.LinkedList;

/**
 * Esta clase representa a los objetos que forman parte
 * del fondo en la primer parte de cada nivel.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 30/abril/2015
 */
public class Ambiente extends Elemento
{
    private int frame;
    private int tipo;
    private LinkedList <GreenfootImage> imagenes;
    
    /**
     * Constructor de la clase Ambiente. Inicializa las variables frame, 
     * y tipo, además de definir  las imágenes que utiliza el objeto de esta clase.
     */
    public Ambiente() 
    {
        super();
        frame = 0;
        tipo = 0;
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("pasto.png"));          //0
        imagenes.add(new GreenfootImage("hoja.png"));           //1
        imagenes.add(new GreenfootImage("hoja2.png"));          //2
        imagenes.add(new GreenfootImage("piedra.png"));         //3
        imagenes.add(new GreenfootImage("flor.png"));           //4
        setImage(getImagen(0));
    }
    
    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Ejecuta las funciones que representan lo que el
     * objeto de esta clase debe hacer cuando es agregado al mundo.
     */
    public void act()
    {
        if(frame == 2)
        {
            setLocation(getX(), getY() + PASOS);
            if(getY() > getAlto() - 10) {
                setAmbiente();
            }
            frame = 0;
        }
        frame++;
    }
    
    /**
     * Este método define la imagen que tendra este objeto cada vez que 
     * sea llamado.
     */
    public void setAmbiente()
    {
        tipo = Greenfoot.getRandomNumber(8);
        switch(tipo) {
            case 0: case 1: case 6: case 7: case 8: setImage(getImagen(0));
                    setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
            break;
            case 2: setImage(getImagen(1));
                    setLocation(30, 0);
            break;
            case 3: setImage(getImagen(2));
                    setLocation(getAncho() - 30, 0);
            break;
            case 4: setImage(getImagen(3));
                    setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
            break;
            case 5: setImage(getImagen(4));
                    setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
            break;
        }
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
}
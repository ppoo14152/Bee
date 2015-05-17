import greenfoot.*;
import java.util.LinkedList;

/**
 * Esta clase representa a un depredador (araña o polilla), un
 * obstáculo en la primer fase de cada nivel.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 05/mayo/2015
 */
public class Depredador extends Elemento
{
    private int frame;
    private int fase;
    private int pasos;
    private LinkedList <GreenfootImage> imagenes;
    
    /**
    * Constructor de la clase Mouse. Iniciaiza las variables
    * de instancia, además de definir las imagenes que
    * utiliza el objeto de esta clase.
    */
    public Depredador(int numero)
    {
        super();
        frame = 0;
        fase = numero;
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("a1.png"));         //0
        imagenes.add(new GreenfootImage("a2.png"));         //1
        imagenes.add(new GreenfootImage("polilla1.png"));   //2
        imagenes.add(new GreenfootImage("polilla2.png"));   //3
        imagenes.add(new GreenfootImage("polilla3.png"));   //4
        setImagen();
    }
    
    /**
     * Este método define la imágen (tipo GreenfootImage)
     * que el objeto de esta clase va a tomar, además de
     * definir la distancia que avanzará el objeto al moverse.
     * Dicha imágen es obtenida de una Lista de la posición
     * específicada por el valor asignado en la llamada
     * a este método.
     * 
     * @param int Valor de la posición de la imágen que se
     * desea obtener.
     */
    public void setImagen()
    {
        if(fase == 1) {
            setImage(getImagen(0));
            pasos = PASOS;
        }
        else {
            setImage(getImagen(2));
            pasos = PASOS + 3;
        }     
    }

    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Ejecuta las funciones que representan lo que el
     * objeto de esta clase debe hacer cuando es agregado al mundo.
     */    
    public void act() 
    {
        if(frame %2 == 0) {
            tocar();
            mover();
            come();
        }
        frame++;
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
     * Este método mueve un objeto de esta clase por el escenario,
     * además de redefinir su posición cuando llega a un limite
     * establecido. También se encarga de animar al objeto
     * simulando su movimiento
     */
    public void mover()
    {
        setLocation(getX(), getY() + pasos);
        switch(frame)
        {
            case 10: if(fase == 1) {
                         setImage(getImagen(1));
                     }
                     else {
                         setImage(getImagen(3));
                     }
            break;
            case 20: if(fase == 1) {
                         setImage(getImagen(0));
                         frame = 0;
                     }
                     else {
                         setImage(getImagen(4));
                     }
            break;
            case 30: setImage(getImagen(3));
            break;
            case 40: setImage(getImagen(2));
                     frame = 0;
            break;
        }
        if(getY() > getAlto() - 10) {
            setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
        }
    }
    
    /**
     * Este método envía varias señales al objeto de la clase Bee
     * que esté teniendo contacto con un objeto de esta clase.
     * Dichas señales modifican el estado del objeto de la clase
     * Bee.
     */
    public void come()
    {
        Actor b = getOneObjectAtOffset(0, 75, Bee.class);
        if(b != null) {
            ((Bee) b).setVida();
            ((Bee) b).chocar();
            setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
        }
    }
    
    /**
     * Este método envía una señal al objeto de la clase
     * BurbujaNectar que esté teniendo contacto con un objeto
     * de esta clase.
     */
    public void tocar()
    {
        Actor b = getOneObjectAtOffset(0, 75, BurbujaNectar.class);
        if(b != null) {
            ((BurbujaNectar) b).tocar();
        }
    }    
}

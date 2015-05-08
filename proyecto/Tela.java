import greenfoot.*;
/**
 * Esta clase representa a una telaraña, un obstáculo en la primer
 * fase de cada nivel.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 26/abril/2015
 */
public class Tela extends Elemento
{
    private int frame;
    private GreenfootImage sprite;
    
    /**
     * Constructor de la clase Tela. Inicializa frame a 0 y
     * define la imágen que toma el objeto que se crea de esta
     * clase.
     */
    public Tela()
    {
        super();
        frame = 0;
        sprite = new GreenfootImage("tela.png");
        setImage(sprite);
    }
    
    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Llama a las funciones que representan lo que el
     * objeto debe hacer cuando es agregado al mundo.
     */
    public void act() 
    {
        if(frame == 2) {
            tocar();
            mover();
            atrapar();
        }
        frame++;
    }
    
    /**
     * Este método mueve un objeto de esta clase por el escenario,
     * además de redefinir su posición cuando llega a un limite
     * establecido.
     */
    public void mover()
    {
        setLocation(getX(), getY() + PASOS);
        if(getY() > getAlto() - 10) {
            setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
        }
        frame = 0;
    }
    
    /**
     * Este método envía varias señales al objeto de la clase Bee
     * que esté teniendo contacto con un objeto de esta clase.
     * Dichas señales modifican el estado del objeto de la clase
     * Bee.
     * 
     * @see #Bee.setVida()
     * @see #Bee.chocar()
     */
    public void atrapar()
    {
        Actor b = colisionar(Bee.class);
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
     * 
     * @see #Bee.tocar()
     */
    public void tocar()
    {
        Actor b = colisionar(BurbujaNectar.class);
        if(b != null) {
            ((BurbujaNectar) b).tocar();
        }
    }
}

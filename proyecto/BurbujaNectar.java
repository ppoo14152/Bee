import greenfoot.*;
/**
 * Esta clase representa 
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 30/abril/2015
 */
public class BurbujaNectar extends Elemento
{
    private int frame;
    private GreenfootImage sprite;
    
    /**
     * Constructor de la clase Bee. Fija frame a 0, además
     * la imágen que utiliza el objeto de esta clase.
     */
    public BurbujaNectar()
    {
        super();
        frame = 0;
        sprite = new GreenfootImage("nectar.png");
        setImage(sprite);
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
            mover();
        }
        frame++;
    }
    
    /**
     * Este método mueve un objeto de esta clase por el escenario,
     * además de redefinir su posición cuando llega a un límite
     * establecido.
     */
    public void mover()
    {
        setLocation(getX(), getY() + 5);
        if(getY() > getAlto() - 120) {
            retirar(this);
        }
        frame = 0;
    }
    
    /**
     * Este método reposiciona al objeto de esta clase.
     */
    public void tocar()
    {
        int n = Greenfoot.getRandomNumber(getAncho()) + 61;
        if(n > getAncho() - 61) {
            n = getAncho() - 61;
        }
        setLocation(n, getY());
    }
}

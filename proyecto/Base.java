import greenfoot.*;
/**
 * Esta clase representa un elemento de la interfaz del juego,
 * es agregado en cada fase de cada nivel.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 26/abril/2015
 */
public class Base extends Elemento
{
    private GreenfootImage sprite;
    
    public Base()
    {
        super();
        sprite = new GreenfootImage("base.png");
        setImage(sprite);
    }
}

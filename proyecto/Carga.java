import greenfoot.*;
import java.util.LinkedList;

/**
 * Esta clase representa un elemento de la interfaz del juego,
 * es agregado en cada fase de cada nivel.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 30/abril/2015
 */
public class Carga extends Elemento
{
    private LinkedList <GreenfootImage> imagenes;
    private int contador;
    private int limite;
    private int frame;
    private int tempo;

    public Carga()
    {
        super();
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("carga0.png")); //0
        imagenes.add(new GreenfootImage("carga1.png")); //1
        imagenes.add(new GreenfootImage("carga2.png")); //2
        imagenes.add(new GreenfootImage("carga3.png")); //3
        imagenes.add(new GreenfootImage("carga4.png")); //4
        imagenes.add(new GreenfootImage("carga5.png")); //5
        imagenes.add(new GreenfootImage("carga6.png")); //6
        setImage(getImagen(6));
        contador = 6;
        limite = 6;
        frame = 0;
        tempo = 0;
    }
    
    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Ejecuta las funciones que representan lo que el
     * objeto de esta clase debe hacer cuando es agregado al mundo.
     */
    public void act() 
    {
        frame++;
        setImage(getImagen(contador));
        incrementaContador();
    }    
    
    public void incrementaContador()
    {
        if(frame > tempo && contador < 6) {
            contador++;
            frame = 0;
        }
    }
    
    public void setContador()
    {
        if(contador > 0) {
            contador--;
            frame = 0;
        }
    }
    
    public void setCarga(int n)
    {
        contador = n;
    }
    

    public int getCotador()
    {
        return contador;
    }
    
    public void setTempo(int n)
    {
        tempo = n;
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
}

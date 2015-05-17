import greenfoot.*;
import java.util.LinkedList;

public class Depredador extends Elemento
{
    private int frame;
    private int fase;
    private int pasos;
    private LinkedList <GreenfootImage> imagenes;
    
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
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
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
    
    public void come()
    {
        Actor b = getOneObjectAtOffset(0, 75, Bee.class);
        if(b != null) {
            ((Bee) b).setVida();
            ((Bee) b).chocar();
            setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
        }
    }
    
    public void tocar()
    {
        Actor b = getOneObjectAtOffset(0, 75, BurbujaNectar.class);
        if(b != null) {
            ((BurbujaNectar) b).tocar();
        }
    }    
}

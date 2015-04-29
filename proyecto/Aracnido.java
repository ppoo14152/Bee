import greenfoot.*;
import java.util.LinkedList;

public class Aracnido extends Elemento
{
    private int frame;
    private int tipo;
    private LinkedList <GreenfootImage> imagenes;
    
    public Aracnido()
    {
        super();
        tipo = 0;
        frame = 0;
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("a1.png"));         //0
        imagenes.add(new GreenfootImage("a2.png"));         //1
        setImage(getImagen(0));
    }
    
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
        setLocation(getX(), getY() + PASOS);
        if(frame == 10) {
            frame = 0;
            if(tipo == 0) {
                tipo = 1;
                setImage(getImagen(1));
            }
            else {
                tipo = 0;
                setImage(getImagen(0));
            }
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

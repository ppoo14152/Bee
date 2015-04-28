import greenfoot.*;
import java.util.LinkedList;

public class Ambiente extends Elemento
{
    private int frame;
    private int tipo;
    private LinkedList <GreenfootImage> imagenes;
    
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
    
    public void act()
    {
        if(frame == 2)
        {
            setLocation(getX(), getY() + PASOS);
            if(getY() > getAlto() - 10)
            {
                tipo = Greenfoot.getRandomNumber(8);
                switch(tipo)
                {
                    case 0: case 1: case 6: case 7: case 8: setImage(getImagen(0));;
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
            frame = 0;
        }
        frame++;
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
}
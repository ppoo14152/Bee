import greenfoot.*;
import java.util.LinkedList;

public class Queen extends Elemento
{
    private int frame;
    private LinkedList <GreenfootImage> imagenes;
    private GreenfootSound knock;
    public Queen()
    {
        super();
        frame = 0;
        knock = new GreenfootSound("knock.wav");
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("reyna1.png"));         //0
        imagenes.add(new GreenfootImage("reyna2.png"));         //1
        imagenes.add(new GreenfootImage("reyna3.png"));         //2
        imagenes.add(new GreenfootImage("reyna4.png"));         //3
        imagenes.add(new GreenfootImage("reynadead.png"));      //4
        setImage(getImagen(0));
    }
    public void act() 
    {
        animar();
    }    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    public void animar()
    {
            switch(frame)
            {
                case 10: setImage(getImagen(1));
                break;
                case 20: setImage(getImagen(2));
                break;
                case 30: setImage(getImagen(3));
                break;
                case 40: setImage(getImagen(2));
                break;
                case 50: setImage(getImagen(1));
                break;                
                case 60: setImage(getImagen(0));
                     frame = 0;
                break;
            }
            frame++;
        }
        
  }    


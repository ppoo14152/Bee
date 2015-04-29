import greenfoot.*;
import java.util.LinkedList;

public class Bee extends Elemento
{
    private int frame;
    private int numeroNectar;
    private int vida;
    private boolean choque;
    private LinkedList <GreenfootImage> imagenes;
    private GreenfootSound get;
    private GreenfootSound knock;
    
    public Bee()
    {
        super();
        frame = 0;
        numeroNectar = 0;
        vida = 0;
        get = new GreenfootSound("get.wav");
        knock = new GreenfootSound("knock.wav");
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("abeja1.png"));         //0
        imagenes.add(new GreenfootImage("abeja2.png"));         //1
        imagenes.add(new GreenfootImage("abeja3.png"));         //2
        imagenes.add(new GreenfootImage("abeja4.png"));         //3
        imagenes.add(new GreenfootImage("abejachoque.png"));    //4
        setImage(getImagen(0));
    }
 
    public void act()
    {
        World world = getWorld();
        animar();
        desplazar();
        setContador();
        world.showText("x " + numeroNectar, 80, getAlto() - 63);
        world.showText("x " + vida, 165, getAlto() - 63);
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }

    public void desplazar()
    {
        if((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) && getX() < getAncho() - BORDE)
        {
            move(PASOS);
        }
        if((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) && getX() > BORDE)
        {
            move(-PASOS);
        }
    }
    
    public void animar()
    {
        if(choque == false)
        {
            switch(frame)
            {
                case 5: setImage(getImagen(1));
                break;
                case 10: setImage(getImagen(2));
                break;
                case 15: setImage(getImagen(3));
                break;
                case 20: setImage(getImagen(0));
                     frame = 0;
                break;
            }
        }
        if(frame == 25)
        {
            choque = false;
            frame = 0;
        }
        frame++;
    }
    
    public int getNectar()
    {
        return numeroNectar;
    }

    public void setContador()
    {
        Actor b = colisionar(BurbujaNectar.class);
        if(b != null)
        {
            numeroNectar++;
            retirar(b);
            get.play();
        }
    }
    
    public void setVida()
    {
        vida--;
    }
    
    public void setVida(int numVidas)
    {
        vida=numVidas;
    }
    
    public void chocar()
    {
        setImage(getImagen(4));
        knock.play();
        choque = true;
        frame = 0;
    }
    
    public int getVida()
    {
        return vida;
    }
}

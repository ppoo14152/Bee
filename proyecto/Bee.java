import greenfoot.*;
import java.util.LinkedList;

public class Bee extends Elemento
{
    private int frame;
    private int numeroNectar;
    private int vida;
    private int puntaje;
    private boolean choque;
    private LinkedList <GreenfootImage> imagenes;
    private GreenfootSound get;
    private GreenfootSound knock;
    private GreenfootSound abeja;
    
    public Bee()
    {
        super();
        frame = 0;
        numeroNectar = 0;
        vida = 0;
        puntaje = 0;
        get = new GreenfootSound("get.wav");
        get.setVolume(85);
        knock = new GreenfootSound("knock.wav");
        knock.setVolume(85);
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("abeja1.png"));         //0
        imagenes.add(new GreenfootImage("abeja2.png"));         //1
        imagenes.add(new GreenfootImage("abeja3.png"));         //2
        imagenes.add(new GreenfootImage("abejachoque.png"));    //3
        setImage(getImagen(0));
    }
 
    public void act()
    {
        animar();
        desplazar();
        setContador();
        muestraContador();
    }
    
    public void setPuntaje(int puntos)
    {
        puntaje = puntos;
    }
    
    public int getPuntaje()
    {
        return puntaje;
    }
    
    public void muestraContador()
    {
        World world = getWorld();
        world.showText("x " + numeroNectar, 80, getAlto() - 48);
        world.showText("x " + vida, 152, getAlto() - 48);
        world.showText("Puntaje", 400, getAlto() - 58);
        world.showText("" + puntaje, 400, getAlto() - 38);
        world.showText("" , 250, getAlto() - 60);
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }

    public void desplazar()
    {
        if((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) && getX() < getAncho() - BORDE) {
            move(PASOS);
        }
        if((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) && getX() > BORDE) {
            move(-PASOS);
        }
    }
    
    public void animar()
    {
        if(choque == false) {
            switch(frame) {
                case 5: setImage(getImagen(0));
                break;
                case 10: setImage(getImagen(1));
                break;
                case 15: setImage(getImagen(2));
                break;
                case 20: setImage(getImagen(1));
                     frame = 0;
                break;
            }
        }
        if(frame == 25) {
            choque = false;
            frame = 0;
        }
        frame++;
    }
    
    public int getNectar()
    {
        return numeroNectar;
    }
    
    public void setNectar( int nectar)
    {
       numeroNectar = nectar;
    }

    public void setContador()
    {
        Actor b = colisionar(BurbujaNectar.class);
        if(b != null) {
            numeroNectar++;
            retirar(b);
            puntaje = puntaje + 10;
            get.play();
        }
    }
    
    public void setVida()
    {
        vida--;
    }
    
    public void setVida(int numVidas)
    {
        vida = numVidas;
    }
    
    public void chocar()
    {
        setImage(getImagen(3));
        knock.play();
        choque = true;
        frame = 0;
    }
    
    public void setImagen(int n)
    {
        setImage(getImagen(n));
    }
    
    public int getVida()
    {
        return vida;
    }
}

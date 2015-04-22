import greenfoot.*;

public class Bee extends Elemento
{
    private int frame;
    private int numNectar;
    private int vida;
    private boolean choque;
    
    public Bee(int numVidas)
    {
        super();
        frame = 0;
        numNectar = 0;
        vida = numVidas;
    }
 
    public void act()
    {
        World world = getWorld();
        animar();
        desplazar();
        setContador();
        world.showText("x " + numNectar, 80, getAlto() - 48);
        world.showText("x " + vida, 165, getAlto() - 48);
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
                case 5: setImage("abeja2.png");
                break;
                case 10: setImage("abeja3.png");
                break;
                case 15: setImage("abeja4.png");
                break;
                case 20: setImage("abeja1.png");
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
        return numNectar;
    }

    public void setContador()
    {
        Actor b = colisionar(BurbujaNectar.class);
        if(b != null)
        {
            numNectar++;
            retirar(b);
            Greenfoot.playSound("get.wav");
        }
    }
    
    public void setVida()
    {
        vida--;
    }
    
    public void chocar()
    {
        setImage("abejachoque.png");
        Greenfoot.playSound("knock.wav");
        choque = true;
        frame = 0;
    }
    
    public int getVida()
    {
        return vida;
    }
}

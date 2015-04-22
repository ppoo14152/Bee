import greenfoot.*;

public class Aracnido extends Elemento
{
    private int frame;
    private int tipo;
    
    public Aracnido()
    {
        super();
        tipo = 0;
        frame = 0;
        setImage("a1.png");
    }
    
    public void act() 
    {
        if(frame %2 == 0)
        {
            tocar();
            mover();
            come();
        }
        frame++;
    }
    
    public void mover()
    {
        setLocation(getX(), getY() + PASOS);
        if(frame == 10)
        {
            frame = 0;
            if(tipo == 0)
            {
                tipo = 1;
                setImage("a2.png");
            }
            else
            {
                tipo = 0;
                setImage("a1.png");
            }
        }
        if(getY() > getAlto() - 10)
        {
            setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
        }
    }
    
    public void come()
    {
        Actor b = getOneObjectAtOffset(0, 75, Bee.class);
        if(b != null)
        {
            ((Bee) b).setVida();
            ((Bee) b).chocar();
            setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
        }
    }
    
    public void tocar()
    {
        Actor b = getOneObjectAtOffset(0, 75, BurbujaNectar.class);
        if(b != null)
        {
            ((BurbujaNectar) b).tocar();
        }
    }
}

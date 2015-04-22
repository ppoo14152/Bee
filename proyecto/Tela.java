import greenfoot.*;

public class Tela extends Elemento
{
    private int frame;
  
    public Tela()
    {
        super();
        frame = 0;
        setImage("tela.png");
    }
    
    public void act() 
    {
        if(frame == 2)
        {
            tocar();
            mover();
            atrapar();
        }
        frame++;
    }
    
    public void mover()
    {
        setLocation(getX(), getY() + PASOS);
        if(getY() > getAlto() - 10)
        {
            setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
        }
        frame = 0;
    }
    
    public void atrapar()
    {
        Actor b = getOneObjectAtOffset(0, 0, Bee.class);
        if(b != null)
        {
            ((Bee) b).setVida();
            ((Bee) b).chocar();
            setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
        }
    }
    
    public void tocar()
    {
        Actor b = colisionar(BurbujaNectar.class);
        if(b != null)
        {
            ((BurbujaNectar) b).tocar();
        }
    }
}

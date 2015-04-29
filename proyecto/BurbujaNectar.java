import greenfoot.*;

public class BurbujaNectar extends Elemento
{
    private int frame;
    private GreenfootImage sprite;
    
    public BurbujaNectar()
    {
        super();
        frame = 0;
        sprite = new GreenfootImage("nectar.png");
        setImage(sprite);
    }
    
    public void act() 
    {
        if(frame == 2)
        {
            mover();
        }
        frame++;
    }
    
    public void mover()
    {
        setLocation(getX(), getY() + 5);
        if(getY() > getAlto() - 120) {
            retirar(this);
        }
        frame = 0;
    }
    
    public void tocar()
    {
        int n = Greenfoot.getRandomNumber(getAncho()) + 61;
        if(n > getAncho() - 61) {
            n = getAncho() - 61;
        }
        setLocation(n, getY());
    }
}

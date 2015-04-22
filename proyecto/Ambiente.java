import greenfoot.*;

public class Ambiente extends Elemento
{
    private int frame;
    private int tipo;
    
    public Ambiente() 
    {
        super();
        frame = 0;
        tipo = 0;
        setImage("pasto.png");
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
                    case 0: case 1: case 6: case 7: case 8: setImage("pasto.png");
                        setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
                    break;
                    case 2: setImage("hoja.png");
                        setLocation(30, 0);
                    break;
                    case 3: setImage("hoja2.png");
                        setLocation(getAncho() - 30, 0);
                    break;
                    case 4: setImage("piedra.png");
                        setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
                    break;
                    case 5: setImage("flor.png");
                        setLocation(Greenfoot.getRandomNumber(getAncho()), 0);
                    break;
                }
            }
            frame = 0;
        }
        frame++;
    }
}
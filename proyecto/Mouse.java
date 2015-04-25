import greenfoot.*;

public class Mouse extends Elemento
{
    private int tocaJ;
    private int tocaR;
    private int tocaV;
    private int tocaS;
    private int tocaC;
    private Juego bee;
    private Boton jugar, record, regresar, siguiente, creditos;
    private GreenfootImage sprite;
    
    public Mouse()
    {
        super();
        sprite = new GreenfootImage("puntero.png");
        tocaJ = 0;
        tocaR = 0;
        tocaV = 0;
        tocaS = 0;
        tocaC = 0;
    }
    
    public void act()
    {
        jugar = bee.dameJugar();
        record = bee.dameRecord();
        creditos = bee.dameCreditos();
        if(Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        setImage(sprite);
        if(tocaS == 1)
        {
            if(Greenfoot.mouseClicked(siguiente))
            {
                Greenfoot.playSound("click.wav");
                retirar(siguiente);
                bee.nivel1();
            }
        }
        else
        {
            if(Greenfoot.mouseClicked(null) && tocaJ == 1)
            {
                Greenfoot.playSound("click.wav");
                retirar(jugar);
                retirar(record);
                retirar(creditos);
                bee.ayuda1();
                siguiente = bee.dameSiguiente();
                tocaS = 1;
            }
            else
            {
                if(Greenfoot.mouseClicked(this) && tocaR == 1)
                {
                    Greenfoot.playSound("click.wav");
                    tocaR = 0;
                    retirar(jugar);
                    retirar(record);
                    retirar(creditos);
                    bee.record();
                    regresar = bee.dameRegresar();
                    tocaV = 1;
                }
                if(Greenfoot.mouseClicked(this) && tocaC == 1)
                {
                    Greenfoot.playSound("click.wav");
                    tocaC = 0;
                    retirar(jugar);
                    retirar(record);
                    retirar(creditos);
                    bee.creditos();
                    regresar = bee.dameRegresar();
                    tocaV = 1;
                }
                if(tocaV == 1)
                {
                    if(Greenfoot.mouseClicked(regresar))
                    {
                        Greenfoot.playSound("click.wav");
                        tocaV = 0;
                        bee.menu();
                        retirar(regresar);
                        retirar(this);
                    }
                }   
                else
                {
                    seleccionBoton();
                }
            }
        }   
    }
    
    public void seleccionBoton()
    {
        Actor bot = getOneIntersectingObject(Boton.class);
        if(bot != null && getY() < 300 && tocaJ == 0)
        {
            Greenfoot.playSound("menu.wav");
            jugar.setImage("boton_jugar2.png");
            tocaJ = 1;
        }
        if(bot == null && tocaJ == 1)
        {
            jugar.setImage("boton_jugar.png");
            tocaJ = 0;
        }
        if(bot != null && getY() > 350 && getY() < 450  && tocaR == 0)
        {
            Greenfoot.playSound("menu.wav");
            record.setImage("boton_record2.png");
            tocaR = 1;
        }
        if(bot == null && tocaR == 1)
        {
            record.setImage("boton_record.png");
            tocaR = 0;
        }
        if(bot != null && getY() > 500 && tocaC == 0)
        {
            Greenfoot.playSound("menu.wav");
            creditos.setImage("boton_creditos2.png");
            tocaC = 1;
        }
        if(bot == null && tocaC == 1)
        {
            creditos.setImage("boton_creditos.png");
            tocaC = 0;
        }
    }
    
    public void addedToWorld(World world) 
    {
        bee = (Juego) world;        
    }
}

import greenfoot.*;
import java.util.LinkedList;

public class Mouse extends Elemento
{
    private int tocaJ;
    private int tocaR;
    private int tocaV;
    private int tocaS;
    private int tocaC;
    private LinkedList <GreenfootImage> sprites;
    private GreenfootSound sonido;
    private Juego bee;
    private Boton jugar, record, regresar, siguiente, creditos;
    
    public Mouse(GreenfootImage ima)
    {
        super();
        this.setImage(ima);
        tocaJ = 0;
        tocaR = 0;
        tocaV = 0;
        tocaS = 0;
        tocaC = 0;
        sprites = new LinkedList();
        sprites.add(new GreenfootImage("puntero.png"));        //0
        sprites.add(new GreenfootImage("boton_jugar.png"));    //1
        sprites.add(new GreenfootImage("boton_record.png")); //2
        sprites.add(new GreenfootImage("boton_creditos.png"));   //3
        sprites.add(new GreenfootImage("boton_jugar2.png"));   //4
        sprites.add(new GreenfootImage("boton_record2.png"));//5
        sprites.add(new GreenfootImage("boton_creditos2.png"));  //6
        sonido = new GreenfootSound("menu.wav");
    }
    
    public void act()
    {
        jugar = bee.dameJugar();
        record = bee.dameRecord();
        creditos = bee.dameCreditos();
 
        if(Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX() + 7, mouse.getY() + 5);
        }
        setImage(getImagen(0));
        seleccionBoton();   
    }
    
    public GreenfootImage getImagen(int n)
    {
        return sprites.get(n);
    }
    
    public void seleccionBoton()
    {
        Actor bot = getOneIntersectingObject(Boton.class);
        if(bot != null && getY() < 300 && tocaJ == 0)
        {
            sonido.play();
            jugar.setImage(getImagen(4));
            tocaJ = 1;
        }
        if(bot == null && tocaJ == 1)
        {
            jugar.setImage(getImagen(1));
            tocaJ = 0;
        }
        if(bot != null && getY() > 350 && getY() < 450  && tocaR == 0)
        {
            sonido.play();
            record.setImage(getImagen(5));
            tocaR = 1;
        }
        if(bot == null && tocaR == 1)
        {
            record.setImage(getImagen(2));
            tocaR = 0;
        }
        if(bot != null && getY() > 500 && tocaC == 0)
        {
            sonido.play();
            creditos.setImage(getImagen(6));
            tocaC = 1;
        }
        if(bot == null && tocaC == 1)
        {
            creditos.setImage(getImagen(3));
            tocaC = 0;
        }
    }
    
    public void addedToWorld(World world) 
    {
        bee = (Juego) world;        
    }
}
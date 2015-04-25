import greenfoot.*;
import java.util.LinkedList;

public class Juego extends World
{
    private int limiteNectar;
    private float frame;
    private Bee principal;
    private int nectar;
    private int menu; // bandera que indica si estamos en el menu
    private Boton jugar, record, regresar, siguiente, creditos; //Objetos tipo boton del menu
    private int fase;
    private MouseInfo mouse;
    private int tocaJ;
    private LinkedList <GreenfootImage> imagenes;
    private GreenfootSound sonido;
    
    public Juego()
    {
        super(480, 600, 1);
        frame = 0;
        nectar = 0;
        menu = 0;
        fase = 0;
        tocaJ = 0;
        sonido = new GreenfootSound("menu.wav");
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("ayuda.png"));         //0
        imagenes.add(new GreenfootImage("ayuda2.png"));        //1
        imagenes.add(new GreenfootImage("records.png"));       //2
        imagenes.add(new GreenfootImage("creditos.png"));      //3
        imagenes.add(new GreenfootImage("gameover.png"));      //4
        imagenes.add(new GreenfootImage("fondo1.png"));        //5
        imagenes.add(new GreenfootImage("menu.png"));          //6
        imagenes.add(new GreenfootImage("boton_play.png"));    //7
        imagenes.add(new GreenfootImage("boton_regresar.png"));//8
        imagenes.add(new GreenfootImage("boton_record.png"));  //9
        imagenes.add(new GreenfootImage("boton_jugar.png"));   //10
        imagenes.add(new GreenfootImage("boton_creditos.png"));//11
        jugar = new Boton(getImagen(10));
        record = new Boton(getImagen(9));
        creditos = new Boton(getImagen(11));
        regresar = new Boton(getImagen(8));
        siguiente = new Boton(getImagen(7));
        menu();
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
    public Boton dameJugar()
    {
        return jugar;
    }
     
    public Boton dameRecord()
    {
        return record;
    }
    
    public Boton dameRegresar()
    {
        return regresar;
    }
    
    public Boton dameSiguiente()
    {
        return siguiente;
    }
    
    public Boton dameCreditos()
    {
        return creditos;
    }
    
    public void ayuda1()
    {
        setBackground(getImagen(0));
        addObject(siguiente, getWidth() / 2, 550);
    }
    
    public void ayuda2()
    {
        setBackground(getImagen(1));
        addObject(siguiente, getWidth() / 2, 550);
    }
    
    public void record()
    {
        setBackground(getImagen(2));      
        addObject(regresar, getWidth() / 2, 550);
    }
    
    public void creditos()
    {
        setBackground(getImagen(3));
        addObject(regresar, getWidth() / 2, 550);
    }
    
    public void gameOver()
    {
        setBackground(getImagen(4));
        addObject(regresar, getWidth() / 2, 550);
    }
    
    public void nivel1()
    {
        fase = 1;
        limiteNectar = 20;
        setBackground(getImagen(5));
        principal = new Bee(5);
        addObject(new Ambiente(), getWidth() / 4, (getHeight() - 60) / 5);
        addObject(new Ambiente(), getWidth() / 2, ((getHeight() - 60) * 2) / 5);
        addObject(new Ambiente(), (getWidth() * 3) / 4, ((getHeight() - 60) * 3) / 5);
        addObject(new Ambiente(), getWidth() / 4, ((getHeight() - 60) * 4) / 5);
        addObject(new Tela(), getWidth() / 2, 0);
        addObject(new Aracnido(), getWidth() / 2, 0);
        addObject(new Base(), getWidth() / 2, getHeight() - 47);
        addObject(principal, getWidth() / 2, getHeight() - 200);
    }
    
    public void menu()
    {
        setBackground(getImagen(6));
        addObject(jugar, getWidth() / 3, 250);
        addObject(record, getWidth() / 3, 400);
        addObject(creditos, getWidth() / 3, 550);
        //addObject(new Mouse(), 0, 0);
        menu = 1;
        Greenfoot.setSpeed(50);
    }
    
    public void act()
    {
        mouse = Greenfoot.getMouseInfo();
        animaMenu();
        if(Greenfoot.mouseClicked(creditos))
        {
            removeObjects(getObjects(null));
            creditos();
        }
        if(Greenfoot.mouseClicked(regresar))
        {
            removeObjects(getObjects(null));
            menu();
        }
        if(Greenfoot.mouseClicked(record))
        {
            removeObjects(getObjects(null));
            record();
        }
          if(Greenfoot.mouseClicked(jugar))
        {
            removeObjects(getObjects(null));
            nivel1();
        }
        if(fase == 1)
        {
            if(principal.getVida() == 0)
            {
                showText("", 80, getHeight() - 63);
                showText("", 165, getHeight() - 63);
                removeObjects(getObjects(null));
                fase = 0;
                gameOver();
            }
            else
            {
                agregaNectar();
                frame++;
            }
        }
    }
    
    public void animaMenu()
    {
        int tocaR = 0;
        int tocaV = 0;
        int tocaS = 0;
        int tocaC = 0;
        //if(mouse.getActor() == jugar)
        if(Greenfoot.mouseMoved(jugar))
        {
            tocaJ = 1;
           

        }
        else
        {
            tocaJ = 0;
        }
        if(tocaJ == 1)
        {
         sonido.play();
        }
        
        /*if(bot == null && tocaJ == 1)
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
        */
    }
    public void agregaNectar()
    {
        int n = Greenfoot.getRandomNumber(getWidth()) + 61;
        if(n > getWidth() - 61)
        {
            n = getWidth() - 61;
        }
        if(frame == 100)
        {
            if(nectar < limiteNectar)
            {
                addObject(new BurbujaNectar(), n, 0);
            }
            else
            {
                if(nectar == limiteNectar + 4 && principal.getVida() > 0)
                {
                    showText("", 80, getHeight() - 63);
                    showText("", 165, getHeight() - 63);
                    removeObjects(getObjects(null));
                    fase = 0;
                    ayuda2();
                }
            }
            nectar++;
            frame = 0;
        }
    }
}

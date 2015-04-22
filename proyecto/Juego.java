import greenfoot.*;
import java.util.*;

public class Juego extends World
{
    private int limiteNectar;
    private float frame;
    private Bee principal;
    private int nectar;
    private int menu; // bandera que indica si estamos en el menu
    private Boton jugar, record, regresar, siguiente, creditos; //Objetos tipo boton del menu
    private int fase;
    private LinkedList <GreenfootImage> imagenes;
    
    public Juego()
    {
        super(480, 600, 1);
        frame = 0;
        nectar = 0;
        menu = 0;
        fase = 0;
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("ayuda.png"));      //0
        imagenes.add(new GreenfootImage("ayuda2.png"));     //1
        imagenes.add(new GreenfootImage("records.png"));    //2
        imagenes.add(new GreenfootImage("creditos.png"));   //3
        imagenes.add(new GreenfootImage("gameover.png"));   //4
        imagenes.add(new GreenfootImage("fondo1.png"));     //5
        imagenes.add(new GreenfootImage("menu.png"));       //6
        imagenes.add(new GreenfootImage("boton_play.png")); //7
        imagenes.add(new GreenfootImage("boton_regresar.png"));//8
        imagenes.add(new GreenfootImage("boton_record.png"));//9
        imagenes.add(new GreenfootImage("boton_jugar.png"));//10
        imagenes.add(new GreenfootImage("boton_creditos.png"));//11
        menu();
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
        setBackground(imagenes.get(0));
        siguiente = new Boton(imagenes.get(7));
        addObject(siguiente, getWidth() / 2, 550);
    }
    
    public void ayuda2()
    {
        setBackground(imagenes.get(1));
        siguiente = new Boton(imagenes.get(7));
        addObject(siguiente, getWidth() / 2, 550);
    }
    
    public void record()
    {
        setBackground(imagenes.get(2));
        regresar = new Boton(imagenes.get(8));
        addObject(regresar, getWidth() / 2, 550);
    }
    
    public void creditos()
    {
        setBackground(imagenes.get(3));
        regresar = new Boton(imagenes.get(8));
        addObject(regresar, getWidth() / 2, 550);
    }
    
    public void gameOver()
    {
        setBackground(imagenes.get(4));
        regresar = new Boton(imagenes.get(8));
        addObject(regresar, getWidth() / 2, 550);
    }
    
    public void nivel1()
    {
        fase = 1;
        limiteNectar = 20;
        setBackground(imagenes.get(5));
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
        setBackground(imagenes.get(6));
        jugar = new Boton(imagenes.get(10));
        addObject(jugar, getWidth() / 3, 250);
        record = new Boton(imagenes.get(9));
        addObject(record, getWidth() / 3, 400);
        creditos = new Boton(imagenes.get(11));
        addObject(creditos, getWidth() / 3, 550);
        addObject(new Mouse(), 0, 0);
        menu = 1;
        Greenfoot.setSpeed(50);
    }
    
    public void act()
    {
        if(fase == 1)
        {
            if(principal.getVida() == 0)
            {
                showText("", 80, getHeight() - 48);
                showText("", 165, getHeight() - 48);
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
                    showText("", 80, getHeight() - 48);
                    showText("", 165, getHeight() - 48);
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

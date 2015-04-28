import greenfoot.*;
import java.util.LinkedList;

public class Juego extends World
{
    private int limiteNectar;
    private float frame;
    private Bee principal;
    private int contadorNectar;
    private int nectarTotal;
    private int menu; // bandera que indica si estamos en el menu
    private Boton jugar, record, regresar, siguiente, siguiente2, creditos; //Objetos tipo boton del menu
    private int fase;
    private Mouse mouse;
    private LinkedList <GreenfootImage> imagenes;
    private GreenfootSound sonido;
    
   public Juego()
    {
        super(480, 600, 1);
        frame = 0;
        contadorNectar = 0;
        nectarTotal = 0;
        menu = 0;
        fase = 0;
        sonido = new GreenfootSound("click.wav");
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
        imagenes.add(new GreenfootImage("puntero.png"));       //12
        imagenes.add(new GreenfootImage("fondo2.png"));        //13
        principal = new Bee(5);
        jugar = new Boton(getImagen(10));
        record = new Boton(getImagen(9));
        creditos = new Boton(getImagen(11));
        regresar = new Boton(getImagen(8));
        siguiente = new Boton(getImagen(7));
        siguiente2 = new Boton(getImagen(7));
        mouse = new Mouse(getImagen(12));
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
    
   public Boton dameSiguiente2()
    {
        return siguiente2;
    }
    
   public Boton dameCreditos()
    {
        return creditos;
    }
    
   public void ayuda1()
    {
        setBackground(getImagen(0));
        addObject(siguiente, getWidth() / 2, 500);
    }
    
   public void ayuda2()
    {
        setBackground(getImagen(1));     
        addObject(siguiente2, getWidth() / 2, 500);
    }
    
   public void record()
    {
        setBackground(getImagen(2));      
        addObject(regresar, getWidth() / 2, 500);
    }
    
   public void creditos()
    {
        setBackground(getImagen(3));
        addObject(regresar, getWidth() / 2, 500);
    }
    
   public void gameOver()
    {
        setBackground(getImagen(4));
        addObject(regresar, getWidth() / 2, 500);
        fase = 0;
    }
    
   public void nivel1()
    {
        fase = 1;
        limiteNectar = 5;
        setBackground(getImagen(5));
        addObject(new Ambiente(), getWidth() / 4, (getHeight() - 60) / 5);
        addObject(new Ambiente(), getWidth() / 2, ((getHeight() - 60) * 2) / 5);
        addObject(new Ambiente(), (getWidth() * 3) / 4, ((getHeight() - 60) * 3) / 5);
        addObject(new Ambiente(), getWidth() / 4, ((getHeight() - 60) * 4) / 5);
        addObject(new Tela(), getWidth() / 2, 0);
        addObject(new Aracnido(), getWidth() / 2, 0);
        addObject(new Base(), getWidth() / 2, getHeight() - 47);
        addObject(principal, getWidth() / 2, getHeight() - 200);
    }
    
   public void nivel1fase2()
    {
        fase = 2;
        setBackground(getImagen(13));
    }
    
   public void menu()
    {
        setBackground(getImagen(6));
        addObject(jugar, getWidth() / 3, 240);
        addObject(record, getWidth() / 3, 390);
        addObject(creditos, getWidth() / 3, 540);
        addObject(mouse, 0, 0);
        menu = 1;
        Greenfoot.setSpeed(50);
    }
    
   public void act()
    {
        seleccionar();        
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
    
   public void seleccionar()
    {
        if(Greenfoot.mouseClicked(creditos))
        {
            sonido.play();
            removeObjects(getObjects(null));
            creditos();
        }
        if(Greenfoot.mouseClicked(regresar))
        {
            sonido.play();
            removeObjects(getObjects(null));
            menu();
        }
        if(Greenfoot.mouseClicked(record))
        {
            sonido.play();
            removeObjects(getObjects(null));
            record();
        }
        if(Greenfoot.mouseClicked(jugar))
        {
            sonido.play();
            removeObjects(getObjects(null));
            ayuda1();
        }
        if(Greenfoot.mouseClicked(siguiente))
        {
            sonido.play();
            removeObjects(getObjects(null));
            nivel1();                  
        }
        if(Greenfoot.mouseClicked(siguiente2))
        {
            sonido.play();
            removeObjects(getObjects(null));
            nivel1fase2();                  
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
            if(contadorNectar < limiteNectar)
            {
                addObject(new BurbujaNectar(), n, 0);
            }
            else
            {
                if(contadorNectar == limiteNectar + 4 && principal.getVida() > 0)
                {
                    showText("", 80, getHeight() - 63);
                    showText("", 165, getHeight() - 63);
                    nectarTotal=principal.getNectar();
                    removeObjects(getObjects(null));
                    fase = 0;
                    ayuda2();
                }
            }
            contadorNectar++;
            frame = 0;
        }
    }
}

import greenfoot.*;
import java.util.LinkedList;
public class Queen extends Elemento
{
    private int frame;
    private int bombaNectar;
    private int choque;
    private int puntaje;
    private LinkedList <GreenfootImage> imagenes;
    private Juego mundo;
    private GreenfootSound knock;
    private SimpleTimer timer = new SimpleTimer();
    private int tiempo;
    
    public Queen()
    {
        super();
        bombaNectar = 0;
        frame = 0;
        choque = 0;
        puntaje = 0;
        tiempo = 10;
        knock = new GreenfootSound("knock.wav");
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("reyna1.png"));         //0
        imagenes.add(new GreenfootImage("reyna2.png"));         //1
        imagenes.add(new GreenfootImage("reyna3.png"));         //2
        imagenes.add(new GreenfootImage("reyna4.png"));         //3
        imagenes.add(new GreenfootImage("reynadead.png"));      //4
        setImage(getImagen(0));
    }
    
    public void act() 
    {
        animar();
        timer();
        contactoEnemigo();
        muestraContador();
    }
    
    public void setPuntaje(int puntos)
    {
        puntaje = puntos;
    }
    
    public void aumentaPuntaje()
    {
        puntaje = puntaje + 10;
    }
    
    public int getPuntaje()
    {
        return puntaje;
    }
    
    public void setBomba(int n)
    {
        bombaNectar = n;
    }
    
    public void setTiempo(int n)
    {
        tiempo = n;
    }
    
    
    public void muestraContador()
    {
        World world = getWorld();
        world.showText("x " + bombaNectar, 80, getAlto() - 48);
        world.showText("x " + (1 - choque), 152, getAlto() - 48);
        world.showText("Puntaje", 400, getAlto() - 58);
        world.showText("" + puntaje, 400, getAlto() - 38);
        world.showText("Tiempo " + tiempo,250, getAlto() - 60);
    }
    
    public void timer()
    {
        if (timer.millisElapsed() > 1000 && tiempo >0)
      {
          tiempo--;
          timer.mark(); 
       }
    }
    
    public void contactoEnemigo()
    {
        Actor b = colisionar(Larva.class);
        if(b != null || tiempo == 0) {
            chocar();
        }
    }
    
    public void chocar()
    {
        setImage(getImagen(4));
        choque = 1;
    }
    
     public void setImagen(int n)
    {
        setImage(getImagen(n));
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
    public void animar()
    {     
        switch(frame) {
            case 10: setImage(getImagen(1));
            break;
            case 20: setImage(getImagen(2));
            break;
            case 30: setImage(getImagen(3));
            break;
            case 40: setImage(getImagen(2));
            break;
            case 50: setImage(getImagen(1));
            break;                
            case 60: setImage(getImagen(0));
                     frame = 0;
            break;
        }
        frame++;
    }
    
    public void addedToWorld(World world) 
    {
        mundo = (Juego) world;        
    }
    
    public int getChoque() 
    {
       return choque;        
    }
    
     public void setChoque() 
    {
       choque = 0;        
    }
}    


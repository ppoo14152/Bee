import greenfoot.*;
public class Hueco extends Elemento
{
    private GreenfootImage sprite;
    private Juego mundo;
    private Carga carga;

    public Hueco()
    {
        super();
        sprite = new GreenfootImage("huecopanel.png");
        setImage(sprite);        
    }

    public void act() 
    {
        int c;
        if(Greenfoot.mouseClicked(this)){
            carga = mundo.dameCarga();
           
            if(carga.getCotador()>0){
                carga.setContador();
                mundo.addObject(new Panel1(), this.getX(),this.getY());
                mundo.removeObject(this);
            }
        }
    }    
    
    public void addedToWorld(World world) 
    {
        mundo = (Juego) world;        
    }
}


import greenfoot.*;
public class Panel1 extends Elemento
{  
    private Juego mundo;
    private Carga carga;
    public Panel1()
    {
        super();
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            carga = mundo.dameCarga();
            if(carga.getCotador()>0){
                carga.setContador();
                mundo.addObject(new Panel2(), this.getX(),this.getY());
                mundo.removeObject(this);
            }
        }
    }    
    
    public void addedToWorld(World world) 
    {
        mundo = (Juego) world;        
    }
    
}

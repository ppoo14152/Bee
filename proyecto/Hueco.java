import greenfoot.*;
import java.util.LinkedList;
import java.util.List;
public class Hueco extends Elemento
{
    private LinkedList <GreenfootImage> imagenes;
    private Juego mundo;
    private Carga carga;
    private int tipo;   
    private List <Enemigo> Enemigos;

    public Hueco()
    {
        super();
        tipo = 0;
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("huecopanel.png")); //0
        imagenes.add(new GreenfootImage("panel1.png"));     //1
        imagenes.add(new GreenfootImage("panel.png"));      //2
        setImage(getImagen(0));
    }

    public void act() 
    {
        cargar();
        contactoEnemigo();
    }    
    
    public void cargar()
    {
        if(Greenfoot.mouseClicked(this) && Greenfoot.getMouseInfo().getButton()==1) {
            carga = mundo.getCarga();
            if(carga.getCotador() > 0 && tipo < 2) {
                carga.setContador();
                if(tipo == 0) {
                    setImage(getImagen(tipo + 1));
                }
                if(tipo == 1) {
                    setImage(getImagen(tipo + 1));
                }
                tipo++;
            }
        }
    }
    
    public void contactoEnemigo()
    {
        Enemigos=getObjectsInRange(35,Enemigo.class);
        if(Enemigos.size() > 0 && tipo > 0) {
           mundo.removeObjects(Enemigos);
           Actor b = mundo.getReyna();
           ((Queen)b).aumentaPuntaje();
           tipo--;
           setImage(getImagen(tipo));
        }
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
    public void addedToWorld(World world) 
    {
        mundo = (Juego) world;        
    }
}


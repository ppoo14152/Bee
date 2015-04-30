import greenfoot.*;
import java.util.LinkedList;

public class Hueco extends Elemento
{
    private LinkedList <GreenfootImage> imagenes;
    private Juego mundo;
    private Carga carga;
    private int tipo;

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
        if(Greenfoot.mouseClicked(this)) {
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
        Actor b = colisionar(Larva.class);
        if(b != null && tipo > 0) {
            retirar(b);
            b = mundo.getReyna();
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


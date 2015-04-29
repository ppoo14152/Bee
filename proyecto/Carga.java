import greenfoot.*;
import java.util.LinkedList;
public class Carga extends Elemento
{
    private LinkedList <GreenfootImage> imagenes;
    private int contador;
    private int limite;
    private int frame;

    public Carga()
    {
        super();
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("carga0.png"));         //0
        imagenes.add(new GreenfootImage("carga1.png"));         //1
        imagenes.add(new GreenfootImage("carga2.png"));         //2
        imagenes.add(new GreenfootImage("carga3.png"));         //3
        imagenes.add(new GreenfootImage("carga4.png"));         //4
        imagenes.add(new GreenfootImage("carga5.png"));         //4
        imagenes.add(new GreenfootImage("carga6.png"));         //4
        setImage(getImagen(6));
        contador = 6;
        limite = 6;
        frame=0;
    }

    public void act() 
    {
        frame++;
        setImage(getImagen(contador));
        if(frame > 130 && contador < 6){
            contador++;
            frame = 0;
        }
        
    }    
    
    public void setContador()
    {
        if(contador>0){
            contador--;
        }
    }

    public int getCotador()
    {
        return contador;
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
}

import greenfoot.*;
import java.util.LinkedList;
import java.util.List;
/**
 * Esta clase representa el hueco y los tipo de paneles que 
 * se pueden usar en la segunda fasee de cada nivel.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 30/abril/2015
 */
public class Hueco extends Elemento
{
    private LinkedList <GreenfootImage> imagenes;
    private Juego mundo;
    private Carga carga;
    private int tipo;   
    private List <Enemigo> Enemigos;
    private GreenfootSound puesto;
    private GreenfootSound no;
    private GreenfootSound destruido;

     /**
     * Constructor de la clase Hueco. Fija tipo a 0.
     * además definelos sonidos e
     * imágenes que utiliza el objeto de esta clase.
     */
    public Hueco()
    {
        super();
        tipo = 0;
        puesto = new GreenfootSound("colocar.wav");
        puesto.setVolume(85);
        no = new GreenfootSound("no.wav");
        no.setVolume(85);
        destruido = new GreenfootSound("destruirpanel.wav");
        destruido.setVolume(85);
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("huecopanel.png")); //0
        imagenes.add(new GreenfootImage("panel1.png"));     //1
        imagenes.add(new GreenfootImage("panel.png"));      //2
        setImage(getImagen(0));
    }
    
    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Ejecuta las funciones que representan lo que el
     * objeto de esta clase debe hacer cuando es agregado al mundo.
     */
    public void act() 
    {
        cargar();
        contactoEnemigo();
    }    
    
     /**
     * Este método cambia el tipo e imágen del objeto en relación
     * con un objeto de la clase Carga .
     */
    public void cargar()
    {
        if(Greenfoot.mouseClicked(this) && Greenfoot.getMouseInfo().getButton() == 1) {
            carga = mundo.getCarga();
            if(carga.getCotador() > 0 && tipo < 2) {
                puesto.play();
                carga.setContador();
                if(tipo == 0) {
                    setImage(getImagen(tipo + 1));
                }
                if(tipo == 1) {
                    setImage(getImagen(tipo + 1));
                }
                tipo++;
            }
            else
            {
                no.play();
            }
        }
    }
    
     /**
     * Este método cambia el tipo e imágen del objeto en relación
     * con una colisión con objetos de la clase Enemigo, además 
     * elimina a los objetos relacionados con la colisión e 
     * incrementa el puntaje de la partida.
     */
    public void contactoEnemigo()
    {
        Enemigos = getObjectsInRange(35, Enemigo.class);
        if(Enemigos.size() > 0 && tipo > 0) {
            mundo.removeObjects(Enemigos);
            Actor b = mundo.getReyna();
            ((Queen)b).aumentaPuntaje();
            tipo--;
            destruido.play();
            setImage(getImagen(tipo));
        }
    }
    
     /**
     * Este método regresa la imágen (tipo GreenfootImage)
     * contenida en una Lista de la posición específicada
     * por el valor asignado en la llamada a este método.
     * 
     * @param int Valor de la posición de la imágen que se
     * desea obtener.
     * @return GreenfootImage - Imágen contenida en la Lista
     * en la posición especificada.
     */
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
    /**
     * Este método iguala la variable mundo a el World de juego.
     *
     *@param World Variable que representa el mundo del proyecto. 
     */
    public void addedToWorld(World world) 
    {
        mundo = (Juego) world;        
    }
}


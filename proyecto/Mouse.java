import greenfoot.*;
import java.util.LinkedList;
/**
 * Esta clase representa el cursor en el menu del juego.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 30/abril/2015
 */
public class Mouse extends Elemento
{
    private int tocaJ;
    private int tocaR;
    private int tocaV;
    private int tocaS;
    private int tocaC;
    private LinkedList <GreenfootImage> sprites;
    private GreenfootSound sonido;
    private Juego bee;
    private Boton jugar, record, regresar, siguiente, creditos;
    
    /**
    * Constructor de la clase Bee. Iniciaiza las variables
    * de instancia, además de definir los sonidos e
    * imágenes que utiliza el objeto de esta clase.
    */
    public Mouse(GreenfootImage ima)
    {
        super();
        this.setImage(ima);
        tocaJ = 0;
        tocaR = 0;
        tocaV = 0;
        tocaS = 0;
        tocaC = 0;
        sprites = new LinkedList();
        sprites.add(new GreenfootImage("puntero.png"));        //0
        sprites.add(new GreenfootImage("boton_jugar.png"));    //1
        sprites.add(new GreenfootImage("boton_record.png"));   //2
        sprites.add(new GreenfootImage("boton_creditos.png")); //3
        sprites.add(new GreenfootImage("boton_jugar2.png"));   //4
        sprites.add(new GreenfootImage("boton_record2.png"));  //5
        sprites.add(new GreenfootImage("boton_creditos2.png"));//6
        sonido = new GreenfootSound("menu.wav");
        sonido.setVolume(85);
        setImage(getImagen(0));
    }
    
    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Ejecuta las funciones que representan lo que el
     * objeto de esta clase debe hacer cuando es agregado al mundo.
     */
    public void act()
    {
        jugar = bee.getJugar();
        record = bee.getRecord();
        creditos = bee.getCreditos();
        moverMouse();
        seleccionBoton();   
    }
    
    /**
     * Este método mueve el objeto de la clase a la posicion actual
     * del cursor.
     */
    public void moverMouse()
    {
        if(Greenfoot.mouseMoved(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX() + 7, mouse.getY() + 5);
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
        return sprites.get(n);
    }
    
    /**
     * Este método hace el cambio de imagenes de los botones
     * que intersectan con los objetos de esta clase.
     */
    public void seleccionBoton()
    {
        Actor bot = getOneIntersectingObject(Boton.class);
        if(bot != null && getY() < 290 && tocaJ == 0) {
            sonido.play();
            jugar.setImage(getImagen(4));
            tocaJ = 1;
        }
        if(bot == null && tocaJ == 1) {
            jugar.setImage(getImagen(1));
            tocaJ = 0;
        }
        if(bot != null && getY() > 340 && getY() < 440 && tocaR == 0) {
            sonido.play();
            record.setImage(getImagen(5));
            tocaR = 1;
        }
        if(bot == null && tocaR == 1) {
            record.setImage(getImagen(2));
            tocaR = 0;
        }
        if(bot != null && getY() > 490 && tocaC == 0) {
            sonido.play();
            creditos.setImage(getImagen(6));
            tocaC = 1;
        }
        if(bot == null && tocaC == 1) {
            creditos.setImage(getImagen(3));
            tocaC = 0;
        }
    }
    
     /**
     * Este método iguala la variable mundo a el World de juego.
     *
     *@param World Variable que representa el mundo del proyecto. 
     */
    public void addedToWorld(World world) 
    {
        bee = (Juego) world;        
    }
}
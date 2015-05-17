import greenfoot.*;
import java.util.LinkedList;

/**
 * Esta clase representa al personaje principal
 * en la segunda fase de cada nivel.
 * 
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 30/abril/2015
 */
public class Queen extends Elemento
{
    private int frame;
    private int bombaNectar;
    private int choque;
    private int puntaje;
    private int tiempo;
    private LinkedList <GreenfootImage> imagenes;
    private Juego mundo;
    private GreenfootSound knock;
    private SimpleTimer timer = new SimpleTimer();
    
    /**
     * Constructor de la clase Queen. Fija frame, choque, puntaje
     * tiempo y bombaNectar, además de definir los sonidos e
     * imágenes que utiliza el objeto de esta clase.
     */
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
    
    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Ejecuta las funciones que representan lo que el
     * objeto de esta clase debe hacer cuando es agregado al mundo.
     */
    public void act() 
    {
        animar();
        timer();
        contactoEnemigo();
        muestraContador();
    }
    
    /**
     * Este método define el valor de la variable puntaje con el
     * valor especificado en la llamada al método.
     * 
     * @param int Valor que va a tomar la variable puntaje.
     */
    public void setPuntaje(int puntos)
    {
        puntaje = puntos;
    }
    
    /**
     * Este método incrementa el valor actual de la variable puntaje.
     */
    public void aumentaPuntaje()
    {
        puntaje = puntaje + 10;
    }
    
    /**
     * Este método regresa el valor de la variable puntaje.
     * 
     * @return int - Valor actual de la variable puntaje.
     */
    public int getPuntaje()
    {
        return puntaje;
    }
    
    /**
     * Este método regresa el valor de la variable tiempo.
     * 
     * @return int - Valor actual de la variable timepo.
     */
    public int getTiempo()
    {
        return tiempo;
    }
   
    /**
     * Este método define el valor de la variable bombaNectar con el
     * valor especificado en la llamada al método.
     * 
     * @param int Valor que va a tomar la variable bombaNectar.
     */
    public void setBomba(int n)
    {
        bombaNectar = n;
    }
    
    /**
     * Este método define el valor de la variable timepo con el
     * valor especificado en la llamada al método.
     * 
     * @param int Valor que va a tomar la variable timepo.
     */
    public void setTiempo(int n)
    {
        tiempo = n;
    }
  
    /**
     * Este método muestra en pantalla los valores de las
     * variables choque, bombaNectar y puntaje (con letrero).
     */
    public void muestraContador()
    {
        World world = getWorld();
        world.showText("x " + bombaNectar, 80, getAlto() - 48);
        world.showText("x " + (1 - choque), 152, getAlto() - 48);
        world.showText("Puntaje", 400, getAlto() - 58);
        world.showText("" + puntaje, 400, getAlto() - 38);
        world.showText("Tiempo " + tiempo, 250, getAlto() - 60);
    }
    
    /**
     * Este método decrementa la variable tiempo si se
     * cumple la condicón establecida.
     */
    public void timer()
    {
       if (timer.millisElapsed() > 1000 )
       {
          tiempo--;
          timer.mark(); 
       }
    }
    
    /**
     * Este método reproduce un sonido cuando se ha colisionado con un
     * enemigo o se ha acabado el tiempo.
     */
    public void contactoEnemigo()
    {
        Actor b = colisionar(Enemigo.class);
        if(b != null || tiempo == 0) {
            knock.play();
            chocar();
        }
    }
    
    /**
     * Este método realiza la animación de la abeja al recibir daño.
     */
    public void chocar()
    {
        setImage(getImagen(4));
        choque = 1;
    }
    
    /**
     * Este método define la imágen (tipo GreenfootImage)
     * que el objeto de esta clase va a tomar. Dicha imágen
     * es obtenida de una Lista de la posición específicada
     * por el valor asignado en la llamada a este método.
     * 
     * @param int Valor de la posición de la imágen que se
     * desea obtener.
     */
    public void setImagen(int n)
    {
        setImage(getImagen(n));
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
     * Este método cambia  las imagenes del objeto para
     * generar una animación.
     * 
     */  
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
    
     /**
     * Este método iguala la variable mundo a el World de juego.
     *
     *@param World Variable que representa el mundo del proyecto. 
     */
    public void addedToWorld(World world) 
    {
        mundo = (Juego) world;        
    }
    
     /**
     * Este método regresa el valor de la variable choque.
     * 
     * @return int - Valor actual de la variable choque.
     */  
    public int getChoque() 
    {
        return choque;        
    }

     /**
     * Este método asigna el valor de 0 a la variable choque.
     *
     */    
    public void setChoque() 
    {
        choque = 0;        
    }
}    


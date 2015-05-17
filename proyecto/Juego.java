import greenfoot.*;
import java.util.LinkedList;
/**
 * Subclase de World. Respresenta todos los escenarios mostrados
 * en el juego, además de mantener el control de cada uno de los
 * diversos niveles.
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 17/mayo/2015
 */
public class Juego extends World
{
    private int limiteNectar;
    private int contadorNectar;
    private int nectarTotal;
    private int fase;
    private int puntajeTotal;
    private float frame;
    private Bee principal;
    private Queen reyna;
    private Boton jugar, record, regresar, siguiente, siguiente2, creditos; //Objetos tipo boton del menu
    private Mouse mouse;
    private Carga carga;
    private LinkedList <GreenfootImage> imagenes;
    private GreenfootSound sonido;
    private GreenfootSound knock;
    private GreenfootSound bomba;
    private MouseInfo info;
    
    /**
     * Variable global constante (int) que representa el número de pixeles
     * limite máximo antes de tocar el borde del escenario.
     */
    public final int BORDE = 61;
    
    /**
     * Constructor de la clase Juego. Inicializa las
     * variables de instancia de la clase, además
     * de definir los sonidos e imágenes que se
     * utilizan.
     */
    public Juego()
    {
        super(480, 600, 1);
        frame = 0;
        contadorNectar = 0;
        nectarTotal = 0;
        fase = 0;
        puntajeTotal = 0;
        sonido = new GreenfootSound("click.wav");
        sonido.setVolume(85);
        knock = new GreenfootSound("knock.wav");
        knock.setVolume(85);
        bomba = new GreenfootSound("explosion.wav");
        bomba.setVolume(85);
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
        principal = new Bee();
        jugar = new Boton(getImagen(10));
        record = new Boton(getImagen(9));
        creditos = new Boton(getImagen(11));
        regresar = new Boton(getImagen(8));
        siguiente = new Boton(getImagen(7));
        siguiente2 = new Boton(getImagen(7));
        mouse = new Mouse(getImagen(12));
        carga = new Carga();
        reyna = new Queen();
        menu();
    }
    
    /**
     * Este método es ejecutado por Greenfoot cuando se Inicia el
     * juego. Ejecuta los métodos que representan las acciones que
     * se deben de realizar durante la ejecución del juego.
     */
    public void act()
    {
        seleccionar();        
        controlNectar();
        controlEnemigo();
    }
    
    /**
     * Este método se encarga de mostrar la pantalla de Game
     * Over. Asigna el fondo de pantalla y agrega un botón.
     * Además de guardar un Record con el puntaje acumulado y
     * reinicia valores en variables de instancia.
     */
    public void gameOver()
    {
        showText("", 80, getHeight() - 48);
        showText("", 152, getHeight() - 48);
        showText("", 400, getHeight() - 58);
        showText("", 400, getHeight() - 38);
        showText("", 250, getHeight() - 60);
        fase = 0;
        setBackground(getImagen(4));
        addObject(regresar, getWidth() / 2, 540);
        contadorNectar = 0;
        nectarTotal = 0;
        frame = 0;
        guardaRecord();
        puntajeTotal = 0;
    }
    
    /**
     * Este método se encarga de mostrar e inicializar
     * la pantalla de nivel 1, en su primer fase, colocando
     * el fondo de pantalla, agregando los objetos necesarios
     * e inicializando variables.
     */
    public void nivel1()
    {
        fase = 1;
        limiteNectar = 10;
        contadorNectar = 0;
        setBackground(getImagen(5));
        principal.setNectar(nectarTotal);
        principal.setVida(3);
        principal.setPuntaje(puntajeTotal);
        principal.setImagen(1);
        addObject(new Ambiente(), getWidth() / 4, (getHeight() - 60) / 5);
        addObject(new Ambiente(), getWidth() / 2, ((getHeight() - 60) * 2) / 5);
        addObject(new Ambiente(), (getWidth() * 3) / 4, ((getHeight() - 60) * 3) / 5);
        addObject(new Ambiente(), getWidth() / 4, ((getHeight() - 60) * 4) / 5);
        addObject(new Tela(), getWidth() / 2, 0);
        addObject(new Depredador(1), getWidth() / 2, 0);
        addObject(new Base(), getWidth() / 2, getHeight() - 47);
        addObject(principal, getWidth() / 2, getHeight() - 200);
    }
    
    /**
     * Este método se encarga de mostrar e inicializar
     * la pantalla de nivel 2, en su primer fase, colocando
     * el fondo de pantalla, agregando los objetos necesarios
     * e inicializando variables.
     */
    public void nivel2()
    {
        fase = 3;
        limiteNectar = 20;
        contadorNectar = 0;
        nectarTotal = 0;
        frame = 0;
        setBackground(getImagen(5));
        principal.setNectar(nectarTotal);
        principal.setVida(3);
        principal.setPuntaje(0);
        principal.setImagen(1);
        principal.setPuntaje(puntajeTotal);
        addObject(new Ambiente(), getWidth() / 4, (getHeight() - 60) / 5);
        addObject(new Ambiente(), getWidth() / 2, ((getHeight() - 60) * 2) / 5);
        addObject(new Ambiente(), (getWidth() * 3) / 4, ((getHeight() - 60) * 3) / 5);
        addObject(new Ambiente(), getWidth() / 4, ((getHeight() - 60) * 4) / 5);
        addObject(new Depredador(1), getWidth() / 4, 0);
        addObject(new Depredador(2), getWidth() * 3 / 4, 0);
        addObject(new Base(), getWidth() / 2, getHeight() - 47);
        addObject(principal, getWidth() / 2, getHeight() - 200);
    }
    
    /**
     * Este método se encarga de mostrar e inicializar
     * la pantalla de nivel 1, en su segunda fase, colocando
     * el fondo de pantalla, agregando los objetos necesarios
     * e inicializando variables.
     */
    public void nivel1fase2()
    {
        fase = 2;
        reyna.setChoque();
        reyna.setBomba(nectarTotal);
        reyna.setPuntaje(puntajeTotal);
        reyna.setTiempo(60);
        reyna.setImagen(1);
        carga.setTempo(60);
        carga.setCarga(6);
        setBackground(getImagen(13));
        addObject(reyna, getWidth() / 2, getHeight() / 5 * 2);
        addObject(new Base(), getWidth() / 2, getHeight() - 47);
        addObject(carga, getWidth() / 2 + 10, getHeight() - 35);
        agregaHueco();
    }
    
    /**
     * Este método se encarga de mostrar e inicializar
     * la pantalla de nivel 2, en su segunda fase, colocando
     * el fondo de pantalla, agregando los objetos necesarios
     * e inicializando variables.
     */
    public void nivel2fase2()
    {
        fase = 4;
        reyna.setChoque();
        reyna.setBomba(nectarTotal);
        reyna.setPuntaje(puntajeTotal);
        reyna.setTiempo(120);
        reyna.setImagen(1);
        carga.setTempo(80);
        carga.setCarga(6);
        setBackground(getImagen(13));
        addObject(reyna, getWidth() / 2, getHeight() / 5 * 2);
        addObject(new Base(), getWidth() / 2, getHeight() - 47);
        addObject(carga, getWidth() / 2 + 10, getHeight() - 35);
        agregaHueco();
    }
    
    /**
     * Este método muestra la pantalla de Menú. Coloca
     * el fondo de pantalla, agregando los objetos necesarios
     * y fija la velocidad del juego.
     */
    public void menu()
    {
        setBackground(getImagen(6));
        addObject(jugar, getWidth() / 3, 240);
        addObject(record, getWidth() / 3, 390);
        addObject(creditos, getWidth() / 3, 540);
        addObject(mouse, 0, 0);
        Greenfoot.setSpeed(50);
    }
    
    /**
     * Este método se encarga de controlar los cambios
     * ocurridos en la segunda fase de cada nivel, para
     * que esta llegue a su termino. Además, controla la
     * inserción de enemigos y de explosiones.
     */
    public void controlEnemigo()
    {
        if(fase == 2 || fase == 4) {
            if(reyna.getTiempo() == 1 && fase == 2) {
                puntajeTotal = reyna.getPuntaje();
                removeObjects(getObjects(null));
                reyna.setTiempo(15);
                nivel2();
            } 
            if(reyna.getChoque() == 1 || reyna.getTiempo() == 0) {
                puntajeTotal = reyna.getPuntaje();
                removeObjects(getObjects(null));
                gameOver();
            }
            else {
                if(Greenfoot.mouseClicked(null)){
                    info = Greenfoot.getMouseInfo();
                    if(info.getButton() == 3 && nectarTotal > 0){
                        addObject(new Explosion(), Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                        bomba.play();
                        nectarTotal--;
                    }
                }
                agregarEnemigo();
                frame++;
            }
            reyna.setBomba(nectarTotal);
        }
    }
    
    /**
     * Este método controla la inserción de enemigos en
     * la segunda fase de cada nivel. Agrega enemigos
     * especificados en base a condiciones de nivel y
     * ubicación.
     */
    public void agregarEnemigo()
    {
        int n = Greenfoot.getRandomNumber(7) * 80;
        int o = 0;
        int tipo = Greenfoot.getRandomNumber(2);
        int tiempo;
        if(n == 0 || n == 480) {
            o = Greenfoot.getRandomNumber(7) * 84;
        }
        if(fase == 2){
            tiempo = 100;
        }
        else {
            tiempo = 65;
        }            
        if(frame == tiempo) {
            if(fase == 2) {
                addObject(new Larva(tipo), n, o);   
            }
            if(fase == 4) {
                if(tipo == 0) {                    
                    addObject(new Larva(tipo), n, o);
                }
                else {
                    addObject(new Hormiga(), n, o);   
                }
            }      
            frame = 0;
        }           
    }
    
    /**
     * Este método se encarga de llevar el control de la
     * inserción de objetos de la clase Nectar al mundo,
     * además de finalizar el juego, si se terminan las vidas
     * en la primer fase del juego.
     */
    public void controlNectar()
    {
        if(fase == 1 || fase == 3)
        {
            if(principal.getVida() == 0) {
                puntajeTotal = puntajeTotal + principal.getPuntaje();
                removeObjects(getObjects(null));
                gameOver();
            }
            else {
                agregaNectar();
                frame++;
            }
        }
    }
    
    /**
     * Este método se encarga de agregar objetos de la clase
     * Nectar, cuidando su ubicación y cantidad, así como de
     * realizar la transición entre la primer y la segunda fase
     * de cada nivel.
     */
    public void agregaNectar()
    {
        int n = Greenfoot.getRandomNumber(getWidth()) + BORDE;
        if(n > getWidth() - BORDE) {
            n = getWidth() - BORDE;
        }
        if(frame == 100) {
            if(contadorNectar < limiteNectar) {
                addObject(new BurbujaNectar(), n, 0);
            }
            else {
                if(contadorNectar == limiteNectar + 4 && principal.getVida() > 0) {
                    showText("", 80, getHeight() - 48);
                    showText("", 152, getHeight() - 48);
                    showText("", 400, getHeight() - 58);
                    showText("", 400, getHeight() - 38);
                    nectarTotal = principal.getNectar();
                    puntajeTotal = puntajeTotal + principal.getPuntaje();
                    removeObjects(getObjects(null));
                    if(fase == 1){
                        fase = 0;
                        ayuda2();
                    }
                    if(fase == 3){
                        fase = 0;
                        nivel2fase2();
                    }
                }
            }
            contadorNectar++;
            frame = 0;
        }
    }
    
    /**
     * Este método se encarga de guardar los datos
     * que conforman la parte de records.
     */
    public void guardaRecord()
    {
        if(UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();
            if (puntajeTotal > myInfo.getScore()) {
                myInfo.setScore(puntajeTotal);
                myInfo.store();
            }
        }
    }
    
    /**
     * Este método se encarga de agregar los
     * objetos de la clase Hueco con los que se
     * puede interactuar en la segunda fase de
     * cada nivel.
     */
    public void agregaHueco()
    {
        int x = getWidth() / 2 - 100;
        int y = getHeight() / 5 + 30;
        int aumento = 50,i;
       
        for(i = 0; i < 5; i++) {
            addObject(new Hueco(), x , y);
            x += aumento;
        }
      
        x = getWidth() / 2 - 100;
        y = getHeight() / 2 + 30;
        for(i = 0; i < 5; i++) {
            addObject(new Hueco(), x , y);
            x += aumento;
        }
       
        x = getWidth() / 2 - 75;
        y = getHeight() / 5 - 15;
        for(i = 0; i < 4; i++) {
            addObject(new Hueco(), x , y);
            x += aumento;
        } 
       
        addObject(new Hueco(), getWidth() / 2 - 75, getHeight() / 5 + 25 + aumento);
        addObject(new Hueco(), getWidth() / 2 - 75, getHeight() / 5 + 115 + aumento);
        addObject(new Hueco(), getWidth() / 2 - 125, getHeight() / 5 + 25 + aumento);
        addObject(new Hueco(), getWidth() / 2 - 125, getHeight() / 5 + 115 + aumento);
        addObject(new Hueco(), getWidth() / 2 + 125, getHeight() / 5 + 25 + aumento);
        addObject(new Hueco(), getWidth() / 2 + 125, getHeight() / 5 + 115 + aumento);
        addObject(new Hueco(), getWidth() / 2 + 75, getHeight() / 5 + 25 + aumento);
        addObject(new Hueco(), getWidth() / 2 + 75, getHeight() / 5 + 115 + aumento);
       
        addObject(new Hueco(), getWidth() / 2 - 100, getHeight() / 5 + aumento * 2 + 20);
        addObject(new Hueco(), getWidth() / 2 + 100, getHeight() / 5 + aumento * 2 + 20);
        addObject(new Hueco(), getWidth() / 2 - 150, getHeight() / 5 + aumento * 2 + 20);
        addObject(new Hueco(), getWidth() / 2 + 150, getHeight() / 5 + aumento * 2 + 20);
        
        x = getWidth() / 2 - 75;
        y = getHeight() / 2 + 75;
        
        for(i = 0; i < 4; i++) {
            addObject(new Hueco(), x , y);
            x += aumento;
        } 
    }
    
    /**
     * Este método se encarga de controlar la
     * selección de los respectivos botones en cada
     * parte del menú. Llama a la función correspondiente
     * según el botón tocado y reproduce un sonido.
     */
    public void seleccionar()
    {
        if(Greenfoot.mouseClicked(creditos)) {
            sonido.play();
            removeObjects(getObjects(null));
            creditos();
        }
        if(Greenfoot.mouseClicked(regresar)) {
            sonido.play();
            removeObjects(getObjects(null));
            menu();
        }
        if(Greenfoot.mouseClicked(record)) {
            sonido.play();
            removeObjects(getObjects(null));
            record();
        }
        if(Greenfoot.mouseClicked(jugar)) {
            sonido.play();
            removeObjects(getObjects(null));
            ayuda1();
        }
        if(Greenfoot.mouseClicked(siguiente)) {
            sonido.play();
            removeObjects(getObjects(null));
            nivel1();                
        }
        if(Greenfoot.mouseClicked(siguiente2)) {
            sonido.play();
            removeObjects(getObjects(null));
            nivel1fase2();                  
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
     * Este método regresa un objeto en especifico de la clase Boton.
     * 
     * @return Boton - Objeto jugar de la clase Boton.
     */
    public Boton getJugar()
    {
        return jugar;
    }
    
    /**
     * Este método regresa un objeto en especifico de la clase Boton.
     * 
     * @return Boton - Objeto record de la clase Boton.
     */
    public Boton getRecord()
    {
        return record;
    }
    
    /**
     * Este método regresa un objeto en especifico de la clase Boton.
     * 
     * @return Boton - Objeto regresar de la clase Boton.
     */
    public Boton getRegresar()
    {
        return regresar;
    }
    
    /**
     * Este método regresa un objeto en especifico de la clase Boton.
     * 
     * @return Boton - Objeto siguiente de la clase Boton.
     */
    public Boton getSiguiente()
    {
        return siguiente;
    }
    
    /**
     * Este método regresa un objeto en especifico de la clase Boton.
     * 
     * @return Boton - Objeto siguiente2 de la clase Boton.
     */
    public Boton getSiguiente2()
    {
        return siguiente2;
    }
    
    /**
     * Este método regresa un objeto en especifico de la clase Boton.
     * 
     * @return Boton - Objeto creditos de la clase Boton.
     */
    public Boton getCreditos()
    {
        return creditos;
    }
    
    /**
     * Este método regresa un objeto de la clase Carga.
     * 
     * @return Carga - Objeto de la clase Carga manejado
     * en la segunda fase de cada nivel.
     */
    public Carga getCarga()
    {
        return carga;
    }
    
    /**
     * Este método regresa un objeto de la clase Queen.
     * 
     * @return Queen - Objeto de la clase Queen manejado
     * en la segunda fase de cada nivel.
     */
    public Queen getReyna()
    {
        return reyna;
    }
    
    /**
     * Este método se encarga de mostrar la primer pantalla
     * de ayuda. Asigna el fondo de pantalla y agrega un botón.
     */
    public void ayuda1()
    {
        setBackground(getImagen(0));
        addObject(siguiente, getWidth() / 2, 540);
    }
    
    /**
     * Este método se encarga de mostrar la segunda pantalla
     * de ayuda. Asigna el fondo de pantalla y agrega un botón.
     */
    public void ayuda2()
    {
        setBackground(getImagen(1));     
        addObject(siguiente2, getWidth() / 2, 540);
    }
    
    /**
     * Este método se encarga de mostrar la pantalla de
     * records. Asigna el fondo de pantalla, agrega un botón
     * y el tablero de records.
     */
    public void record()
    {
        setBackground(getImagen(2));
        addObject(new ScoreBoard(480, 350), getWidth() / 2, getHeight() / 2);
        addObject(regresar, getWidth() / 2, 540);
    }
    
    /**
     * Este método se encarga de mostrar la pantalla de
     * créditos. Asigna el fondo de pantalla y agrega un botón.
     */
    public void creditos()
    {
        setBackground(getImagen(3));
        addObject(regresar, getWidth() / 2, 540);
    }
}

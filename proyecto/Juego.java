import greenfoot.*;
import java.util.LinkedList;

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
    private MouseInfo info;
    
    public final int BORDE = 61;
    
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
    
    public void act()
    {
        seleccionar();        
        controlNectar();
        controlEnemigo();
    }
    
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
    
    public void nivel1()
    {
        fase = 1;
        limiteNectar = 2;
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
        addObject(new Aracnido(1), getWidth() / 2, 0);
        addObject(new Base(), getWidth() / 2, getHeight() - 47);
        addObject(principal, getWidth() / 2, getHeight() - 200);
    }
    
    public void nivel2()
    {
        fase = 3;
        limiteNectar = 10;
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
        addObject(new Aracnido(1), getWidth() / 4, 0);
        addObject(new Aracnido(2), getWidth() * 3 / 4, 0);
        addObject(new Base(), getWidth() / 2, getHeight() - 47);
        addObject(principal, getWidth() / 2, getHeight() - 200);
    }
    
    public void nivel1fase2()
    {
        fase = 2;
        reyna.setChoque();
        reyna.setBomba(nectarTotal);
        reyna.setPuntaje(puntajeTotal);
        reyna.setTiempo(10);
        reyna.setImagen(1);
        carga.setTempo(75);
        carga.setCarga(6);
        setBackground(getImagen(13));
        addObject(reyna, getWidth() / 2, getHeight() / 5 * 2);
        addObject(new Base(), getWidth() / 2, getHeight() - 47);
        addObject(carga, getWidth() / 2 + 10, getHeight() - 35);
        agregaHueco();
    }
    
    public void nivel2fase2()
    {
        fase = 4;
        reyna.setChoque();
        reyna.setBomba(nectarTotal);
        reyna.setPuntaje(puntajeTotal);
        reyna.setTiempo(10);
        reyna.setImagen(1);
        carga.setTempo(100);
        carga.setCarga(6);
        setBackground(getImagen(13));
        addObject(reyna, getWidth() / 2, getHeight() / 5 * 2);
        addObject(new Base(), getWidth() / 2, getHeight() - 47);
        addObject(carga, getWidth() / 2 + 10, getHeight() - 35);
        agregaHueco();
    }
    
    public void menu()
    {
        setBackground(getImagen(6));
        addObject(jugar, getWidth() / 3, 240);
        addObject(record, getWidth() / 3, 390);
        addObject(creditos, getWidth() / 3, 540);
        addObject(mouse, 0, 0);
        Greenfoot.setSpeed(50);
    }
    
    public void controlEnemigo()
    {
        if(fase == 2 || fase == 4) {
            
            if(reyna.getTiempo() == 1) {
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
                        addObject(new Explosion(),Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
                        nectarTotal--;
                    }
                }
                agregarEnemigo();
                frame++;
            }
            reyna.setBomba(nectarTotal);
        }
    }
    
    public void agregarEnemigo()
    {
        int n = Greenfoot.getRandomNumber(7) * 80;
        int o = 0;
        int tipo = Greenfoot.getRandomNumber(2);
        if(n == 0 || n == 480) {
            o = Greenfoot.getRandomNumber(7) * 84;
        }
        if(frame == 100) {
            if(fase == 2) {
                addObject(new Larva(tipo), n, o);   
            }
            if(fase == 4) {
                addObject(new Hormiga(), n, o);   
            }      
            frame = 0;
        }           
    }
    
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
       
        addObject(new Hueco(), getWidth() / 2 - 100, getHeight() / 5 + aumento *2 + 20);
        addObject(new Hueco(), getWidth() / 2 + 100, getHeight() / 5 + aumento *2 + 20);
        addObject(new Hueco(), getWidth() / 2 - 150, getHeight() / 5 + aumento *2 + 20);
        addObject(new Hueco(), getWidth() / 2 + 150, getHeight() / 5 + aumento *2 + 20);
        
        x = getWidth() / 2 - 75;
        y = getHeight() / 2 + 75;
        
        for(i = 0; i < 4; i++) {
            addObject(new Hueco(), x , y);
            x += aumento;
        } 
    }
    
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
    
     public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
    public Boton getJugar()
    {
        return jugar;
    }
     
    public Boton getRecord()
    {
        return record;
    }
    
    public Boton getRegresar()
    {
        return regresar;
    }
    
    public Boton getSiguiente()
    {
        return siguiente;
    }
    
    public Boton getSiguiente2()
    {
        return siguiente2;
    }
    
    public Boton getCreditos()
    {
        return creditos;
    }
    
    public Carga getCarga()
    {
        return carga;
    }
    
    public Queen getReyna()
    {
        return reyna;
    }
    
    public void ayuda1()
    {
        setBackground(getImagen(0));
        addObject(siguiente, getWidth() / 2, 540);
    }
    
    public void ayuda2()
    {
        setBackground(getImagen(1));     
        addObject(siguiente2, getWidth() / 2, 540);
    }
    
    public void record()
    {
        setBackground(getImagen(2));
        addObject(new ScoreBoard(480, 350), getWidth() / 2, getHeight() / 2);
        addObject(regresar, getWidth() / 2, 540);
    }
    
    public void creditos()
    {
        setBackground(getImagen(3));
        addObject(regresar, getWidth() / 2, 540);
    }
}

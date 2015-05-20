import greenfoot.UserInfo;
/**
 * Esta clase se encarga de guardar el record del usuario.
 * @author José Joaquín Ortiz Hernández
 * @author Oscar Torres Silva
 * @version 18/mayo/2015
 */
public class Record  
{
    // instance variables - reemplace el ejemplo a continuación por uno propio
    private UserInfo jugador;
    private int score;
    
    /**
     * Constructor de la clase Record. Toma los datos del jugador
     * siempre y cuando se puedan obtener y haya espacio disponible
     */
    public Record() 
    {
        if((UserInfo.isStorageAvailable()) && (UserInfo.getMyInfo() != null)) {
            this.jugador = UserInfo.getMyInfo();
        }
    }
    
    /**
     * Este método se encarga de guardar los puntos en el record
     * del usuario correspondiente.
     * 
     * @param int puntos a guardar.
     */
    public void guardaRecords(int puntos)
    {
        if((UserInfo.isStorageAvailable()) && (this.jugador != null) && ((puntos > this.jugador.getScore())) || (this.jugador.getInt(0))==0){ 
            this.jugador.setScore(puntos);
            this.jugador.setInt(0,1); 
            this.jugador.store();
        }
        
        if((UserInfo.isStorageAvailable()) && (this.jugador != null) && (puntos > this.jugador.getScore())){
            this.jugador.setScore(puntos);
            this.jugador.setInt(0,1); 
            this.jugador.store();
        }
    }
     
}
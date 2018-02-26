package exception;

/**
 * @author GOBERT Guillaume
 * Classe mère de gestion des exceptions
 */
public class StockageException extends Exception{
	
	/**
	 * Premier Constructeur
	 */
	public StockageException(){
		
	}
	/**
	 * @param msg
	 * Constructeur qui renvoie le message en cas d'erreur.
	 */
	public StockageException(String msg){
		super(msg);
	}
}

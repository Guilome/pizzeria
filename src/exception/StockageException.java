package exception;

/**
 * @author ETY0004
 * Classe mère de gestion des exceptions
 */
public class StockageException extends Exception{
	
	/**
	 * Premier constructeur vide
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

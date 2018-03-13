package fr.pizzeria.exception;

/**
 * @author GOBERT Guillaume
 *
 */
public class SavePizzaException extends StockageException{
	
	public SavePizzaException(){
		
	}
	public SavePizzaException(String msg){
		super(msg);
	}
		
}

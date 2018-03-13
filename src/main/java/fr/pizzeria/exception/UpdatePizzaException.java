package fr.pizzeria.exception;

/**
 * @author GOBERT Guillaume
 *
 */
public class UpdatePizzaException extends StockageException{
	
	public UpdatePizzaException(){
		
	}
	public UpdatePizzaException(String msg){
		super(msg);
	}
}

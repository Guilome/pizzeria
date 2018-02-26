package exception;

public class UpdatePizzaException extends StockageException{
	
	public UpdatePizzaException(){
		
	}
	public UpdatePizzaException(String msg){
		super(msg);
	}
}

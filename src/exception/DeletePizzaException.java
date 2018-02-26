package exception;

public class DeletePizzaException extends StockageException{
	
	public DeletePizzaException(){
		
	}
	public DeletePizzaException(String msg){
		super(msg);
	}
}
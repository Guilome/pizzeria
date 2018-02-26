package model;

import exception.StockageException;

public abstract class MenuService {

	public abstract void executeUC(PizzaMemDAO dao) throws StockageException;
	
}

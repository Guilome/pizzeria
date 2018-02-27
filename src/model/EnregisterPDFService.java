/**
 * 
 */
package model;

import java.util.List;

import Interface.IPizzaDAO;
import exception.StockageException;
import utils.PDFGenerator;

/**
 * @author GOBERT Guillaume
 *
 */
public class EnregisterPDFService extends MenuService{

	/* (non-Javadoc)
	 * @see model.MenuService#executeUC(Interface.IPizzaDAO)
	 */
	@Override
	public void executeUC(IPizzaDAO dao) throws StockageException {
		System.out.println("Liste des pizzas");
		List<Pizza> pizzas =  dao.findAllPizzas();
		PDFGenerator.creatorPDF(pizzas);
	}


}

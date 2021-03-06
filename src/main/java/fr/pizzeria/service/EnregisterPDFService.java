/**
 * 
 */
package fr.pizzeria.service;

//import
import java.util.List;
import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.utils.PDFGenerator;

/**
 * @author GOBERT Guillaume
 * Service qui fait appel � PDFGenerator pour cr�er le PDF 
 */
public class EnregisterPDFService extends MenuService{

	/* (non-Javadoc)
	 * @see model.MenuService#executeUC(Interface.IPizzaDAO)
	 */
	@Override
	public void executeUC(IPizzaDAO dao) {
		System.out.println("Cr�ation du PDF");
		List<Pizza> pizzas =  dao.findAllPizzas();
		PDFGenerator.creatorPDF(pizzas);
		System.out.println("Fini.");		
	}


}

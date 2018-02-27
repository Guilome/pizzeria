/**
 * 
 */
package model;

//import
import java.util.List;
import Interface.IPizzaDAO;
import utils.PDFGenerator;

/**
 * @author GOBERT Guillaume
 * Service qui fait appel à PDFGenerator pour créer le PDF 
 */
public class EnregisterPDFService extends MenuService{

	/* (non-Javadoc)
	 * @see model.MenuService#executeUC(Interface.IPizzaDAO)
	 */
	@Override
	public void executeUC(IPizzaDAO dao) {
		System.out.println("Création du PDF");
		List<Pizza> pizzas =  dao.findAllPizzas();
		PDFGenerator.creatorPDF(pizzas);
		System.out.println("Fini.");		
	}


}

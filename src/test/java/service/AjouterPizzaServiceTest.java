/**
 * 
 */
package service;

//import
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.dao.PizzaMemDAO;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.MenuService;

/**
 * @author GOBERT Guillaume
 *
 */
public class AjouterPizzaServiceTest {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	/**
	 * Test method for {@link fr.pizzeria.service.AjouterPizzaService#executeUC(fr.pizzeria.Interface.IPizzaDAO)}.
	 */
	@Test
	public void testExecuteUC() {
		IPizzaDAO dao = new PizzaMemDAO();
		systemInMock.provideLines("NOR","Norvegienne","POISSON","15.00");
		MenuService ms = new AjouterPizzaService();
		try {
			ms.executeUC(dao);
		}catch(StockageException se){
			System.out.println(se.getMessage());
		}
		assertEquals(9, dao.findAllPizzas().size());
		assertEquals("NOR", dao.findPizzaByCode("NOR").getCode());
		assertEquals("Norvegienne",dao.findPizzaByCode("NOR").getLibelle());
		assertEquals(CategoriePizza.POISSON, dao.findPizzaByCode("NOR").getCategorie());
		assertEquals(15.00,dao.findPizzaByCode("NOR").getPrix(), 0.0);		
	}
	
	@Test (expected = StockageException.class)
	public void testExecuteUCCode()throws StockageException{
		IPizzaDAO dao = new PizzaMemDAO();
		//Test code vide
		systemInMock.provideLines("","Norvegienne","POISSON","15.00");
		MenuService ms = new AjouterPizzaService();
		ms.executeUC(dao);		
	}	
	
	@Test (expected = StockageException.class)
	public void testExecuteUCLibelle()throws StockageException{
		IPizzaDAO dao = new PizzaMemDAO();
		//Test Libell� vide
		systemInMock.provideLines("NOR","","POISSON","blabla");
		MenuService ms = new AjouterPizzaService();
		ms.executeUC(dao);		
	}	
	
	@Test (expected = StockageException.class)
	public void testExecuteUCCategorie()throws StockageException{
		IPizzaDAO dao = new PizzaMemDAO();
		//Test categorie non existante
		systemInMock.provideLines("NOR","Norvegienne","80","15.00");
		MenuService ms = new AjouterPizzaService();
		ms.executeUC(dao);		
	}
	
	@Test (expected = StockageException.class)
	public void testExecuteUCPrix()throws StockageException{
		IPizzaDAO dao = new PizzaMemDAO();
		//Test prix non valide
		systemInMock.provideLines("NOR","Norvegienne","POISSON","blabla");
		MenuService ms = new AjouterPizzaService();
		ms.executeUC(dao);		
	}	
	
}

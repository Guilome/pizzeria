/**
 * 
 */
package service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.ListerPizzasService;
import fr.pizzeria.service.MenuService;

/**
 * @author ETY0004
 *
 */
public class ListerPizzasServiceTest {

	@Test (expected = StockageException.class)
	public void testNull() throws StockageException{
		
		IPizzaDAO mockedDao = Mockito.mock(IPizzaDAO.class);
		Mockito.when(mockedDao.findAllPizzas()).thenReturn(null);
		
		MenuService ms = new ListerPizzasService();
		ms.executeUC(mockedDao);
	}
	
	@Test
	public void testIncoherence() throws StockageException{
		
		IPizzaDAO mockedDao = Mockito.mock(IPizzaDAO.class);
		List<Pizza> pizzas = new ArrayList<>();
		
		Pizza p = null;
		pizzas.add(p);
		Pizza p2 = new Pizza(null, "Norvegienne", 15.00, CategoriePizza.POISSON);
		pizzas.add(p2);
		
		Mockito.when(mockedDao.findAllPizzas()).thenReturn(pizzas);
		
		MenuService ms = new ListerPizzasService();
		ms.executeUC(mockedDao);		
	}
}

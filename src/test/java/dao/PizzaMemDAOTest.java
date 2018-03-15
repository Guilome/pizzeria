package dao;

//import
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.dao.PizzaMemDAO;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY0004
 *
 */
public class PizzaMemDAOTest {

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDAO#findAllPizzas()}.
	 */
	@Test
	public void testFindAllPizzas(){
		IPizzaDAO dao = new PizzaMemDAO();
		List<Pizza> pizzas = dao.findAllPizzas();
		assertEquals(8 , pizzas.size());		
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDAO#saveNewPizza(fr.pizzeria.model.Pizza)}.
	 */
	@Test
	public void testSaveNewPizza() {
		IPizzaDAO dao = new PizzaMemDAO();		
		Pizza p = new Pizza("NOR","Norvegienne",15.00, CategoriePizza.POISSON);
		dao.saveNewPizza(p);
		assertEquals(9 , dao.findAllPizzas().size());		
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDAO#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)}.
	 */
	@Test
	public void testUpdatePizza() {
		IPizzaDAO dao = new PizzaMemDAO();
		List<Pizza> pizzas = dao.findAllPizzas();
		Pizza p = new Pizza("NOR","Norvegienne",15.00, CategoriePizza.POISSON);		
		dao.updatePizza("IND", p);
		
		assertEquals("NOR", dao.findAllPizzas().get(7).getCode());
		assertEquals("Norvegienne", dao.findAllPizzas().get(7).getLibelle());
		assertEquals(15.0, dao.findAllPizzas().get(7).getPrix(),0.0);
		assertEquals( CategoriePizza.POISSON, dao.findAllPizzas().get(7).getCategorie());
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDAO#deletePizza(java.lang.String)}.
	 */
	@Test
	public void testDeletePizza() {
		IPizzaDAO dao = new PizzaMemDAO();		
		dao.deletePizza("IND");
		assertEquals(7 , dao.findAllPizzas().size());	
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDAO#findPizzaByCode(java.lang.String)}.
	 */
	@Test
	public void testFindPizzaByCode() {
		IPizzaDAO dao = new PizzaMemDAO();	
		assertNotNull(dao.findPizzaByCode("IND"));
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDAO#pizzaExists(java.lang.String)}.
	 */
	@Test
	public void testPizzaExists() {
		IPizzaDAO dao = new PizzaMemDAO();	
		assertTrue(dao.pizzaExists("IND"));
	}

}

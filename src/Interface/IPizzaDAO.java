package Interface;

//import
import java.util.List;
import model.Pizza;

public interface IPizzaDAO {
	List<Pizza>findAllPizzas();
	void saveNewPizza(Pizza pizza);
	void updatePizza(String codePizza, Pizza pizza);
	void deletePizza(String codePizza);
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);
}

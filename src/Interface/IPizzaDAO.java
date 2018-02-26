package Interface;

//import
import java.util.List;
import model.Pizza;

/**
 * @author ETY0004
 *
 */
public interface IPizzaDAO {
	/** Stocke dans une liste toutes les pizzas
	 * @return
	 */
	List<Pizza>findAllPizzas();
	/**Sauvegarde une nouvelle pizza
	 * @param pizza
	 */
	void saveNewPizza(Pizza pizza);
	/** Met à jour une pizza déjà existante
	 * @param codePizza
	 * @param pizza
	 */
	void updatePizza(String codePizza, Pizza pizza);
	/** Supprime une pizza
	 * @param codePizza
	 */
	void deletePizza(String codePizza);
	/** Retourne un pizza en fonction de son code
	 * @param codePizza
	 * @return
	 */
	Pizza findPizzaByCode(String codePizza);
	/** Verifie si la pizza existe
	 * @param codePizza
	 * @return
	 */
	boolean pizzaExists(String codePizza);
}

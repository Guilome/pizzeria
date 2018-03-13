/**
 * 
 */
package fr.pizzeria.model;

//import
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import fr.pizzeria.Interface.IPizzaDAO;

/**
 * @author GOBERT Guillaume
 *
 */
public class PizzaTxtDAO implements IPizzaDAO{	

	File persistance = new File("persistance.txt");
	List<Pizza> mesPizzas = new ArrayList<>();	

	public PizzaTxtDAO(){

	}
	
	@Override
	public List<Pizza> findAllPizzas() {		
		try {
			File file = persistance;
			String string = FileUtils.readFileToString(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return mesPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {		
		try {
			File file = persistance;
			FileUtils.writeStringToFile(file, pizza.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}


}

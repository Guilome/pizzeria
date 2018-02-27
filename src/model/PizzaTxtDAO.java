/**
 * 
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.Paragraph;

import Interface.IPizzaDAO;

/**
 * @author GOBERT Guillaume
 *
 */
public class PizzaTxtDAO implements IPizzaDAO{	

	File persistance = new File("persistance.txt");
	List<Pizza> mesPizzas = new ArrayList<>();	
	int compteur = 0;

	public PizzaTxtDAO(){
		if( compteur == 0){
			//Création de la liste		
			mesPizzas.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
			mesPizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
			mesPizzas.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
			mesPizzas.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
			mesPizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
			mesPizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
			mesPizzas.add(new Pizza("ORI", "L’orientale", 13.50, CategoriePizza.SANS_VIANDE));
			mesPizzas.add(new Pizza("IND", "L’indienne", 14.00, CategoriePizza.VIANDE));
			//Création de la persistance
			try {
				File file = persistance;
				for(Pizza p : mesPizzas){
					FileUtils.writeStringToFile(file, p.toString());
				}     
			} catch (IOException e) {
				e.printStackTrace();
			}			
			compteur++;
		}
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

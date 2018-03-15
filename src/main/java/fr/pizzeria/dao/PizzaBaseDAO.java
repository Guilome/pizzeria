/**
 * 
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.pizzeria.PizzerieAdminConsoleApp2;
import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.utils.ConnectionDB;

/**
 * @author GOBERT Guillaume
 *
 */
public class PizzaBaseDAO implements IPizzaDAO{
	
	private static final Logger log = LoggerFactory.getLogger(PizzerieAdminConsoleApp2.class);
	
	public PizzaBaseDAO() {
		ConnectionDB.openConnection();
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> Pizzas = new ArrayList<>(); 
		CategoriePizza categorie = null;
		
		try {
			
			Statement statement = ConnectionDB.getStatement();
			
			ResultSet rsPizzas = statement.executeQuery("SELECT * FROM pizza");
			
			while(rsPizzas.next()) {
				Pizza pizzaAjout = new Pizza();
				pizzaAjout.setId(rsPizzas.getInt("id"));
				pizzaAjout.setCode(rsPizzas.getString("code"));
				pizzaAjout.setLibelle(rsPizzas.getString("libelle"));
				pizzaAjout.setPrix(rsPizzas.getDouble("prix"));				
				pizzaAjout.setCategorie(categorie.valueOf(rsPizzas.getString("categorie").toUpperCase()));
				Pizzas.add(pizzaAjout);
			}
			rsPizzas.close();		
		}catch (SQLException e) {			
			log.error(e.getMessage());
		}
		return Pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
				
		try {
			PreparedStatement insertPizza = ConnectionDB.getConnexion().prepareStatement
					("INSERT INTO pizza VALUES (?,?,?,?,?')");
			insertPizza.setInt(1, pizza.getId());
			insertPizza.setString(2, pizza.getCode());
			insertPizza.setString(3, pizza.getLibelle());
			insertPizza.setDouble(4, pizza.getPrix());
			insertPizza.setString(5, pizza.getCategorie().toString());
			insertPizza.execute();
			
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		try {
			PreparedStatement updatePizza = ConnectionDB.getConnexion().prepareStatement
					("UPDATE pizza SET code=?, libelle=?, prix=?, categorie=? WHERE code=?");
			updatePizza.setString(1, pizza.getCode());
			updatePizza.setString(2, pizza.getLibelle());
			updatePizza.setDouble(3, pizza.getPrix());
			updatePizza.setString(4, pizza.getCategorie().toString());
			updatePizza.setString(5, codePizza);
			updatePizza.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		
		try {
			PreparedStatement pizzaExist = ConnectionDB.getConnexion().prepareStatement("DELETE FROM pizza WHERE code=?");
			pizzaExist.setString(1, codePizza);
			pizzaExist.executeUpdate();
			
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean exist = false;
		
		try {
			PreparedStatement pizzaExist = ConnectionDB.getConnexion().prepareStatement("SELECT * FROM pizza WHERE code=?");
			pizzaExist.setString(1, codePizza);
			ResultSet resultPizza = pizzaExist.executeQuery();
			if(resultPizza.next())
				exist = true;
			
		} catch (SQLException e) {
			log.error(e.getMessage());
		}		
		return exist;
	}

}

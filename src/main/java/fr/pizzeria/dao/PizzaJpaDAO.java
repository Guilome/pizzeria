/**
 * 
 */
package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.model.Pizza;

/**
 * @author GOBERT Guillaume
 *
 */
public class PizzaJpaDAO implements IPizzaDAO {


	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria");

	Pizza pizza = null;

	@Override
	public List<Pizza> findAllPizzas() {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Pizza> lesPizzas = null;
		TypedQuery<Pizza> pizzaQuery = em.createQuery("select p from Pizza p ", Pizza.class);

		lesPizzas = pizzaQuery.getResultList();	
		return lesPizzas;

	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(pizza);
		et.commit();	
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Pizza> pizzaQuery = em.createQuery("select p from Pizza p where code= :pizzaCode", Pizza.class);
		pizzaQuery.setParameter("pizzaCode", codePizza);
		
		Pizza pizzaUpdate = pizzaQuery.getSingleResult();
		pizzaUpdate.setCode(pizza.getCode());
		pizzaUpdate.setLibelle(pizza.getLibelle());
		pizzaUpdate.setPrix(pizza.getPrix());
		pizzaUpdate.setCategorie(pizza.getCategorie());
		
		em.persist(pizzaUpdate);
		et.commit();	
	}

	@Override
	public void deletePizza(String codePizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Pizza> pizzaQuery = em.createQuery("select p from Pizza p where code= :pizzaCode", Pizza.class);
		pizzaQuery.setParameter("pizzaCode", codePizza);
		
		Pizza pizzaDelete = pizzaQuery.getSingleResult();
		em.remove(pizzaDelete);
		et.commit();	
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery<Pizza> pizzaQuery = em.createQuery("select p from Pizza p where code= :pizzaCode", Pizza.class);
		pizzaQuery.setParameter("pizzaCode", codePizza);
		
		pizza = pizzaQuery.getSingleResult();		
		return pizza;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery<Pizza> pizzaQuery = em.createQuery("select p from Pizza p where code= :pizzaCode", Pizza.class);
		pizzaQuery.setParameter("pizzaCode", codePizza);	
		if (pizzaQuery.getMaxResults() > 1) {
			return true;
		}
		return false;
	}
}

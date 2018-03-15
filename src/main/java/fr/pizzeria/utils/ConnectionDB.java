/**
 * 
 */
package fr.pizzeria.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;

/**
 * @author GOBERT Guillaume
 *
 */
public class ConnectionDB {
	
	private static final Logger log = LoggerFactory.getLogger(ConnectionDB.class);
	private static Connection connexionBase = null;
	private static Statement statement = null;
	
	/**
	 * 
	 * @return propertie -> ce sont les proprietes necessaires a la connection en base de donnée
	 * @throws Exception 
	 */
	public static Properties loadPropertiesFile() throws Exception {
		 
		Properties propertie = new Properties();
		InputStream lecture = new FileInputStream("jdbc.properties");
		propertie.load(lecture);
		lecture.close();
		return propertie;
	}
	
	/**
	 * Ouvre une connection et ouvre un statement 
	 */
	public static void openConnection() {
		
		try {

			Properties propertie = loadPropertiesFile();

			String driver = propertie.getProperty("jdbc.driver");
			String url = propertie.getProperty("jdbc.url");
			String username = propertie.getProperty("jdbc.username");
			String password = propertie.getProperty("jdbc.password");

			Class.forName(driver);

			connexionBase = DriverManager.getConnection(url, username, password);

			if (connexionBase != null) {
				log.debug("Connexion réussie");
				statement = connexionBase.createStatement();
			}

			else {
				log.error("La connexion est vide");
			}

		}catch (SQLException e) {
			log.error("Erreur : échec ouverture connexion");
		} 
		catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	/**
	 * Ferme la connaxion a la base de donnée et ferme le statement 
	 */
	public static void closeConnection(){
		try {
			connexionBase.close();
			statement.close();
			log.debug("Connexion fermée");
		} catch (SQLException e) {
			log.error("Erreur : échec fermeture connexion");
		}
	}
	/**
	 * 
	 * @return statement -> retourne le statement créé avec openConnection
	 */
	public static Statement getStatement(){
		return statement;		
	}
	/**
	 * 
	 * @return connexionBase -> retourne la connection créée avec openConnection
	 */
	public static Connection getConnexion(){
		return connexionBase;		
	}
}

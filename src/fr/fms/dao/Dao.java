/**
 * @author Mathieu FIX - 2022
 * 
 */

package fr.fms.dao;

import java.sql.Connection;
import java.util.ArrayList;

import java.util.logging.Logger;

public interface Dao<T> {
	public Connection connection = 
			BddConnection.getConnection();
	//au chargement d'une classe qui implémente Dao, une création de connexion sera faite (gestion du multithreading à 2 verrous)
	
	public static final Logger logger = Logger.getLogger( "SqlExceptions" );
	
	/**
	 * ajout d'une nouvelle occurence en base
	 * @param obj correspond à un enregistrement
	 */
	public boolean create(T obj);	
	
	/**
	 * renvoi un objet correspondant à l'id en base
	 * @param id de l'objet
	 * @return l'objet correspondant, si non trouvé, renvoi null
	 */
	public T read(int id);		
	
	/**
	 * met à jour l'objet en base
	 * @param obj
	 * @return vrai si c'est fait, sinon faux
	 */
	public boolean update(T obj);	
	
	/**
	 * supprime un objet en base
	 * @param obj
	 * @return vrai si c'est fait, sinon faux
	 */
	public boolean delete(T obj);	
	
	/**
	 * renvoi tous les objets de la table correspondante
	 * @return ArrayList<T> correspondant 
	 */
	public ArrayList<T> readAll();

}


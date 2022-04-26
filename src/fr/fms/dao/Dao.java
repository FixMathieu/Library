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
	//au chargement d'une classe qui impl�mente Dao, une cr�ation de connexion sera faite (gestion du multithreading � 2 verrous)
	
	public static final Logger logger = Logger.getLogger( "SqlExceptions" );
	
	/**
	 * ajout d'une nouvelle occurence en base
	 * @param obj correspond � un enregistrement
	 */
	public boolean create(T obj);	
	
	/**
	 * renvoi un objet correspondant � l'id en base
	 * @param id de l'objet
	 * @return l'objet correspondant, si non trouv�, renvoi null
	 */
	public T read(int id);		
	
	/**
	 * met � jour l'objet en base
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


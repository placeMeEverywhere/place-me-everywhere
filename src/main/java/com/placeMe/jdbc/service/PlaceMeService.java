package com.placeMe.jdbc.service;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class PlaceMeService {
	
	/**
	 * Metodo che effettua una serie di operazioni transazionali sul database
	 * 
	 */
	abstract void serve() throws DataAccessException;
}

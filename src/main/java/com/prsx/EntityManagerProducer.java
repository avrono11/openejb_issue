package com.prsx;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;






/*
 * 
 *  Do we need to import Javax.Persistance or OpenEJB ? 
 *  
 *  */

@SessionScoped
@Stateful
public class EntityManagerProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	@Produces
	public EntityManager getEntityManager() {
		return em;
	}
}

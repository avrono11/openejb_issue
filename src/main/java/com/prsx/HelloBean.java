package com.prsx;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.prsx.persistence.Item;

/**
 * Session Bean implementation class HelloBean
 */
@Stateful
@LocalBean
public class HelloBean implements Serializable  {
	
	/*
	@PersistenceContext(unitName = "PRSX", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
	*/
    public String from() {
    	
    	/* Testing persistance with the Entity Manager */
    	/*
		Item item = new Item();
		item.setId(0);
		Date now = new Date();
		now.UTC(2012, 12, 12, 12, 12, 12);
		
		item.setBidStartDate(now);
		item.setCreatedDate(now);
		item.setBidEndDate(now);
		item.setInitialPrice(100.00);
		item.setName("test item");
		
		try {
			entityManager.persist(item);
		} catch (Exception ex ) {
			System.out.println("Entity Manager has thrown an exception ");
			ex.printStackTrace();
		}
    	*/
    	return "EJB";
    }

}

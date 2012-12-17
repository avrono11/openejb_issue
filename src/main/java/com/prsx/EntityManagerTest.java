package com.prsx;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;


@Named
public class EntityManagerTest {

	@Inject
	private EntityManager em;
	
}

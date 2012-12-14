package com.prsx;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TestTable
 *
 */
@Entity

public class TestTable implements Serializable {

	
	private Integer id;
	private String name;
	private static final long serialVersionUID = 1L;

	public TestTable() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}

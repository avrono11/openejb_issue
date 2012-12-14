package com.prsx.persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the group database table.
 * 
 */
@Entity
@Table(name="group")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String group;

	private String username;

    public Group() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
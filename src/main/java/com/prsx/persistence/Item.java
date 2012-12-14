package com.prsx.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@Table(name="item")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

    @Temporal( TemporalType.DATE)
	private Date bidEndDate;

    @Temporal( TemporalType.DATE)
	private Date bidStartDate;

    @Temporal( TemporalType.DATE)
	private Date createdDate;

	private double initialPrice;

	private String name;

	//bi-directional many-to-one association to Bid
	@OneToMany(mappedBy="item")
	private Set<Bid> bids;

    public Item() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBidEndDate() {
		return this.bidEndDate;
	}

	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public Date getBidStartDate() {
		return this.bidStartDate;
	}

	public void setBidStartDate(Date bidStartDate) {
		this.bidStartDate = bidStartDate;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public double getInitialPrice() {
		return this.initialPrice;
	}

	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Bid> getBids() {
		return this.bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	
}
package com.prsx.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the bidder database table.
 * 
 */
@Entity
@Table(name="bidder")
public class Bidder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="credit_rating")
	private double creditRating;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to Bid
	@OneToMany(mappedBy="bidder")
	private Set<Bid> bids;

    public Bidder() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCreditRating() {
		return this.creditRating;
	}

	public void setCreditRating(double creditRating) {
		this.creditRating = creditRating;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<Bid> getBids() {
		return this.bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	
}
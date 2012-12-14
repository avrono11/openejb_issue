package com.prsx.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the bids database table.
 * 
 */
@Entity
@Table(name="bids")
public class Bid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

    @Temporal( TemporalType.DATE)
	private Date bidDate;

	private double bidPrice;

	//bi-directional many-to-one association to Bidder
    @ManyToOne
	private Bidder bidder;

	//bi-directional many-to-one association to Item
    @ManyToOne
	private Item item;

    public Bid() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBidDate() {
		return this.bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public double getBidPrice() {
		return this.bidPrice;
	}

	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}

	public Bidder getBidder() {
		return this.bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}
	
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
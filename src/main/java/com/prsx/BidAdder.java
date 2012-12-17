package com.prsx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.sql.DataSource;


@ManagedBean(name = "bidAdder")
@RequestScoped
public class BidAdder {
	
	private int id =0;
	private Date bidDate = null;
	private double bidPrice = 0;
	private int item_id = 0;
	private int bidder_id = 0;
	private ArrayList <String> itemList = null;
	
	private java.text.SimpleDateFormat sdf;

	@Resource(name="jdbc/testDB", type=javax.sql.DataSource.class)
	private DataSource dataSource;
	
	private Connection connection;

	/* Getter / Setter */
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
	
	public int getItem_id() {
		return this.item_id;
	}
	
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
	public int getBidder_id() {
		return this.bidder_id;
	}
	
	public void setBidder_id(int bidder_id) {
		this.bidder_id = bidder_id;
	}
	
	public ArrayList<String> getItemList() {
		this.itemList = new ArrayList<String>();
		java.sql.Statement stmt = null;
		try {
			stmt = connection.createStatement();
			String query = "SELECT  * from item ";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {

				this.itemList.add(rs.getString("name"));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return this.itemList;

	}
	
	public String addBid() {
		java.sql.Statement stmt = null;
		String insertStr = "INSERT INTO bids values(" +
				this.id + "," +
				"'" + sdf.format(this.bidDate) + "'," +
				"" + this.bidPrice + "," +
				"" + this.item_id + "," +
				"" + this.bidder_id + "," + ")";
		
		System.out.println("Query is <" + insertStr);
		
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(insertStr);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Item added";
	}
	
	public String reset (){
		
	    this.id=0;
	    this.bidDate = null;
	    this.bidPrice = 0;
	    this.item_id = 0;
	    this.bidder_id = 0;
		return "reset";
	  }
	
	@PostConstruct
	public void init() {
		/* Just make the dates NOW and NOW+14 days */
		Calendar today = Calendar.getInstance();
		bidDate = new java.util.Date(today.getTimeInMillis());

		sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			System.out.println("Trying to establish DB connection ...");
			connection = dataSource.getConnection();
			System.out.println("Connection info is ...");
			System.out.println(connection.getWarnings());
			
			/*
			try {
				Class.forName(DRIVER);
			}  catch(ClassNotFoundException e){
	            System.out.println("Database driver not found.");
	        }
			String username = "root";	 
			String password = "milena11";
	        connection = DriverManager.getConnection(DBURL, username, password);
	        */
		} catch(Exception sqle) {
			sqle.printStackTrace();
		}
	}
	
	
}

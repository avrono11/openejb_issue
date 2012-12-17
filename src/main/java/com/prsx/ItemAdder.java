package com.prsx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.sql.DataSource;


@ManagedBean(name = "itemAdder")
@RequestScoped
public class ItemAdder {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost/testDB";
	
	private int id = 0;
	private String name = null;
	private Date createdDate = null;
	private Date bidStartDate = null;
	private Date bidEndDate = null;
	private double  initialPrice = 0;
	
	private java.text.SimpleDateFormat sdf;
	
	@SuppressWarnings("unused")
	private Connection connection;
	
	@Resource(name="jdbc/testDB", type=javax.sql.DataSource.class)
	private DataSource dataSource;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public Date getCreatedDate() {
		return this.createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}	
	
	public Date getBidStartDate() {
		return this.bidStartDate;
	}
	
	public void setBidStartDate(Date bidStartDate) {
		this.bidStartDate = bidStartDate;
	}
	
	public Date getBidEndDate() {
		return this.bidEndDate;
	}
	
	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}
	
	public double getInitialPrice() {
		return this.initialPrice;
	}
	
	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}
	
	public String addItem() {
		java.sql.Statement stmt = null;
		String insertStr = "INSERT INTO item values(" +
				this.id + "," +
				"'" + this.name + "'," +
				"'" + sdf.format(this.createdDate) + "'," +
				"'" + sdf.format(this.bidStartDate) + "'," +
				"'" + sdf.format(this.bidEndDate) + "'," +
				this.initialPrice + ")";
		
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
	    this.name = null;
	    this.initialPrice =0;
	    this.createdDate = null;
	    this.bidStartDate = null;
	    this.bidEndDate = null;
		return "reset";
	  }
	
	@PostConstruct
	public void init() {
		/* Just make the dates NOW and NOW+14 days */
		Calendar today = Calendar.getInstance();
		createdDate = new java.util.Date(today.getTimeInMillis());
		bidStartDate = new java.util.Date(today.getTimeInMillis());
		today.add(Calendar.DATE, 14);
		bidEndDate = new java.util.Date(today.getTimeInMillis());
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

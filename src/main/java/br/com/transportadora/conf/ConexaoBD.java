package br.com.transportadora.conf;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/database_name";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String MAX_POOL = "250"; // set your own limit
	
	private Connection connection;
	
	public Connection connect() {
	    if (connection == null) {
	        try {
	            Class.forName(DATABASE_DRIVER);
	            connection = DriverManager.getConnection(DATABASE_URL);
	        }catch (Exception e) {
	        	
			}
	    }
	    return connection;
	}
		
	
}

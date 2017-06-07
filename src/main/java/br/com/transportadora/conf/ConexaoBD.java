package br.com.transportadora.conf;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/transportadora";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	private Connection connection;
	
	public Connection connect() {
	    if (connection == null) {
	        try {
	            Class.forName(DATABASE_DRIVER);
	            connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
	        }catch (Exception e) {
	        	e.printStackTrace();
			}
	    }
	    return connection;
	}
		
	
}

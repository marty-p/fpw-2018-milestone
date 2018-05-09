/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

/**
 *
 * @author Marty
 */
public class DbConnection {
	private static DbConnection singleton;
	public static DbConnection getInstance(){
		if(singleton == null)
			singleton = new DbConnection();
		return singleton;
	}

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * @param conn the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Connection Connect() throws SQLException {
		if (getConn()==null) {
			String hostname = "jdbc:mysql://ec2-52-47-198-123.eu-west-3.compute.amazonaws.com:443/fpw18_pinnamartino";
			String username = "fpw18_pinnamartino";
			String password = "marty-p";
			Connect(hostname, username, password);
		}
		return getConn();
	}

	public void Connect(String hostname, String username, String password) throws SQLException {
		setConn(DriverManager.getConnection(hostname, username, password));
	}

	private Connection conn;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.logging.Logger;
import java.util.logging.Level;

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

	private Connection conn;
	public DbConnection() {
		String hostname = "jdbc:mysql://ec2-52-47-198-123.eu-west-3.compute.amazonaws.com:443/fpw18_pinnamartino";
		String username = "fpw18_pinnamartino";
		String password = "marty-p";
		Connect(hostname, username, password);
	}

	public void Connect(String hostname, String username, String password) {
		try {
			conn = DriverManager.getConnection(hostname, username, password);
		} catch (SQLException ex) {
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

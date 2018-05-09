/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marty
 */
public class DbHelper {
	private static DbHelper singleton;
	public static DbHelper getInstance(){
		if(singleton == null)
			singleton = new DbHelper();
		return singleton;
	}

	public DbHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Connection connect() throws SQLException {
		String hostname = "jdbc:mysql://ec2-52-47-198-123.eu-west-3.compute.amazonaws.com:443/fpw18_pinnamartino";
		String username = "fpw18_pinnamartino";
		String password = "marty-p";
		return connect(hostname, username, password);
	}

	public Connection connect(String hostname, String username, String password) throws SQLException {
		return DriverManager.getConnection(hostname, username, password);
	}

	public void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public void close(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
			}
		}
	}

	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}

	public void close(Connection conn, PreparedStatement stmt, ResultSet res) {
		close(res);
		close(stmt);
		close(conn);
	}
}

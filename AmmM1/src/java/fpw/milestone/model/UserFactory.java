/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Marty
 */
public class UserFactory {
	private static UserFactory singleton;
	public static UserFactory getInstance() {
		if(singleton == null)
			singleton = new UserFactory();
		return singleton;
	}

	public List<User> getUsers() {
		ArrayList<User> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select * from users";
			stmt = conn.prepareStatement(query);

            res = stmt.executeQuery();
            while (res.next()) {
				User user = new User();
				user.setId(res.getInt("id"));
				user.setName(res.getString("name"));
				user.setSurname(res.getString("surname"));
				user.setUsername(res.getString("username"));
				user.setPassword(res.getString("password"));
				user.setCategory(res.getString("category"));
				// extra fields
				user.setBirthDate(res.getDate("birthDate"));
				user.setIntroDesc(res.getString("introDesc"));
				user.setImageUrl(res.getString("imageUrl"));
				list.add(user);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DbHelper.getInstance().close(conn, stmt, res);
		}

		return list;
	}

	public User getUserById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select * from users where id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);

            res = stmt.executeQuery();
            if (res.next()) {
				User user = new User();
				user.setId(res.getInt("id"));
				user.setName(res.getString("name"));
				user.setSurname(res.getString("surname"));
				user.setUsername(res.getString("username"));
				user.setPassword(res.getString("password"));
				user.setCategory(res.getString("category"));
				// extra fields
				user.setBirthDate(res.getDate("birthDate"));
				user.setIntroDesc(res.getString("introDesc"));
				user.setImageUrl(res.getString("imageUrl"));
				return user;
			}
		} catch (SQLException ex) {
			Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DbHelper.getInstance().close(conn, stmt, res);
		}

		return null;
	}

	public User ProcessLogin(String username, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select * from users where username = ? and password = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);

            res = stmt.executeQuery();
            if (res.next()) {
				User user = new User();
				user.setId(res.getInt("id"));
				user.setName(res.getString("name"));
				user.setSurname(res.getString("surname"));
				user.setUsername(res.getString("username"));
				user.setPassword(res.getString("password"));
				user.setCategory(res.getString("category"));
				// extra fields
				user.setBirthDate(res.getDate("birthDate"));
				user.setIntroDesc(res.getString("introDesc"));
				user.setImageUrl(res.getString("imageUrl"));
				return user;
			}
		} catch (SQLException ex) {
			Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DbHelper.getInstance().close(conn, stmt, res);
		}

		return null;
	}
}

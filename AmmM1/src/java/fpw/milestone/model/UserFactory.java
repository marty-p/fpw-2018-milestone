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
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Connection conn = DbConnection.getInstance().Connect();
			String query = "select * from users;";
			PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
				User user = new User();
				user.setId(res.getInt("id"));
				user.setName(res.getString("name"));
				user.setSurname(res.getString("surname"));
				user.setUsername(res.getString("username"));
				user.setPassword(res.getString("password"));
				user.setCategory(fpw.milestone.model.User.Category.AUTHOR);
				// extra fields
				try {
					user.setBirthDate(df.parse(res.getString("birthDate")));
				} catch (ParseException e) {}
				user.setIntroDesc(res.getString("introDesc"));
				user.setImageUrl(res.getString("imageUrl"));
				list.add(user);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
		}

		return list;
	}

	public User getUserById(int id) {
		// just for milestone2 (list of news)
		List<User> userList = this.getUsers();
		for (User u : userList) {
			if (u.getId() == id)
				return u;
		}
		return null;
	}

	public User ProcessLogin(String username, String password) {
		// just for milestone2
		List<User> ulist = getUsers();
		for (User u : ulist) {
			// guest users can't log in
			if (u.getCategory()==fpw.milestone.model.User.Category.GUEST)
				continue;
			// check if username and password match
			if (u.getUsername().equals(username)) {
				if (u.getPassword().equals(password))
					return u;
			}
		}
		return null;
	}
}

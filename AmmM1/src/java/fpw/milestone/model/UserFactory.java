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
		// just for milestone2 (list of users)
		ArrayList<User> list = new ArrayList<>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		// pinco pallino
		User user = new User();
		user.setId(1);
		user.setName("Pinco");
		user.setSurname("Pallino");
		user.setUsername("pp1");
		user.setPassword("111");
		user.setCategory(fpw.milestone.model.User.Category.AUTHOR);
		// extra fields
		try {
			user.setBirthDate(df.parse("1/1/2018"));
		} catch (ParseException e) {}
		user.setIntroDesc("introducting myself 1");
		list.add(user);

		// pinco pallone
		user = new User();
		user.setId(2);
		user.setName("Pinco");
		user.setSurname("Pallone");
		user.setUsername("pp2");
		user.setPassword("222");
		user.setCategory(fpw.milestone.model.User.Category.READER);
		// extra fields
		try {
			user.setBirthDate(df.parse("2/2/2018"));
		} catch (ParseException e) {}
		user.setIntroDesc("introducting myself 2");
		list.add(user);

		// pinco palloncino
		user = new User();
		user.setId(3);
		user.setName("Pinco");
		user.setSurname("Palloncino");
		user.setUsername("pp3");
		user.setPassword("333");
		user.setCategory(fpw.milestone.model.User.Category.GUEST);
		// extra fields
		try {
			user.setBirthDate(df.parse("3/3/2018"));
		} catch (ParseException e) {}
		user.setIntroDesc("introducting myself 3");
		list.add(user);

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
			if (u.getUsername().equals(username)) {
				if (u.getPassword().equals(password))
					return u;
			}
		}
		return null;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Marty
 */
public class UserFactory {
	private static UserFactory singleton;
	public static UserFactory getInstance(){
		if(singleton == null)
			singleton = new UserFactory();
		return singleton;
	}

	public List<User> getUsers(){
		// creo la lista degli utenti nel sistema
		ArrayList<User> list = new ArrayList<>();

		// pinco pallino
		User user = new User();
		user.setId(1);
		user.setName("Pinco");
		user.setSurname("Pallino");
		user.setUsername("pp1");
		user.setPassword("111");
		user.setCategory(fpw.milestone.model.User.Category.AUTHOR);
		list.add(user);

		// pinco pallone
		user = new User();
		user.setId(2);
		user.setName("Pinco");
		user.setSurname("Pallone");
		user.setUsername("pp2");
		user.setPassword("222");
		user.setCategory(fpw.milestone.model.User.Category.AUTHOR);
		list.add(user);

		// pinco palloncino
		user = new User();
		user.setId(3);
		user.setName("Pinco");
		user.setSurname("Palloncino");
		user.setUsername("pp3");
		user.setPassword("333");
		user.setCategory(fpw.milestone.model.User.Category.AUTHOR);
		list.add(user);

		return list;
	}
}

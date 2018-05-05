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
        // (molto corta, sono solo 2)
        ArrayList<User> list = new ArrayList<>();
        User usr1 = new User();
        usr1.setId(1);
        usr1.setName("Pinco");
        usr1.setSurname("Pallone");
        usr1.setUsername("pinco_pallino");
        usr1.setPassword("admin");
        list.add(usr1);

        User usr2 = new User();
        usr2.setId(2);
        usr2.setName("Pinco");
        usr2.setSurname("Pallone");
        usr2.setUsername("pinco_pallone");
        usr2.setPassword("test");
        list.add(usr2);
        return list;
    }
}

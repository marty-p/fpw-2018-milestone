/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.User;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Marty
 */
public class UserFactory {
    private static UserFactory singleton;

    public static UserFactory getInstance(){
        if(singleton == null){
            singleton = new UserFactory();
        }

        return singleton;
    }

    private UserFactory(){

    }

    public List<Utenti> getUsers(){
        // creo la lista degli utenti nel sistema
        // (molto corta, sono solo 2)
        ArrayList<Utenti> list = new ArrayList<>();
        Utenti usr1 = new Utenti();
        usr1.setId(1);
        usr1.setName("Pinco");
        usr1.setSurname("Pallone");
        usr1.setUsername("pinco_pallino");
        usr1.setPassword("admin");
        list.add(usr1);

        Utenti usr2 = new Utenti();
        usr2.setId(2);
        usr2.setName("Pinco");
        usr2.setSurname("Pallone");
        usr2.setUsername("pinco_pallone");
        usr2.setPassword("test");
        list.add(usr2);
        return list;
    }
}

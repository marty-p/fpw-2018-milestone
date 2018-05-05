/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

/**
 *
 * @author Marty
 */
public class CommentsFactory {
    private static CommentsFactory singleton;
    public static CommentsFactory getInstance(){
        if(singleton == null)
            singleton = new CommentsFactory();
        return singleton;
    }
}

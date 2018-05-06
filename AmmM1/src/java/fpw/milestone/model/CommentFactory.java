/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Marty
 */
public class CommentFactory {
	private static CommentFactory singleton;
	public static CommentFactory getInstance(){
		if(singleton == null)
			singleton = new CommentFactory();
		return singleton;
	}
	public List<Comment> getComments() {
		// just for milestone2 (list of comments)
		ArrayList<Comment> list = new ArrayList<>();
		DateFormat df = new SimpleDateFormat("dd/MM/yy");

		int id = 0; // comment incremental id

		// pinco pallino comments
		User user = new User(); // only id, name, surname
		user.setId(1);
		user.setName("Pinco");
		user.setSurname("Pallino");
		Comment comment = new Comment();
		comment.setId(++id);
		comment.setNewsId(1);
		comment.setAuthor(user);
		try {
			comment.setDate(df.parse("1/2/18"));
		} catch (ParseException e) {
		}
		comment.setDesc("BELLO BELLO BELLO");
		list.add(comment);

		comment = new Comment();
		comment.setId(++id);
		comment.setNewsId(8);
		comment.setAuthor(user);
		try {
			comment.setDate(df.parse("3/3/18"));
		} catch (ParseException e) {
		}
		comment.setDesc("QuANtO CoStANo I PaLLONcInI!?????");
		list.add(comment);

		comment = new Comment();
		comment.setId(++id);
		comment.setNewsId(8);
		comment.setAuthor(user);
		try {
			comment.setDate(df.parse("4/4/18"));
		} catch (ParseException e) {
		}
		comment.setDesc("(breathing intensifies)");
		list.add(comment);

		// pinco pallone comments
		user = new User(); // only id, name, surname
		user.setId(2);
		user.setName("Pinco");
		user.setSurname("Pallone");
		comment = new Comment();
		comment.setId(++id);
		comment.setNewsId(8);
		comment.setAuthor(user);
		try {
			comment.setDate(df.parse("5/5/18"));
		} catch (ParseException e) {
		}
		comment.setDesc("DAJE CHE SE GIOKAAAA");
		list.add(comment);

		// sort the list by desc date
		Collections.sort(list, new Comparator<Comment>() {
			@Override
			public int compare(Comment a, Comment b)
			{
				return -a.getDate().compareTo(b.getDate());
			}
		});
		return list;
	}

	public List<Comment> getCommentsByNewsId(int newsId) {
		// just for milestone2 (list of comments)
		List<Comment> commentsList = this.getComments();
		ArrayList<Comment> outList = new ArrayList<>();
		for (Comment c : commentsList) {
			if (c.getNewsId() == newsId)
				outList.add(c);
		}
		return outList;
	}

}

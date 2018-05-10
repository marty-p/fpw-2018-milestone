/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	public Comment processRow(ResultSet res) throws SQLException {
		if (res==null)
			return null;
		User user = new User();
		user.setId(res.getInt("uid"));
		user.setName(res.getString("uName"));
		user.setSurname(res.getString("uSurname"));
		user.setImageUrl(res.getString("uImageUrl"));
		Comment comment = new Comment();
		comment.setId(res.getInt("id"));
		comment.setNewsId(res.getInt("newsId"));
		comment.setAuthor(user);
		comment.setDate(res.getDate("date"));
		comment.setDesc(res.getString("desc"));
		return comment;
	}

	public List<Comment> getComments() {
		ArrayList<Comment> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select `comments`.*, `users`.`id` as `uid`,"
					+" `users`.`name` as `uName`, `users`.`surname` as `uSurname`, `users`.`imageUrl` as `uImageUrl`"
					+ " from `comments`, `users` where `users`.`id` = `comments`.`authorId`"
					+ " order by `date` desc";
			stmt = conn.prepareStatement(query);

            res = stmt.executeQuery();
            while (res.next()) {
				list.add(processRow(res));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DbHelper.getInstance().close(conn, stmt, res);
		}

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

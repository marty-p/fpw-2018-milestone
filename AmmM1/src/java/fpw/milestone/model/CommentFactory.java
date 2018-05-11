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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
		ArrayList<Comment> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select `comments`.*, `users`.`id` as `uid`,"
					+" `users`.`name` as `uName`, `users`.`surname` as `uSurname`, `users`.`imageUrl` as `uImageUrl`"
					+ " from `comments`, `users` where `users`.`id` = `comments`.`authorId` and `comments`.`newsId` = ?"
					+ " order by `date` desc";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, newsId);

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

	public int insertCommentByNewsId(String comment, int newsId, int userId) {
		int success = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			conn = DbHelper.getInstance().connect();
			// prepare query
			stmt = conn.prepareStatement("INSERT INTO `comments`"
					+ " (`newsId`, `desc`, `date`, `authorId`)"
					+ " VALUES (?, ?, NOW(), ?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, newsId);
			stmt.setString(2, comment);
			stmt.setInt(3, userId);
            stmt.executeUpdate();
			// get the generated key
			res = stmt.getGeneratedKeys();
			if (res.next()) {
				success = res.getInt(1);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DbHelper.getInstance().close(conn, stmt, res);
		}
		return success;
	}
}

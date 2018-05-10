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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marty
 */
public class NewsFactory {
	private static NewsFactory singleton;
	public static NewsFactory getInstance(){
		if(singleton == null)
			singleton = new NewsFactory();
		return singleton;
	}

	public List<News> getNews() {
		ArrayList<News> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select `news`.*, `users`.`id` as `uid`, `users`.`name` as `uname`, `users`.`surname` as `usurname`"
					+ " from `news`, `users` where `users`.`id` = `news`.`authorId`"
					+ " ORDER BY `date` DESC";
			stmt = conn.prepareStatement(query);

            res = stmt.executeQuery();
            while (res.next()) {
				User user = new User();
				user.setId(res.getInt("uid"));
				user.setName(res.getString("uname"));
				user.setSurname(res.getString("usurname"));
				News news = new News();
				news.setId(res.getInt("id"));
				news.setAuthor(user);
				news.setDate(res.getDate("date"));
				news.setTitle(res.getString("title"));
				news.setDesc(res.getString("desc"));
				news.setImageUrl(res.getString("imageUrl"));
				news.setImageDesc(res.getString("imageDesc"));
				news.addCategory(res.getString("category"));
				list.add(news);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DbHelper.getInstance().close(conn, stmt, res);
		}

		return list;
	}

	public News getNewsById(int id) {
		// just for milestone2 (list of news)
		List<News> newsList = this.getNews();
		for (News n : newsList) {
			if (n.getId() == id)
				return n;
		}
		return null;
	}

	public List<News> getNewsByAuthor(User usr) {
		return getNewsByAuthor(usr.getId());
	}

	public List<News> getNewsByAuthor(int id) {
		// just for milestone2 (list of news)
		List<News> newsList = this.getNews();
		ArrayList<News> outList = new ArrayList<>();
		for (News n : newsList) {
			if (n.getAuthor().getId() == id)
				outList.add(n);
		}
		return outList;
	}

	public List<News> getNewsByCategory(int id) {
		return getNewsByCategory(fpw.milestone.model.News.Category.fromInteger(id));
	}

	public List<News> getNewsByCategory(fpw.milestone.model.News.Category c) {
		// just for milestone2 (list of news)
		List<News> newsList = this.getNews();
		ArrayList<News> outList = new ArrayList<>();
		for (News n : newsList) {
			if (n.getCategory().contains(c))
				outList.add(n);
		}
		return outList;
	}
}

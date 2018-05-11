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
import javax.servlet.http.HttpServletRequest;

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

	public News processRow(ResultSet res) throws SQLException {
		if (res==null)
			return null;
		User user = new User();
		user.setId(res.getInt("uid"));
		user.setName(res.getString("uName"));
		user.setSurname(res.getString("uSurname"));
		News news = new News();
		news.setId(res.getInt("id"));
		news.setAuthor(user);
		news.setDate(res.getDate("date"));
		news.setTitle(res.getString("title"));
		news.setDesc(res.getString("desc"));
		news.setImageUrl(res.getString("imageUrl"));
		news.setImageDesc(res.getString("imageDesc"));
		news.addCategory(res.getString("category"));
		return news;
	}

	public List<News> getNews() {
		ArrayList<News> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select `news`.*, `users`.`id` as `uid`, `users`.`name` as `uName`, `users`.`surname` as `uSurname`"
					+ " from `news`, `users` where `users`.`id` = `news`.`authorId`"
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

	public News getNewsById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select `news`.*, `users`.`id` as `uid`, `users`.`name` as `uName`, `users`.`surname` as `uSurname`"
					+ " from `news`, `users` where `users`.`id` = `news`.`authorId` and `news`.id = ?"
					+ " order by `date` desc";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);

            res = stmt.executeQuery();
            if (res.next()) {
				return processRow(res);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DbHelper.getInstance().close(conn, stmt, res);
		}

		return null;
	}

	public List<News> getNewsByAuthor(User usr) {
		return getNewsByAuthor(usr.getId());
	}

	public List<News> getNewsByAuthor(int id) {
		ArrayList<News> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select `news`.*, `users`.`id` as `uid`, `users`.`name` as `uName`, `users`.`surname` as `uSurname`"
					+ " from `news`, `users` where `users`.`id` = `news`.`authorId` and `news`.authorId = ?"
					+ " order by `date` desc";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);

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

	public List<News> getNewsByCategory(int id) {
		return getNewsByCategory(fpw.milestone.model.News.Category.fromInteger(id));
	}

	public List<News> getNewsByCategory(fpw.milestone.model.News.Category c) {
		ArrayList<News> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select `news`.*, `users`.`id` as `uid`, `users`.`name` as `uName`, `users`.`surname` as `uSurname`"
					+ " from `news`, `users` where `users`.`id` = `news`.`authorId` and FIND_IN_SET(?, `news`.category) > 0"
					+ " order by `date` desc";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, c.name());

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

	public String getCategoryFromRequest(HttpServletRequest request) {
		String fmtCategory = "";
		for (News.Category e : News.Category.getValues()) {
			if (request.getParameter(e.name())!=null) {
				String reqName = request.getParameter(e.name());
				if (!fmtCategory.isEmpty())
					fmtCategory += ",";
				if (!reqName.isEmpty())
					fmtCategory += reqName;
			}
		}
		return fmtCategory;
	}

	public int insertNewsByRequest(HttpServletRequest request, int authorId) {
		int success = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		// check if all the fields exist
		if (request.getParameter("title")==null
				|| request.getParameter("date")==null
				|| request.getParameter("imageUrl")==null
				|| request.getParameter("imageDesc")==null
				|| request.getParameter("desc")==null
		) {
			Logger.getLogger(NewsFactory.class.getName()).log(Level.SEVERE, "no valid arguments for updateNewsByRequest");
			return success;
		}

		try {
			conn = DbHelper.getInstance().connect();
			// prepare query
			stmt = conn.prepareStatement("INSERT INTO `news`(`title`, `desc`,"
					+ " `imageUrl`, `imageDesc`, `date`, `category`, `authorId`)"
					+ "  VALUES (?, ?, ?, ?, STR_TO_DATE(?, '%d/%m/%Y'), ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, request.getParameter("title").toString());
			stmt.setString(2, request.getParameter("desc").toString());
			stmt.setString(3, request.getParameter("imageUrl").toString());
			stmt.setString(4, request.getParameter("imageDesc").toString());
			stmt.setString(5, request.getParameter("date").toString());
			stmt.setString(6, getCategoryFromRequest(request));
			stmt.setInt(7, authorId);
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

	public boolean updateNewsByRequest(HttpServletRequest request, int id, int authorId) {
		boolean success = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		// check if all the fields exist
		if (request.getParameter("title")==null
				|| request.getParameter("date")==null
				|| request.getParameter("imageUrl")==null
				|| request.getParameter("imageDesc")==null
				|| request.getParameter("desc")==null
		) {
			Logger.getLogger(NewsFactory.class.getName()).log(Level.SEVERE, "no valid arguments for updateNewsByRequest");
			return false;
		}

		try {
			conn = DbHelper.getInstance().connect();
			// prepare query
			stmt = conn.prepareStatement("UPDATE `news`"
					+ " SET `title` = ?, `desc` = ?, `imageUrl` = ?,"
					+ " `imageDesc` = ?, `date` = STR_TO_DATE(?, '%d/%m/%Y'),"
					+ " `category` = ?"
					+ " WHERE `id` = ? and `authorId` = ?");
			stmt.setString(1, request.getParameter("title").toString());
			stmt.setString(2, request.getParameter("desc").toString());
			stmt.setString(3, request.getParameter("imageUrl").toString());
			stmt.setString(4, request.getParameter("imageDesc").toString());
			stmt.setString(5, request.getParameter("date").toString());
			stmt.setString(6, getCategoryFromRequest(request));
			stmt.setInt(7, id);
			stmt.setInt(8, authorId);
            stmt.executeUpdate();
			success = true;
		} catch (SQLException ex) {
			Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DbHelper.getInstance().close(conn, stmt, res);
		}
		return success;
	}

	public boolean deleteNewsById(int id, int authorId) {
		boolean success = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			stmt = conn.prepareStatement("delete from `news` where `id` = ? and `authorId` = ?");
			stmt.setInt(1, id);
			stmt.setInt(2, authorId);
			stmt.executeUpdate();
			success = true;
		} catch (SQLException ex) {
			Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DbHelper.getInstance().close(conn, stmt, res);
		}
		return success;
	}
}

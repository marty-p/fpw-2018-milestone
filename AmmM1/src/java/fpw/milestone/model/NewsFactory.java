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
	/**
	 *
	 * @return
	 */
	public static synchronized NewsFactory getInstance(){
		if (singleton == null)
			singleton = new NewsFactory();
		return singleton;
	}
	private static NewsFactory singleton;

	/**
	 *
	 * @param res
	 * @return
	 * @throws SQLException
	 */
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

	/**
	 *
	 * @return
	 */
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

	/**
	 *
	 * @param id
	 * @return
	 */
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

	/**
	 *
	 * @param usr
	 * @return
	 */
	public List<News> getNewsByAuthor(User usr) {
		return getNewsByAuthor(usr.getId());
	}

	/**
	 *
	 * @param id
	 * @return
	 */
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

	/**
	 *
	 * @param id
	 * @return
	 */
	public List<News> getNewsByCategory(int id) {
		return getNewsByCategory(fpw.milestone.model.News.Category.fromInteger(id));
	}

	/**
	 *
	 * @param c
	 * @return
	 */
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

	/**
	 *
	 * @param request
	 * @return
	 */
	public String getCategoryFromRequest(HttpServletRequest request) {
		StringBuilder fmtCategory = new StringBuilder();
		for (News.Category e : News.Category.getValues()) {
			if (request.getParameter(e.name())!=null) {
				String reqName = request.getParameter(e.name());
				if (fmtCategory.length()!=0)
					fmtCategory.append(",");
				if (!reqName.isEmpty())
					fmtCategory.append(reqName);
			}
		}
		return fmtCategory.toString();
	}

	/**
	 *
	 * @param request
	 * @param authorId
	 * @return
	 */
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
					+ "  VALUES (?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, request.getParameter("title"));
			stmt.setString(2, request.getParameter("desc"));
			stmt.setString(3, request.getParameter("imageUrl"));
			stmt.setString(4, request.getParameter("imageDesc"));
			stmt.setString(5, request.getParameter("date"));
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

	/**
	 *
	 * @param request
	 * @param id
	 * @param authorId
	 * @return
	 */
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
					+ " `imageDesc` = ?, `date` = ?,"
					+ " `category` = ?"
					+ " WHERE `id` = ? and `authorId` = ?");
			stmt.setString(1, request.getParameter("title"));
			stmt.setString(2, request.getParameter("desc"));
			stmt.setString(3, request.getParameter("imageUrl"));
			stmt.setString(4, request.getParameter("imageDesc"));
			stmt.setString(5, request.getParameter("date"));
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

	/**
	 *
	 * @param id
	 * @param authorId
	 * @return
	 */
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

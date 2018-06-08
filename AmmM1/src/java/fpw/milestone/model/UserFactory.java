/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Marty
 */
public class UserFactory {
	/**
	 *
	 * @return
	 */
	public static synchronized UserFactory getInstance() {
		if (singleton == null)
			singleton = new UserFactory();
		return singleton;
	}
	private static UserFactory singleton;

	/**
	 *
	 * @param res
	 * @return
	 * @throws SQLException
	 */
	public User processRow(ResultSet res) throws SQLException {
		if (res==null)
			return null;
		User user = new User();
		user.setId(res.getInt("id"));
		user.setName(res.getString("name"));
		user.setSurname(res.getString("surname"));
		user.setUsername(res.getString("username"));
		user.setPassword(res.getString("password"));
		user.setCategory(res.getString("category"));
		// extra fields
		user.setBirthDate(res.getDate("birthDate"));
		user.setIntroDesc(res.getString("introDesc"));
		user.setImageUrl(res.getString("imageUrl"));
		return user;
	}

	/**
	 *
	 * @return
	 */
	public List<User> getUsers() {
		ArrayList<User> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select * from `users`";
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
	public User getUserById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select * from `users` where `id` = ?";
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
	 * @param category
	 * @return
	 */
	public List<User> getUsersByCategory(User.Category category) {
		ArrayList<User> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select * from `users` where `category` = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, category.name());

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
	 * @param category
	 * @param q
	 * @return
	 */
	public List<User> getUsersByCategoryLike(User.Category category, String q) {
		ArrayList<User> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select * from `users` where `category` = ? and (`name` like ? or `surname` like ?)";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, category.name());
			stmt.setString(2, "%" + q + "%");
			stmt.setString(3, "%" + q + "%");

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
	 * @param id
	 * @return
	 */
	public boolean updateUserByRequest(HttpServletRequest request, int id) {
		boolean success = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		// check if all the fields exist
		if (request.getParameter("name")==null
				|| request.getParameter("surname")==null
				|| request.getParameter("password")==null
				|| request.getParameter("password2")==null
				|| request.getParameter("birthDate")==null
				|| request.getParameter("introDesc")==null
				|| request.getParameter("imageUrl")==null
		) {
			Logger.getLogger(NewsFactory.class.getName()).log(Level.SEVERE, "no valid arguments for updateUserByRequest");
			return false;
		}

		// password and password2 must be the same
		if (!request.getParameter("password").equals(request.getParameter("password2")))
			return false;

		try {
			conn = DbHelper.getInstance().connect();
			// delete all the comments by author id
			stmt = conn.prepareStatement("UPDATE `users`"
					+ " SET `name` = ?, `surname` = ?, `password` = ?,"
					+ "`birthDate` = ?, `introDesc` = ?, `imageUrl` = ?"
					+ " WHERE `id` = ?");
			stmt.setString(1, request.getParameter("name"));
			stmt.setString(2, request.getParameter("surname"));
			stmt.setString(3, request.getParameter("password"));
			stmt.setString(4, request.getParameter("birthDate"));
			stmt.setString(5, request.getParameter("introDesc"));
			stmt.setString(6, request.getParameter("imageUrl"));
			stmt.setInt(7, id);
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
	 * @return
	 */
	public boolean deleteUserById(int id) {
		boolean success = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			// start transation
			conn.setAutoCommit(false);
			// delete all the comments by author id
			stmt = conn.prepareStatement("delete from `comments` where `authorId` = ?");
			stmt.setInt(1, id);
            stmt.executeUpdate();
			// delete all the news by author id
			stmt = conn.prepareStatement("delete from `news` where `authorId` = ?");
			stmt.setInt(1, id);
            stmt.executeUpdate();
			// delete the author by id
			stmt = conn.prepareStatement("delete from `users` where `id` = ?");
			stmt.setInt(1, id);
            stmt.executeUpdate();
			// commit transation
			conn.commit();
			success = true;
		} catch (SQLException ex) {
			Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
			// rollback transation
			try { if (conn != null) conn.rollback(); } catch(SQLException ex2) {
				Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex2);
			}
		} finally {
			// rollback transation
			try { if (conn != null) conn.setAutoCommit(true); } catch(SQLException ex2) {
				Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex2);
			}
			DbHelper.getInstance().close(conn, stmt, res);
		}
		return success;
	}

	/**
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public User processLogin(String username, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			conn = DbHelper.getInstance().connect();
			String query = "select * from `users` where `username` = ? and `password` = ? and category <> 'GUEST'";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);

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
}

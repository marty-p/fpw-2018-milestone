/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Marty
 */
public class User {

	public User() {
		birthDate = new Date();
	}

	/**
	 * @return the introDesc
	 */
	public String getIntroDesc() {
		return introDesc;
	}

	/**
	 * @param introDesc the introDesc to set
	 */
	public void setIntroDesc(String introDesc) {
		this.introDesc = introDesc;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the date as dd/MM/yy
	 */
	public String getShortBirthDate() {
		return new SimpleDateFormat("dd/MM/yy").format(birthDate);
	}

	/**
	 * @return the date as yyyy-MM-dd
	 */
	public String getInputBirthDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(birthDate);
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 *
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = Category.valueOf(category);
	}

	public enum Category {
		AUTHOR, READER, GUEST;

		@Override
		public String toString() {
			return getName();
		}

		/**
		 *
		 * @return
		 */
		public String getName() {
			String n = name();
			return n.length() == 0 ? n : n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase();
		}

		// static cached way to convert int to enum
		private static final Category[] cachedValues = Category.values();

		/**
		 *
		 * @return
		 */
		static public Category[] getValues() {
			return cachedValues;
		}

		/**
		 *
		 * @param id
		 * @return
		 */
		static public Category fromInteger(int id) {
			return (id >= cachedValues.length) ? cachedValues[0] : cachedValues[id];
		}
	};
	private String name;
	private String surname;
	private String username;
	private String password;
	private int id;
	private Category category;
	private Date birthDate;
	private String introDesc;
	private String imageUrl;
}

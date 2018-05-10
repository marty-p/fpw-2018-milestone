/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.model;

import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.EnumSet;
import java.util.Set;

/**
 *
 * @author Marty
 */
public class News {

	public News() {
		date = new Date();
		category = EnumSet.noneOf(Category.class);
	}

	/**
	 * @return the category
	 */
	public Set<Category> getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(EnumSet<Category> category) {
		this.category = category;
	}

	/**
	 * @param category the category to set
	 */
	public void addCategory(Category category) {
		this.category.add(category);
	}

	/**
	 * @param category the category to set
	 */
	public void addCategory(String category) {
		for (String elem : category.split(","))
			this.category.add(Category.valueOf(elem.trim()));
	}

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(User author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @return the first 100 characters of desc
	 */
	public String getShortDesc() {
		return desc.substring(0, Math.min(desc.length(), 100));
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
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
	 * @return the imageDesc
	 */
	public String getImageDesc() {
		return imageDesc;
	}

	/**
	 * @param imageDesc the imageDesc to set
	 */
	public void setImageDesc(String imageDesc) {
		this.imageDesc = imageDesc;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the date as dd/MM/yy
	 */
	public String getShortDate() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		return df.format(date);
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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

	public enum Category {
		POLITICA, CRONACA, ESTERI, ECONOMIA, SPORT, CULTURA;

		@Override
		public String toString() {
			String n = name();
			return n.length() == 0 ? n : n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase();
		}

		// static cached way to convert int to enum
		static Category[] cValues = null;
		static public Category fromInteger(int id) {
			// cache values once
			if (cValues == null) {
				cValues = Category.values();
			}
			// check out of bound
			if (id >= cValues.length)
				return cValues[0];
			// return the cached elem by id
			return cValues[id];
		}
	};
	public boolean getHasPolitica() {
		return category.contains(Category.POLITICA);
	}
	public boolean getHasCronaca() {
		return category.contains(Category.CRONACA);
	}
	public boolean getHasEsteri() {
		return category.contains(Category.ESTERI);
	}
	public boolean getHasEconomia() {
		return category.contains(Category.ECONOMIA);
	}
	public boolean getHasSport() {
		return category.contains(Category.SPORT);
	}
	public boolean getHasCultura() {
		return category.contains(Category.CULTURA);
	}

	private EnumSet<Category> category; // it can have multiple values
	private String title;
	private String desc;
	private String imageUrl;
	private String imageDesc;
	private Date date;
	private User author;
	private int id;
}

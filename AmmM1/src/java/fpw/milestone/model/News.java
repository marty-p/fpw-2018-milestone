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
public class News {

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

	public enum Category { POLITICA, CRONACA, ESTERI, ECONOMIA, SPORT, CULTURA };
	private Category category;
	private String title;
	private String desc;
	private String imageUrl;
	private String imageDesc;
	private Date date;
	private User author;
	private int id;
}

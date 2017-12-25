package com.bananealcanws.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "gift")
public class Gift implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String wishListId;
	private String name;
	private String detail;
	private String price;
	private String notes;

	/**
	 * @return the id
	 */
	public synchronized String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public synchronized void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the wishListId
	 */
	public synchronized String getWishListId() {
		return wishListId;
	}

	/**
	 * @param wishListId
	 *            the wishListId to set
	 */
	public synchronized void setWishListId(String wishListId) {
		this.wishListId = wishListId;
	}

	/**
	 * @return the name
	 */
	public synchronized String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public synchronized void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the detail
	 */
	public synchronized String getDetail() {
		return detail;
	}

	/**
	 * @param detail
	 *            the detail to set
	 */
	public synchronized void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * @return the price
	 */
	public synchronized String getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public synchronized void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the notes
	 */
	public synchronized String getNotes() {
		return notes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public synchronized void setNotes(String notes) {
		this.notes = notes;
	}
}

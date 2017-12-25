package com.bananealcanws.model;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WishList implements Serializable {

	private static final long serialVersionUID = -4442215095283251477L;
	private String id;
	private String memberId;
	private String categoryId;
	private String name;
	private String detail;
	private Date creationDate;
	private Date lastUpdateDate;
	private String publicUrl;

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
	 * @return the memberId
	 */
	public synchronized String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId
	 *            the memberId to set
	 */
	public synchronized void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the categoryId
	 */
	public synchronized String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public synchronized void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
	 * @return the creationDate
	 */
	public synchronized Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public synchronized void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public synchronized Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate
	 *            the lastUpdateDate to set
	 */
	public synchronized void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the publicUrl
	 */
	public synchronized String getPublicUrl() {
		return publicUrl;
	}

	/**
	 * @param publicUrl
	 *            the publicUrl to set
	 */
	public synchronized void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}
}

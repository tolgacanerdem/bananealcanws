package com.bananealcanws.model;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ImportantDate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String memberId;
	private String dateName;
	private String dateDescription;
	private Date importantDate;

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
	 * @return the dateName
	 */
	public synchronized String getDateName() {
		return dateName;
	}

	/**
	 * @param dateName
	 *            the dateName to set
	 */
	public synchronized void setDateName(String dateName) {
		this.dateName = dateName;
	}

	/**
	 * @return the dateDescription
	 */
	public synchronized String getDateDescription() {
		return dateDescription;
	}

	/**
	 * @param dateDescription
	 *            the dateDescription to set
	 */
	public synchronized void setDateDescription(String dateDescription) {
		this.dateDescription = dateDescription;
	}

	/**
	 * @return the importantDate
	 */
	public synchronized Date getImportantDate() {
		return importantDate;
	}

	/**
	 * @param importantDate
	 *            the importantDate to set
	 */
	public synchronized void setImportantDate(Date importantDate) {
		this.importantDate = importantDate;
	}
}

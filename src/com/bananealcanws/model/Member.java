package com.bananealcanws.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "member")
public class Member implements Serializable {

	private static final long serialVersionUID = -6218331417263723568L;
	private String id;
	private String name;
	private String surname;
	private String username;
	private String mail;
	private String password;
	private Map<String, Date> importantDates;
	private String profileImage;
	private boolean isActive;

	public Member() {

	}

	public Member(String id, String name, String surname, String username, String mail, String password) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.mail = mail;
		this.password = password;
	}

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
	@XmlElement
	public synchronized void setId(String id) {
		this.id = id;
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
	@XmlElement
	public synchronized void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public synchronized String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	@XmlElement
	public synchronized void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the username
	 */
	public synchronized String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	@XmlElement
	public synchronized void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the mail
	 */
	public synchronized String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	@XmlElement
	public synchronized void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public synchronized String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	@XmlElement
	public synchronized void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the importantDates
	 */
	public synchronized Map<String, Date> getImportantDates() {
		return importantDates;
	}

	/**
	 * @param importantDates
	 *            the importantDates to set
	 */
	@XmlElement
	public synchronized void setImportantDates(Map<String, Date> importantDates) {
		this.importantDates = importantDates;
	}

	/**
	 * @return the profileImage
	 */
	public synchronized String getProfileImage() {
		return profileImage;
	}

	/**
	 * @param profileImage
	 *            the profileImage to set
	 */
	@XmlElement
	public synchronized void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	/**
	 * @return the isActive
	 */
	public synchronized boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	@XmlElement
	public synchronized void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}

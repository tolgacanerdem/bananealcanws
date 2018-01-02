package com.bananealcanws.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FriendRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String fromMember;
	private String toMember;
	private String status;

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
	 * @return the fromMember
	 */
	public synchronized String getFromMember() {
		return fromMember;
	}

	/**
	 * @param fromMember
	 *            the fromMember to set
	 */
	public synchronized void setFromMember(String fromMember) {
		this.fromMember = fromMember;
	}

	/**
	 * @return the toMember
	 */
	public synchronized String getToMember() {
		return toMember;
	}

	/**
	 * @param toMember
	 *            the toMember to set
	 */
	public synchronized void setToMember(String toMember) {
		this.toMember = toMember;
	}

	/**
	 * @return the status
	 */
	public synchronized String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public synchronized void setStatus(String status) {
		this.status = status;
	}
}

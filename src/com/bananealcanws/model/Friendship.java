package com.bananealcanws.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Friendship implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4455110929430329209L;

	private String id;
	private String memberId;
	private String friendId;

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
	 * @return the friendId
	 */
	public synchronized String getFriendId() {
		return friendId;
	}

	/**
	 * @param friendId
	 *            the friendId to set
	 */
	public synchronized void setFriendId(String friendId) {
		this.friendId = friendId;
	}
}

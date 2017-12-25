package com.bananealcanws.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Category implements Serializable {

	private static final long serialVersionUID = -9165116977475919703L;
	private String id;
	private String name;

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
}

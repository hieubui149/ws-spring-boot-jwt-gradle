package com.cjo.starter.auth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tomas
 * @date Apr 20, 2019
 *
 */
@Entity
@Table(name = "TB_AUTHORITY")
public class Authority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8834015191047570574L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "SHORT_NAME", nullable = false)
	private String shortName;
	
	public Authority() {
		
	}
	
	public Authority(final String name, final String shortName) {
		this.name = name;
		this.shortName = shortName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
}

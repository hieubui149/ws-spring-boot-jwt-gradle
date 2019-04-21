package com.cjo.starter.auth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_USER_ROLE")
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7558959590688859065L;

	@Id
	private int userId;

	@Column(name="role", nullable=false)
	private String roleName;
	
	@OneToOne(fetch=FetchType.LAZY)
	@MapsId
	private User user;
	
	public UserRole() {
		
	}
	
	public UserRole(final String roleName) {
		this.roleName = roleName;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}

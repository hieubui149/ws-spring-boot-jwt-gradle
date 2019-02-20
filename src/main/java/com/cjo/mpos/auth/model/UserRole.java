package com.cjo.mpos.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_USER_ROLE")
public class UserRole {

	private int userId;
	private String roleName;
	private User user;
	
	public UserRole() {
		
	}
	
	public UserRole(final String roleName) {
		this.roleName = roleName;
	}

	@Id
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@MapsId
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="role", nullable=false)
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}

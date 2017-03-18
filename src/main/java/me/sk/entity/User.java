package me.sk.entity;
// Generated 2017-3-8 11:21:02 by Hibernate Tools 5.2.0.Beta1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "demo")
public class User implements java.io.Serializable {

	private int userId;
	private String userName;
	private String password;
	private Set<Role> roleses = new HashSet<Role>(0);

	public User() {
	}

	public User(int userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public User(int userId, String userName, String password, Set<Role> roleses) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roleses = roleses;
	}

	@Id

	@Column(name = "userId", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "userName", nullable = false, length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", catalog = "demo", joinColumns = {
			@JoinColumn(name = "userId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "roleId", nullable = false, updatable = false) })
	public Set<Role> getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set<Role> roleses) {
		this.roleses = roleses;
	}

}
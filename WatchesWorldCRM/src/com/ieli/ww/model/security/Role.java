package com.ieli.ww.model.security;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer roleId;
	private String role;
	private List<Permission> permissions;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "role_id", unique = true, nullable = false)
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roles_permissions", joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "role_id") }, inverseJoinColumns = {
					@JoinColumn(name = "permission_id", referencedColumnName = "permission_id") })
	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

}
package com.ieli.ww.model.security;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permissions")
public class Permission implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer permissionId;
	private String permission;

	public Permission() {

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "permission_id", unique = true, nullable = false)
	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	@Column(name = "permission")
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}

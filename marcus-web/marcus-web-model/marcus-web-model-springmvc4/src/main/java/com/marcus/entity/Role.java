package com.marcus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.marcus.entity.Base.BaseObject;

@Entity
@Table(name = "CORE_ROLE")
public class Role extends BaseObject implements java.io.Serializable {

	private String id;

	private String name;

	private String code;

	private String description;

	private java.util.Set<com.marcus.entity.User> users;

	private java.util.Set<com.marcus.entity.Function> functions;

	public Role() {

	}

	public Role(String id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID", length = 32, nullable = false, unique = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CODE", length = 50)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "DESCRIPTION", length = 250)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(mappedBy = "roles")
	public java.util.Set<com.marcus.entity.User> getUsers() {
		return users;
	}

	public void setUsers(java.util.Set<com.marcus.entity.User> users) {
		this.users = users;
	}

	@ManyToMany
	@JoinTable(name = "CORE_ROLE_FUNCTION", joinColumns = @JoinColumn(name = "ROLE_ID") , inverseJoinColumns = @JoinColumn(name = "FUNCTION_ID") )
	public java.util.Set<com.marcus.entity.Function> getFunctions() {
		return functions;
	}

	public void setFunctions(java.util.Set<com.marcus.entity.Function> functions) {
		this.functions = functions;
	}
}

package com.marcus.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.marcus.entity.Base.BaseObject;

@Entity
@Table( name = "CORE_FUNCTION")
public class Function extends BaseObject implements java.io.Serializable{
	
	private String id;
	
	private String name;
	
	private String url;
	
	private String funcs;
	
	private String description;
	
	private Integer priority;
	
	private Boolean menu;
	
	private Function parent;
	
	private Set<Function> child;
	
	private Set<Role> roles;
	
	public Function() {
		
	}
	
	public Function(String id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "FUNCTION_ID", length = 32, nullable = false, unique = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "NAME", length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "URL", length = 200)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "FUNCS", length = 2000)
	public String getFuncs() {
		return funcs;
	}

	public void setFuncs(String funcs) {
		this.funcs = funcs;
	}

	@Column(name = "DESCRIPTION", length = 250)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "PRIORITY")
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	@Column(name = "IS_MENU")
	public Boolean getMenu() {
		return menu;
	}

	public void setMenu(Boolean menu) {
		this.menu = menu;
	}

	@ManyToOne
	public Function getParent() {
		return parent;
	}

	public void setParent(Function parent) {
		this.parent = parent;
	}

	public Set<Function> getChild() {
		return child;
	}

	public void setChild(Set<Function> child) {
		this.child = child;
	}
	
	@ManyToMany(mappedBy = "functions")
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	

}

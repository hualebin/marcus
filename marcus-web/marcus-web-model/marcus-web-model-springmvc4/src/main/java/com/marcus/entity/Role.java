package com.marcus.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.marcus.entity.Base.BaseObject;

@Entity
@Table( name = "CORE_ROLE")
public class Role extends BaseObject implements java.io.Serializable{
	
	private String id;
	
	private String name;
	
	private String code;
	
	private String description;
	
	private java.util.Set<com.marcus.entity.User> users;
	private java.util.Set<com.marcus.entity.Function> functions;
}

package com.marcus.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.marcus.entity.Base.BaseObject;

@Entity
@Table( name = "CORE_ORG")
public class Organization extends BaseObject implements java.io.Serializable{
	private java.lang.String id;

	private java.lang.String code;
	private java.lang.String name;
	private java.lang.String parentId;
	private java.lang.String description;
	private com.marcus.entity.Organization parent;
	private java.util.Set<com.marcus.entity.Organization> child;
}

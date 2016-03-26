package com.marcus.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.marcus.entity.Base.BaseObject;

@Entity
@Table( name = "CORE_USER")
public class User extends BaseObject implements java.io.Serializable{
	
	private String id;
	
	private Organization organization;
	
	private String loginName;
	
	private String realName;
	
	private String password;
	
	private String email;
	
	private Boolean sex;
	
	private String mobile;
	
	private String qq;
	
	private String job;
	
	private String unitTel;
	
	private String unitFax;
	
	private String major;
	
	private String address;
	
	private String dept;
	
	private Date createTime;
	
	private Date lastLoginTime;
	
	private String lastLoginIp;
	
	private Date currentLoginTime;
	
	private String currentLoginIp;
	
	private Long loginCount;
	
	private Boolean disabled;
	
	private java.util.Set<com.marcus.entity.Role> roles;
	
	public User() {
		
	}
	
	public User(String id) {
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
	
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getUnitTel() {
		return unitTel;
	}

	public void setUnitTel(String unitTel) {
		this.unitTel = unitTel;
	}

	public String getUnitFax() {
		return unitFax;
	}

	public void setUnitFax(String unitFax) {
		this.unitFax = unitFax;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getCurrentLoginTime() {
		return currentLoginTime;
	}

	public void setCurrentLoginTime(Date currentLoginTime) {
		this.currentLoginTime = currentLoginTime;
	}

	public String getCurrentLoginIp() {
		return currentLoginIp;
	}

	public void setCurrentLoginIp(String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}

	public Long getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Long loginCount) {
		this.loginCount = loginCount;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public java.util.Set<com.marcus.entity.Role> getRoles() {
		return roles;
	}

	public void setRoles(java.util.Set<com.marcus.entity.Role> roles) {
		this.roles = roles;
	}

}

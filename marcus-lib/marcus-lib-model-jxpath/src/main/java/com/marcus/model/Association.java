package com.marcus.model;

import org.apache.commons.jxpath.JXPathContext;

public class Association {
	
	private Company company;
	

	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Association association = new Association();
		//实例化Company类
		Company company = new Company();
		company.setId(1);
		company.setName("vivianj组织");
		company.setAddress("www.vivianj.org");
		//设置Association对象的company属性
		association.setCompany(company);
		JXPathContext context = JXPathContext.newContext(association);
		
		context.setLenient(true);
		String name = (String) context.getValue("company/name");
		System.out.println(name);
	}

}

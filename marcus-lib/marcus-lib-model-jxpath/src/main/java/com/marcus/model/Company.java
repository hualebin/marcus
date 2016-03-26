package com.marcus.model;

import java.util.Comparator;

import org.apache.commons.jxpath.JXPathContext;

public class Company implements Comparator{
	
	private String name = "";
	private int id = 0;
	private String address = "";
	public void setName(String p_name){
	this.name = p_name;
	}
	public void setId(int p_id){
	this.id = p_id;
	}
	public void setAddress(String p_address){
	this.address = p_address;
	}
	public String getName(){
	return this.name;
	}
	public int getId(){
	return this.id;
	}
	public String getAddress(){
	return this.address;
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Company){
			Company company = (Company) obj;
			if (company.getId()==this.id
					&& company.getName().equals(this.getName())
					&& company.getAddress().equals(this.getAddress())){
					result = true;
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		Company company = new Company();
		company.setAddress("china");
		company.setId(123456);
		company.setName("marcus");
		JXPathContext context = JXPathContext.newContext(company);
		context.setLenient(true);
		String address = (String) context.getValue("address");
		int id = (int) context.getValue("id");
		String name = (String) context.getValue("name");
		context.getValue("test");
		
		System.out.println("address:" + address + " id:" + id + " name:" + name);
		
	}

}

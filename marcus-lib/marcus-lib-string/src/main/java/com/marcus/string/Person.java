package com.marcus.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * equals和hashcode方法简单的作用
 * @author Administrator
 *
 */
public class Person {
	private int id;
	private String name;
	private boolean sex;
	private Double money;
	private int age;
	  
	public Person(){
		
	}
	
	public Person(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (sex ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", sex=" + sex + ", money=" + money + ", age=" + age + "]";
	}
	
	public static void main(String args[]){
		Person person = new Person();
		person.setId(123456);
		person.setAge(19);
		person.setName("hua");
		person.setMoney(5000.23);
		person.setSex(true);
		
		Person p1 = new Person();
		p1.setId(123456);
		p1.setAge(19);
		p1.setName("hua");
		p1.setMoney(5000.23);
		p1.setSex(true);
		if(p1.equals(person)){
			System.out.println("p1 == person");
		}
		Map<Object, Object> map = new LinkedHashMap<Object, Object>();
		map.put(person, "person");
		map.put(p1, "p1");
		System.out.println(map.toString());
		Set<Person> set = new HashSet<Person>();
		set.add(person);
		set.add(p1);
		System.out.println(set.toString());
		Set<Person> set1 = new LinkedHashSet<Person>();
		set1.add(person);
		set1.add(p1);
		System.out.println(set1.toString());
	}
	

}

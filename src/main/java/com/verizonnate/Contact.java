package com.verizonnate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

	private Integer id;
	private String name;
	private String mtn;
	private String relationship;
	private Integer age;
	private String address;

	

	public Contact() {

	}

	public Contact(Integer id, String name, String mtn, String relationship, Integer age, String address) {

		this.id = id;
		this.name = name;
		this.mtn = mtn;
		this.relationship = relationship;
		this.age = age;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMtn() {
		return mtn;
	}

	public void setMtn(String mtn) {
		this.mtn = mtn;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

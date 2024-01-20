package com.core.classes;

public class Cricketer {
	private String name;
	private int age;
	private String email_id;
	private String Phone;
	private StarRating rating;
	public Cricketer(String name, int age, String email_id, String phone, StarRating rating) {
		super();
		this.name = name;
		this.age = age;
		this.email_id = email_id;
		this.Phone = phone;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Cricketer [name=" + name + ", age=" + age + ", email_id=" + email_id + ", Phone=" + Phone + ", rating="
				+ rating + "]";
	}
	public StarRating getRating() {
		return rating;
	}
	public void setRating(StarRating rating) {
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmail_id() {
		return email_id;
	}
	public String getPhone() {
		return Phone;
	}
	
}

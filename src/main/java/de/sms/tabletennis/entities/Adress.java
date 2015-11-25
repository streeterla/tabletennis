package de.sms.tabletennis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adress {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String street;
	private int postalCode;
	private String city;
	
	public Adress() {}
	
	public Adress(String street, int postalCode, String city) {
		super();
		this.street = street;
		this.postalCode = postalCode;
		this.setCity(city);
	}
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return street + " " + postalCode + " " + city;
	}
}

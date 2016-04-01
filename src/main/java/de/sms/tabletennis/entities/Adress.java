package de.sms.tabletennis.entities;

import de.sms.tabletennis.entities.id.AdressID;

import javax.persistence.*;

@Entity
@IdClass(AdressID.class)
public class Adress {

	@Id
	private String street;
	@Id
	private int postalCode;
	@Id
	private String city;
	
	public Adress() {}
	
	public Adress(String street, int postalCode, String city) {
		super();
		this.street = street;
		this.postalCode = postalCode;
		this.setCity(city);
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

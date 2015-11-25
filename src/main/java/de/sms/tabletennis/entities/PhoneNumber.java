package de.sms.tabletennis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PhoneNumber {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private PhoneType phoneType;
	private String number;
	
	public PhoneNumber() {}
	
	public PhoneNumber(PhoneType phoneType, String number) {
		super();
		this.phoneType = phoneType;
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return phoneType.name() + ": " + number;
	}
}

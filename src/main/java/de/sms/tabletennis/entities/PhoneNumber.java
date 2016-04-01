package de.sms.tabletennis.entities;

import javax.persistence.*;

@Entity
public class PhoneNumber {
	
	@Enumerated(EnumType.STRING)
	private PhoneType phoneType;
	@Id
	private String number;
	
	public PhoneNumber() {}
	
	public PhoneNumber(PhoneType phoneType, String number) {
		super();
		this.phoneType = phoneType;
		this.number = number;
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

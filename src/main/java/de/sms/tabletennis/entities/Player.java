package de.sms.tabletennis.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Player {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Adress adress;
	private String firstName;
	private String lastName;
	@OneToOne(cascade = CascadeType.ALL)
	private PhoneNumber privatePhone;
	@OneToOne(cascade = CascadeType.ALL)
	private PhoneNumber mobilePhone;
	@OneToOne(cascade = CascadeType.ALL)
	private PhoneNumber businessPhone;
	@OneToOne(cascade = CascadeType.ALL)
	private Email privateEmail;
	@OneToOne(cascade = CascadeType.ALL)
	private Email businessEmail;
	private Date birthday;
	
	public Player() {}
	
	public Player(Adress adress, String firstName, String lastName, PhoneNumber privatePhone, PhoneNumber mobilePhone, PhoneNumber businessPhone,
			Email privateEmail, Email businessEmail, Date birthday) {
		super();
		this.adress = adress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.privatePhone = privatePhone;
		this.mobilePhone = mobilePhone;
		this.businessPhone = businessPhone;
		this.privateEmail = privateEmail;
		this.businessEmail = businessEmail;
		this.birthday = birthday;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public PhoneNumber getPrivatePhone() {
		return privatePhone;
	}

	public void setPrivatePhone(PhoneNumber privatePhone) {
		this.privatePhone = privatePhone;
	}

	public PhoneNumber getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(PhoneNumber mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public PhoneNumber getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(PhoneNumber businessPhone) {
		this.businessPhone = businessPhone;
	}

	public Email getPrivateEmail() {
		return privateEmail;
	}

	public void setPrivateEmail(Email privateEmail) {
		this.privateEmail = privateEmail;
	}

	public Email getBusinessEmail() {
		return businessEmail;
	}

	public void setBusinessEmail(Email businessEmail) {
		this.businessEmail = businessEmail;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}

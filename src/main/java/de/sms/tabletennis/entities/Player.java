package de.sms.tabletennis.entities;

import de.sms.tabletennis.entities.id.PlayerID;

import java.util.Date;

import javax.persistence.*;


@Entity
@IdClass(PlayerID.class)
public class Player {

    @ManyToOne(cascade = CascadeType.ALL)
    private Adress adress;
	@Id
	private String firstName;
	@Id
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
	@Id
	private int position;

	public Player() {}

	public Player(Adress adress, String firstName, String lastName, PhoneNumber privatePhone, PhoneNumber mobilePhone, PhoneNumber businessPhone,
			Email privateEmail, Email businessEmail, Date birthday, int position) {
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
		this.position = position;
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}

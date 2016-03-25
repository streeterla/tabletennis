package de.sms.tabletennis.entities;

import javax.persistence.*;

@Entity
public class Email {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	@Enumerated(EnumType.STRING)
    private EmailType emailType;
    private String email;
    
    public Email() {}
    
	public Email(EmailType emailType, String email) {
		super();
		this.emailType = emailType;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EmailType getEmailType() {
		return emailType;
	}

	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return emailType.name() + ": " + email;
	}
}

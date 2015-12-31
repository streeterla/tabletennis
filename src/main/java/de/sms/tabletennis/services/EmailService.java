package de.sms.tabletennis.services;

import de.sms.tabletennis.entities.Email;

public interface EmailService extends EntityService<Email> {

	/**
	 * validates an email
	 * 
	 * @param email to validate
	 * @return true if email is valid
	 */
	public boolean validate(Email email);
	
	/**
	 * gets all emails as a list
	 * 
	 * @return all emails separated by a semicolon
	 */
	public String getAllEmails();
}

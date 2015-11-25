package de.sms.tabletennis.services;

import de.sms.tabletennis.entities.Email;

public interface EmailService extends EntityService<Email> {

	public boolean validate(Email email);
}

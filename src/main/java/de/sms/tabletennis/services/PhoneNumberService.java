package de.sms.tabletennis.services;

import de.sms.tabletennis.entities.PhoneNumber;

public interface PhoneNumberService extends EntityService<PhoneNumber> {

	public boolean validate(PhoneNumber phoneNumber);
}

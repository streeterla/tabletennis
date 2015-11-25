package de.sms.tabletennis.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.sms.tabletennis.entities.PhoneNumber;
import de.sms.tabletennis.entities.PhoneType;

public interface PhoneNumberDAO extends CrudRepository<PhoneNumber, Long> {
	
	public List<PhoneNumber> findAll();
	
	public Iterable<PhoneNumber> findByNumberAndPhoneType(String number, PhoneType phoneType);
}

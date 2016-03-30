package de.sms.tabletennis.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.sms.tabletennis.entities.PhoneNumber;
import de.sms.tabletennis.entities.PhoneType;

public interface PhoneNumberDAO extends CrudRepository<PhoneNumber, Long> {
	
	List<PhoneNumber> findAll();
	
	Iterable<PhoneNumber> findByNumberAndPhoneType(String number, PhoneType phoneType);
}

package de.sms.tabletennis.daos;

import de.sms.tabletennis.entities.PhoneNumber;
import de.sms.tabletennis.entities.PhoneType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneNumberDAO extends CrudRepository<PhoneNumber, String> {
	
	List<PhoneNumber> findAll();
	
	Iterable<PhoneNumber> findByNumberAndPhoneType(String number, PhoneType phoneType);
}

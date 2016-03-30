package de.sms.tabletennis.daos;

import org.springframework.data.repository.CrudRepository;

import de.sms.tabletennis.entities.Email;
import de.sms.tabletennis.entities.EmailType;

public interface EmailDAO extends CrudRepository<Email, Long> {

	Iterable<Email> findAll();
	
	Iterable<Email> findByEmailAndEmailType(String email, EmailType emailType);
}

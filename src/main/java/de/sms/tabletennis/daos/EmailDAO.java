package de.sms.tabletennis.daos;

import de.sms.tabletennis.entities.Email;
import de.sms.tabletennis.entities.EmailType;
import org.springframework.data.repository.CrudRepository;

public interface EmailDAO extends CrudRepository<Email, String> {

	Iterable<Email> findAll();
	
	Iterable<Email> findByEmailAndEmailType(String email, EmailType emailType);
}

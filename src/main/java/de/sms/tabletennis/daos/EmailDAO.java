package de.sms.tabletennis.daos;

import org.springframework.data.repository.CrudRepository;

import de.sms.tabletennis.entities.Email;
import de.sms.tabletennis.entities.EmailType;

public interface EmailDAO extends CrudRepository<Email, Long> {

	public Iterable<Email> findAll();
	
	public Iterable<Email> findByEmailAndEmailType(String email, EmailType emailType);
}

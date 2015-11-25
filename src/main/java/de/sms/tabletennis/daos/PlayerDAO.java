package de.sms.tabletennis.daos;

import org.springframework.data.repository.CrudRepository;

import de.sms.tabletennis.entities.Player;

public interface PlayerDAO extends CrudRepository<Player, Long> {
	
	public Iterable<Player> findAll();
	
	public Iterable<Player> findByFirstNameAndLastName(String firstName, String lastName);
}

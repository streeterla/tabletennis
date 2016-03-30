package de.sms.tabletennis.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.sms.tabletennis.entities.Player;

@RepositoryRestResource(path = "player")
public interface PlayerDAO extends CrudRepository<Player, Long> {
	
	Iterable<Player> findAll();
	
	Iterable<Player> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	Iterable<Player> findByFirstName(@Param("firstName") String firstName);
}

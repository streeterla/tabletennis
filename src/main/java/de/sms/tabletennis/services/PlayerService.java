package de.sms.tabletennis.services;

import de.sms.tabletennis.entities.Player;

public interface PlayerService extends EntityService<Player>{

	Iterable<Player> findByFirstNameAndLastName(String firstName, String lastName);

}

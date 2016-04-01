package de.sms.tabletennis.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sms.tabletennis.daos.PlayerDAO;
import de.sms.tabletennis.entities.Player;
import de.sms.tabletennis.services.PlayerService;

import java.util.Iterator;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Autowired	
	private PlayerDAO playerDAO;
	
	@Override
	public void save(Player player) {
		Iterator<Player>  iter = findByFirstNameAndLastName(player.getFirstName(), player.getLastName()).iterator();
		if(iter.hasNext()) {
			Player oldPlayer = iter.next();
			playerDAO.delete(oldPlayer);
		}
		playerDAO.save(player);
	}
	
	@Override
	public Iterable<Player> findAll() {
		return playerDAO.findAll();
	}
	
	@Override
	public Iterable<Player> findByFirstNameAndLastName(String firstName, String lastName) {
		return playerDAO.findByFirstNameAndLastName(firstName, lastName);
	}
	
	@Override
	public Iterable<Player> findByFirstName(String firstName) {
		return playerDAO.findByFirstName(firstName);
	}

}

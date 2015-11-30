package de.sms.tabletennis.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.sms.tabletennis.entities.Player;
import de.sms.tabletennis.services.PlayerService;

@RestController
public class AllEndpoint {
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("/all")
	public Iterable<Player> sync() {
		return playerService.findAll();
	}
	
}

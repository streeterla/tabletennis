package de.sms.tabletennis.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.sms.tabletennis.entities.Player;
import de.sms.tabletennis.excel.ExcelImporter;
import de.sms.tabletennis.services.PlayerService;

@RestController
public class SyncEndpoint {
	
	@Autowired
	private ExcelImporter excelImporter;
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("/sync")
	public Iterable<Player> sync() {
		excelImporter.fullImport();
		return playerService.findAll();
	}
}

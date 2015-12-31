package de.sms.tabletennis.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.sms.tabletennis.services.EmailService;

@RestController
public class EmailEndpoint {

	@Autowired
	EmailService emailService;
	
	@RequestMapping("/emaillist")
	public String emailList() {
		return "[{\"one\":\"" + emailService.getAllEmails() + "\"}]";
	}
}

package de.sms.tabletennis.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.sms.tabletennis.services.EmailService;

/**
 * endpoint to return all emails available in the system
 * 
 * @author streeter
 *
 */
@RestController
public class EmailEndpoint {

	@Autowired
    private EmailService emailService;
	
	@RequestMapping("/emaillist")
	public String emailList() {
		return "[{\"one\":\"" + emailService.getAllEmails() + "\"}]";
	}
}

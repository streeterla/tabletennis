package de.sms.tabletennis.endpoints;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * endpoint to authenticate on the frontend
 * 
 * @author streeter
 *
 */
@RestController
public class AuthenticationEndpoint {
	
	Logger LOG = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
//		LOG.info("Logged in user: " + user.getName());
		return user;
	}
}

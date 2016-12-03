package de.sms.tabletennis.controller;

import java.util.Collection;
import java.util.Collections;

import de.sms.tabletennis.entities.Account;
import de.sms.tabletennis.services.AccountService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AccountService accountService;
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Override
	public UserDetails loadUserByUsername(String usernameByLogin) throws UsernameNotFoundException {
		LOG.info("Try to find user: " + usernameByLogin);
		Account account = accountService.findByUsername(usernameByLogin).iterator().next();
		String persistedUsername = account.getUsername();
		String persistedPassword = account.getPassword();
		if (StringUtils.isEmpty(persistedUsername)) {
			throw new UsernameNotFoundException("Username " + persistedUsername + " not found");
		}
		LOG.info("Logged in user: " + persistedUsername);
		return new User(persistedUsername, persistedPassword, getGrantedAuthorities());
	}
	
	private Collection<? extends GrantedAuthority> getGrantedAuthorities() {
		GrantedAuthority auth = new GrantedAuthority() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return "ROLE_BASIC";
			}
		};
		return Collections.singletonList(auth);
	}
}
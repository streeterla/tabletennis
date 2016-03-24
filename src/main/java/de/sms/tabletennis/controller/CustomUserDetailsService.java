package de.sms.tabletennis.controller;

import java.util.Collection;
import java.util.Collections;

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

import de.sms.tabletennis.entities.Player;
import de.sms.tabletennis.services.PlayerService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private PlayerService playerService;
	
	final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Override
	public UserDetails loadUserByUsername(String usernameByLogin) throws UsernameNotFoundException {
		Player player = playerService.findByFirstName(usernameByLogin).iterator().next();
		String persistedUsername = player.getFirstName() + player.getLastName();
		String persistedPassword = player.getLastName();
		if (StringUtils.isEmpty(persistedUsername)) {
			throw new UsernameNotFoundException("Username " + persistedUsername + " not found");
		}
		LOG.info("Logged in player: " + player.getFirstName() + " " + player.getLastName());
		return new User(resolveUmlauts(persistedUsername), resolveUmlauts(persistedPassword), getGrantedAuthorities(persistedUsername));
	}
	
	private Collection<? extends GrantedAuthority> getGrantedAuthorities(String
	username) {
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

	private String resolveUmlauts(String source) {
		return source.replace("ä", "ae").replace("ö", "oe").replace("ü", "ue");
	}
}
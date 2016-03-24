package de.sms.tabletennis.services.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;

import de.sms.tabletennis.daos.EmailDAO;
import de.sms.tabletennis.entities.Email;
import de.sms.tabletennis.services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailDAO emailDAO;
	
	@Override
	public void save(Object entity) {
		if(entity instanceof Email) {
			Email email = (Email) entity;
			if(!emailDAO.findByEmailAndEmailType(email.getEmail(), email.getEmailType()).iterator().hasNext()) {
				emailDAO.save(email);
			}
		}
	}

	@Override
	public boolean validate(Email email) {
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email.getEmail());
		return matcher.matches() || StringUtils.isNullOrEmpty(email.getEmail());
	}
	
	@Override
	public Iterable<Email> findAll() {
		return emailDAO.findAll();
	}
	
	@Override
	public String getAllEmails() {
		
		List<Email> emailList = StreamSupport.stream(emailDAO.findAll().spliterator(), true).collect(Collectors.toList());
		return emailList.stream().map(Email::getEmail).collect(Collectors.joining(";"));
	}

}

package de.sms.tabletennis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sms.tabletennis.daos.PhoneNumberDAO;
import de.sms.tabletennis.entities.PhoneNumber;
import de.sms.tabletennis.services.PhoneNumberService;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

	@Autowired
	private PhoneNumberDAO phoneNumberDAO;
	
	@Override
	public void save(PhoneNumber phoneNumber) {
		if(!phoneNumberDAO.findByNumberAndPhoneType(phoneNumber.getNumber(), phoneNumber.getPhoneType()).iterator().hasNext()) {
			phoneNumberDAO.save(phoneNumber);
		}
	}

	@Override
	public boolean validate(PhoneNumber phoneNumber) {
//		String regex = "/^([+][0-9]{1,3}[ .-])?([(]{1}[0-9]{1,6}[)])?([0-9 .-/]{3,20})((x|ext|extension)[ ]?[0-9]{1,4})?$/";
//		Pattern pattern = Pattern.compile(regex);
//		Matcher matcher = pattern.matcher(phoneNumber.getNumber());
//		return matcher.matches();
		return true;
	}
	
	@Override
	public Iterable<PhoneNumber> findAll() {
		return phoneNumberDAO.findAll();
	}

}

package de.sms.tabletennis.services.impl;

import com.mysql.jdbc.StringUtils;
import de.sms.tabletennis.daos.AdressDAO;
import de.sms.tabletennis.entities.Adress;
import de.sms.tabletennis.entities.id.AdressID;
import de.sms.tabletennis.services.AdressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
public class AdressServiceImpl implements AdressService {

	@Autowired
	private AdressDAO adressDAO;

	private final Logger LOG = Logger.getLogger(AdressServiceImpl.class);

	@Override
	public void save(Adress adress) {
		if((!StringUtils.isNullOrEmpty(adress.getCity()) && adress.getPostalCode() != 0 && !StringUtils.isNullOrEmpty(adress.getStreet()))
				&& (!adressDAO.exists(new AdressID(adress)))){
			try {
				LOG.info("save addess");
				adressDAO.save(adress);
			}
			catch(EntityExistsException eee) {
				LOG.info("Address " + adress + " already saved");
			}
		} else {
			LOG.info("address " + adress.getCity() + " " + adress.getPostalCode() + " " + adress.getStreet()  + " not saved");
		}
	}
	
	@Override
	public Iterable<Adress> findAll() {
		return adressDAO.findAll();
	}

}

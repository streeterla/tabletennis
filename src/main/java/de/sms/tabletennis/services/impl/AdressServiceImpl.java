package de.sms.tabletennis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;

import de.sms.tabletennis.daos.AdressDAO;
import de.sms.tabletennis.entities.Adress;
import de.sms.tabletennis.services.AdressService;
import jxl.common.Logger;

@Service
public class AdressServiceImpl implements AdressService {

	@Autowired
	private AdressDAO adressDAO;

	private final Logger LOG = Logger.getLogger(AdressServiceImpl.class);

	@Override
	public void save(Adress adress) {
		if((!StringUtils.isNullOrEmpty(adress.getCity()) && adress.getPostalCode() != 0 && !StringUtils.isNullOrEmpty(adress.getStreet()))
				&& (!adressDAO.findByStreetAndPostalCodeAndCity(adress.getStreet(), adress.getPostalCode(), adress.getCity()).iterator().hasNext())){
			adressDAO.save(adress);
		} else {
			LOG.info(adress + " not saved");
		}
	}
	
	@Override
	public Iterable<Adress> findAll() {
		return adressDAO.findAll();
	}

}

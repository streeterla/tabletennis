package de.sms.tabletennis.daos;

import org.springframework.data.repository.CrudRepository;

import de.sms.tabletennis.entities.Adress;

public interface AdressDAO extends CrudRepository<Adress, Long> {

	Iterable<Adress> findAll();
	
	Iterable<Adress> findByStreetAndPostalCodeAndCity(String street, int postalCode, String city);
}

package de.sms.tabletennis.daos;

import de.sms.tabletennis.entities.Adress;
import de.sms.tabletennis.entities.id.AdressID;
import org.springframework.data.repository.CrudRepository;

public interface AdressDAO extends CrudRepository<Adress, AdressID> {

	Iterable<Adress> findAll();
	
	Iterable<Adress> findByStreetAndPostalCodeAndCity(String street, int postalCode, String city);
}

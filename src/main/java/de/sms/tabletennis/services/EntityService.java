package de.sms.tabletennis.services;

public interface EntityService<T> {

	void save(T entity);
	
	Iterable<T> findAll();
}

package de.sms.tabletennis.services;

public interface EntityService<T extends Object> {

	public void save(Object entity);
	
	public Iterable<T> findAll();
}

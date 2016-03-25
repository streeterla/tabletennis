package de.sms.tabletennis.daos;

import de.sms.tabletennis.entities.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by streeter on 24.03.16.
 */
public interface AccountDAO extends CrudRepository<Account, Long> {
    public Iterable<Account> findByUsername(String username);
    public Iterable<Account> findByPassword(String password);
    public Iterable<Account> findAll();
    public Iterable<Account> findByUsernameAndPassword(String username, String password);
}

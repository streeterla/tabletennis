package de.sms.tabletennis.daos;

import de.sms.tabletennis.entities.Account;
import de.sms.tabletennis.entities.id.AccountID;
import org.springframework.data.repository.CrudRepository;

public interface AccountDAO extends CrudRepository<Account, AccountID> {
    Iterable<Account> findByUsername(String username);
    Iterable<Account> findByPassword(String password);
    Iterable<Account> findAll();
    Iterable<Account> findByUsernameAndPassword(String username, String password);
}

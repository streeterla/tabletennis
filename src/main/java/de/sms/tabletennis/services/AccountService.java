package de.sms.tabletennis.services;

import de.sms.tabletennis.entities.Account;

/**
 * Created by streeter on 24.03.16.
 */
public interface AccountService extends EntityService<Account> {
    Iterable<Account> findByUsername(String username);
    Iterable<Account> findByUsernameAndPassword(String username, String password);
}

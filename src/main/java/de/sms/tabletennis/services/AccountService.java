package de.sms.tabletennis.services;

import de.sms.tabletennis.entities.Account;
import de.sms.tabletennis.entities.Player;

public interface AccountService extends EntityService<Account> {
    void save(Player player);
    Iterable<Account> findByUsername(String username);
    Iterable<Account> findByUsernameAndPassword(String username, String password);
}

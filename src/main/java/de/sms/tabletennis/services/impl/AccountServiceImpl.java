package de.sms.tabletennis.services.impl;

import com.mysql.jdbc.StringUtils;
import de.sms.tabletennis.daos.AccountDAO;
import de.sms.tabletennis.entities.Account;
import de.sms.tabletennis.entities.Player;
import de.sms.tabletennis.entities.Role;
import de.sms.tabletennis.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by streeter on 24.03.16.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public void save(Object entity) {
        if(entity instanceof  Account) {
            Account account = (Account) entity;
            if(!StringUtils.isNullOrEmpty(account.getUsername()) && !StringUtils.isNullOrEmpty(account.getPassword()) &&
                    !accountDAO.findByUsernameAndPassword(account.getUsername(), account.getPassword()).iterator().hasNext()) {
                accountDAO.save(account);
            }
        }
        if(entity instanceof Player) {
            Player player = (Player) entity;
            Account account =  new Account(player, player.getFirstName() + player.getLastName(), player.getLastName(), Role.USER);
            save(account);
        }
    }

    @Override
    public Iterable<Account> findAll() {
        return accountDAO.findAll();
    }
}
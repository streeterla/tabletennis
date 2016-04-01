package de.sms.tabletennis.services.impl;

import com.mysql.jdbc.StringUtils;
import de.sms.tabletennis.daos.AccountDAO;
import de.sms.tabletennis.entities.Account;
import de.sms.tabletennis.entities.Player;
import de.sms.tabletennis.entities.Role;
import de.sms.tabletennis.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public void save(Account account) {
        if(!StringUtils.isNullOrEmpty(account.getUsername()) && !StringUtils.isNullOrEmpty(account.getPassword())) {
            Iterator<Account> iter = accountDAO.findByUsernameAndPassword(account.getUsername(), account.getPassword()).iterator();
            if(iter.hasNext()) {
                Account oldAccount = iter.next();
                accountDAO.delete(oldAccount);
            }
            accountDAO.save(account);
        }
    }

    @Override
    public void save(Player player) {
        Account account =  new Account(player, resolveUmlauts(player.getFirstName()) + resolveUmlauts(player.getLastName()), resolveUmlauts(player.getLastName()), Role.USER);
        save(account);
    }


    @Override
    public Iterable<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public Iterable<Account> findByUsernameAndPassword(String username, String password) {
        return accountDAO.findByUsernameAndPassword(username,  password);
    }

    @Override
    public Iterable<Account> findByUsername(String username) {
        return accountDAO.findByUsername(username);
    }

    private String resolveUmlauts(String source) {
        if(!StringUtils.isNullOrEmpty(source)) {
            return source.replace("ä", "ae").replace("ö", "oe").replace("ü", "ue");
        }
        return "";
    }
}

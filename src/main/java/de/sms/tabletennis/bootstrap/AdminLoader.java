package de.sms.tabletennis.bootstrap;

import de.sms.tabletennis.entities.Account;
import de.sms.tabletennis.entities.Role;
import de.sms.tabletennis.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AdminLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountService accountService;

    @Value("${administrator.username}")
    private String adminUsername;

    @Value("${administrator.password}")
    private String adminPassword;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Account admin = new Account();

        admin.setUsername(adminUsername);
        admin.setPassword(adminPassword);
        admin.setRole(Role.ADMIN);
        if(!accountService.findByUsernameAndPassword(admin.getUsername(), admin.getPassword()).iterator().hasNext()) {
            accountService.save(admin);
            LOG.info("admin user created which credentials: " + admin.getUsername() + "/" + admin.getPassword());
        }
        else {
            LOG.info("admin user already created with credentials: " + admin.getUsername() + "/" + admin.getPassword());
        }
    }
}

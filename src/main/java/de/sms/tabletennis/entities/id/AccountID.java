package de.sms.tabletennis.entities.id;

import java.io.Serializable;

public class AccountID implements Serializable {
    private String password;

    private String username;

    public AccountID(String password) {
        this.password = password;
    }

    public AccountID() {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

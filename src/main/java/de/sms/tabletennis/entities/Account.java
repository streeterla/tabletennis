package de.sms.tabletennis.entities;

import de.sms.tabletennis.entities.id.AccountID;

import javax.persistence.*;

@Entity
@IdClass(AccountID.class)
public class Account {

    @OneToOne
    private Player player;
    @Id
    private String username;
    @Id
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Account() {}

    public Account(Player player, String username, String password, Role role) {
        this.player = player;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

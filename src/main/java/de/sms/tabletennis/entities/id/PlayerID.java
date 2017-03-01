package de.sms.tabletennis.entities.id;

import java.io.Serializable;

public class PlayerID implements Serializable {
    private String firstName;
    private String lastName;

    public PlayerID() {}

    public PlayerID(String firstName, String lastName, int position) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

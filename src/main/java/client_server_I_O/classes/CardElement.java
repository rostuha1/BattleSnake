package client_server_I_O.classes;

import java.io.Serializable;

public class CardElement implements Serializable {

    public int Role;

    public CardElement() {}

    public int getRole() {
        return Role;
    }
    public void setRole(int role) {
        Role = role;
    }

}

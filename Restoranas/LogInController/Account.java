package LogInController;

import LogInController.Password;

public class Account {
    String username;
    Password password;
    String type;
    Account ( String username , String password , String type ) {
        this.username = username;
        this.password = new Password(password);
        this.type = type;
    }
    public String getType () {
        return this.type;
    }
    public String getUsername () {
        return this.username;
    }
}
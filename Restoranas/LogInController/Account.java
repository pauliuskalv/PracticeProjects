package LogInController;

import LogInController.Password;
import LogInController.Enums.AccountType;

public class Account {
    String username;
    Password password;
    AccountType type;
    Account ( String username , String password , AccountType type ) {
        this.username = username;
        this.password = new Password(password);
        this.type = type;
    }
    public AccountType getType () {
        return this.type;
    }
    public String getUsername () {
        return this.username;
    }
}
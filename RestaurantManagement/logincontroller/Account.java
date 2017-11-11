package logincontroller;

import logincontroller.Password;
import logincontroller.enums.AccountType;

public class Account {
    public String username;
    private Password password;
    public AccountType type;
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
    public boolean passwordIsCorrect(String password)
    {
        return this.password.isCorrect(password);
    }
}
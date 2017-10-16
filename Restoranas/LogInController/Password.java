package LogInController;

import LogInController.Encryption.Hasher;
import java.io.Serializable;

public class Password implements Serializable {
    private final byte[] saltedPassword ;
    private final byte[] salt ;
    public Password ( String password ) {
        salt = Hasher.getNextSalt();
        saltedPassword = Hasher.hash( password.toCharArray() , salt);
    }
    public boolean isCorrect ( String password ) {
        byte[] hashedPassword = Hasher.hash( password.toCharArray() , salt );

        if ( saltedPassword.length != hashedPassword.length ) return false;

        for ( int i = 0 ; i < saltedPassword.length ; i ++ ) {
            if ( saltedPassword[i] != hashedPassword[i] ) return false;
        }
        return true;
    }
}

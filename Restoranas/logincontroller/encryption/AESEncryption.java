package logincontroller.encryption;

import logincontroller.encryption.IEncrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;

public class AESEncryption implements IEncrypt
{
    private final int keySize = 192;
    private final String algorithm = "AES";
    public EncryptableData generateData(String message)
    {
        KeyGenerator generator = null;
        try
        {
            generator = KeyGenerator.getInstance(algorithm);
        }
        catch (NoSuchAlgorithmException e)
        {
            return null;
        }

        generator.init(keySize);

        return new EncryptableData(message, generator.generateKey() );
    }   
    public boolean encrypt(EncryptableData data)
    {
        try
        {
            Cipher cipher = Cipher.getInstance( algorithm );
            cipher.init(Cipher.ENCRYPT_MODE, data.secretKey );
    
            data.bytes = cipher.doFinal( data.message.getBytes()) ;
        }
        catch(Exception e)
        {
            data.bytes = null;
            return false;
        }

        data.message = null;
        data.isEncrypted = true;

        return true;
    }
    public boolean decrypt(EncryptableData data)
    {
        try
        {
            Cipher cipher = Cipher.getInstance( algorithm ) ;
            cipher.init(Cipher.DECRYPT_MODE, data.secretKey );
    
            data.message = new String ( cipher.doFinal( data.bytes ) ) ;
        }
        catch(Exception e)
        {
            data.message = null;
            return false;
        }

        data.isEncrypted = false;
        data.bytes = null;

        return true;
    }
}
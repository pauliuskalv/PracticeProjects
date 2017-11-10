package logincontroller.encryption;

import javax.crypto.SecretKey;

public class EncryptableData
{
    SecretKey secretKey;
    String message;
    byte[] bytes;
    boolean isEncrypted;
    public EncryptableData(String message, SecretKey secretKey)
    {
        this.message = message;
        this.secretKey = secretKey;
    }
    public String getMessage()
    {
        return this.message;
    }
    public byte[] getBytes()
    {
        return this.bytes;
    }
}
package LogInController.Encryption;

public interface IEncrypt
{
    public EncryptableData generateData(String message);
    public boolean encrypt(EncryptableData data);
    public boolean decrypt(EncryptableData data);
}
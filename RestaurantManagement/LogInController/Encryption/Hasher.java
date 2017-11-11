package LogInController.Encryption;

import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Random;

public class Hasher {
	private static final int iterations = 65536;
	private static final int keyLength = 256 ;
	private static final int saltSize = 256 ;
	private static final Random random = new SecureRandom();
	public static byte[] getNextSalt ( ) {
		byte[] toGenerate = new byte[saltSize] ;

		random.nextBytes(toGenerate);

		return toGenerate ;
	}
	public static byte[] hash ( char[] password , byte[] salt ) {
		PBEKeySpec pbeKeySpec = new PBEKeySpec(password, salt, iterations, keyLength);

		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1") ;
			return keyFactory.generateSecret(pbeKeySpec).getEncoded();
		} catch ( NoSuchAlgorithmException e ) {
		} catch ( InvalidKeySpecException e ) {
		} finally {
			pbeKeySpec.clearPassword();
		}
		return null;
	}
}

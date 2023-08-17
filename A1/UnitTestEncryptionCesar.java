import org.junit.Test;
import org.junit.Assert;
import java.util.Random;

public class UnitTestEncryptionCesar
{
    @Test
    public void testEncryption()
    {
        for (int i = 0; i < 10; i++)
        {
            String messageAvantEncryption = randomString(); //random word
            int decalage = randomDecalage(); // random decalage
            
            EncryptionCesar encryption = new EncryptionCesar(decalage);//messageAvantEncryption
            
            String encrypted = encryption.Encrypter(messageAvantEncryption); //encrypt
            String decrypted = encryption.Decrypter(encrypted); //decrypt the encrypted message
            
            String expected = messageAvantEncryption;
            String result = decrypted;
            
            System.out.println ("Message avant Encryption: " + messageAvantEncryption);             
            System.out.println ("Message apres Encryption: " + encrypted +  " (decalage="+ decalage + ")");  
            System.out.println ("Message apres Decryption: " + decrypted);
            System.out.println();
            Assert.assertEquals(expected, result);
        }
    }
    private String randomString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50; i++)
        {
            char c = (char) (Math.random() * 26 + 'a');
            sb.append(c);
        }
        String lowercase = sb.toString().toLowerCase();
        return lowercase;
    }

    public int randomDecalage()
    {
        Random random = new Random();
        int decalage = random.nextInt(101)-50; // genere un nombre entre -50 et 50 inclusif
        return decalage;
    }
}
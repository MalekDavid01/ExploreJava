import java.util.*;

public class EncryptionCesar
{
  //
  //TODO - Ajouter votre code (variable d instance etc) ici
  private final int decalage;
  private String alphabet = "abcdefghijklmnopqrstuvwxyz";
  private char[] listed_alpha = alphabet.toCharArray();

  //
  //TODO - Ajouter votre constructeur ici
  EncryptionCesar(int decalage)
  {
    this.decalage = decalage%26; //pour que l'intervalle demeure toujours [0,25]
  }
   

  public String Encrypter (String message) ////presumer des lettres minuscules
  { 
    //
    //TODO - Ajouter votre constructeur ici
    int i, alpha_index;
    int shifted_index = 0;
    char[] seperated_message = message.toCharArray();
    char new_letter;
    String new_message = "";
    for (i=0; i<message.length(); i++)
    {
      alpha_index = alphabet.indexOf(seperated_message[i]);
      if (decalage >= 0)
      {
        shifted_index = (alpha_index + this.decalage) %26;
        new_letter = alphabet.charAt(shifted_index);
        new_message += new_letter;
      }
      else if (decalage <0)
      {
        shifted_index = (alpha_index + (26 - (decalage*-1)%26))%26;
        new_letter = alphabet.charAt(shifted_index);
        new_message += new_letter;
      }
    }
    return new_message;
  }

  public String Decrypter (String message)
  {
    //
    //TODO - Ajouter votre constructeur ici
    int i, alpha_index;
    int shifted_index = 0;
    char[] seperated_message = message.toCharArray();
    char new_letter;
    String new_message = "";
    for (i=0; i<message.length(); i++)
    {
      alpha_index = alphabet.indexOf(seperated_message[i]);
      if (decalage >= 0)
      {
        shifted_index = ((alpha_index+26) - this.decalage) %26;
        new_letter = alphabet.charAt(shifted_index);
        new_message += new_letter;
      }
      else if (decalage <=0)
      {
        shifted_index = (alpha_index + (26 + (decalage*-1)%26))%26;
        new_letter = alphabet.charAt(shifted_index);
        new_message += new_letter;
      }
    }
    return new_message;
  }

  public static void main (String[] args) 
  {
    if (args.length !=2)
    {
      System.out.print("Utilisation: java EncryptionCesar <Message:string> <Decalage:int>");
      return;
    } 

    String messageAvantEncryption = args[0];
    int decalage = Integer.parseInt(args[1]);   
  
    EncryptionCesar encryption = new EncryptionCesar(decalage);
    
    System.out.println ("Message avant Encryption: " + messageAvantEncryption);   
    String messageEncrypter = encryption.Encrypter(messageAvantEncryption);            
    System.out.println ("Message apres Encryption: " + messageEncrypter +  " (decalage="+ decalage + ")");
    String messageApresDecryption= encryption.Decrypter(messageEncrypter);    
    System.out.println ("Message apres Decryption: " + messageApresDecryption);
  }
}
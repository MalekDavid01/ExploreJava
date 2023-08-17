import java.util.*;

/**
 * la classe EncryptionCesar qui implemente l algorithme d encryption selon la methode de Cesar
 */
public class EncryptionCesar extends SubstitutionEncryption { 
  private int decalage;
  private final String alphabet_min= "abcdefghijklmnopqrstuvwxyz";
  private final String alphabet_maj= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  /**
   * construit un object EncryptionCesar
   * @param decalage le nombre decalage des caracters
   * e.g. decalage = 2 alors Encrypter('a') = 'c', Encrypter('y') = 'a', Encrypter('A')= 'C', Encrypter('Y') = 'A'
   */
  public EncryptionCesar (int decalage){  
    super();
    //TODO: Ajouter votre code ici
    this.decalage = decalage%26;
    this.tableauSubstitutions[0] = (alphabet_min+alphabet_maj).toCharArray();
    this.tableauSubstitutions[1] = (encryptionSub(alphabet_min)+encryptionSub(alphabet_maj)).toCharArray();
  }


  public String encryptionSub(String message) //methode qui va simplement encrypter soit toutes des lettres minuscules, soit toutes de lettres majuscules
  { 
    //
    //TODO - Ajouter votre constructeur ici
    int i, alpha_index;
    int shifted_index = 0;
    char[] seperated_message = message.toCharArray();
    char new_letter;
    String new_message = "";
    String alphabet = "";

    if (seperated_message[0] >='a' && seperated_message[0] <='z'){
      alphabet = alphabet_min;
    }
    else if (seperated_message[0] >='A' && seperated_message[0] <='Z'){
      alphabet = alphabet_maj;
    }

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

  /**
   * Encrypte le message envoyé en paramètre et retourne le message encrypté
   * @param message le message a encrypter
   * @return le message encrypte
   */
  public String Encrypter (String message) {
    return super.Encrypter(message);
  }

  /**
   * decrypte le message envoyé en paramètre et retourne le message original
   * @param message le message a decrypter
   * @return le message decrypter
   */
  public String Decrypter (String message) {
    return super.Decrypter(message);
  }

  /**
   * Methode principale d acces pour l execution
   * @param args les arguments de la ligne de commande
   */
    public static void main (String[] args) {
      if (args.length !=2) {
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
import java.util.*;

/**
 * la classe abstraite Encryption qui represente un algorithme d encryption quelconque
 */
public abstract class Encryption {   
  /**
   * Encrypte le message envoyé en paramètre et retourne le message encrypté
   * @param message le message a encrypter
   * @return le message encrypte
   */
  abstract String Encrypter (String message);

  /**
   * decrypte le message envoyé en paramètre et retourne le message original
   * @param message le message a decrypter
   * @return le message decrypter
   */
  abstract String Decrypter (String message);  
}
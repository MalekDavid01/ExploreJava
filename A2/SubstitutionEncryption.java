import java.util.*;

public class SubstitutionEncryption extends Encryption{ 
  //protected donc la variable d instance est accessible aux classes enfants.
  protected char[][] tableauSubstitutions; 

  /**
   * construit la classe et initialise le tableau de substitutions pour contenir 2 lignes. 
   * la 1ere ligne contient les caracteres originaux et la 2eme ligne contient les caracteres de substitutions.
   * donc si tableauSubstitutions[0][index] contient le caractere avant encryption alors
   *   alors tableauSubstitutions[1][index] contient le caractere apres encryption
   */
  public SubstitutionEncryption(){
    this.tableauSubstitutions = new char[2][];
  }

  /**
   * construira la classe avec les caracteres de substitution selon l alphabet [a-zA-Z] (voir Util.ALPHABET)
   * @param tableauSubstitutions le tableau de substitution 
   */
  public SubstitutionEncryption(char [][] tableauSubstitutions){
    this.tableauSubstitutions = tableauSubstitutions;
  }

  /**
   * Encrypte le message envoyé en paramètre et retourne le message encrypté
   * @param message le message a encrypter
   * @return le message encrypte
   */
  public String Encrypter (String message) {
    int tailleMessage = message.length();
    char[] resultat = new char[tailleMessage];

    for (int i=0; i<tailleMessage; i++) {
      resultat[i] = Encrypter(message.charAt(i));
    }

    return String.valueOf(resultat);
  }

  /**
   * decrypte le message envoyé en paramètre et retourne le message original
   * @param message le message a decrypter
   * @return le message decrypter
   */
  public String Decrypter (String message) {
    int tailleMessage = message.length();
    char[] resultat = new char[tailleMessage];

    for (int i=0; i<tailleMessage; i++) {
      resultat[i] = Decrypter(message.charAt(i));
    }

    return String.valueOf(resultat);
  }

  /**
   * Encrypte un seul caractere selon le tableau de substitution 
   * @param c le caractere a encrypter
   * @return le caractere apres encryption
   */
  private char Encrypter(char c){
    if (this.tableauSubstitutions!=null && this.tableauSubstitutions[0]!=null){
      for (int j=0; j<this.tableauSubstitutions[0].length; j++) {
        if (c == this.tableauSubstitutions[0][j]) {
          return this.tableauSubstitutions[1][j];
        }
      }
    }
    return c;
  }

  /**
   * Decrypte un seul caractere selon le tableau de substitution
   * @param c le caractere a decrypter
   * @return le caractere apres decryption
   */
  private char Decrypter(char c){
    // TODO: Ajouter votre code ici
    if (this.tableauSubstitutions!=null && this.tableauSubstitutions[0]!=null){
      for (int j=0; j<this.tableauSubstitutions[0].length; j++) {
        if (c == this.tableauSubstitutions[1][j]) {
          return this.tableauSubstitutions[0][j];
        }
      }
    }
    return c;
    
  }

  /**
   * @return vrai si le tableau de subsitution arrive convenablement a encrypter de decrypter un message
   * inscrit dans l alphabet.
   */
  public boolean isValid() {
    boolean result = true;

    //BONUS
    //TODO: Ajouter votre code ici
    int i,j;
    i =0;
    j= i+1;

    while (i<tableauSubstitutions[0].length-1){
      while(j<tableauSubstitutions[0].length){
        if (tableauSubstitutions[0][i] == tableauSubstitutions[0][j]){
          result = false;
          return result;
        }
        j++;
      }
      i++;
      j= i+1;
    }

    i =0;
    j= i+1;
    while (i<tableauSubstitutions[1].length-1){
      while(j<tableauSubstitutions[1].length){
        if (tableauSubstitutions[1][i] == tableauSubstitutions[1][j]){
          result = false;
          return result;
        }
        j++;
      }
      i++;
      j= i+1;
    }
    return result;
  } 
  /**
   * la methode d entree pour la classe. 
   * @param args les arguments envoyes a la ligne de commande
   */
  public static void main (String[] args) {
    if (args.length !=3) {
      System.out.print("Utilisation: java SubstitutionEncryption <message:string> <tableauSubstitutions[0]:string> <tableauSubstitutions[1]:string> ");
      //e.g.1  java SubstitutionEncryption ITI1521 abciIjktT123456 xywjak90mznbZO3 
      //           va encrypter "ITI1521" en "amazOnz"
      //e.g 2 java SubstitutionEncryption COMMANDER ABCDEFGHIJKLMNOPQRSTUVWXYZ ZEBRASCDFGHIJKLMNOPQTUVWXY
      //           va encrypter "COMMANDER" en "BLJJZKRAO"
      return;
    } 

    String messageAvantEncryption = args[0];
    char[] tableauSubstitutions0 = args[1].toCharArray(); //e.g abciIjktT123456
    char[] tableauSubstitutions1 = args[2].toCharArray(); //e.g xywjak90mznbZO3

    char[][] tableauSubstitutions = new char[2][];
    tableauSubstitutions[0] = tableauSubstitutions0;
    tableauSubstitutions[1] = tableauSubstitutions1;

    SubstitutionEncryption encryption = new SubstitutionEncryption(tableauSubstitutions);
    
    System.out.println ("Message avant Encryption: " + messageAvantEncryption);   
    String messageEncrypter = encryption.Encrypter(messageAvantEncryption);            
    System.out.println ("Message apres Encryption: " + messageEncrypter);
    String messageApresDecryption= encryption.Decrypter(messageEncrypter);    
    System.out.println ("Message apres Decryption: " + messageApresDecryption);
  }
}
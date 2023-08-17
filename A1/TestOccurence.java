import java.util.*;
import java.io.*;
import java.util.regex.*;

public class TestOccurence
{
  public static final int TAILLEALPHABET = 26;
    

  public static void main (String[] args) throws Exception
  {
    if (args.length !=2)
    {
      System.out.print("Utilisation: java TestOccurence <fichier:string> <fichier:string>");
      return;
    } 
    
    String fichierinput = args[0];
    String fichierOutput = args[1];
    
    Occurence[] occurences = new Occurence[Util.TAILLEALPHABET*2];

    //
    //TODO - Ajouter votre code ici pour initaliser votre tableau

    for (int i = 0; i<TAILLEALPHABET*2; i++)
    {
      occurences[i] = new Occurence("", 0);
    }
    
    FileReader fileReader = new FileReader(fichierinput);

    //
    // Lire le fichier, pour chaque caractere incrementer son comptage.
    //TODO - Ajouter votre code ici

    char[] cbuf = new char[1];
     
    int index; 
    int repetition_count;

    while(fileReader.read(cbuf)>0) //
    {
      if(cbuf[0] >='A' && cbuf[0] <='Z')
      {
        index = cbuf[0] - 'A';
        occurences[index + 26].setMot(Character.toString(cbuf[0]));
        repetition_count = occurences[index + 26].getRepetition();
        repetition_count++; 
        occurences[index + 26].setRepetition(repetition_count);
      }
      else
      {
        if(cbuf[0] >='a' && cbuf[0] <='z')
        {
          index = cbuf[0] - 'a';
          occurences[index].setMot(Character.toString(cbuf[0]));
          repetition_count = occurences[index].getRepetition();
          repetition_count++; 
          occurences[index].setRepetition(repetition_count);
        }
      } 
    }

    fileReader.close();

    //Vous pouvez utiliser le code commente ci-dessous pour tester le contenu 
    //de votre tableau d'occurences.
    //for (int i=0 ; i<occurences.length ; i++) {
    //    System.out.println(occurences[i].toString());
    //}

    FileWriter output = new FileWriter(fichierOutput);

    //Naviguez votre tableau d occurence et ecrivez les statistiques selon le format demande. 
    //TODO: Metter votre code ici
    String rank;
    for (int letter=0; letter < 52; letter++)
    {
      if (occurences[letter].getRepetition() !=0)
      {
        System.out.println(occurences[letter].toString());
        rank = occurences[letter].toString();
        for (int i = 0; i< rank.length(); i++)
        {
          output.write(rank.charAt(i));   
        }
        output.write('\n');
      }
    }
    output.close();
  }
}
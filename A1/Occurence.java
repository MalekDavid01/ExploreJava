public class Occurence {
    private String mot;
    private int repetition;

    // Constructeur
    //TODO - Ajouter votre code ici
    Occurence(String mot, int repetition)
    {
        this.mot = mot;
        this.repetition = repetition;
    }
    //
    // retourne le mot. Le mot peut etre 1 seul caractere
    //
    public String getMot() {
        return mot;
    }

    //
    // retourne le nombre d occurence du mot. Le mot peut etre 1 seul caractere
    //
    public int getRepetition() {
        return repetition;
    }

    //
    // retourne la valeur en string du mot selon la forme "mot:repetition"
    //
    public String toString() {
        //
        //TODO - Ajouter votre code ici
        return mot + ":" + Integer.toString(repetition);
    }

    //
   //TODO - Ajouter votre code ici si necessaires (methode d'instance, methode de classe, private ou public, etc ..)
   public void setMot(String mot)
   {
        this.mot = mot;
   }

   public void setRepetition(int repetition)
   {
        this.repetition = repetition;
   }
}
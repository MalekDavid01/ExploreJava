/**
 * la classe Occurence qui garde les statistiques d'un objet
 */
//TODO: Corriger la declaration de la classe
public class Occurence<T extends Identifiable> { //<T extends Identifiable>
    private T objet;
    private int repetition;

    /**
     * 
     * <p>Construit un object Occurence qui va garder le nombre de repetion du mot</p>
     * 
     * @param mot le mot a comptabiliser
     */
    public Occurence (T objet) {
        this.objet = objet;
        repetition = 0;
    }

    /**
     * Construit un objet Occurence avec un nombre de repetition predefini.
     * @param objet l ojbet contenu dans l Occurence
     * @param repetition le nombre de repetition initial
     */
    public Occurence (T objet, int repetition) {
        this.objet = objet;
        this.repetition = repetition;
    }

    /**
     * <p>Incremente le nombre de repetion de l objet</p>
     */
    public void Incrementer () {
        repetition++;
    }

    /**
     * <p>Incremente le nombre de repetion de l objet</p>
     */
    public void Incrementer (int ajout) {
        repetition+= ajout;
    }

    /**
     * <p>Decremente le nombre de repetion de l objet</p>
     */
    public void Decrementer (int soustraire) {
        repetition-= soustraire;
    }

    /**
     * retourne l objet dans Occurence
     * 
     * @return le mot 
     */
    public T getObjet() {
        return objet;
    }

    /**
     * retourne la repetition
     * 
     * @return le nombre de repetition de l objet
     */
    public int getRepetition() {
        return repetition;
    }

    /**
     * retourne la version string du mot selon la forme "mot:repetition"
     * 
     * @return la version string de l objet Occurence
     */
    public String toString() {
        String resultat = new String(this.objet.toString() + ":" + repetition);

        return resultat;
    }  
}
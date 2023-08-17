import java.util.*;

/**
 * la classe OccurenceCollection qui permet de garder une collection d'Occurence
 */
public class OccurenceCollection {
  private List<Occurence> occurences;

  /**
   * Constructor
   */
  public OccurenceCollection(){
    occurences = new ArrayList<Occurence>();
  }

  /**
   * ajoute un objet Occurence dans la collection
   * @param occurence
   */
  public void add(Occurence occurence) {
    boolean exist = false;

    for(Occurence o: this.occurences) {
        

      if (o.getObjet().getId().equals(occurence.getObjet().getId())) {
        o.Incrementer(occurence.getRepetition());
        exist = true;
        break;
      }
    }

    //si l occurence n existe pas encore, on ajoute l occurence dans notre collection
    if (!exist) {
      occurences.add(occurence);   
    } 
  }

  /**
   * retourne le nombre d objets Occurence dans la collection
   * @return le nombre d objets Occurence
   */
  public int count() {
    return this.occurences.size();
  }

  /**
   * retourne l objet Occurence selon un Id donne
   * @param id le id de l objet encapsule dans Occurence
   * @return l objet Occurence
   */
  public Occurence get(String id) {
    for(Occurence o: this.occurences) {
      if (o.getObjet().getId().equals(id)) {
        return o;
      }
    }
    return null;
  }

  /** 
   *  @return la version String en concatenant chaque Objet Occurence separe par une ligne
   */
  public String toString() {
    StringBuffer sb = new StringBuffer();
    for (Occurence o : this.occurences) {
      sb.append(o.toString()+System.lineSeparator());
    }
    return sb.toString();
  }
}
/**
 * La classe abstraite Jersey 
 */
public class Jersey extends Produit {
    private Boolean isCustomized = false;

    public Jersey(String name, String sku, Double unitPrice, Double taxRate) {
        super (name, sku, unitPrice, taxRate);
    }

    /**
     * verifie si le jersey a ete personnalise
     * @return vrai si le jersey a ete personnalise
     */
    public Boolean getIsCustomized() {
        return this.isCustomized;
    }

    //Il manque exactement trois methodes a cette classe. Elle ne compilera pas tant que vous ne les ajoutiez pas
    //Inspirez vous des deux autres classes (Poster et Carte) pour la remplir. 
    //
    //TODO: Ajouter votre code ici.
    
    /**
     * @return le type de produit (en valeur enum)
     */
    public Produit.ProductType getProductType() {
        return ProductType.JERSEY;
    }

    /**
     * Personnalise le jersey
     * @param set valeur boolenne qui definit si on personalise le jersey
     */
    public void setIsCustomized(boolean set) {
        this.isCustomized =set;
    }

    
}
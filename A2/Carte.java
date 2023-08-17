/**
 * La classe  Carte 
 */
public class Carte extends Produit {

    /**
     * @return le type de produit (en valeur enum)
     */
    public Produit.ProductType getProductType() {
        return ProductType.CARTE;
    }

    /**
     * consruit un objet Carte
     * @param name le nom du produit
     * @param sku le product-Id du Poster
     * @param unitPrice le prix unitaire
     * @param taxRate le taux de taxe
     */
    public Carte(String name, String sku, Double unitPrice, Double taxRate) {
        super (name, sku, unitPrice, taxRate);
    }
}
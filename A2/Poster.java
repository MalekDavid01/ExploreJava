/**
 * La classe  Poster 
 */
public class Poster extends Produit {
    private Boolean isSigned;

    /**
     * @return le type de produit (en valeur enum) 
     */
    public Produit.ProductType getProductType() {
        return ProductType.POSTER;
    }

    /**
     * construit un objet Poster
     * @param name le nom du produit
     * @param sku  le product-Id du Poster
     * @param unitPrice le prix unitaire
     * @param taxRate le taux de taxe
     * @param isSigned true si le poster est signe
     */
    public Poster(String name, String sku, Double unitPrice, Double taxRate, Boolean isSigned) {
        super (name, sku, unitPrice, taxRate);
        this.isSigned = isSigned;
    }
}
package org.howard.edu.lsp.assignment3;
/**
 * Provides business logic for transforming product data according to assignment rules.
 */
public class ProductTransformer {
    /**
     * Applies a 10% discount to Electronics and rebrands expensive items as Premium.
     * @param product The Product object to be modified in-place.
     */
    public void transform(Product product) {
        /**
        * Categorizes a product price into Low, Medium, High, or Premium buckets.
        * @param price The final price after discounts.
        * @return A String representing the price range.
        */
        if (product.getCategory().equalsIgnoreCase("Electronics")) {
            // Apply 10% discount
            product.setPrice(product.getPrice() * 0.90);
            
            // Premium Electronics rule
            if (product.getPrice() > 500.00) {
                product.setCategory("Premium Electronics");
            }
        }
    }

    /**
     * Determines the price range label based on price.
     * @param price The current price of the product.
     * @return A string representing the range (Low, Medium, High, Premium).
     */
    public String getPriceRange(double price) {
        if (price <= 10.00) return "Low";
        if (price <= 100.00) return "Medium";
        if (price <= 500.00) return "High";
        return "Premium";
    }
}

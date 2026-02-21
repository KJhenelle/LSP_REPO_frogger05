package org.howard.edu.lsp.assignment3;
/**
 * Represents a product entity in the ETL process.
 * This class encapsulates product data including ID, name, price, and category.
 */
public class Product {
    private String id;
    private String name;
    private double price;
    private String category;

    /**
     * Constructs a new Product and standardizes the name and category strings.
     * @param id The unique identifier for the product
     * @param name The name of the product
     * @param price The unit price of the product
     * @param category The product category (e.g., Electronics)
     */
     
    public Product(String id, String name, double price, String category) {

        /**
        * Gets the current price of the product.
        * @return the double value of the price
        */

        this.id = id;
        this.name = name.toUpperCase().trim();
        this.price = price;
        this.category = category.trim();
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString() {
        return String.format("%s,%s,%.2f,%s", id, name, price, category);
    }
}

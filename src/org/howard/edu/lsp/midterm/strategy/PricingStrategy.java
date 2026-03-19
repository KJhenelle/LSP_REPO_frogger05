package org.howard.edu.lsp.midterm.strategy;
/**
 * Interface for pricing strategies.
 * Author: Jhenelle Walters
 */
public interface PricingStrategy {

    double calculatePrice(double basePrice, int quantity);/**
     * Calculates the price based on a specific strategy.
     * @param price The base price.
     * @return The final price after discount.
     */
    double calculate(double price);
}
    


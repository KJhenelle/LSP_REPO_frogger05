package org.howard.edu.lsp.midterm.strategy;
/**
 * Regular pricing strategy.
 * Author: Jhenelle Walters
 */
public class RegularStrategy implements PricingStrategy{
    @Override
    public double calculate(double price) {
        // No discount for regular customers
        return price; 
    }
}

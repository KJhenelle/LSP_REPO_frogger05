package org.howard.edu.lsp.midterm.strategy;
/**
 * VIP pricing strategy.
 * Author: Jhenelle Walters
 */
public class VIPStrategy implements PricingStrategy{
    @Override
    public double calculate(double price) {
        return price * 0.80; // 20% discount for VIP customers
    }
}

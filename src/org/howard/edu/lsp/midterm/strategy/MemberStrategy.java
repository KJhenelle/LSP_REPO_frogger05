package org.howard.edu.lsp.midterm.strategy;
/**
 * Member pricing strategy.
 * Author: Jhenelle Walters
 */
public class MemberStrategy implements PricingStrategy{
    @Override
    public double calculate(double price) {
        
        return price * 0.90; // 10% discount for members
    }
}

package org.howard.edu.lsp.midterm.strategy;
/**
 * Holiday pricing strategy.
 * Author: Jhenelle Walters
 */
public class HolidayStrategy implements PricingStrategy{
    @Override
    public double calculate(double price) {
        
        return price * 0.85; // 15% discount for holidays
    }
}

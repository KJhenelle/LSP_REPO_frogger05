package org.howard.edu.lsp.midterm.strategy;
/**
 * Context class that uses a PricingStrategy to calculate the final price.
 * Author: Jhenelle Walters
 */
public class PriceCalculator {
    private PricingStrategy strategy;

    /**
     * Sets the strategy to be used for calculation.
     * @param strategy the pricing strategy to apply.
     */
    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the price using the current strategy.
     * @param price the base price.
     * @return the calculated final price.
     */
    public double calculatePrice(double price) {
        return strategy.calculate(price);
    }
}

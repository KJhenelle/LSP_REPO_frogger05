The current PriceCalculator implementation violates the Open/Closed Principle.

Hard to Extend: To add a new customer type (e.g., "STUDENT"), you must modify the existing calculatePrice method.
+1

Conditional Complexity: The use of multiple if statements for different behaviors makes the code harder to read and maintain as more types are added.
+1

Tight Coupling: The logic for every single discount is crammed into one class, which increases the risk of side effects when changing one specific discount rule.
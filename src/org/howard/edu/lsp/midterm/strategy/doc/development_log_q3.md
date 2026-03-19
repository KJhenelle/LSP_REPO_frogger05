External Resources Used:

AI Tool: Gemini (Google) 

Conversation Transcript

User Prompt: "lets go through 3" AI Response: Provided an evaluation of the PriceCalculator class, noting violations of the Open/Closed Principle. Suggested refactoring using the Strategy Design Pattern with a PricingStrategy interface and concrete classes for each discount type.


User Prompt: "What would be the file extension for the interface is PricingStrategy.java good?" AI Response: Confirmed the naming convention and provided the Java code for the PricingStrategy interface and the refactored PriceCalculator context class.


User Prompt: "The type VIPStrategy must implement the inherited abstract method PricingStrategy.calculatePrice(double, int)" 
AI Response: Identified a mismatch in the method signature between the interface and the implementation class. Advised standardizing the parameter list to double price across all strategy classes to ensure consistency.

User Prompt: "[User provided terminal output showing compilation errors in the Driver class]" 
AI Response: Identified that MemberStrategy and HolidayStrategy were missing the implements PricingStrategy clause in their class declarations, which prevented the compiler from recognizing them as valid strategies.

How this resource helped

Design Pattern Implementation: The AI guided the transition from a rigid if-else structure to a flexible Strategy Pattern implementation.

Debugging Support: The AI assisted in resolving Java compilation errors related to interface implementation and method signatures.

Documentation: Helped structure the design_evaluation.md to accurately reflect issues with maintainability and extensibility.
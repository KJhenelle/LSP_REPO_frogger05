External Resources Used

AI Tool: Gemini (Google) 

Conversation Transcript

User Prompt:
"evaluation.md
In OrderProcessor this class is what you would call a God class and has too many responsibilities as it calculate taxes print receipts saves to files sons emails and applies discounts all in one. This is This is a violation of SRP. All fields are marked public, which allows any outside class to modify the data directly, which is poor encapsulation. This class is connected to specific technologies like FileWriter for file I/O and if you wanted to change how you save you would have to rewrite the whole thing.The tax rate and the discount threshold are hardcoded instead of variables, so it would be hard to maintain this code and change it or extend it."

AI Response:
"Your evaluation is spot on, Jhenelle! You’ve correctly identified the most critical architectural flaws in the OrderProcessor class... [The AI then provided a structured version of the evaluation including sections on SRP, Encapsulation, High Coupling, and Hard-coded Logic.]"

User Prompt:
"yes [in response to helping with CRC cards]"

AI Response:
"[The AI provided a set of CRC cards for the redesign, suggesting the creation of classes like Order, TaxCalculator, DiscountService, OrderRepository, and NotificationService to distribute responsibilities.]"

How this resource helped

Design Evaluation: The AI helped structure my initial observations into a professional technical report that clearly explained the violations of Object-Oriented design principles like SRP and Encapsulation.

Architecture Redesign: The AI assisted in brainstorming how to decouple the "God Class" into smaller, specialized components using the CRC (Class-Responsibility-Collaborator) format
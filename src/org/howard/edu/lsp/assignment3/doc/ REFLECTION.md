1. Design Differences

In Assignment 2, the implementation was procedural, meaning the entire logic—reading the file, parsing strings, calculating discounts, and writing the output—was contained within a single main method.

In Assignment 3, the solution is decomposed into multiple classes with distinct responsibilities:

Product: Acts as a data container (Model).

ProductTransformer: Contains the business logic for modifications.

ETLPipeline: Manages the flow of data.

2. Object-Oriented Concepts Used

Encapsulation: I used private fields in the Product class to protect data, ensuring that product attributes can only be modified through controlled methods or constructors.

Abstraction: The ETLPipeline class doesn't need to know the mathematical details of the "Electronics" discount; it simply calls the transform method.

Classes and Objects: Instead of manipulating raw arrays of strings, I instantiated Product objects that represent real-world entities with their own state and behavior.

3. Comparison of Implementations

The new design is significantly more maintainable. In Assignment 2, changing a price threshold required digging through nested if-else blocks inside a large loop. In Assignment 3, these rules are isolated in the ProductTransformer, making the code easier to read and debug.

4. Testing Process

To confirm that Assignment 3 works exactly like Assignment 2, I performed the following:

Output Comparison: I ran both versions and used the diff command in the terminal to compare the resulting transformed_products.csv files, ensuring they were identical.

Edge Case Validation: I tested the pipeline with an empty products.csv and a file containing malformed rows to verify that error handling (rows skipped) remained consistent.
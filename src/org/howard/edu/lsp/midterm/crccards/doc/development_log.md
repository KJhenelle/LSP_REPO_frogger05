External Resources Used

AI Tool: Gemini (Google) 

Conversation Transcript

User Prompt: "how would I do 1" AI Response: Provided a breakdown of the requirements for the Task and TaskManager classes, including the package naming conventions and logic for the setStatus method and duplicate ID handling. 

User Prompt: "is this a good start [User provided a class skeleton for Task]" 
AI Response: Corrected the Java syntax, separating the class definition from the constructor. Provided the logic for valid status checks ("OPEN", "IN_PROGRESS", "COMPLETE") and the fallback to "UNKNOWN". 

User Prompt: "what's the best java data structure for taskmanager" AI Response: Recommended HashMap<String, Task> to support O(1) lookups by taskId and to easily prevent duplicates using containsKey(). 

User Prompt: "good? [User provided TaskManager implementation with HashMap logic]" AI Response: Confirmed the logic was correct but advised removing duplicate method signatures and adding Javadoc comments to meet the 5-point rubric requirement. 

User Prompt: "[User provided terminal output showing memory addresses like Task@7344699f]" 
AI Response: Identified that the toString() method was not correctly overriding the default Object method. Provided the specific format: taskId description [status]. 

User Prompt: "[User provided terminal output showing T4 Invalid status test [OPEN]]" 
AI Response: Pointed out that the requirement for invalid status values was to set them to "UNKNOWN", not keep them as "OPEN". Provided the corrected if-else logic for setStatus(). 

How this resource helped

Syntax Correction: Helped transition from a conceptual class outline to a functional Java class with proper field encapsulation and constructor logic. 

Data Structure Selection: Guided the choice of a HashMap to satisfy the midterm's requirement for efficient task location and duplicate prevention. 

Bug Fixing: Assisted in troubleshooting the toString() output and the conditional logic for status validation to match the "Expected Output" exactly.
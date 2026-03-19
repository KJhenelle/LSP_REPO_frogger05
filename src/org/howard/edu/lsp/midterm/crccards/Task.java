package org.howard.edu.lsp.midterm.crccards;

/**
 * Task class to store task information and status.
 * Author: Jhenelle Walters
 */

public class Task {
    // 1. Declare fields
    private String taskId;
    private String description;
    private String status;
    // 2. Create the constructor
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN"; // Default status must be "OPEN" [cite: 23]
    }
    // 3. Implement the methods
    public String getTaskId() {
        return taskId;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    /**
     * Sets the task status. Validates against OPEN, IN_PROGRESS, COMPLETE.
     * Otherwise sets to UNKNOWN. 
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }
    public String toString() {
    
    return taskId + " " + description + " [" + status + "]";
}
}

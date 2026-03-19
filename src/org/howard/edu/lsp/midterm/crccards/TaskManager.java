package org.howard.edu.lsp.midterm.crccards;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
/**
 * TaskManager manages a collection of Task objects using a Map.
 * Author: Jhenelle Walters
 */
public class TaskManager {
    // Use a Map where the Key is the String taskId and the Value is the Task object
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a task to the manager.
     * @param task The task to add.
     * @throws IllegalArgumentException if the taskId already exists. 
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID detected."); 
        }
        tasks.put(task.getTaskId(), task); 
    }
    /**
     * Finds a task by its ID.
     * @return the Task, or null if not found. 
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId); 
    }
    /**
     * Returns a list of tasks with a specific status. 
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }

}

package org.howard.edu.lsp.midterm.crccards;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    
    private Map<String, Task> tasks = new HashMap<>();


    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID detected."); 
        }
        tasks.put(task.getTaskId(), task); 
    }

    public Task findTask(String taskId) {
        return tasks.get(taskId); 
    }

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

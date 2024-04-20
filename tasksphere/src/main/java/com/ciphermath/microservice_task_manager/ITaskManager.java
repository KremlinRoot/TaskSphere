package com.ciphermath.microservice_task_manager;

import java.util.List;

import com.ciphermath.microservice_tasks.Task;

public interface ITaskManager {
    // These are method signatures defined in the `ITaskManager` interface in Java. Here's what each
    // method does:
    
    /**
     * This function adds a Task object to a collection of tasks.
     * 
     * @param taskToAdd The parameter `taskToAdd` is of type `Task`, which means it represents an
     * object or instance of the `Task` class. When the `addTask` function is called, it expects a
     * `Task` object to be passed as an argument, which will then be added to some collection or
     */
    void addTask(Task taskToAdd);

    /**
     * The function `removeTask` takes a Task object as a parameter and removes it from the list of
     * tasks.
     * 
     * @param taskToRemove The parameter `taskToRemove` is of type `Task`, which represents a task that
     * needs to be removed from a list or collection of tasks. This function `removeTask` is likely
     * intended to remove a specific task from a list of tasks or a task management system.
     */
    void removeTask(Task taskToRemove);

    /**
     * The function searchTask takes a Task object as input and returns the Task object that matches
     * the input.
     * 
     * @param tasktToSearch The parameter `taskToSearch` is likely an object of type `Task` that you
     * want to search for in a collection or database. The method `searchTask` is expected to take this
     * `Task` object as input and perform a search operation to find a matching task.
     * @return The Task object that matches the search criteria is being returned.
     */
    Task searchTask(Task tasktToSearch);

    /**
     * This function returns a list of current tasks.
     * 
     * @return A list of Task objects is being returned.
     */
    List<Task> getCurrentTasks(); 
}

package com.ciphermath.microservice_task_manager;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.ciphermath.microservice_tasks.Task;

public class TaskManager implements ITaskManager{

    private List<Task> runtimeTasks;

    public TaskManager(){
        this.runtimeTasks = new ArrayList<>();
    }

    @Override
    // The `addTask` method in the `TaskManager` class is adding a new `Task` object to the list of
    // `runtimeTasks`. It takes a `Task` object as a parameter and adds it to the list using the `add`
    // method of the `ArrayList` class.
    public void addTask(Task taskToAdd) {
        // The code snippet in the `addTask` method of
        // the `TaskManager` class is performing a null check on the `taskToAdd` parameter.
        if (taskToAdd == null) {
            throw new IllegalArgumentException(
                "The task that will be added can not be null. Plase pass a valid task."
            );
        }
        runtimeTasks.add(taskToAdd);
    }

    @Override
    // The `removeTask` method in the `TaskManager` class is removing a specific `Task` object from the
    // list of `runtimeTasks`. It takes a `Task` object as a parameter and removes that object from the
    // list using the `remove` method of the `ArrayList` class.
    public void removeTask(Task taskToRemove) {
        /**
         * Throws a NullPointerException if the task to be removed is null.
         *
         * @param taskToRemove The task to be removed
         * @throws NullPointerException if the task to be removed is null
         */
        if (taskToRemove==null) {
            throw new NullPointerException(
                "The task that will be remove can not be null. Please pass a task."
            );
        }
        /**
         * Checks if a task is present in the list of runtime tasks and throws an exception if not found.
         *
         * @param taskToRemove The task to be removed
         * @throws NoSuchElementException if the task is not found in the list of runtime tasks
         */
        if (runtimeTasks.contains(taskToRemove)==false) {
            throw new NoSuchElementException("No such task in current tasks list.");
        }
        
        runtimeTasks.remove(taskToRemove);
    }

    @Override
    // The `getCurrentTasks` method in the `TaskManager` class is a public method that returns the list
    // of `Task` objects currently stored in the `runtimeTasks` list. It simply returns the
    // `runtimeTasks` list which contains all the tasks that have been added to the `TaskManager`
    // instance.
    public List<Task> getCurrentTasks() {
        return runtimeTasks;
    }

    @Override
    // The `searchTask` method in the `TaskManager` class is used to search for a specific `Task`
    // object within the list of `runtimeTasks`. It takes a `Task` object `taskToSearch` as a parameter
    // and iterates through the `runtimeTasks` list to find a matching task based on the title.
    public Task searchTask(Task tasktToSearch) {
        for (Task taskIteration : runtimeTasks) {
            if(taskIteration.equals(tasktToSearch))
                return taskIteration;
        }

        throw new NoSuchElementException(
            "No task found with title '" + tasktToSearch.getTitle() + "in current tasks list."
        );
    }
}

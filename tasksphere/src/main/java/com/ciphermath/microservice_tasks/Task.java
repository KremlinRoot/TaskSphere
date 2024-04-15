package com.ciphermath.microservice_tasks;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * This class represents a task that will place into list in app (To Do List).
 */
public class Task {

    // VARIABLES
    private String title; // Title of the task.
    private String description; // Description of the task.
    private boolean completed; // Flag to mark as done the current task.
    private LocalDate dueDate, creationDate; // Dates for due and creation.
    private Priority taskPriority; // Priority for task.

    // CONSTRUCTORS

    /**
     * Create task with title, description, due date and priority.
     * 
     * @param title        Task title.
     * @param description  Task description.
     * @param dueDate      Due date for new task.
     * @param taskPriority Priority for new task.
     */
    public Task(String title, String description, LocalDate dueDate, Priority taskPriority) {
        // This code snippet is a validation check in the constructor of the `Task` class. It ensures
        // that the `title` parameter passed to the constructor is not null or an empty string. If the
        // `title` is either null or empty, it throws an `IllegalArgumentException` with the message
        // "Title can not be empty or null". This validation helps enforce a requirement that a task
        // must have a non-null and non-empty title when it is being created.
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title can not be empty or null");
        }

        // This code snippet is a validation check in the constructor of the `Task` class. It ensures
        // that the `taskPriority` parameter passed to the constructor is one of the valid values
        // defined in the `Priority` enum (`High`, `Medium`, or `Low`).
        if (taskPriority != Priority.High && taskPriority != Priority.Medium && taskPriority != Priority.Low && taskPriority != Priority.Unselected && taskPriority != null) {
            throw new IllegalArgumentException("Invalid Priority, this value must be High, Medium, Low or Unselected.");
        }
        
        // This code snippet is a try-catch block used for handling potential exceptions when setting
        // the due date for a task in the `Task` class constructor.
        try{
            this.dueDate = dueDate;
        } catch (DateTimeException dueDateException){
            throw new IllegalArgumentException("The format of due date is not correct, check it.", dueDateException);
        }

        // This code snippet is a try-catch block used for handling potential exceptions when setting
        // the creation date for a task in the `Task` class constructor.
        try{
            this.creationDate = LocalDate.now();
        } catch (DateTimeException creationDateTimeException){
            throw new IllegalArgumentException("Format for field creation date is invalid at moment of create task. Internal Error.", creationDateTimeException);
        }

        // This code snippet is checking if the `creationDate` variable is not null. If it is not null,
        // it throws a `NullPointerException` with the message "Creation date can not be null value.
        // Error at moment of creation Task, check it on code".
        if (creationDate == null) {
            throw new NullPointerException("Creation date can not be null value. Error at moment of creation Task. Internal Error");
        }

        this.title = title;
        this.description = description;
        this.completed = false;
        this.taskPriority = taskPriority;
    }

    /**
     * Create task with title and description.
     * 
     * @param title       Task title.
     * @param description Description task.
     */
    public Task(String title, String description) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title can not be empty or null.");
        }
        if (taskPriority != Priority.High && taskPriority != Priority.Medium && taskPriority != Priority.Low && taskPriority != Priority.Unselected && taskPriority != null) {
            throw new IllegalArgumentException("Invalid Priority, this value must be High, Medium, Low or Unselected.");
        }
        
        // This code snippet is a try-catch block used for handling potential exceptions when setting
        // the creation date for a task in the `Task` class constructor.
        try{
            this.creationDate = LocalDate.now();
        } catch (DateTimeException creationDateException){
            throw new IllegalArgumentException(
                "Failed to assign creation date while creating object" +
                creationDateException.getMessage(), creationDateException);
        }
        
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    /**
     * Create task with only title.
     * 
     * @param title Task title.
     */
    public Task(String title) {
        this.title = title;
        this.description = "";
        this.completed = false;
        this.creationDate = LocalDate.now();
    }

    // GETTERS AND SETTERS

    /**
     * Set the title of new task
     * 
     * @param title String: title for new task.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return the title of new task.
     * 
     * @return Title of task.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set description of new task.
     * 
     * @param description Description for the new task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return description of current task.
     * 
     * @return Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set indicator (flag) for status of task
     * 
     * @param completed Status for the task.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Get the status of current task.
     * 
     * @return Status (If it is completed).
     */
    public boolean getCompleted() {
        return completed;
    }

    /**
     * Set due date for new task (if it has one)
     * 
     * @param dueDate Localdate: due date for new task.
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Get due date of current task.
     * 
     * @return Due date.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Set creation date for new task. This date must be set always.
     * 
     * @param creationDate Creation date for new task.
     */
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Return creation date of current task.
     * 
     * @return Creation date.
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Set priority of new task: High, Medium, Low.
     * 
     * @param taskPriority Priority for new task.
     */
    public void setPriority(Priority taskPriority) {
        this.taskPriority = taskPriority;
    }

    /**
     * Get priority of current task.
     * 
     * @return Priority of current task.
     */
    public Priority getPriority() {
        return taskPriority;
    }

    // The `public enum Priority` defines a custom data type called `Priority` with
    // three possible
    // values: `High`, `Medium`, and `Low`. This enum is used to represent the
    // priority level of a task
    // in the `Task` class. By using an enum, you can restrict the possible values
    // for the priority of
    // a task to only these three options, making the code more readable and
    // maintainable.
    public enum Priority {
        High,
        Medium,
        Low,
        Unselected
    }
}
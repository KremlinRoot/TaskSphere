package tests.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ciphermath.microservice_tasks.Task;
import com.ciphermath.microservice_tasks.Task.Priority;

public class TestTask {
    @Test
    // This code snippet is a JUnit test method named `testTaskTitle` that tests the
    // functionality of
    // the `getTitle()` method in the `Task` class.
    public void testTaskTitle() {
        Task testTask = new Task("Testing Title Java Class");
        assertEquals("Testing Title Java Class", testTask.getTitle());
    }

    @Test
    // This code snippet is a JUnit test method named `testTaskUpperCaseTitle` that
    // tests the
    // functionality of the `getTitle()` method in the `Task` class.
    public void testTaskUpperCaseTitle() {
        Task testTask = new Task("TESTING TITLE IN UPPER CASE");
        assertEquals("TESTING TITLE IN UPPER CASE", testTask.getTitle());
    }

    @Test
    // This code snippet is a JUnit test method named `testTaskLowerCaseTitle` that
    // tests the
    // functionality of the `getTitle()` method in the `Task` class when the task
    // title is in
    // lowercase.
    public void testTaskLowerCaseTitle() {
        Task testTask = new Task("testing title in lower case");
        assertEquals("testing title in lower case", testTask.getTitle());
    }

    @Test
    // This code snippet is a JUnit test method named `testTaskTitleWithNullValue`
    // that tests the
    // functionality of the `getTitle()` method in the `Task` class when the task
    // title is set to
    // `null`.
    public void testTaskTitleWithNullValue() {
        Task testTask = new Task(null);
        assertEquals(null, testTask.getTitle());
    }

    @Test
    // This code snippet is a JUnit test method named `testTaskPriority` that tests
    // the functionality
    // of the `getPriority()` method in the `Task` class.
    public void testTaskPriorityHigh() {
        Task taskTest = new Task("null", "null", LocalDate.now(), Priority.High);
        assertEquals(Priority.High, taskTest.getPriority());
    }

    // The testTaskPriorityNull function tests if the priority of a Task object is
    // null.
    @Test
    public void testTaskPriorityNull() {
        Task taskTest = new Task("null", "null", null, null);
        assertEquals(null, taskTest.getPriority());
    }

    // The testTaskPriorityMedium function tests if a Task object with Medium
    // priority returns the
    // correct priority value.
    @Test
    public void testTaskPriorityMedium() {
        Task taskTest = new Task("null", "null", null, Priority.Medium);
        assertEquals(Priority.Medium, taskTest.getPriority());
    }

     // The testTaskPriorityLow function tests if a Task object with Low priority is
     // created
     // successfully.
    @Test
    public void testTaskPriorityLow() {
        Task taskTest = new Task("null", "null", null, Priority.Low);
        assertEquals(Priority.Low, taskTest.getPriority());
    }

     // This test function checks if the due date of a task object is set correctly.
    @Test
    public void testTaskDueDate() {
        Task taskTest = new Task("dummie", "dummie", LocalDate.of(1987, 01, 23), Priority.Unselected);
        assertEquals(LocalDate.of(1987, 01, 23), taskTest.getDueDate());
    }

    @Test
    // It creates a new `Task` object with a priority set
    // to `High` and then asserts that the priority returned by the `getPriority()` method is not equal
    // to `null` using the `assertNotEquals()` method. This test ensures that the priority value is
    // properly set and retrieved in the `Task` class.
    public void testTaskPriorityIsNotNull(){
        var taskTest = new Task("null", "null", null, Priority.High);
        assertNotEquals(null, taskTest.getPriority());
    }

    @Test
    // This JUnit test method named `testTaskDueDateNull()` is testing the functionality of the
    // `getDueDate()` method in the `Task` class when the due date of the task is set to `null`.
    public void testTaskDueDateNull(){
        Task taskTest = new Task("null", "null", null, Priority.Unselected);
        assertEquals(null, taskTest.getDueDate());
    }

     // The testCreationDateToString function tests if the creation date of a Task object is correctly
     // converted to a string.
    @Test
    public void testCreationDateToString() {
        Task taskTest = new Task("dummie");
        assertEquals(LocalDate.now().toString(), taskTest.getCreationDate().toString());
    }

    @Test
    // The `testCreationDateDifferentNull()` method in the JUnit test class is testing whether the
    // creation date of a `Task` object is not null.
    // This test ensures that the creation date is being properly set when
    // a new `Task` object is created.
    public void testCreationDateDifferentNull(){
        Task taskTest = new Task("null");
        assertNotEquals(null, taskTest.getCreationDate());
    }
}
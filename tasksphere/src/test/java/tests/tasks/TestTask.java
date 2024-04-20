package tests.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ciphermath.microservice_tasks.Task;
import com.ciphermath.microservice_tasks.Task.Priority;

public class TestTask {
    // TITLE VARIABLE
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
        assertThrows(NullPointerException.class, () -> new Task(null));
    }

    
    // The test function checks if an IllegalArgumentException is thrown when a Task object is created
    // with a long title exceeding the character limit.
    @Test void testTaskTitleLengthLongException(){
        String title82Length = "Various social media platforms have different character limits for their profiles.";
        assertThrows(IllegalArgumentException.class, () -> new Task(title82Length));
    }

    // PRIORITY VARIABLE
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
        assertThrows(IllegalArgumentException.class, () -> new Task("null", "null", LocalDate.now(), null));
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
    public void testTaskPriorityIsUnselected(){
        Task testTask = new Task("null", "null");
        assertEquals(Priority.Unselected, testTask.getPriority());
    }

    @Test
    public void testTaskUnknownPriorityValue(){
        assertThrows(IllegalArgumentException.class, () -> new Task("null", "null", LocalDate.now(), null));
    }


    // DUE DATE VARIABLE
    // This test function checks if the due date of a task object is set correctly.
    @Test
    public void testTaskDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new Task("null",null,LocalDate.now(),null));
    }

    @Test
    // This JUnit test method named `testTaskDueDateNull()` is testing the functionality of the
    // `getDueDate()` method in the `Task` class when the due date of the task is set to `null`.
    public void testTaskDueDateNull(){
        Task taskTest = new Task("null", "null", null, Priority.Unselected);
        assertEquals(null, taskTest.getDueDate());
    }

    @Test
    // This particular test method `testTaskPastDueDate()` is testing the functionality related to the
    // due date of a `Task` object.
    public void testTaskPastDueDate(){
        Task taskTest = new Task("null", null, LocalDate.now().minusDays(1), Priority.Unselected);
        assertEquals(LocalDate.now().minusDays(1), taskTest.getDueDate());
    }

    // CREATION DATE VARIABLE
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

    @Test
    // This particular test method `testTaskCreationInvalidDate()` is checking whether an exception of
    // type `DateTimeException` is thrown when attempting to create a new `Task` object with an invalid
    // date. In this case, the date being passed is January 32, 2024, which is an invalid date since
    // January only has 31 days. The test is verifying that the `Task` class correctly handles such
    // invalid date inputs by throwing a `DateTimeException`.
    public void testTaskCreationInvalidDate(){
        assertThrows(DateTimeException.class, () -> new Task("null", null, LocalDate.of(2024, 1, 32), Priority.High));
    }

    // COMPLETED VARIABLE
    @Test
    public void testCompleteIsFalse(){
        Task testTask = new Task("null",null);
        assertEquals(false, testTask.getCompleted());
    }
    
    @Test
    public void testCompleteIsTrue(){
        Task testTask = new Task("null", null);
        testTask.setCompleted(true);
        assertEquals(true, testTask.getCompleted());
    }
}
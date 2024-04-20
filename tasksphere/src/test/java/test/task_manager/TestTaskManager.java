package test.task_manager;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.ciphermath.microservice_task_manager.TaskManager;
import com.ciphermath.microservice_tasks.Task;

public class TestTaskManager {

    // This logger can be used to log messages and information within
    // the test class for debugging or informational purposes. It allows you to log
    // messages at
    // different levels of severity (e.g., debug, info, error) to help in
    // troubleshooting and
    // monitoring the test execution.
    private static final Logger log = LogManager.getLogger(TestTaskManager.class);
	
    @Test
    // This Java test method `testAddTaskAsNull()` is testing the behavior of the
    // `addTask()` method in
    // the `TaskManager` class when a `null` task is passed as a parameter.
    public void testAddTaskAsNull() {
        TaskManager testTaskManager = new TaskManager();
        assertThrows(IllegalArgumentException.class, () -> testTaskManager.addTask(null));
    }

    @Test
    // This Java test method `testAddValidTask()` is testing the behavior of the
    // `addTask()` method in
    // the `TaskManager` class. It creates a new `TaskManager` instance, creates a
    // new `Task` object
    // with the title "dummy", adds this task to the task manager using the
    // `addTask()` method, and
    // then asserts that the task manager's list of current tasks contains the added
    // task. The
    // assertion checks if the task was successfully added to the task manager's
    // list of tasks.
    public void testAddValidTask() {
        TaskManager testTaskManager = new TaskManager();
        Task testTask = new Task("dummy");
        testTaskManager.addTask(testTask);
        assertTrue(testTaskManager.getCurrentTasks().contains(testTask), "Test task with title '" +
                testTask.getTitle() + "' can not be added.");
    }

    @Test
    public void testSearchTaskFound() {
        TaskManager testTaskManager = new TaskManager();
        Task testTask = new Task("Run");
        testTaskManager.addTask(testTask);
        assertEquals(testTask, testTaskManager.searchTask(testTask), "Title can not be found in testManager.");
        log.info("testTask title = {}", testTask.getTitle());
        log.info("testTaskManager.searchTask(testTask).getTitle() = {}",
                testTaskManager.searchTask(testTask).getTitle());
    }

    @Test
    /**
     * This method is used to test the retrieval of all existing current tasks from the TaskManager.
     * It creates a TaskManager instance, adds tasks to it, and then asserts that the current tasks list
     * contains the added tasks and does not contain a task that was not added.
     *
     */
    public void testGetAllExistCurrentTasks() {
        TaskManager testTaskManager = new TaskManager();
        Task t1 = new Task("Exercise"), t2 = new Task("Study"), t3 = new Task("Coding"), t4 = new Task("Not in list");
        testTaskManager.addTask(t1);
        testTaskManager.addTask(t2);
        testTaskManager.addTask(t3);
        assertAll(
                () -> assertTrue(testTaskManager.getCurrentTasks().contains(t1),
                        "Title: " + t1.getTitle() + "is not in curren task list."),
                () -> assertTrue(testTaskManager.getCurrentTasks().contains(t2),
                        "Title: " + t2.getTitle() + "is not in curren task list."),
                () -> assertTrue(testTaskManager.getCurrentTasks().contains(t3),
                        "Title: " + t3.getTitle() + "is not in curren task list."),
                () -> assertFalse(testTaskManager.getCurrentTasks().contains(t4),
                        "Title: " + t4.getTitle() + "is in curren task list."));
        log.info(
                "Current task list: {}", testTaskManager.getCurrentTasks());
    }

	@Test
	/**
	 * This method tests the removal of a task from the TaskManager.
	* It creates a TaskManager instance, adds a test task to it, removes the test task,
	* and then asserts that the test task is no longer present in the list of current tasks.
	*/
	public void testRemoveTaskSuccess() {
		TaskManager testTaskManager = new TaskManager();
		Task testTask = new Task("Test");
		testTaskManager.addTask(testTask);
		testTaskManager.removeTask(testTask);
		assertFalse(testTaskManager.getCurrentTasks().contains(testTask),"Test task can not be removed.");
	}
	@Test
	public void testRemoveNullTask(){
		TaskManager testTaskManager = new TaskManager();
		assertThrows(NullPointerException.class, () -> testTaskManager.removeTask(null));
	}
	@Test
	public void testRemoveTaskNoExists(){
		TaskManager testTaskManager = new TaskManager();
		var testTask = new Task("Not in list");
		assertThrows(NoSuchElementException.class,() -> testTaskManager.removeTask(testTask));
	}

	@Test
	public void testAllTaskInList() {
		TaskManager testTaskManager = new TaskManager();
		List<Task> tasks = Arrays.asList(new Task("Run"), new Task("Eat"), new Task("Sleep"));
		tasks.forEach(testTaskManager::addTask);
		assertEquals(tasks, testTaskManager.getCurrentTasks(), "All tasks can not be found in testManager.");
	}
}

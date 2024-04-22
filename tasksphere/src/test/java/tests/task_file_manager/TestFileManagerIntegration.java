package tests.task_file_manager;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ciphermath.microservice_task_manager.TaskManager;
import com.ciphermath.microservice_tasks.Task;

import microservice_task_file_manager.TaskFileManager;

public class TestFileManagerIntegration {
    private static final String TEST_FILE_PATH = "test_tasks.json";
    private TaskManager testTaskManager;
    private static final Logger log = LogManager.getLogger(TestFileManagerIntegration.class);

    @BeforeEach
    /**
     * Initializes the task file manager with the specified test file path.
     */
    public void setup() {
        testTaskManager = new TaskManager();

    }

    
    @AfterEach
    /**
     * Cleans up resources after the test execution.
     * It logs the content size of the test file in kilobytes and then deletes the file.
     */
    public void tearDown() {
        // Deletes the file used for testing after each test
        File testFile = new File(TEST_FILE_PATH);
        log.info("Content of file {}", (testFile.length() / 1024) + "KB"); // 1KB = 1024B
        testFile.delete();
    }


    @Test
    /**
     * This method is used to test the saving and loading of tasks from JSON.
     * It creates a list of tasks, adds them to the task manager, and then saves the task manager into a JSON file.
     */
    public void testSaveAndLoadTaskFromJson() {
        List<Task> tasksToSave = Arrays.asList(new Task("Run"), new Task("Eat"), new Task("Sleep"));
        tasksToSave.forEach(testTaskManager::addTask);
        TaskFileManager.saveTaskIntoFile(testTaskManager, TEST_FILE_PATH);
    }
}

package microservice_task_file_manager;

import java.io.IOException;
import java.util.List;
import java.io.File;

import com.ciphermath.microservice_task_manager.TaskManager;
import com.ciphermath.microservice_tasks.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Utility class for managing tasks and saving them to a file.
 */
public class TaskFileManager {
    
    /**
     * ObjectMapper instance used for JSON serialization with indentation enabled for output.
     */
    private static final ObjectMapper om = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    /**
     * Saves the current tasks managed by the TaskManager to a JSON file.
     *
     * @param taskManager The TaskManager instance managing the tasks
     * @param fileName    The name of the file to save the tasks to
     * @throws IOException If an I/O error occurs while writing to the file
     */
    public static void saveTaskIntoFile(TaskManager taskManager, String fileName){ 
        List<Task> tasksToSaveJson = taskManager.getCurrentTasks();
        try{
            om.writeValue(new File(fileName), tasksToSaveJson);
        }
        catch (IOException e){
            System.err.println(fileName + " cannot be saved");
        }
    }

    /**
     * Loads a TaskManager object from a JSON file.
     *
     * @param fileName The name of the file to load the TaskManager from
     * @return The TaskManager object loaded from the file
     * @throws IOException If an I/O error occurs while reading the file
     */
    public static TaskManager loadTaskFromFile(String fileName) throws IOException {
        List<Task> tasksToLoadJson = om.readValue(new File(fileName), new TypeReference<List<Task>>(){});
        TaskManager taskManagerToStorageJsonTasks = new TaskManager();
        for(Task taskLoaded:tasksToLoadJson){
            taskManagerToStorageJsonTasks.addTask(taskLoaded);
        }

        return taskManagerToStorageJsonTasks;
    }


}

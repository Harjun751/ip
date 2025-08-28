package marvin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import marvin.task.TaskList;

public class StorageHandler {
    private static final String FILE_PATH = "./save.mrvn";

    public static TaskList loadTaskList() {
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (TaskList) ois.readObject();
        } catch (FileNotFoundException e) {
            return new TaskList();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("(failed to load data - resetting)");
            return new TaskList();
        }
    }

    public static void storeTaskList(TaskList taskList) {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(taskList);
        } catch (IOException e) {
            System.out.println("(failed to save data - data will not persist.)");
        }
    }
}

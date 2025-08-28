package marvin.task;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable {
    private final ArrayList<Task> list;
    private int count = 0;

    public TaskList() {
        this.list = new ArrayList<Task>();
    }

    /**
     * Adds a duke.task.Todo object to the TodoList.
     *
     * @param task a duke.task.Todo object representing the task to be added
     */
    public void addToList(Task task) {
        this.list.add(task);
        count++;
    }

    /**
     * Marks a task at a given index as the supplied done state
     *
     * @param index The index at which the desired task object resides
     * @param done  The state at which to set the task object
     * @return The string representation of the object after the operation
     * @throws ArrayIndexOutOfBoundsException If index supplied is not a valid index for a task
     */
    public String markTask(int index, boolean done) {
        // Throw error if index supplied is bigger than size
        // or bigger than the current count
        if (index >= count || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        Task task = this.list.get(index);
        task.setDone(done);
        return task.toString();
    }

    /**
     * Removes a task at a given index
     *
     * @param index The index at which the desired task object resides
     * @return The string representation of the object deleted
     * @throws ArrayIndexOutOfBoundsException If index supplied is not a valid index for a task
     */
    public String removeTask(int index) {
        // Throw error if index supplied is bigger than size
        // or bigger than the current count
        if (index >= count || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        Task task = this.list.remove(index);
        count--;
        return task.toString();
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(this.list.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}

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
     * Adds a Task object to the Task List.
     *
     * @param task a Task object representing the task to be added.
     */
    public void addToList(Task task) {
        this.list.add(task);
        count++;
    }

    /**
     * Marks a task at a given index as the supplied done state.
     *
     * @param index The index at which the desired task object resides.
     * @param isDone The state at which to set the task object.
     * @throws ArrayIndexOutOfBoundsException If index supplied is not a valid index for a task.
     * @return The string representation of the object after the operation is complete.
     */
    public String markTask(int index, boolean isDone) {
        // Throw error if index supplied is bigger than size
        // or bigger than the current count
        if (index >= count || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        Task task = this.list.get(index);
        task.setDone(isDone);
        return task.toString();
    }

    /**
     * Removes a task at the given index in the task list.
     *
     * @throws ArrayIndexOutOfBoundsException If index supplied is not a valid index for a task.
     * @return The string representation of the object deleted.
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

    /**
     * Filters tasks to find matching descriptions.
     *
     * @param query The filter to search the descriptions for.
     * @return String representation of the tasks that match the query.
     */
    public String searchTasks(String query) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (this.list.get(i).getDescription().contains(query)) {
                sb.append(i + 1);
                sb.append(". ");
                sb.append(this.list.get(i));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Returns the count of objects in the task list.
     *
     * @return How many objects are in the list.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Returns the stylized string representation of the task list.
     */
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

public class TaskList {
    private final int SIZE;
    private final Task[] list;
    private int count = 0;

    public TaskList(int size) {
        SIZE = size;
        this.list = new Task[SIZE];
    }

    /**
     * Adds a Todo object to the TodoList.
     * @param task a Todo object representing the task to be added
     * @throws IllegalStateException If attempt to insert
     *                               task into a full list
     */
    public void addToList(Task task) {
        if (count > SIZE) {
            throw new IllegalStateException("Array is full");
        }
        this.list[count++] = task;
    }

    /**
     * Marks a task at a given index as the supplied done state
     * @throws ArrayIndexOutOfBoundsException If index supplied is not a valid index for a task
     * @param index The index at which the desired task object resides
     * @param done The state at which to set the task object
     * @return The string representation of the object after the operation
     */
    public String markTask(int index, boolean done) {
        // Throw error if index supplied is bigger than size
        // or bigger than the current count
        if (index > SIZE - 1 || index >= count) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        this.list[index].setDone(done);
        return this.list[index].toString();
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(this.list[i]);
            sb.append("\n");
        }
        return sb.toString();
    }
}

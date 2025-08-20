public class TodoList {
    private final int SIZE;
    private final Todo[] list;
    private int count = 0;

    public TodoList(int size) {
        SIZE = size;
        this.list = new Todo[SIZE];
    }

    /**
     * Adds a Todo object to the TodoList.
     * @param task a Todo object representing the task to be added
     * @throws IllegalStateException If attempt to insert
     *                               task into a full list
     */
    public void addToList(Todo task) {
        if (count > SIZE) {
            throw new IllegalStateException("Array is full");
        }
        this.list[count++] = task;
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

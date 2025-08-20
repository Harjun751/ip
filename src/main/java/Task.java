public abstract class Task {
    protected String description;
    protected boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    // Alternate constructor with done specified
    public Task(String description, boolean done) {
        this.description = description;
        this.done = done;
    }

    /**
     * A setter for the done parameter.
     * Affects the string display of the item.
     * @param done represents the new state of doneness of the task
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public abstract String toString();
}

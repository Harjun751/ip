public class Todo {
    private String description;
    private boolean done;

    public Todo(String description) {
        this.description = description;
        this.done = false;
    }

    // Alternate constructor with done specified
    public Todo(String description, boolean done) {
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
    public String toString() {
        // Construct string based on description and status
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.done){
            sb.append("X");
        } else {
            sb.append(" ");
        }
        sb.append("] ");
        sb.append(this.description);
        return sb.toString();
    }
}

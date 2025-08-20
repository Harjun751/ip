public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    // Alternate constructor with done specified
    public Todo(String description, boolean done) {
        super(description, done);
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

package marvin.task;

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
        String mark;
        if (this.getDone()) {
            mark = "X";
        } else {
            mark = " ";
        }
        return String.format("[T][%s] %s", mark, this.getDescription());
    }
}

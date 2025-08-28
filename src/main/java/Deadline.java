import java.time.LocalDate;

public class Deadline extends Task {
    private LocalDate due;

    public Deadline(String description, LocalDate due) {
        super(description);
        this.due = due;
    }

    @Override
    public String toString() {
        // Construct string based on description and status
        String mark;
        if (this.getDone())
            mark = "X";
        else
            mark = " ";
        return String.format("[D][%s] %s (by: %s)", mark, this.getDescription(), this.due);
    }
}

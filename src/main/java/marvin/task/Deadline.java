package marvin.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalDateTime due;

    public Deadline(String description, LocalDateTime due) {
        super(description);
        this.due = due;
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
        return String.format("[D][%s] %s (by: %s)", mark, this.getDescription(),
                this.due.format(DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy, ha"
                ))
        );
    }
}
